package im.peng.ceramic.ceramic_sell.dao;

import im.peng.ceramic.ceramic_sell.model.po.MemberInfo;

public interface MemberInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    MemberInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);

    //根据会员查询id查询会员卡信息
    MemberInfo getByIdentity(String identity);

}