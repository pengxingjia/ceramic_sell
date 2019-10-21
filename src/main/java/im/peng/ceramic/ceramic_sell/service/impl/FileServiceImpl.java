package im.peng.ceramic.ceramic_sell.service.impl;

import im.peng.ceramic.ceramic_sell.constants.ErrorCodeConstants;
import im.peng.ceramic.ceramic_sell.constants.exception.CommonException;
import im.peng.ceramic.ceramic_sell.dao.ImageMapper;
import im.peng.ceramic.ceramic_sell.model.po.Image;
import im.peng.ceramic.ceramic_sell.service.FileService;
import im.peng.ceramic.ceramic_sell.util.StringUtil;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qiaofeng
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    ImageMapper imageMapper;

    /**
     * 文件上传
     */
    @Override
    public String fileUpload(HttpServletRequest request, MultipartFile file, String vxOpenId) {
        //处理文件流
        Image image = processingFile(request, file);
        image.setUploadId(vxOpenId);
        imageMapper.insertSelective(image);
        return image.getUrl();

    }

    /**
     * 处理文件流
     * @param request 请求
     * @param file 文件流封装对象
     * @return 文件参数对象
     */
    private Image processingFile(HttpServletRequest request, MultipartFile file){
        String fileName = StringUtil.getUuid(32);
        String originalName = file.getOriginalFilename();
        String extName = "";
        if (originalName.contains(".")) {
            extName = originalName.substring(originalName.lastIndexOf(".") + 1);
            fileName = fileName + "." + extName;
        }
        File uploadPath = new File(StringUtil.getRealPath(request));
        if (!uploadPath.exists()) {
            uploadPath.mkdir();
        }
        File f = new File(uploadPath, fileName);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CommonException(ErrorCodeConstants.FILE_TRANSFER_EXCETPION);
        }
        return this.initMeetingFileRel(fileName);
    }

    /**
     * 封装MeetingFileRel对象
     */
    private Image initMeetingFileRel(String fileName) {
        Image image = new Image();
        image.setId(StringUtil.getUuid());
        image.setGmtCreate(System.currentTimeMillis());
        image.setGmtModify(System.currentTimeMillis());
        image.setUrl("/static/" + fileName);
        return image;
    }
}
