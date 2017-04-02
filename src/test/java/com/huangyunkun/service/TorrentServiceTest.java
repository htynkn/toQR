package com.huangyunkun.service;

import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TorrentServiceTest {
    @Autowired
    private TorrentService torrentService;


    @Test
    public void shouldGetCorrentLink() throws Exception {
        String link = torrentService.getLink(new File(Resources.getResource("test-one.torrent").getFile()));

        assertThat(link.equalsIgnoreCase("magnet:?xt=urn:btih:549042BB96C13F90607538CCB19C9865992EFAE7"), is(true));
    }
}