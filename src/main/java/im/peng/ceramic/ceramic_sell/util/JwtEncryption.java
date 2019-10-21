package im.peng.ceramic.ceramic_sell.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * token加密算法
 *
 * @author hubilie
 */
@Slf4j
public class JwtEncryption {

    /**
     * 加密生成token
     *
     * @param vxOpen 用户id
     * @return token
     * @throws Exception 生成时产生错误，向上抛
     */
    public static String createToken(String vxOpen) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        Date createTime = new Date();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = null;//加密
        token = JWT.create()
            .withHeader(map)//header
            .withClaim("createTime", createTime)
            .withClaim("vxOpen", vxOpen)
            .sign(Algorithm.HMAC256("sell"));
        return token;
    }

    /**
     * 生成refreshToken
     *
     * @param vxOpen 用户id
     * @return refreshToken
     * @throws Exception 生成时产生错误，向上抛
     */
    public static String createFreshToken(String vxOpen) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Date createTime = new Date();
        String ceramic = "ceramic"; //为了区分token加的固定值
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String freshToken = JWT.create()
            .withHeader(map)//header
            .withClaim("createTime", createTime)
            .withClaim("vxOpen", vxOpen)
            .withClaim("ceramic", ceramic)
            .sign(Algorithm.HMAC256("sell"));//加密
        return freshToken;
    }

    /**
     * 解析token数据
     *
     * @param token token身份令牌
     * @return 解析过后的数据集合
     */
    public static boolean verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = null;
        verifier = JWT.require(Algorithm.HMAC256("sell"))
            .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        if (claims.containsKey("vxOpen") && claims.containsKey("createTime")) {
            return true;
        }
        return false;
    }

    /**
     * 解析token数据
     *
     * @param token token身份令牌
     * @return 解析过后的数据集合
     */
    public static Map<String, Claim> getTokenMap(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = null;
        verifier = JWT.require(Algorithm.HMAC256("sell"))
            .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims;
    }
    /**
     * 传入token，获取userid，前提：token有效
     *
     * @param token 身份令牌
     * @return 用户的userid
     */
    public static String getVxOpen(String token) {
        Map<String, Claim> map = null;
        try {
            map = getTokenMap(token);
        } catch (UnsupportedEncodingException e) {
            log.error("获取userid失败，token有误" + e);
        }
        String vxOpen = map.get("vxOpen").asString();
        return vxOpen;
    }

    /**
     * 判断token是否合法
     *
     * @param token 需要验证的token
     * @return true 表示合法 ，false 表示不合法
     */
    public static boolean legalToken(String token) throws UnsupportedEncodingException {
        Map<String, Claim> claims = getTokenMap(token);
        //判断返回值是否为空
        if (claims == null) {
            return false;
        }
        return true;
    }

    /**
     * 判断token是否过期,默认2小时过期
     *
     * @param createTime 创建token的时间
     * @return true 过期，false 没过期
     */
    public static Boolean isExpired(Date createTime) {
        Date now = new Date();
        //计算时间差值 s
        long differTime = (now.getTime() - createTime.getTime()) / 1000 / 60;
        if (differTime < 2 * 60) {
            return false;
        }
        return true;
    }

}

