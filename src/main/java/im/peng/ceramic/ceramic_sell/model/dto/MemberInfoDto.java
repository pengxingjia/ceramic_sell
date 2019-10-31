package im.peng.ceramic.ceramic_sell.model.dto;

import lombok.Data;

/**
 * 会员信息dto
 *
 * @author qiaofeng
 */
@Data
public class MemberInfoDto {


    private String identity; //会员查询id（非会员id），用户通过此id来查询会员信息情况
    private String account; //会议卡账号
    private long expirationTime;//会员到期时间
    private long createTime;//会员卡注册时间
    private String mobile;
}
