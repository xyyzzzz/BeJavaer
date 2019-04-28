package com.tobe.springcloudfeignlearning;

import com.tobe.core.response.Result;
import com.tobe.mail.Protocol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CNan
 * @date 2018/12/16
 */
@RestController
@RequestMapping(value = "mail")
public class MailController {

    @Autowired
    private MailClient mailClient;

    @RequestMapping(value = "/test")
    public Result test() {

        return mailClient
            .test(
                new Protocol.Test
                    .Input()
                    .setName("fwq")
                    .setEmail("fangwq@yealink.com")
            );
    }
}
