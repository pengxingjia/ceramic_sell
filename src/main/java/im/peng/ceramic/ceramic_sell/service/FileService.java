package im.peng.ceramic.ceramic_sell.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qiaofeng
 */
public interface FileService {

    /**
     * 图片上传
     * @param request 请求对象
     * @param file 文件对象
     * @param vxOpenId 操作人的openId身份标志
     * @return 图片访问url
     */
     String fileUpload(HttpServletRequest request, MultipartFile file, String vxOpenId);
}