package com.latam.birthday.mvp.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latam.birthday.mvp.model.Poem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PoemMapperHelper {

    public List<Poem> mapPoems(String poems){
        ObjectMapper om = new ObjectMapper();
        List<Poem> poemsList = new ArrayList<>();
        try{
            poemsList = om.readValue(poems, new TypeReference<List<Poem>>() {});
        }catch (IOException e){
            log.error(e.getMessage());
        }

        return poemsList;
    }

}
