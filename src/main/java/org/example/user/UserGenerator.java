package org.example.user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {

    public FullUser generic(){
        return new FullUser(RandomStringUtils.randomAlphabetic(3,8)+"@yandex.ru", "12345", "oleg");
    }
}
