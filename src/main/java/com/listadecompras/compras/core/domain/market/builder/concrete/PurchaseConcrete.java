package com.listadecompras.compras.core.domain.market.builder.concrete;

import com.listadecompras.compras.core.domain.market.builder.PurchaseBuilder;
import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Purchase;

import java.time.LocalDate;
import java.util.List;

public class PurchaseConcrete implements PurchaseBuilder {

    private LocalDate dateReference;
    private List<Item> items;
    private String comments;
    private Boolean isDone;

    @Override
    public void setDateReference(LocalDate dateReference) {
        this.dateReference = dateReference;
    }

    @Override
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Purchase getPurchase() {
        return new Purchase(this.dateReference, this.items, this.comments, this.isDone);
    }

}
