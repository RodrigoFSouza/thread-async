package br.com.cronos.bitabit.threadasync.services;

import br.com.cronos.bitabit.threadasync.domain.constants.QueueName;
import br.com.cronos.bitabit.threadasync.domain.request.PriceRequest;
import br.com.cronos.bitabit.threadasync.domain.request.StokRequest;
import br.com.cronos.bitabit.threadasync.domain.response.PriceResponse;
import br.com.cronos.bitabit.threadasync.domain.response.StokResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitService rabbitService;
    public StokResponse updateStok(StokRequest request) {
        rabbitService.sendMessage(QueueName.STOK.name(), request);
        return new StokResponse(request.getProductId(), request.getQuantity(), "Send Message Update Stok");
    }

    public PriceResponse updatePrice(PriceRequest request) {
        rabbitService.sendMessage(QueueName.PRICE.name(), request);
        return new PriceResponse(request.getProductId(), request.getPrice(), "Send Message Update Price");
    }
}
