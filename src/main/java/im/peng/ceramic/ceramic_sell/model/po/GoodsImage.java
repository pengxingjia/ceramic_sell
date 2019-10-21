package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsImage implements Serializable {
    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
    * 商品id
    */
    private String goodsId;

    /**
    * 商品图片id
    */
    private String imageId;

    private static final long serialVersionUID = 1L;
}