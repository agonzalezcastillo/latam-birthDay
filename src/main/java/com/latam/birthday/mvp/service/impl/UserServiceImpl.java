package com.latam.birthday.mvp.service.impl;

import com.latam.birthday.mvp.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getuserName(String name) throws Exception {
        StringBuilder userName = new StringBuilder();
        if(name != null && !name.isEmpty()) {
            List<String> arrName = Arrays.asList(name.split(" "));
            if(arrName.size() == 4){
                userName.append(arrName.get(0));
                userName.append(" ");
                userName.append(arrName.get(2));
            }else{
                throw new Exception();
            }
        }
        return userName.toString();
    }

    @Override
    public Integer getUserAge(LocalDate birthDay) {
        LocalDate currentDate = LocalDate.now();
        Integer age = 0;
        if(birthDay != null){
            age = Period.between(birthDay, currentDate).getYears();
        }
        return age;
    }

    @Override
    public Long getUserDaysToBirthday(LocalDate birthDay) {
        LocalDate currentDate = LocalDate.now();
        Long days = 0L;

        if(birthDay != null){
            LocalDate nextBDay = birthDay.withYear(currentDate.getYear());
            if (nextBDay.isBefore(currentDate) || nextBDay.isEqual(currentDate)) {
                nextBDay = nextBDay.plusYears(1);
            }
            Period p = Period.between(currentDate, nextBDay);
            days = ChronoUnit.DAYS.between(currentDate, nextBDay);
            if(days == 365L)
                days = 0L;
        }
        return days;
    }
}
