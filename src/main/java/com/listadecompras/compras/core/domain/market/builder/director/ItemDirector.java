package com.listadecompras.compras.core.domain.market.builder.director;

import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.builder.ItemBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemDirector {

    private final ItemBuilder builder;

    public void constructItem(Product product, Integer quantity) {
        builder.setProduct(product);
        builder.setQuantity(quantity);
        builder.setBought(false);
    }

    public void constructItemBought(Product product, Integer quantity) {
        builder.setProduct(product);
        builder.setQuantity(quantity);
        builder.setBought(true);
    }
}