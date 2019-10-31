package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.GoodsCollect;

public interface GoodsCollectMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsCollect record);

    int insertSelective(GoodsCollect record);

    GoodsCollect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsCollect record);

    int updateByPrimaryKey(GoodsCollect record);
}