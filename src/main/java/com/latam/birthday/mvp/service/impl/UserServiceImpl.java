package com.latam.birthday.mvp.service.impl;

import com.latam.birthday.mvp.exception.InvalidNameException;
import com.latam.birthday.mvp.helper.PoemMapperHelper;
import com.latam.birthday.mvp.helper.RandomNumberHelper;
import com.latam.birthday.mvp.httpClient.PoemClient;
import com.latam.birthday.mvp.model.Poem;
import com.latam.birthday.mvp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private PoemClient poemClient;
    private PoemMapperHelper poemMapperHelper;
    private RandomNumberHelper randomNumberHelper;

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
                throw new InvalidNameException("Incomplete name");
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

    @Override
    public Poem getRandomPoem() {
        String poems = poemClient.getPoemsList();
        Poem poem = new Poem();
        if(poems != null && !poems.isEmpty()) {
            List<Poem> poemList = poemMapperHelper.mapPoems(poems);
            poem = poemList.get(randomNumberHelper.getRandomNumber(poemList.size()));
        }
        return poem;
    }
}
