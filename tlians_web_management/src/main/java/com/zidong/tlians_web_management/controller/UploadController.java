package com.zidong.tlians_web_management.controller;

import com.zidong.tlians_web_management.pojo.Result;
import com.zidong.tlians_web_management.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

//    @PostMapping("/upload")
//    public Result Upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info ( "文件上传: {}, {}, {}", username, age, image );
//        //获取文件名
////        String fileName = image.getOriginalFilename();
//
//        //构造唯一的文件名（不能重复）-- 用uuid
//        String fileName = image.getOriginalFilename ();
//        int index = 0;
//        String ext = null;
//        if (fileName != null) {
//            index = fileName.lastIndexOf ( "." );
//            ext = fileName.substring ( index );
//        }
//        String newFileName = UUID.randomUUID () + ext;
//
//        //将文件存储到本地
////        image.transferTo ( new File (
////                "H:\\My Drive\\Job_seeking\\javaweb_learning\\day11-SpringBootWeb案例\\资料\\FileUploadTest\\"
////                        + fileName ) );
//
//        image.transferTo (new File (
//                "H:\\My Drive\\Job_seeking\\javaweb_learning\\day11-SpringBootWeb案例\\资料\\FileUploadTest\\"
//                        + newFileName));
//
//        return Result.success ();
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}", image.getOriginalFilename());
        //调用阿里云工具类上传文件
        String url = aliOSSUtils.upload (image);

        return Result.success(url);
    }
}
