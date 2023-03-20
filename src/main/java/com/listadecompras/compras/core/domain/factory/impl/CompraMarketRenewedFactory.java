package com.listadecompras.compras.core.domain.factory.impl;

import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.factory.CompraFactory;
import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.domain.market.builder.concrete.ItemConcrete;
import com.listadecompras.compras.core.domain.market.builder.concrete.ProductConcrete;
import com.listadecompras.compras.core.domain.market.builder.concrete.PurchaseConcrete;
import com.listadecompras.compras.core.domain.market.builder.director.ItemDirector;
import com.listadecompras.compras.core.domain.market.builder.director.ProductDirector;
import com.listadecompras.compras.core.domain.market.builder.director.PurchaseDirector;
import lombok.RequiredArgsConstructor;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class CompraMarketRenewedFactory implements CompraFactory {

    private final Purchase purchase;

    private final Map<String, AbstractMap.SimpleEntry<Double, Double>> complement;

    @Override
    public Compra create() {
        if(this.purchase == null) return null;

        if( purchase.items() == null || purchase.items().isEmpty() ||
            this.complement == null || this.complement.isEmpty()) return this.purchase;

        ProductConcrete productConcrete = new ProductConcrete();
        ProductDirector productDirector = new ProductDirector(productConcrete);

        ItemConcrete itemConcrete = new ItemConcrete();
        ItemDirector itemDirector = new ItemDirector(itemConcrete);

        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        PurchaseDirector purchaseDirector = new PurchaseDirector(purchaseConcrete);

        purchaseDirector.constructPurchaseDone(purchase.items().stream()
                .map(item -> {
                    var isBought = isProductBought(complement, item.product());

                    if (isBought) {
                        var additionalInfo = Optional.ofNullable(complement.get(item.product().name())).orElse(new AbstractMap.SimpleEntry<>(null, null));
                        productDirector.createProductBought(item.product().name(), additionalInfo.getKey(), additionalInfo.getValue());
                        itemDirector.constructItemBought(productConcrete.getProduct(), item.quantity());
                        return itemConcrete.getItem();
                    }

                    return item;
                })
                .toList(), purchase);

        return purchaseConcrete.getPurchase();
    }

    private boolean isProductBought(Map<String, AbstractMap.SimpleEntry<Double, Double>> complement, Product product) {
        boolean isBought = complement.containsKey(product.name());

        if(isBought) isBought = complement.get(product.name()).getKey() != null && complement.get(product.name()).getValue() != null;

        return isBought;
    }

}
