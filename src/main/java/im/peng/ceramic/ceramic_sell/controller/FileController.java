package im.peng.ceramic.ceramic_sell.controller;

import im.peng.ceramic.ceramic_sell.service.FileService;
import im.peng.ceramic.ceramic_sell.util.AuthHeaderUtil;
import im.peng.ceramic.ceramic_sell.util.BaseDataVo;
import im.peng.ceramic.ceramic_sell.util.JwtEncryption;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件相关控制层
 *
 * @author qiaofeng
 */
@RequestMapping("file")
@RestController
public class FileController {

    @Autowired
    FileService fileService;

    /**
     * 文件上传（原始方式）
     * @return 图片的url地址
     */
    @PostMapping(value = "upload")
    public BaseDataVo fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String token = AuthHeaderUtil.getTokenFromAuthHeader(request);
        String vxOpenId = JwtEncryption.getVxOpen(token);

        String imageUrl = fileService.fileUpload(request, file, vxOpenId);
        return BaseDataVo.successData(imageUrl);
    }


}