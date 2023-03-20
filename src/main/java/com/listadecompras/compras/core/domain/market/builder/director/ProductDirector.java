package com.listadecompras.compras.core.domain.market.builder.director;

import com.listadecompras.compras.core.domain.market.builder.ProductBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductDirector {

    private final ProductBuilder builder;

    public void createProduct(String name) {
        builder.setName(name);
        builder.setWeight(null);
        builder.setAmount(null);
    }

    public void createProductBought(String name, Double weight, Double amount) {
        builder.setName(name);
        builder.setWeight(weight);
        builder.setAmount(amount);
    }
}
