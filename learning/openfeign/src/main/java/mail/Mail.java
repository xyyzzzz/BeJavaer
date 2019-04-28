package mail;

import feign.Headers;
import feign.RequestLine;

import com.tobe.core.response.Result;
import com.tobe.mail.Protocol;

public interface Mail {

    @RequestLine("POST /api/v1/mail/test")
    @Headers("Content-Type: application/json")
    Result test(Protocol.Test.Input input);

}