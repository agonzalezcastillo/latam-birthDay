package com.latam.birthday.mvp.api;

import com.latam.birthday.mvp.model.User;
import com.latam.birthday.mvp.service.UserInformationService;
import com.latam.birthday.mvp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class BirthdayController {

    private UserService userService;
    private UserInformationService userInformationService;

    @RequestMapping(value = "/birthday", consumes = "application/json", produces = "application/json",  method = RequestMethod.GET)
    public ResponseEntity<User> getDaysToBirthDay(@Validated @RequestBody User user) throws Exception {

        User userInfo = userInformationService.getUserInformation(user);

        return new ResponseEntity<User>(userInfo,  HttpStatus.OK);
    }
}