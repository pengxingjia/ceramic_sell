package im.peng.ceramic.ceramic_sell.constants.exception;

import im.peng.ceramic.ceramic_sell.util.CodeMsgDTO;

/**
 * 参数错误异常
 *
 * @author qiaofeng
 */
public class ParamException extends BaseException {

    private CodeMsgDTO codeMsgDTO;


    ParamException() {

    }

    public ParamException(CodeMsgDTO codeMsgDTO) {
        super(codeMsgDTO);
        this.codeMsgDTO = codeMsgDTO;
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

}