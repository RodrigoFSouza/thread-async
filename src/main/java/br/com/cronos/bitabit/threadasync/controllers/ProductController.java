package br.com.cronos.bitabit.threadasync.controllers;

import br.com.cronos.bitabit.threadasync.domain.request.PriceRequest;
import br.com.cronos.bitabit.threadasync.domain.request.StokRequest;
import br.com.cronos.bitabit.threadasync.domain.response.PriceResponse;
import br.com.cronos.bitabit.threadasync.domain.response.StokResponse;
import br.com.cronos.bitabit.threadasync.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(":stok")
    public ResponseEntity<StokResponse> updateStok(@RequestBody StokRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateStok(request));
    }

    @PostMapping(":price")
    public ResponseEntity<PriceResponse> updateStok(@RequestBody PriceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.updatePrice(request));
    }

}
