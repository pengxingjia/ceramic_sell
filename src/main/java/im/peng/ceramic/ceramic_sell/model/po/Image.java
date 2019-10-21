package im.peng.ceramic.ceramic_sell.model.po;

import java.io.Serializable;
import lombok.Data;

@Data
public class Image implements Serializable {

    private String id;

    private Long gmtCreate;

    private Long gmtModify;

    /**
     * 图片url
     */
    private String url;

    /**
     * 上传者id
     */
    private String uploadId;

    private static final long serialVersionUID = 1L;
}