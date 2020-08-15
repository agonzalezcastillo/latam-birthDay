package com.latam.birthday.mvp.helper;

import com.latam.birthday.mvp.model.Poem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PoemMapperHelperTest {

    @InjectMocks
    private PoemMapperHelper poemMapperHelper;

    private String poemsStr;
    private List<Poem> poemsList;

    @Before
    public void setUp(){
        poemsList = new ArrayList<>();
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
                "        \"title\": \"Poema 5\",\n" +
                "        \"content\": \"Contenido poema 5\",\n" +
                "        \"url\": \"url poema 5\",\n" +
                "        \"poet\": {\n" +
                "            \"name\": \"alejandro gonzalez\",\n" +
                "            \"url\": \"url alejandro gonzalez\"\n" +
                "        }\n" +
                "    }\n" +
                "]";
    }

    @Test
    public void mapPoemsTestOK(){
        poemsList = poemMapperHelper.mapPoems(poemsStr);
        assertNotNull(poemsList);
        assertEquals(5, poemsList.size());
        assertEquals("Contenido poema 3", poemsList.get(2).getContent());

    }
}
