package im.peng.ceramic.ceramic_sell.service.impl;

import im.peng.ceramic.ceramic_sell.constants.ErrorCodeConstants;
import im.peng.ceramic.ceramic_sell.constants.exception.CommonException;
import im.peng.ceramic.ceramic_sell.dao.MemberInfoMapper;
import im.peng.ceramic.ceramic_sell.dao.UserInfoMapper;
import im.peng.ceramic.ceramic_sell.model.dto.LoginDto;
import im.peng.ceramic.ceramic_sell.model.po.MemberInfo;
import im.peng.ceramic.ceramic_sell.model.po.UserInfo;
import im.peng.ceramic.ceramic_sell.service.AccountService;
import im.peng.ceramic.ceramic_sell.util.JwtEncryption;
import im.peng.ceramic.ceramic_sell.util.StringUtil;
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

    @Override
    public LoginDto memberLogin(String account, String password, String vxOpenId) {
        LoginDto loginDto = new LoginDto();
        try {
            String token = JwtEncryption.createToken(vxOpenId);
            String freshToken = JwtEncryption.createFreshToken(vxOpenId);
            loginDto.setToken(token);
            loginDto.setRefreshToken(freshToken);
        } catch (Exception e) {
            log.error("生成token异常");
            throw new CommonException(ErrorCodeConstants.GET_TOKEN_EXCEPTION);
        }

        UserInfo userInfo = checkUserExist(vxOpenId);
        if (StringUtil.isNotEmpty(userInfo.getMemberId())){
            getUserMemberInfo(userInfo.getMemberId(), loginDto);
        }
        return loginDto;
    }

    //获取会员卡信息
    private void getUserMemberInfo(String memberId, LoginDto loginDto){
        MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberId);
        if (memberInfo != null){
            loginDto.setAccount(memberInfo.getAccount());
            loginDto.setExpirationTime(memberInfo.getExpirationTime());
            loginDto.setIdentity(memberInfo.getIdentity());
            loginDto.setCreateTime(memberInfo.getGmtCreate());
        }
    }

    /**
     * 校验用户是否存在，若存在则返回用户
     * @param vxOpenId 用户id
     * @return 用户信息
     */
    private UserInfo checkUserExist(String vxOpenId){
        UserInfo userInfo = userInfoMapper.getByVxOpenId(vxOpenId);
        if (userInfo == null){
            userInfo = new UserInfo();
            userInfo.setId(StringUtil.getUuid());
            userInfo.setGmtCreate(System.currentTimeMillis());
            userInfo.setGmtModify(System.currentTimeMillis());
            userInfo.setVxOpenid(vxOpenId);
            userInfoMapper.insertSelective(userInfo);
        }
        return userInfo;
    }
}