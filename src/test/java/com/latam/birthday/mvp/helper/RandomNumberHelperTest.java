package com.latam.birthday.mvp.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RandomNumberHelperTest {

    @InjectMocks
    private RandomNumberHelper randomNumberHelper;

    @Test
    public void getRandomNumberTestOK(){
        Integer num = randomNumberHelper.getRandomNumber(5);
        assertNotNull(num);
        assertTrue(num < 5);
        assertTrue(num >= 0);
    }

}
