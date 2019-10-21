package im.peng.ceramic.ceramic_sell.util;

/**
 * @author qiaofeng
 */
public class BaseDataVo<T> {
    private static final long serialVersionUID = 1L;
    private T data;
    private long code;

    public static <T> BaseDataVo dataVo(long code, T message) {
        BaseDataVo<T> vo = new BaseDataVo<>();
        vo.setCode(code);
        vo.setData(message);
        return vo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public static <T> BaseDataVo successData(T data){
        return dataVo(0, data);
    }
}
