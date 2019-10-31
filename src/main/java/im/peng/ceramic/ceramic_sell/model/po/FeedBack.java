package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class FeedBack implements Serializable {

    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    private String openId;

    private String feedMsg;

    private static final long serialVersionUID = 1L;
}