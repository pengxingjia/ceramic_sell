package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class Goods implements Serializable {

    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
     * 商品名
     */
    private String name;

    /**
     * 是否删除，1删除
     */
    private Integer isDelete;

    /**
     * 商品说明
     */
    private String explainInfo;

    /**
     * 店铺id
     */
    private String shopkeeperId;

    /**
     * 1下架，0未下架,默认下架
     */
    private Integer isShelves;

    private static final long serialVersionUID = 1L;
}