package im.peng.ceramic.ceramic_sell.constants;


import im.peng.ceramic.ceramic_sell.util.CodeMsgDTO;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常信息常量
 *
 * @author qiaofeng
 */
public final class ErrorCodeConstants {

    /**
     * 错误码对象集合
     */
    public static final Map<Long, CodeMsgDTO> codeDtoMap = new HashMap<Long, CodeMsgDTO>();

    /**
     * 未捕获异常
     */
    public static final CodeMsgDTO SYSTEM_ERROR = CodeMsgDTO.create(-1L, "系统异常");

    /**
     * 通用型异常
     */
    public static final CodeMsgDTO PARAM_ERROR = CodeMsgDTO.create(1000L, "参数错误");
    public static final CodeMsgDTO PARAM_IS_EMPTY = CodeMsgDTO.create(1001L, "参数为空");


    public static final CodeMsgDTO TOKEN_IS_EMPTY = CodeMsgDTO.create(2000L, "token为空");
    public static final CodeMsgDTO TOKEN_RESOLVE_EXCEPTION = CodeMsgDTO.create(2001L, "token解析异常");
    public static final CodeMsgDTO TOKEN_ILLEGAL = CodeMsgDTO.create(2002L, "token不合法");
    public static final CodeMsgDTO TOKEN_EXPIRED = CodeMsgDTO.create(2003L, "token过期");
    public static final CodeMsgDTO REFRESH_TOKEN_ILLEGAL = CodeMsgDTO.create(2004L, "refresh_token不合法");
    public static final CodeMsgDTO HEADER_TOKEN_ILLEGAL = CodeMsgDTO.create(2005L, "header中token不合法");
    public static final CodeMsgDTO GET_TOKEN_EXCEPTION = CodeMsgDTO.create(2006L, "token生成异常");


    public static final CodeMsgDTO FILE_TRANSFER_EXCETPION = CodeMsgDTO.create(4001L, "文件传输异常");
    public static final CodeMsgDTO FILE_TYPE_ERR = CodeMsgDTO.create(4002L, "上传的文件不是图片");



}
