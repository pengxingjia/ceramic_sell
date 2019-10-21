package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class InvestRecord implements Serializable {
    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
    * 用户id
    */
    private String userId;

    /**
    * 会员卡id
    */
    private String memberId;

    /**
    * 充值时间
    */
    private Long inverstTime;

    /**
    * 充值天数
    */
    private Integer investDay;

    private static final long serialVersionUID = 1L;
}