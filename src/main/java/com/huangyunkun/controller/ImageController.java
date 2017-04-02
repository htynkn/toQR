package com.huangyunkun.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
public class ImageController {
    @ResponseBody
    @RequestMapping(value = "/qrs/{filename}.{ext}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] showImages(@PathVariable String filename, @PathVariable String ext) throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir"), String.format("%s.%s", filename, ext));
        return FileUtils.readFileToByteArray(file);
    }
}
