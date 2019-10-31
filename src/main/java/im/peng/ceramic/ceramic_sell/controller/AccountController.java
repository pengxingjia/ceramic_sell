package im.peng.ceramic.ceramic_sell.controller;

import im.peng.ceramic.ceramic_sell.model.dto.MemberInfoDto;
import im.peng.ceramic.ceramic_sell.model.dto.TokenDto;
import im.peng.ceramic.ceramic_sell.model.dto.VxJsApiConfigDto;
import im.peng.ceramic.ceramic_sell.model.param.UserInfoParam;
import im.peng.ceramic.ceramic_sell.service.AccountService;
import im.peng.ceramic.ceramic_sell.util.AuthHeaderUtil;
import im.peng.ceramic.ceramic_sell.util.BaseDataVo;
import im.peng.ceramic.ceramic_sell.util.JwtEncryption;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Slf4j
public class AccountController {




    @Autowired
    AccountService accountService;

    /**
     * 登录会员获取token--特定信息需要
     */
    @GetMapping(value = "member/login")
    @ApiOperation(value = "获取会员信息")
    public BaseDataVo memberLogin(HttpServletRequest request) {
        String token = AuthHeaderUtil.getTokenFromAuthHeader(request);
        String vxOpenId = JwtEncryption.getVxOpen(token);
        MemberInfoDto memberInfoDto = accountService.memberLogin(vxOpenId);
        return BaseDataVo.successData(memberInfoDto);
    }

    /**
     * 通过微信code获取微信用户信息
     * @param code 微信code
     * @return 微信用户信息
     */
    @GetMapping(value = "vx/user/info")
    @ApiOperation(value = "保存微信用户信息，返回用户调用接口凭证")
    public BaseDataVo getVxUserToken(String code){
        TokenDto tokenDto = accountService.getVxUserToken(code);
        return BaseDataVo.successData(tokenDto);
    }

    /**
     * 更新用户信息
     * @param userInfoParam 更新的用户信息
     */
    @PostMapping(value = "update/user/info")
    @ApiOperation(value = "更新用户信息")
    public void updateSaveUserInfo(HttpServletRequest request, @RequestBody UserInfoParam userInfoParam){
        String token = AuthHeaderUtil.getTokenFromAuthHeader(request);
        String openId = JwtEncryption.getVxOpen(token);
        userInfoParam.setOpenId(openId);
        accountService.updateSaveUserInfo(userInfoParam);
    }

    /**
     * 获取jsapi鉴权信息
     * @param request 需要鉴权的url
     * @return jsapi鉴权
     */
    @GetMapping(value = "vx/js/api")
    @ApiOperation(value = "获取微信jsApi配置")
    public BaseDataVo getVxJsAspConfig(HttpServletRequest request){
        StringBuffer urlBuffer = request.getRequestURL();
        String url = urlBuffer.toString();
        log.info("初始URL：" + url);
        if (request.getQueryString() != null) {
            url = url + "?" + request.getQueryString();
        }
        url = url.replace("http", "https");
        log.info("处理后URL：" + url);
        VxJsApiConfigDto vxJsApiConfigDto = accountService.getVxJsAspConfig(url);
        return BaseDataVo.successData(vxJsApiConfigDto);
    }

    @PostMapping(value = "feed-back")
    @ApiOperation(value = "保存意见反馈")
    public BaseDataVo saveFeedBackMsg(HttpServletRequest request, String feedBack){
        String token = AuthHeaderUtil.getTokenFromAuthHeader(request);
        String openId = JwtEncryption.getVxOpen(token);
        accountService.saveFeedBackMsg(openId, feedBack);
        return BaseDataVo.successDefaultData();
    }

}