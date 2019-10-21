package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.GoodsRank;

public interface GoodsRankMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsRank record);

    int insertSelective(GoodsRank record);

    GoodsRank selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsRank record);

    int updateByPrimaryKey(GoodsRank record);
}