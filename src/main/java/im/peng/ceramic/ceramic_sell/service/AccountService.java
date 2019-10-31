package im.peng.ceramic.ceramic_sell.service;

import im.peng.ceramic.ceramic_sell.model.dto.MemberInfoDto;
import im.peng.ceramic.ceramic_sell.model.dto.TokenDto;
import im.peng.ceramic.ceramic_sell.model.dto.VxJsApiConfigDto;
import im.peng.ceramic.ceramic_sell.model.param.UserInfoParam;

/**
 * @author qiaofeng
 */
public interface AccountService {

    /**
     * 会员登陆获取token--特定信息需要，已绑定的人直接通过vxOpenId就能进行访问
     * @param vxOpenId 身份
     * @return 信息
     */
    MemberInfoDto memberLogin(String vxOpenId);

    /**
     * 根据code获取用户信息，数据库若没有则保存
     * @param code 获取用户信息的标
     * @return 获取到到用户信息
     */
    TokenDto getVxUserToken(String code);

    /**
     * 更新用户信息
     * @param userInfoParam 更新的用户信息
     */
    void updateSaveUserInfo(UserInfoParam userInfoParam);

    /**
     * 获取jsapi鉴权信息
     * @param url 需要鉴权的url
     * @return 鉴权信息
     */
    VxJsApiConfigDto getVxJsAspConfig(String url);

    /**
     * 保存意见
     * @param openId 留言者
     * @param feedBack 填写的意见信息
     */
    void saveFeedBackMsg(String openId, String feedBack);
}