package com.latam.birthday.mvp.helper;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberHelper {

    public Integer getRandomNumber(int listSize) {
        Random rand = new Random();
        return rand.nextInt(listSize);
    }

}
