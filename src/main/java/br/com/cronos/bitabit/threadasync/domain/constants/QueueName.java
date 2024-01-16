package br.com.cronos.bitabit.threadasync.domain.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum QueueName {
    STOK("Stok"), PRICE("Price");

    private String description;
}
