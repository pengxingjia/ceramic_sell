package im.peng.ceramic.ceramic_sell.constants.exception;

import im.peng.ceramic.ceramic_sell.util.CodeMsgDTO;
import lombok.Data;

/**
 * 自定义异常处理类
 *
 * @author qiaofeng
 */
@Data
public  class BaseException extends RuntimeException {

    private CodeMsgDTO codeMsgDTO;


    BaseException() {

    }



    BaseException(CodeMsgDTO codeMsgDTO) {
        super(codeMsgDTO.getErr());
        this.codeMsgDTO = codeMsgDTO;
    }

    BaseException(Throwable cause) {
        super(cause);
    }

    BaseException(String message, Throwable cause) {
        super(message, cause);
    }


}