package com.example.accesskeybackend.controler;

import com.example.accesskeybackend.service.SupportIP6Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

@Slf4j
@RestController
public class SupportIP6Controller {

    private final SupportIP6Service supportIP6Service;

    public SupportIP6Controller(SupportIP6Service supportIP6Service) {
        this.supportIP6Service = supportIP6Service;
    }

    @PostMapping("/api/web/checkIpv6Support")
    public ResponseEntity<?> updateAds(@RequestBody String siteUrl) throws UnknownHostException, MalformedURLException {
        return ResponseEntity.status(200).body(supportIP6Service.check(siteUrl));
    }

}
