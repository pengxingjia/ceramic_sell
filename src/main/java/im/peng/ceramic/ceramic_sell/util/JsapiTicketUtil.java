package im.peng.ceramic.ceramic_sell.util;

import im.peng.ceramic.ceramic_sell.model.dto.AppEnv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import net.sf.json.JSONObject;

/**
 * 获取jsApi的Ticket的工具类
 *
 * @author jiajia
 */
public class JsapiTicketUtil {

    /***
     * 模拟get请求
     * @param url  需要请求的地址
     * @param charset 字符集
     * @param timeout 等待时间
     * @return 返回的数据
     */
    public static String sendGet(String url, String charset, int timeout) {
        String result = "";
        try {
            URL u = new URL(url);
            try {
                URLConnection conn = u.openConnection();
                conn.connect();
                conn.setConnectTimeout(timeout);
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
                String line = "";
                while ((line = in.readLine()) != null) {

                    result = result + line;
                }
                in.close();
            } catch (IOException e) {
                return result;
            }
        } catch (MalformedURLException e) {
            return result;
        }

        return result;
    }

    /***
     * 获取acess_token
     * 来源www.vxzsk.com
     * @return accessToken
     */
    public static String getAccessToken() {
        String accessToken;
        Date time = AppEnv.accessTokenTime;
        if (AppEnv.accessToken != null
            && AppEnv.accessTokenTime != null
            && System.currentTimeMillis() - time.getTime() < (7000 * 1000)) {
            accessToken = AppEnv.accessToken;
        } else {
            String appId = AdvancedUtil.appId;
            String appSecret = AdvancedUtil.appSecret;
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret + "";
            String backData = sendGet(url, "utf-8", 10000);
            accessToken = (String) JSONObject.fromObject(backData).get("access_token");
            //存为全局变量
            AppEnv.accessTokenTime = new Date();
            AppEnv.accessToken = accessToken;
        }
        return accessToken;
    }

    /***
     * 获取jsapiTicket
     * 来源 www.vxzsk.com
     * @return JsapiTicket
     */
    public static String getJSApiTicket() {
        String ticket;
        Date nowDate = new Date();
        Date time = AppEnv.jsApiTicketTime;
        if (AppEnv.jsApiTicket != null
            && AppEnv.jsApiTicketTime != null
            && nowDate.getTime() - time.getTime() < 14960242) {
            ticket = AppEnv.jsApiTicket;
        } else {
            //获取token
            String accessToken = JsapiTicketUtil.getAccessToken();
            String urlStr = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
            String backData = sendGet(urlStr, "utf-8", 10000);
            ticket = (String) JSONObject.fromObject(backData).get("ticket");
            AppEnv.jsApiTicketTime = nowDate;
            AppEnv.jsApiTicket = ticket;
        }
        return ticket;

    }

}