package com.listadecompras.compras.core.domain.market.builder.concrete;

import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.builder.ItemBuilder;

public class ItemConcrete implements ItemBuilder {

    private Product product;
    private Integer quantity;
    private Boolean isBought;

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setBought(Boolean isBought) {
        this.isBought = isBought;
    }

    public Item getItem() {
        return new Item(this.product, this.quantity, this.isBought);
    }
}
