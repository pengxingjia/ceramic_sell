package im.peng.ceramic.ceramic_sell.controller;

import im.peng.ceramic.ceramic_sell.model.dto.LoginDto;
import im.peng.ceramic.ceramic_sell.service.AccountService;
import im.peng.ceramic.ceramic_sell.util.BaseDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关控制类
 *
 * @author qiaofeng
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户相关接口")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 登录会员获取token--特定信息需要
     */
    @GetMapping(value = "member/login")
    @ApiOperation(value = "登录获取token")
    public BaseDataVo memberLogin(String account, String password, String vxOpenId) {
        LoginDto loginDto = accountService.memberLogin(account, password, vxOpenId);
        return BaseDataVo.successData(loginDto);
    }
}