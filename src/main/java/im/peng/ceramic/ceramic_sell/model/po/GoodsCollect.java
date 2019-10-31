package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsCollect implements Serializable {
    private String id;

    private Integer gmtCreate;

    private Integer gmtModify;

    private String goodId;

    private String openId;

    private static final long serialVersionUID = 1L;
}