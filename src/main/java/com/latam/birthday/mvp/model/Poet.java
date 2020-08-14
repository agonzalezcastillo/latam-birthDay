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
public class Poet {

    private String name;
    private String url;
}
