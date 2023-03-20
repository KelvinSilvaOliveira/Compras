package com.listadecompras.compras.core.domain.market.builder.concrete;

import com.listadecompras.compras.core.domain.market.builder.ProductBuilder;
import com.listadecompras.compras.core.domain.market.Product;

public class ProductConcrete implements ProductBuilder {

    private String name;
    private Double weight;
    private Double amount;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return new Product(this.name, this.weight, this.amount);
    }
}
