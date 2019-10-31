package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserInfo implements Serializable {

    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
     * 小程序中微信用户身份唯一标识
     */
    private String vxOpenid;

    /**
     * 会员卡id
     */
    private String memberId;

    private String nickname;

    private String sex;

    private String country;

    private String province;

    private String city;

    private String avatar;

    private String mobile;

    private static final long serialVersionUID = 1L;
}