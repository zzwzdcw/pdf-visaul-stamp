package com.my.pdfvisaulstamp.service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Image;
import org.bouncycastle.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author zzwzd
 * @create 2023-04-11 14:43
 */
@Service
public class PdfService {
    private static String BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/file/";


    private String getImgBase64(String path) {
        // 创建一个文件对象
        File file = new File(path);
        // 创建一个字节数组，长度为文件大小
        byte[] data = new byte[(int) file.length()];
        try {
            // 创建一个文件输入流
            FileInputStream fis = new FileInputStream(file);
            // 读取文件内容到字节数组
            fis.read(data);
            // 关闭文件输入流
            fis.close();
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
        // 使用Base64编码器将字节数组转为字符串
        String base64 = Base64.getEncoder().encodeToString(data);
        // 返回base64字符串
        return base64;
    }

    public String stamp() {

        PdfDocument pdfDocument;
        //限制img长宽
        return "";
    }
}
