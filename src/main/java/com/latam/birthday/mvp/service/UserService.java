package com.latam.birthday.mvp.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface UserService {

    String getuserName(String name) throws Exception;
    Integer getUserAge(LocalDate birthDay);
    Long getUserDaysToBirthday(LocalDate birthDay);

}
