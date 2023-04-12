package com.my.pdfvisaulstamp.controller;

import com.my.pdfvisaulstamp.pojo.Point;
import com.my.pdfvisaulstamp.service.PdfService;
import com.my.pdfvisaulstamp.vo.Result;
import com.my.pdfvisaulstamp.vo.StampVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zzwzd
 * @create 2023-04-11 14:43
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class PdfController {
    @Resource
    PdfService pdfService;
    @Resource
    Result result;
    private String BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/file/";

    private String PNG_BASE64 = "data:image/jpeg;base64,";
    @GetMapping("/thwartwise")
    public Result<String> getThwartwisePdfBase64() {
        String path = BASE_PATH+"thwartwise.pdf";
        System.out.println(path);
        return result.success(PNG_BASE64 + pdfService.pdfToImageBase64(path,842,595));
    }

    @GetMapping("/vertical")
    public Result<String> getVerticalPdfBase64() {
        String path = BASE_PATH+"vertical.pdf";
        System.out.println(path);
        return result.success(PNG_BASE64 + pdfService.pdfToImageBase64(path,595,842));
    }

    @PostMapping("/stamp")
    public Result<String> stamp(@RequestBody StampVo stampVo) {

        return result.success();
    }
}
