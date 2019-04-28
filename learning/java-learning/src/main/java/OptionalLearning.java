package com.tobe.java;


import java.util.Optional;

import com.tobe.java.entity.User;

/**
 * @author CNan
 * @date 2018/12/7
 * @desc
 */
public class OptionalLearning {

    public static void main(String[] args) {

    }

    public void optionalMapOfNullable(String id) {
        User user = Optional.ofNullable(id)
                .map(o -> new User().setId(o))
                .orElseGet(
                        () -> new User().setId("DEFAULT_ID")
                );
    }
}
