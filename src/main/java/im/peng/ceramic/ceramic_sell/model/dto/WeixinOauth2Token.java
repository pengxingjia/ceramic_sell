package im.peng.ceramic.ceramic_sell.model.dto;

import lombok.Data;

/**
 */
@Data
public class WeixinOauth2Token {
    private String wxSessionKey;

    // 用户标识
    private String openId;

}