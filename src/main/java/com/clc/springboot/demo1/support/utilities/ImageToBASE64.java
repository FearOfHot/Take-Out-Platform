package com.clc.springboot.demo1.support.utilities;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageToBASE64 {

    /**
     * 本地图片转换成base64字符串
     * @param imageName	图片名称
     * @reture 图片Base64
     * @author Byr
     * @dateTime 2019-03-07
     */
    public static String ImageToBase64ByLocal(String imageName) throws IOException {
//        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            //获取图片
            File file = new File("E:\\vue-relation\\vue-work\\demo1\\src\\assets\\dish\\" + imageName);
            InputStream in = new FileInputStream(file.getPath());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

}
