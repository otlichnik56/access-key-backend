package com.example.accesskeybackend.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.net.*;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class SupportIP6Service {

    private final Logger logger = LoggerFactory.getLogger(SupportIP6Service.class);

    public Boolean check(String siteUrl) throws UnknownHostException, MalformedURLException {
        String domainName =  siteUrl.replaceAll("http(s)?://|www\\.|/.*", "");
        InetAddress[] listIp = Inet6Address.getAllByName(domainName);
        Inet6Address ipv6 = getIPv6Addresses(listIp);
        logger.info(Arrays.toString(listIp));
        return ipv6 != null;
    }

    public Inet6Address getIPv6Addresses(InetAddress[] addresses) {
        for (InetAddress addr : addresses) {
            if (addr instanceof Inet6Address) {
                return (Inet6Address) addr;
            }
        }
        return null;
    }

}
