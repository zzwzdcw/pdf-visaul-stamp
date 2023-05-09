package com.my.pdfvisaulstamp.controller;

import com.my.pdfvisaulstamp.service.PdfService;
import com.my.pdfvisaulstamp.vo.Result;
import com.my.pdfvisaulstamp.vo.StampVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public Result<List> getThwartwisePdfBase64() {
        String path = BASE_PATH+"thwartwise2.pdf";
        System.out.println(path);
        return result.success( pdfService.pdfToImageBase64(path,842,595));
    }

    @GetMapping("/vertical")
    public Result<List> getVerticalPdfBase64() {
        String path = BASE_PATH+"vertical2.pdf";
        System.out.println(path);
        return result.success(pdfService.pdfToImageBase64(path,595,842));
    }

    @PostMapping("/stamp")
    public Result<List> stamp(@RequestBody StampVo stampVo) {
        System.out.println(stampVo);
        return result.success(pdfService.stamp(stampVo));
    }

    @PostMapping("/sign")
    public Result<List> sign(@RequestBody StampVo stampVo) {
        System.out.println(stampVo);
        return result.success(pdfService.sign(stampVo));
    }
}
