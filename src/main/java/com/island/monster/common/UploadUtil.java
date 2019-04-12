package com.island.monster.common;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时光小岛文件上传服务工具类：上传文件，删除文件
 */
@Component
public class UploadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadUtil.class);

    /**
     * remove the very file that provide
     *
     * @param filePath
     * @return
     */
    public Boolean remove(String filePath) {
        File toBeRemove = new File(filePath);
        if (toBeRemove.exists()) {
            toBeRemove.delete();
            return true;
        }
        return false;
    }

    /**
     * upload a file into the given path with the given name, use the originalFilename while the given name is null
     *
     * @param file
     * @param path
     * @param givenName
     * @return
     */
    public Boolean upload(MultipartFile file, String path, String givenName) {
        if (file.isEmpty() || path == null) {
            return null;
        }
        if (givenName == null) {
            givenName = file.getOriginalFilename();
        }
        File dir = new File(path);
        LOGGER.info("文件持久化到：" + path);
        if (!dir.exists()) {
            LOGGER.info("指定目录不存在，新建目录：" + path);
            dir.mkdirs();
        }
        File dest = new File(path + givenName);
        try {
            file.transferTo(dest);
            LOGGER.info("文件上传成功：" + path + givenName);
            return true;
        } catch (IOException e) {
            LOGGER.error(path + givenName + " 文件上传异常：" + e.toString(), e);
        }
        return false;
    }

}
