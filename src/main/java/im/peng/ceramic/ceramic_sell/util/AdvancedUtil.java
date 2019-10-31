package im.peng.ceramic.ceramic_sell.util;

import im.peng.ceramic.ceramic_sell.constants.ErrorCodeConstants;
import im.peng.ceramic.ceramic_sell.constants.exception.CommonException;
import im.peng.ceramic.ceramic_sell.model.dto.WeixinOauth2Token;
import im.peng.ceramic.ceramic_sell.model.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * 获取用户的基本信息
 * @author Administrator
 *
 */
@Slf4j
public class AdvancedUtil {

    public static String appId = SysConfigUtil.getValue("appId"); //公众账号的唯一标识

    public static String appSecret = SysConfigUtil.getValue("appSecret"); //公众账号的密钥

	/**
     * 获取微信小程序 session_key 和 openid
     *
     * @param code 获取到的code
     * @return WeixinAouth2Token
     */
    public static WeixinOauth2Token getOauth2AccessToken(String code) {
        WeixinOauth2Token wat;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        // 获取网页授权凭证
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (jsonObject.has("openid")) {
            try {
                wat = new WeixinOauth2Token();
                wat.setWxSessionKey(jsonObject.getString("session_key"));
                wat.setOpenId(jsonObject.getString("openid"));
                return wat;
            } catch (Exception e) {
                log.error("通过code获取微信用户openId失败");
                throw new CommonException(ErrorCodeConstants.HTTP_REQUEST_ERR);
            }
        }else {
            log.error("通过code获取微信用户openId失败{}", jsonObject.getString("errmsg"));
            throw new CommonException(ErrorCodeConstants.HTTP_REQUEST_ERR);
        }
    }


    /**
     * 通过网页授权获取用户信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId 用户标识
     * @return SNSUserInfo
     */
    public static UserInfo getWeUserInfo(String accessToken, String openId) {
        UserInfo weUser = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                weUser = new UserInfo();
                // 用户的标识
                weUser.setVxOpenid(jsonObject.getString("openid"));
                // 昵称
                weUser.setNickname(jsonObject.getString("nickname"));
                // 性别（1是男性，2是女性，0是未知）
                weUser.setSex(jsonObject.getString("sex"));
                // 用户所在国家
                weUser.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                weUser.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                weUser.setCity(jsonObject.getString("city"));
                // 用户头像
                weUser.setAvatar(jsonObject.getString("headimgurl"));
                weUser.setId(StringUtil.getUuid());
                weUser.setGmtCreate(System.currentTimeMillis());
                weUser.setGmtModify(System.currentTimeMillis());
            } catch (Exception e) {
                log.error("通过openId获取微信用户信息失败");
                throw new CommonException(ErrorCodeConstants.HTTP_REQUEST_ERR);
            }
        }
        return weUser;
    }

}
