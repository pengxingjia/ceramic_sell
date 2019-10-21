package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.Shopkeeper;

public interface ShopkeeperMapper {
    int deleteByPrimaryKey(String id);

    int insert(Shopkeeper record);

    int insertSelective(Shopkeeper record);

    Shopkeeper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shopkeeper record);

    int updateByPrimaryKey(Shopkeeper record);
}