package im.peng.ceramic.ceramic_sell.service;

import im.peng.ceramic.ceramic_sell.model.dto.LoginDto;

/**
 * @author qiaofeng
 */
public interface AccountService {

    /**
     * 会员登陆获取token--特定信息需要，已绑定的人直接通过vxOpenId就能进行访问
     * @param account 账号
     * @param password 密码
     * @param vxOpenId 身份
     * @return 信息
     */
    LoginDto memberLogin(String account, String password, String vxOpenId);
}