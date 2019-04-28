package github;

import feign.*;
import java.util.*;

public interface GitHub {

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> getContributors(@Param("owner") String owner, @Param("repo") String repository);

    class Contributor {
        String login;
        int contributions;

        @Override
        public String toString() {
            return "Contributor{" +
                "login='" + login + '\'' +
                ", contributions=" + contributions +
                '}';
        }
    }
}