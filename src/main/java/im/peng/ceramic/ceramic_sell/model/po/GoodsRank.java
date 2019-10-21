package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsRank implements Serializable {
    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
    * 规格
    */
    private String specifications;

    /**
    * 剩余数量
    */
    private Integer remainAmount;

    /**
    * 总数
    */
    private Integer totalAmount;

    /**
    * 商品id
    */
    private Integer goodsId;

    /**
    * 价格
    */
    private Double price;

    /**
    * 备注说明
    */
    private String explainInfo;

    private static final long serialVersionUID = 1L;
}