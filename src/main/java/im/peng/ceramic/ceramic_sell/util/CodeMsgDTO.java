package im.peng.ceramic.ceramic_sell.util;

import im.peng.ceramic.ceramic_sell.constants.ErrorCodeConstants;
import java.io.Serializable;
import lombok.Data;

/**
 * 错误码对象
 *
 * @author qiaofeng
 */
@Data
public class CodeMsgDTO implements Serializable {

    private Long code;
    private String err;

    public static CodeMsgDTO create(Long code, String err){
        CodeMsgDTO codeMsgDTO = new CodeMsgDTO(code, err);
        ErrorCodeConstants.codeDtoMap.put(code, codeMsgDTO);
        return codeMsgDTO;
    }

    public CodeMsgDTO(){}

    public CodeMsgDTO(Long code, String err){
        this.code = code;
        this.err = err;
    }


}