package br.com.cronos.bitabit.threadasync.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class PriceResponse {

    private Long productId;
    private BigDecimal price;
    private String message;

}
