package com.latam.birthday.mvp.service.impl;

import com.latam.birthday.mvp.model.Poem;
import com.latam.birthday.mvp.model.User;
import com.latam.birthday.mvp.service.UserInformationService;
import com.latam.birthday.mvp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
@AllArgsConstructor
public class UserInformationServiceImpl implements UserInformationService {

    UserService userService;


    @Override
    public User getUserInformation(User user) throws Exception {
        Poem poem = userService.getRandomPoem();
        User userInfo = User.builder()
                .age(userService.getUserAge(user.getBirthDay()))
                .name(userService.getuserName(user.getName()))
                .daysToBirthday(userService.getUserDaysToBirthday(user.getBirthDay()))
                .build();
        if(userInfo.getDaysToBirthday() == 0){
            userInfo.setPoem(poem.getContent());
        }
        return userInfo;
    }
}
