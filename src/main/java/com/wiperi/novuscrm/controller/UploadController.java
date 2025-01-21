package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    // private final String UPLOAD_DIR = "C:\\Users\\Boris\\Documents\\10_MyGithub\\demo\\resources\\images\\";
    @Value("${project.resource.static-locations.images}")
    private String UPLOAD_DIR;

    @PostMapping("/upload")
    public Result upload(@RequestParam(name = "file") MultipartFile image) throws Exception {
        // save file to ./resources/images
        log.info("Upload file: {}", image.getOriginalFilename());

        if (image.isEmpty()) {
            return Result.error("File is empty");
        }

        // get unique file name
        String extName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + extName;

        File targetFile = new File(UPLOAD_DIR + fileName);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }

        image.transferTo(targetFile);

        return Result.success("Upload success");
    }
}
