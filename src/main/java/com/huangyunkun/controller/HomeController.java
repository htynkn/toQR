package com.huangyunkun.controller;

import com.huangyunkun.service.TorrentService;
import net.glxn.qrgen.javase.QRCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TorrentService torrentService;

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/")
    public String transformFileToQR(@RequestParam("file") MultipartFile file, Model model) throws IOException, NoSuchAlgorithmException {
        File torrent = File.createTempFile("torrent", ".torrent");
        file.transferTo(torrent);
        logger.info("Saving file to {}", torrent.getPath());
        String link = torrentService.getLink(torrent);
        logger.info("Torrent link is {}", link);
        File QR = QRCode.from(link).withSize(512, 512).file();
        logger.info("QR file path: " + QR.getAbsolutePath());
        model.addAttribute("fileName", QR.getName());
        return "home";
    }
}
