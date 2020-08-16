package com.latam.birthday.mvp.service.impl;

import com.latam.birthday.mvp.model.Poem;
import com.latam.birthday.mvp.model.Poet;
import com.latam.birthday.mvp.model.User;
import com.latam.birthday.mvp.service.UserService;
import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserInformationServiceImplTest {

    @InjectMocks
    private UserInformationServiceImpl userInformationService;

    @Mock
    private UserService userService;

    private User user;
    private LocalDate birthDay;
    private Poem poem;
    private Poet poet;

    @Before
    public void setUp(){
        birthDay = LocalDate.now();
        user = User.builder()
                .build();

        poet = Poet.builder()
                .name("alejandro gonzalez")
                .url("url alejandro gonzalez")
                .build();

        poem = poem.builder()
                .content("Contenido poema")
                .title("Titulo poema")
                .url("url poema")
                .poet(poet)
                .build();
    }

    @Test
    public void getUserInformationTestOK() throws Exception {
        when(userService.getUserAge(any())).thenReturn(30);
        when(userService.getuserName(any())).thenReturn("alejandro gonzalez");
        when(userService.getUserDaysToBirthday(any())).thenReturn(300L);
        when(userService.getRandomPoem()).thenReturn(poem);

        User userInfo = userInformationService.getUserInformation(user);

        verify(userService).getUserAge(any());
        verify(userService).getuserName(any());
        verify(userService).getRandomPoem();
        verify(userService).getUserDaysToBirthday(any());
        assertNotNull(userInfo);
        assertEquals(new Integer(30),userInfo.getAge());
        assertEquals(new Long(300), userInfo.getDaysToBirthday());
        assertEquals("alejandro gonzalez", userInfo.getName());
    }
}
