package io.douglastenn.beerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

    @Id
    private String id;

    private String name;

    private String brand;

    private Long energy;

    private Long carbohydrate;

    private Long protein;
}
