package im.peng.ceramic.ceramic_sell.model.dto;

import lombok.Data;

/**
 * 微信jsapi鉴权
 *
 * @author qiaofeng
 */
@Data
public class VxJsApiConfigDto {

    private String timestamp;

    private String nonceStr;

    private String signature;
}