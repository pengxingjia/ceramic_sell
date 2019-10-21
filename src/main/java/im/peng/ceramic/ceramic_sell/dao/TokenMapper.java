package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(String id);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
}