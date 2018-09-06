package io.douglastenn.beerservice.gateway.http.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class BeerRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String brand;

    private Long energy;

    private Long carbohydrate;

    private Long protein;
}
