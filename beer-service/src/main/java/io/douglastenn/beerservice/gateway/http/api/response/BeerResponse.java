package io.douglastenn.beerservice.gateway.http.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class BeerResponse {

    private String id;

    private String name;

    private String brand;

    private Long energy;

    private Long carbohydrate;

    private Long protein;
}
