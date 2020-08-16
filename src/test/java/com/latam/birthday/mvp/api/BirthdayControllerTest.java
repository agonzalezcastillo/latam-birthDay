package com.latam.birthday.mvp.api;

import com.latam.birthday.mvp.model.User;
import com.latam.birthday.mvp.service.UserInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayControllerTest {

    @InjectMocks
    private BirthdayController birthdayController;

    @Mock
    private UserInformationService userInformationService;

    private User userInfo;

    @Before
    public void setUp(){

        userInfo = User.builder()
            .poem("Poema")
            .name("alejandro gonzalez")
            .daysToBirthday(300L)
            .build();
    }

    @Test
    public void daysToBirthDayTest() throws Exception {
        when(userInformationService.getUserInformation(any())).thenReturn(userInfo);
        ResponseEntity res = birthdayController.daysToBirthDay(userInfo);
        verify(userInformationService).getUserInformation(any());
        assertNotNull(res);
        assertEquals(200, res.getStatusCodeValue());
    }
}
