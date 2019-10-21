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

    public static final CodeMsgDTO APPID_IS_ILLEGAL = CodeMsgDTO.create(3000L, "appId未授权");
    public static final CodeMsgDTO GET_QT_USER_INFO_FAILED = CodeMsgDTO.create(3001L, "获取轻推用户详情失败");
    public static final CodeMsgDTO USER_INFO_IS_EMPTY = CodeMsgDTO.create(3002L, "获取轻推用户信息为空");

    public static final CodeMsgDTO AREAID_IS_ILLEGAL = CodeMsgDTO.create(4000L, "areaId非法");
    public static final CodeMsgDTO ROOMID_IS_ILLEGAL = CodeMsgDTO.create(4001L, "roomId非法");
    public static final CodeMsgDTO IS_NOT_AREA_ADMIN = CodeMsgDTO.create(4002L, "不是区域管理员");
    public static final CodeMsgDTO FILE_TRANSFER_EXCETPION = CodeMsgDTO.create(4003L, "文件传输异常");
    public static final CodeMsgDTO IS_NOT_ATTENDEE = CodeMsgDTO.create(4004L, "非会议参会人");
    public static final CodeMsgDTO FILE_IS_NOT_EXSIT = CodeMsgDTO.create(4005L, "文件不存在");
    public static final CodeMsgDTO FILE_DOWNLOAD_EXCEPTION = CodeMsgDTO.create(4006L, "文件下载异常");
    public static final CodeMsgDTO USER_IS_NOT_MEETING_ORDER = CodeMsgDTO.create(4007L, "用户不是会议发起者");
    public static final CodeMsgDTO SIGNIN_RECORD_EXPORT_FAILED = CodeMsgDTO.create(4008L, "导出会议签到记录失败");
    public static final CodeMsgDTO NOT_FILE_UPLOADER = CodeMsgDTO.create(4009L, "非文件上传者");
    public static final CodeMsgDTO MEETING_IS_NOT_EXIST = CodeMsgDTO.create(4010L, "会议不存在");
    public static final CodeMsgDTO JOIN_USER_COUNT_BIG = CodeMsgDTO.create(4011L, "参会人大于1000");
    public static final CodeMsgDTO MEETING_FILE_ANNEX_BIG = CodeMsgDTO.create(4012L, "会议附件个数超过9个");
    public static final CodeMsgDTO MEETING_FILE_SUMMARY_BIG = CodeMsgDTO.create(4013L, "会议纪要个数超过9个");
    public static final CodeMsgDTO USER_IS_NOT_ROOM_PERMISSION = CodeMsgDTO.create(4014L, "无会议室权限");
    public static final CodeMsgDTO ROOM_IS_NOT_EXIT = CodeMsgDTO.create(4015L, "会议室不存在");


    public static final CodeMsgDTO USER_IS_EXIST = CodeMsgDTO.create(5000L, "用户不存在");
    public static final CodeMsgDTO MEETING_IS_END = CodeMsgDTO.create(5001L, "会议已结束无法取消");
    public static final CodeMsgDTO USER_IS_NOT_PERMISSION = CodeMsgDTO.create(5002L, "用户无权限");
    public static final CodeMsgDTO SEND_MESSAGE_ERR = CodeMsgDTO.create(5003L, "轻应用发送富文本消息失败");
    public static final CodeMsgDTO HTTP_GET_INFO_ERR = CodeMsgDTO.create(5004L, "通过http获取信息失败");
    public static final CodeMsgDTO SOCKET_ERR = CodeMsgDTO.create(5005L, "socket is err");

    public static final CodeMsgDTO MEETING_DATE_IS_ERR = CodeMsgDTO.create(5007L, "meeting startTime and endTime Beyond");
    public static final CodeMsgDTO MEETING_START_DATE_IS_ERR = CodeMsgDTO.create(5008L, "The meeting start time is less than the current time");

    public static final CodeMsgDTO MEETING_IS_END_NOT_CHANGE_STATUS = CodeMsgDTO.create(5009L, "会议已结束无法更改会议状态");
    public static final CodeMsgDTO REDIS_INIT_FAILED = CodeMsgDTO.create(5010L, "Redis初始化失败");
    public static final CodeMsgDTO REDIS_ERROR = CodeMsgDTO.create(5011L, "Redis获取异常");
    public static final CodeMsgDTO MEETING_IS_DELETED = CodeMsgDTO.create(5012L, "会议已被删除");


}
