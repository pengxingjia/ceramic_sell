package im.peng.ceramic.ceramic_sell.model.param;

import java.io.Serializable;
import lombok.Data;

/**
 * @author qiaofeng
 */
@Data
public class UserInfoParam implements Serializable {

    private String nickName;

    private String gender;

    private String country;

    private String province;

    private String city;

    private String avatarUrl;

    private String openId;
}