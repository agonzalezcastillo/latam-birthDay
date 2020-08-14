package com.latam.birthday.mvp.service;

import com.latam.birthday.mvp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserInformationService {

    User getUserInformation(User user) throws Exception;
}
