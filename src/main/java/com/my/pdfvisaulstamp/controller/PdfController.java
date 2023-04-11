package com.my.pdfvisaulstamp.controller;

import com.my.pdfvisaulstamp.service.PdfService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/thwartwise")
    public String getPdfBase64() {
        return "";
    }
}
