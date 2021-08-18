package com.woniuxy.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UpFileConverter implements Converter<MultipartFile,String> {
    @Override
    public String convert(MultipartFile multipartFile) {
        if(multipartFile!=null&&!multipartFile.isEmpty()){
            //1.获得上传文件的名字
            String fileName=multipartFile.getOriginalFilename();
            fileName= UUID.randomUUID()+fileName;
            //2.获得服务器的路径
            String serverPath="D:/MyProgram/nginx-1.18.0/html/upload/app";
            File file = new File(serverPath);
            if (!file.exists()) {
                file.mkdirs(); // 创建用户目录用于存放自己的图片
            }
            serverPath = serverPath + File.separator + fileName;
            try {
                //3.开始上传
                multipartFile.transferTo(new File(serverPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "http://localhost/upload/app/" + fileName;//存入数据库中的名字
        }
        return null;
    }
}
