package im.peng.ceramic.ceramic_sell.util;

import javax.servlet.http.HttpServletRequest;

/**
 * token处理类
 *
 * @author hubilie
 */
public class AuthHeaderUtil {

    public static final String HEAD_BEAR = "Bearer ";

    /**
     * 通过authHeader获取token
     */
    public static String getTokenFromAuthHeader(String authHeaderString) {

        return authHeaderString.replace(HEAD_BEAR, "");
    }

    /**
     * 通过请求对象获取AccessToken
     */
    public static String getTokenFromAuthHeader(HttpServletRequest request) {

        String authHeader = ((HttpServletRequest) request).getHeader("Authorization");
        if (StringUtil.isEmpty(authHeader)) {
            return null;
        }

        return authHeader.replace(HEAD_BEAR, "");
    }

    /**
     * 通过请求对象获取AccessToken
     */
    public static String getDealToken(String token) {

        if (StringUtil.isEmpty(token)) {
            return null;
        }
        return token.replace(HEAD_BEAR, "");
    }
}
