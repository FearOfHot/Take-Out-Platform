package com.clc.springboot.demo1.controller;

import com.clc.springboot.demo1.facade.base.Message;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("image")
public class UploadImageController {

    @PostMapping("/upload")
    public Message uploadAvatarHandler(@RequestParam("file") MultipartFile uploadFile) throws IOException {
        // 存储图片的路径
         String path = "E:\\vue-relation\\vue-work\\demo1\\src\\assets\\dish";
//        String path = "D:\\final\\vue\\Vue-Take-Out\\src\\assets\\dish";
        //空文件夹在编译时不会打包进入target中
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            System.out.println("上传头像路径不存在，正在创建...");
            uploadDir.mkdir();
        }
        //获得上传文件的文件名
        String oldName = uploadFile.getOriginalFilename();
        System.out.println("[上传的文件名]：" + oldName);
        //我的文件保存在static目录下的avatar/user
        double randomNum = Math.random();
        String newName = randomNum + ".jpg";
        File avatar = new File(path, newName.substring(3));
        try {
            //保存图片
            uploadFile.transferTo(avatar);
            //返回成功结果，附带文件的相对路径
            return new Message().setObj("../../../assets/dish/" + newName.substring(3)).setMessage("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new Message().setMessage("上传失败");
        }

    }


}
