package com.latam.birthday.mvp.httpClient;


import com.latam.birthday.mvp.model.Poem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class PoemClient {

    public String getPoemsList(){
        RestTemplate rt = new RestTemplate();
        String response;
        try{
            response = rt.exchange("https://www.poemist.com/api/v1/randompoems",
                    HttpMethod.GET,null,String.class).getBody();

        }catch(HttpClientErrorException e){
            log.error("Has been an error consulting the poems API");
            throw new HttpClientErrorException(e.getStatusCode(), e.getStatusText());
        }
        return response;
    }

}
