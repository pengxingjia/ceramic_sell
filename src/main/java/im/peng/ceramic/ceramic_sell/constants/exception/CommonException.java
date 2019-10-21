package im.peng.ceramic.ceramic_sell.constants.exception;


import im.peng.ceramic.ceramic_sell.util.CodeMsgDTO;

/**
 * token验证异常类
 *
 * @author hubilie
 */
public class CommonException extends BaseException {

    private CodeMsgDTO codeMsgDTO;


    CommonException() {

    }

    public CommonException(CodeMsgDTO codeMsgDTO) {
        super(codeMsgDTO);
        this.codeMsgDTO = codeMsgDTO;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

}