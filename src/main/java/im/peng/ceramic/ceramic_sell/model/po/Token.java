package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class Token implements Serializable {
    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    private String userId;

    private String refreshToken;

    private String token;

    private static final long serialVersionUID = 1L;
}