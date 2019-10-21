package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.GoodsImage;

public interface GoodsImageMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsImage record);

    int insertSelective(GoodsImage record);

    GoodsImage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsImage record);

    int updateByPrimaryKey(GoodsImage record);
}