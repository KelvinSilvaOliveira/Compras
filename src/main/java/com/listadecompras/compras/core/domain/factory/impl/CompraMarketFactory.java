package com.listadecompras.compras.core.domain.factory.impl;

import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.factory.CompraFactory;
import com.listadecompras.compras.core.domain.market.builder.concrete.ItemConcrete;
import com.listadecompras.compras.core.domain.market.builder.concrete.ProductConcrete;
import com.listadecompras.compras.core.domain.market.builder.concrete.PurchaseConcrete;
import com.listadecompras.compras.core.domain.market.builder.director.ItemDirector;
import com.listadecompras.compras.core.domain.market.builder.director.ProductDirector;
import com.listadecompras.compras.core.domain.market.builder.director.PurchaseDirector;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class CompraMarketFactory implements CompraFactory {

    private final Map<String, Integer> items;
    private final String comment;

    @Override
    public Compra create() {
        if(this.items == null || this.items.isEmpty()) return null;

        ProductConcrete productConcrete = new ProductConcrete();
        ProductDirector productDirector = new ProductDirector(productConcrete);

        ItemConcrete itemConcrete = new ItemConcrete();
        ItemDirector itemDirector = new ItemDirector(itemConcrete);

        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        PurchaseDirector purchaseDirector = new PurchaseDirector(purchaseConcrete);

        purchaseDirector.constructPurchase(items.entrySet().stream()
                .map(item -> {
                    productDirector.createProduct(item.getKey());
                    itemDirector.constructItem(productConcrete.getProduct(), item.getValue());
                    return itemConcrete.getItem();
                })
                .toList(), comment);

        return purchaseConcrete.getPurchase();
    }

}
