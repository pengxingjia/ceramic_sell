package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class MemberInfo implements Serializable {
    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
    * 会员卡密码
    */
    private String password;

    /**
    * 会员卡账号
    */
    private String account;

    /**
    * 会议身份标值，用户通过此id来查询会员信息情况
    */
    private String identity;

    /**
    * 会员到期时间
    */
    private Long expirationTime;

    private static final long serialVersionUID = 1L;
}