package github;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class MyApp {

    @Test
    public void main() {
        GitHub github = Feign
            .builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(GitHub.class, "https://api.github.com");

        /* The owner and repository parameters will be used to expand the owner and repo expressions
         * defined in the RequestLine.
         *
         * the resulting uri will be https://api.github.com/repos/OpenFeign/feign/contributors
         */
        List<GitHub.Contributor> contributors = github.getContributors("OpenFeign", "feign");

        Optional
                .ofNullable(contributors)
                .ifPresent(o ->
                    o.forEach(System.out::println)
                );
    }
}