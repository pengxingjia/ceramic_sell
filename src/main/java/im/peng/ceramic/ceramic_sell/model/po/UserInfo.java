package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserInfo implements Serializable {
    private String id;

    private Integer gmtCreate;

    private Long gmtModify;

    /**
    * 小程序中微信用户身份唯一标识
    */
    private String vxOpenid;

    /**
    * 会员卡id
    */
    private String memberId;

    private static final long serialVersionUID = 1L;
}