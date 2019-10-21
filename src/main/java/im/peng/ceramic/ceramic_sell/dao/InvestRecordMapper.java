package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.InvestRecord;

public interface InvestRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(InvestRecord record);

    int insertSelective(InvestRecord record);

    InvestRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InvestRecord record);

    int updateByPrimaryKey(InvestRecord record);
}