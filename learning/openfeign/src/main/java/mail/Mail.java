package mail;

import feign.Headers;
import feign.RequestLine;


public interface Mail {

    @RequestLine("POST /api/v1/mail/test")
    @Headers("Content-Type: application/json")
    Result test(Protocol.Test.Input input);

}