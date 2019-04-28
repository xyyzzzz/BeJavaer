package com.tobe.springcloudfeignlearning;

import com.tobe.core.response.Result;
import com.tobe.mail.Protocol;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author CNan
 * @date 2018/12/16
 */
@FeignClient(name = "ms-mail",url = "http://127.0.0.1:8002")
public interface MailClient {
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/mail/test")
    Result test(@RequestBody Protocol.Test.Input input);

}
