package com.my.pdfvisaulstamp.service;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.my.pdfvisaulstamp.vo.StampVo;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;

/**
 * @author zzwzd
 * @create 2023-04-11 14:43
 */
@Service
public class PdfService {
    private static String BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/file/";
    public  BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
    public  String pdfToImageBase64(String filePath,int targetWidth, int targetHeight) {
        // 定义一个空的字符串用来存储结果
        String result = "";
        try {
            // 打开pdf文件
            File file = new File(filePath);
            PDDocument document = PDDocument.load(Files.newInputStream(file.toPath()));
            // 创建一个PDFRenderer对象
            PDFRenderer renderer = new PDFRenderer(document);
            // 遍历pdf的每一页
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                // 将每一页渲染成一个BufferedImage对象
                BufferedImage tempImage = renderer.renderImageWithDPI(i, 180, ImageType.RGB);
                BufferedImage image =  resizeImage(tempImage, targetWidth, targetHeight);
                // 将BufferedImage对象转换成字节数组
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", baos);
                byte[] bytes = baos.toByteArray();
                // 将字节数组编码成base64字符串
                String base64 = Base64.getEncoder().encodeToString(bytes);
                // 将base64字符串拼接到结果字符串中，用逗号分隔
                result += base64;
            }
            // 关闭pdf文件
            document.close();
        } catch (IOException e) {
            // 捕获异常并打印
            e.printStackTrace();
        }
        // 返回结果字符串，去掉最后一个逗号
        return result.trim();
    }


    public String getBase64(String path) {
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

    public String stamp(StampVo stampVo) {
        String orginPath = "";
        int width,height;
        String imagePath = BASE_PATH + "stamp1.png";
        if (stampVo.isVertical()) {
            width = 595;
            height = 842;
            orginPath = BASE_PATH + "vertical.pdf";
        }else {
            height = 595;
            width = 842;
            orginPath = BASE_PATH + "thwartwise.pdf";
        }
        //设置输出路径
        String outPath = BASE_PATH + "temp/"+ System.currentTimeMillis()+".pdf";
        String imageBase64 = getBase64(imagePath);
        byte[] imgBytes = Base64.getDecoder().decode(imageBase64);

        PdfDocument pdfDocument;
        try {
            pdfDocument = new PdfDocument(new PdfReader(orginPath), new PdfWriter(outPath));
            com.itextpdf.layout.element.Image image = new Image(ImageDataFactory.createPng(imgBytes));
            image.setFixedPosition(1, (float) stampVo.getX(), (float) stampVo.getY());
            Document document = new Document(pdfDocument);
            document.add(image);
            pdfDocument.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.pdfToImageBase64(outPath,width,height).trim();
    }
}
