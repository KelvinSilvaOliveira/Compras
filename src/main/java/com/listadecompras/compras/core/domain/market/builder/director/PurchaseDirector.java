package com.listadecompras.compras.core.domain.market.builder.director;

import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.domain.market.builder.PurchaseBuilder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class PurchaseDirector {

    private final PurchaseBuilder builder;

    public void constructPurchase(List<Item> items, String comment) {
        builder.setDateReference(LocalDate.now());
        builder.setItems(items);
        builder.setComments(comment);
        builder.setIsDone(false);
    }

    public void constructPurchaseDone(List<Item> items, Purchase purchaseReference) {
        if (purchaseReference == null) return;
        builder.setDateReference(purchaseReference.dateReference());
        builder.setItems(items);
        builder.setComments(purchaseReference.comments());
        builder.setIsDone(true);
    }

}
