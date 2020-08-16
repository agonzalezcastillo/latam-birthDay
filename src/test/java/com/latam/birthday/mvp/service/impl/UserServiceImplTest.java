package com.latam.birthday.mvp.service.impl;

import com.latam.birthday.mvp.exception.InvalidNameException;
import com.latam.birthday.mvp.helper.PoemMapperHelper;
import com.latam.birthday.mvp.helper.RandomNumberHelper;
import com.latam.birthday.mvp.httpClient.PoemClient;
import com.latam.birthday.mvp.model.Poem;
import com.latam.birthday.mvp.model.Poet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private PoemClient poemClient;

    @Mock
    private PoemMapperHelper poemMapperHelper;

    @Mock
    private RandomNumberHelper randomNumberHelper;

    private String name;
    private String wrongName;
    private LocalDate birthDay;
    private String poemsStr;
    private String emptyPoemsStr;
    private Poet poet;
    private Poem poem1;
    private Poem poem2;
    private Poem poem3;
    private Poem poem4;
    private Poem poem5;
    private List<Poem> poemList;
    private List<Poem> emptyPoemList;

    @Before
    public void setUp(){
        name = "alejandro isaias gonzalez castillo";
        wrongName = "alejandro gonzalez";
        birthDay = LocalDate.now();
        poemsStr = "[\n" +
                "    {\n" +
                "        \"title\": \"Poema 1\",\n" +
                "        \"content\": \"Contenido poema 1\",\n" +
                "        \"url\": \"url poema 1\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"Poema 2\",\n" +
                "        \"content\": \"Contenido poema 2\",\n" +
                "        \"url\": \"url poema 2\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"Poema 3\",\n" +
                "        \"content\": \"Contenido poema 3\",\n" +
                "        \"url\": \"url poema 3\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"Poema 4\",\n" +
                "        \"content\": \"Contenido poema 4\",\n" +
                "        \"url\": \"url poema 4\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"Poema 4\",\n" +
                "        \"content\": \"Contenido poema 4\",\n" +
                "        \"url\": \"url poema 4\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"Poema 5\",\n" +
                "        \"content\": \"Contenido poema 5\",\n" +
                "        \"url\": \"url poema 5\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    }\n" +
                "]";
        poet = Poet.builder()
                .name("alejandro gonzalez")
                .url("alejandro gonzalez URL")
                .build();

        poem1 = Poem.builder()
                .content("contenido poema 1")
                .title("poema 1")
                .url("url poema 1")
                .poet(poet)
                .build();
        poem2 = Poem.builder()
                .content("contenido poema 2")
                .title("poema 2")
                .url("url poema 2")
                .poet(poet)
                .build();
        poem3 = Poem.builder()
                .content("contenido poema 3")
                .title("poema 3")
                .url("url poema 3")
                .poet(poet)
                .build();
        poem4 = Poem.builder()
                .content("contenido poema 4")
                .title("poema 4")
                .url("url poema 4")
                .poet(poet)
                .build();
        poem5 = Poem.builder()
                .content("contenido poema 5")
                .title("poema 5")
                .url("url poema 5")
                .poet(poet)
                .build();

        poemList = new ArrayList<>();
        emptyPoemList = new ArrayList<>();
        emptyPoemsStr = "";
        poemList.add(poem1);
        poemList.add(poem2);
        poemList.add(poem3);
        poemList.add(poem4);
        poemList.add(poem5);

    }

    @Test
    public void getUserNameOK() throws Exception {
        String pName = userService.getuserName(name);
        assertNotNull(pName);
        assertEquals("alejandro gonzalez", pName);
    }

    @Test(expected = InvalidNameException.class)
    public void getUserNameNOK() throws Exception {
        userService.getuserName(wrongName);
    }

    @Test
    public void getUserAgeOK(){
        Integer age = userService.getUserAge(birthDay);
        assertNotNull(age);
        assertEquals(new Integer(0), age);

    }

    @Test
    public void getUserAgeNullParam(){
        Integer age = userService.getUserAge(null);
        assertNotNull(age);
        assertEquals(new Integer(0), age);
    }

    @Test
    public void getUserDaysToBirthdayOK(){
        Long days = userService.getUserDaysToBirthday(birthDay);
        assertEquals(new Long(0),days);
        assertNotNull(days);

    }

    @Test
    public void getUserDaysToBirthdayNullParam(){
        Long days = userService.getUserDaysToBirthday(null);
        assertEquals(new Long(0),days);
        assertNotNull(days);

    }

    @Test
    public void getRandomPoemOK(){
        when(poemClient.getPoemsList()).thenReturn(poemsStr);
        when(poemMapperHelper.mapPoems(anyString())).thenReturn(poemList);
        when(randomNumberHelper.getRandomNumber(anyInt())).thenReturn(new Random().nextInt(5));
        Poem poem = userService.getRandomPoem();
        assertNotNull(poem);
        assertNotEquals("", poem.getContent());
    }

    @Test
    public void getRandomPoemNOK(){
        when(poemClient.getPoemsList()).thenReturn(emptyPoemsStr);
        when(poemMapperHelper.mapPoems(anyString())).thenReturn(emptyPoemList);
        when(randomNumberHelper.getRandomNumber(anyInt())).thenReturn(new Random().nextInt(5));
        Poem poem = userService.getRandomPoem();
        assertNotNull(poem);
        assertEquals(null,poem.getContent());
    }




}
