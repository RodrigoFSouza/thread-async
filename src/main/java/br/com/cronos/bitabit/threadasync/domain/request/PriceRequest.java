package br.com.cronos.bitabit.threadasync.domain.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceRequest implements Serializable {

    private Long productId;
    private BigDecimal price;

}
