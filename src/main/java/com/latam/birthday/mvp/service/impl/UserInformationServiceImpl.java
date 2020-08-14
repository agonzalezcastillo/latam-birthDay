package com.latam.birthday.mvp.service.impl;

import com.latam.birthday.mvp.model.User;
import com.latam.birthday.mvp.service.UserInformationService;
import com.latam.birthday.mvp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInformationServiceImpl implements UserInformationService {

    UserService userService;

    @Override
    public User getUserInformation(User user) throws Exception {
        User userInfo = User.builder()
                .age(userService.getUserAge(user.getBirthDay()))
                .name(userService.getuserName(user.getName()))
                .daysToBirthday(userService.getUserDaysToBirthday(user.getBirthDay()))
                .build();
        return userInfo;
    }
}
