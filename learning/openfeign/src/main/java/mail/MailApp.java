package mail;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import java.util.Optional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobe.core.response.Result;
import com.tobe.mail.Protocol;
import com.tobe.utils.JSONUtil;

import org.junit.Test;

public class MailApp {

    @Test
    public void main() {
        ObjectMapper mapper = new ObjectMapper();

        // 设置将未知的枚举置为null
        mapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

        // 设置跳过未知属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Mail mail = Feign
            .builder()
            .client(new ApacheHttpClient())
            .encoder(new JacksonEncoder(mapper))
            .decoder(new JacksonDecoder(mapper))
            .retryer(Retryer.NEVER_RETRY)
            .options(new Request.Options(5000, 10000))
            .logLevel(Logger.Level.HEADERS)
            .target(Mail.class, "http://127.0.0.1:8002");

        /* The owner and repository parameters will be used to expand the owner and repo expressions
         * defined in the RequestLine.
         *
         * the resulting uri will be https://api.github.com/repos/OpenFeign/feign/contributors
         */
        Result result = mail.test(new Protocol.Test.Input()
            .setEmail("fwq")
            .setName("liubing"));

        Optional
            .ofNullable(result)
            .filter(o -> o.getRet() >= 0)
            .ifPresent(o -> {
                    System.out.print(JSONUtil.serialize(o));
                }
            );
    }
}