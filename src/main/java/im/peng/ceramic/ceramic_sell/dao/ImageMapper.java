package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.Image;

public interface ImageMapper {

    int deleteByPrimaryKey(String id);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
}