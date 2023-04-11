package com.my.pdfvisaulstamp.controller;

import com.my.pdfvisaulstamp.pojo.Point;
import com.my.pdfvisaulstamp.service.PdfService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zzwzd
 * @create 2023-04-11 14:43
 */
@RestController
@RequestMapping()
public class PdfController {
    @Resource
    PdfService pdfService;

    private String BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/file/";

    private String PNG_BASE64 = "data:image/jpeg;base64,";
    @GetMapping("/thwartwise")
    public String getThwartwisePdfBase64() {
        return pdfService.getBase64(BASE_PATH+"thwartwise.pdf");
    }

    @GetMapping("/vertical")
    public String getVerticalPdfBase64() {
        return pdfService.getBase64(BASE_PATH+"vertical.pdf");
    }

    @PostMapping("/stamp")
    public String stamp(@RequestBody Point point) {
        // TODO
        return "";
    }
}
