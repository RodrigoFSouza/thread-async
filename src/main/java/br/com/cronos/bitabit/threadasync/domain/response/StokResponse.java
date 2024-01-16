package br.com.cronos.bitabit.threadasync.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StokResponse {

    private Long productId;
    private BigDecimal quantity;
    private String message;
}
