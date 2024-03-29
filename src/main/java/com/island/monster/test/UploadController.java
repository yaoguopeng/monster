package com.island.monster.test;

import com.island.monster.common.Response;
import com.island.monster.common.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 上传文件管理
 */
@Controller
@RequestMapping(value = "/manage")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadUtil uploadUtil;

    @RequestMapping(value = "/jspFile/{jspFileName}")
    public String jsp(@PathVariable("jspFileName") String jspFileName) {
        return jspFileName;
    }

    @RequestMapping(value = "/island/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response<?> uploadTest(@RequestBody MultipartFile file) {

        return Response.success(uploadUtil.upload(file, "E:\\test\\", null));
    }

    @RequestMapping(value = "/island/upload/mix", method = RequestMethod.POST)
    public String upload(HttpServletRequest request) {
        String name = (String) request.getAttribute("givenName");
        System.out.println(request.getParameter("givenName"));
        return "index";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "/Users/itinypocket/workspace/temp/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @GetMapping("/multiUpload")
    public String multiUpload() {
        return "multiUpload";
    }

    @PostMapping("/multiUpload")
    @ResponseBody
    public String multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "/Users/itinypocket/workspace/temp/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }
        return "上传成功";
    }

}
