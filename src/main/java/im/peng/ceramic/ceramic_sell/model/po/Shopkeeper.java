package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class Shopkeeper implements Serializable {
    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
    * 商家背景图片
    */
    private String bgImageId;

    /**
    * 店名
    */
    private String name;

    /**
    * 地址--地图定位，非会员隐藏
    */
    private String address;

    /**
    * 地址，商家自己填写， 非会员隐藏
    */
    private String addressName;

    /**
    * 店铺简介 ，非会员隐藏
    */
    private String synopsis;

    /**
    * 店铺是否删除，1删除
    */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}