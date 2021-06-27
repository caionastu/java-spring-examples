package com.caionastu.javaspringexamples.java.builderPattern.product;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
class ProductMain {
    public static void main(String[] args) {
        Product product1 = Product.builder("Product 1", BigDecimal.valueOf(1.37), BigDecimal.TEN)
                .build();

        log.info("Product 1: {}", product1);

        Product product2 = Product.builder("Product 2", BigDecimal.valueOf(1.37), BigDecimal.TEN)
                .unitsOnOrder(BigDecimal.valueOf(5))
                .discontinued(true)
                .shortDescription("This is a short description for product 2")
                .longDescription("This is a long description for product 2")
                .build();

        log.info("Product 2: {}", product2);
    }
}
