package im.peng.ceramic.ceramic_sell.model.dto;

import java.util.Date;

/**
 * 缓存获取jsapi的参数，解决接口调用次数有限问题
 *
 * @author jiajia
 */
public class AppEnv {

	// 缓存jsapi_ticket值
	public static String jsApiTicket;

	// 更新缓存的时间
	public static Date jsApiTicketTime;

	// 缓存accessToken值
	public static String accessToken;

	// 更新缓存的时间
	public static Date accessTokenTime;


}