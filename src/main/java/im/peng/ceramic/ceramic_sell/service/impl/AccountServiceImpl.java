package im.peng.ceramic.ceramic_sell.service.impl;

import im.peng.ceramic.ceramic_sell.constants.ErrorCodeConstants;
import im.peng.ceramic.ceramic_sell.constants.exception.CommonException;
import im.peng.ceramic.ceramic_sell.constants.exception.ParamException;
import im.peng.ceramic.ceramic_sell.dao.FeedBackMapper;
import im.peng.ceramic.ceramic_sell.dao.MemberInfoMapper;
import im.peng.ceramic.ceramic_sell.dao.UserInfoMapper;
import im.peng.ceramic.ceramic_sell.model.dto.AppEnv;
import im.peng.ceramic.ceramic_sell.model.dto.MemberInfoDto;
import im.peng.ceramic.ceramic_sell.model.dto.TokenDto;
import im.peng.ceramic.ceramic_sell.model.dto.VxJsApiConfigDto;
import im.peng.ceramic.ceramic_sell.model.dto.WeixinOauth2Token;
import im.peng.ceramic.ceramic_sell.model.param.UserInfoParam;
import im.peng.ceramic.ceramic_sell.model.po.FeedBack;
import im.peng.ceramic.ceramic_sell.model.po.MemberInfo;
import im.peng.ceramic.ceramic_sell.model.po.UserInfo;
import im.peng.ceramic.ceramic_sell.service.AccountService;
import im.peng.ceramic.ceramic_sell.util.AdvancedUtil;
import im.peng.ceramic.ceramic_sell.util.JsapiTicketUtil;
import im.peng.ceramic.ceramic_sell.util.JwtEncryption;
import im.peng.ceramic.ceramic_sell.util.Sign;
import im.peng.ceramic.ceramic_sell.util.StringUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaofeng
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    MemberInfoMapper memberInfoMapper;

    @Autowired
    FeedBackMapper feedBackMapper;

    @Override
    public MemberInfoDto memberLogin(String vxOpenId) {
        MemberInfoDto memberInfoDto = new MemberInfoDto();

        UserInfo userInfo = getUserInfo(vxOpenId);
        if (StringUtil.isNotEmpty(userInfo.getMemberId())) {
            getUserMemberInfo(userInfo.getMemberId(), memberInfoDto);
        }
        memberInfoDto.setMobile(userInfo.getMobile());
        return memberInfoDto;
    }

    @Override
    public TokenDto getVxUserToken(String code) {
        StringUtil.checkParamIsNull(code);
        // 用户同意授权
        WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(code);
        String vxOpenId = weixinOauth2Token.getOpenId();
        // 数据库判断openid是否存在，若存在则返回用户,若不存在创建用户对象
        checkUserAndSave(vxOpenId);
        String token;
        String freshToken;
        try {
            token = JwtEncryption.createToken(vxOpenId);
            freshToken = JwtEncryption.createFreshToken(vxOpenId);
        } catch (Exception e) {
            log.error("生成token异常");
            throw new CommonException(ErrorCodeConstants.GET_TOKEN_EXCEPTION);

        }
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setFreshToken(freshToken);
        return tokenDto;
    }

    @Override
    public void updateSaveUserInfo(UserInfoParam userInfoParam) {
        StringUtil.checkParamIsNull(userInfoParam.getOpenId());
        UserInfo userInfo = userInfoMapper.getByVxOpenId(userInfoParam.getOpenId());
        if (userInfo == null){
            userInfo = new UserInfo();
            userInfo.setId(StringUtil.getUuid());
            userInfo.setAvatar(userInfoParam.getAvatarUrl());
            userInfo.setCity(userInfoParam.getCity());
            userInfo.setCountry(userInfoParam.getCountry());
            userInfo.setNickname(userInfoParam.getNickName());
            userInfo.setProvince(userInfoParam.getProvince());
            userInfo.setSex(userInfoParam.getGender());
            userInfoMapper.insertSelective(userInfo);
        }else {
            userInfo.setAvatar(userInfoParam.getAvatarUrl());
            userInfo.setCity(userInfoParam.getCity());
            userInfo.setCountry(userInfoParam.getCountry());
            userInfo.setNickname(userInfoParam.getNickName());
            userInfo.setProvince(userInfoParam.getProvince());
            userInfo.setSex(userInfoParam.getGender());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
    }

    /**
     * 获取jsapi鉴权信息
     * @return jsapi鉴权
     */
    public VxJsApiConfigDto getVxJsAspConfig(String url) {
        // 获取jsApi接口
        String jsApiTicket = JsapiTicketUtil.getJSApiTicket();

        Map<String, String> map = Sign.sign(jsApiTicket, url);
        String timestamp = map.get("timestamp");
        String nonceStr = map.get("nonceStr");
        String signature = map.get("signature");
        // jsapi参数获取成功，返回
        VxJsApiConfigDto vxJsApiConfigDto = new VxJsApiConfigDto();
        vxJsApiConfigDto.setNonceStr(nonceStr);
        vxJsApiConfigDto.setSignature(signature);
        vxJsApiConfigDto.setTimestamp(timestamp);
        return vxJsApiConfigDto;
    }

    @Override
    public void saveFeedBackMsg(String openId, String feedBackMsg) {
        StringUtil.checkParamIsNull(feedBackMsg);

        FeedBack feedBack = new FeedBack();
        feedBack.setFeedMsg(feedBackMsg);
        feedBack.setGmtCreate(System.currentTimeMillis());
        feedBack.setGmtModify(System.currentTimeMillis());
        feedBack.setOpenId(openId);
        feedBack.setId(StringUtil.getUuid());
        feedBackMapper.insertSelective(feedBack);
    }

    /**
     * 获取微信用户信息，数据库有则直接获取，数据库没有则从微信处获取并保存到数据库
     *
     * @param vxOpenId 微信用户id
     * @return 用户信息
     */
    private UserInfo getAndSaveVxUserInfo(String vxOpenId) {
        String accessToken = AppEnv.accessToken;
        // 根据vxOpenId查询用户
        UserInfo userInfo = userInfoMapper.getByVxOpenId(vxOpenId);
        if (userInfo == null) {
            userInfo = AdvancedUtil.getWeUserInfo(accessToken, vxOpenId);
            userInfoMapper.insertSelective(userInfo);
        }
        return userInfo;
    }

    //获取会员卡信息
    private void getUserMemberInfo(String memberId, MemberInfoDto memberInfoDto) {
        MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberId);
        if (memberInfo != null) {
            memberInfoDto.setAccount(memberInfo.getAccount());
            memberInfoDto.setExpirationTime(memberInfo.getExpirationTime());
            memberInfoDto.setIdentity(memberInfo.getIdentity());
            memberInfoDto.setCreateTime(memberInfo.getGmtCreate());
        }
    }

    /**
     * 校验用户是否存在，若存在则返回用户,若不存在创建用户对象
     *
     * @param vxOpenId 用户id
     * @return 用户信息
     */
    private UserInfo checkUserAndSave(String vxOpenId) {
        UserInfo userInfo = userInfoMapper.getByVxOpenId(vxOpenId);
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setId(StringUtil.getUuid());
            userInfo.setGmtCreate(System.currentTimeMillis());
            userInfo.setGmtModify(System.currentTimeMillis());
            userInfo.setVxOpenid(vxOpenId);
            userInfoMapper.insertSelective(userInfo);
        }
        return userInfo;
    }

    /**
     * 根据openId查询用户信息
     * @param vxOpenId openId
     * @return 用户信息
     */
    private UserInfo getUserInfo(String vxOpenId){
        UserInfo userInfo = userInfoMapper.getByVxOpenId(vxOpenId);
        if (userInfo == null){
            log.error("查询的用户不存在{}" + vxOpenId);
            throw new ParamException(ErrorCodeConstants.PARAM_ERROR);
        }
        return userInfo;
    }
}