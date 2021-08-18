package com.woniuxy.controller;

import com.woniuxy.domain.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: rua
 * SpringMVC在文件上传时默认使用
 * fileupload.jar  commons.io.jar
 */
@RequestMapping("file")
@Controller
public class FileController {

	@ResponseBody
	@RequestMapping("upload")
	public Object fileUpload(@RequestParam("myfile") MultipartFile multipartFile) {
		//1.获取原始文件名
		String originalFilename = multipartFile.getOriginalFilename();
		//2.让文件名不重复
		String suffix=originalFilename.substring(originalFilename.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String filename=uuid+suffix;
		//3.获取文件上传路径
		String uploadPath="D:/MyProgram/nginx-1.18.0/html/upload/test";
		File f = new File(uploadPath);
		if (!f.exists())
			f.mkdirs();

		uploadPath=uploadPath+"/"+filename;
		//2.开始上传文件
		File file = new File(uploadPath);
		try {
			multipartFile.transferTo(file); //真正用来上传文件的方法
			return new JsonData(1,"文件上传成功","http://localhost/upload/test/"+filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JsonData(0,"文件上传失败");
	}
}
