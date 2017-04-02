package com.huangyunkun.service;

import com.turn.ttorrent.common.Torrent;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
public class TorrentService {
    public String getLink(File file) throws IOException, NoSuchAlgorithmException {
        Torrent torrent = new Torrent(FileUtils.readFileToByteArray(file), false);
        return "magnet:?xt=urn:btih:" + torrent.getHexInfoHash();
    }
}
