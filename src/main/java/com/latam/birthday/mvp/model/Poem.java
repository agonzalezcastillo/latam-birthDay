package com.latam.birthday.mvp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@ToString
public class Poem {

    private String title;
    private String content;
    private String url;
    private Poet poet;


}
