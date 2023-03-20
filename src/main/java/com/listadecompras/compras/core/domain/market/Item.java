package com.listadecompras.compras.core.domain.market;

public record Item(Product product, Integer quantity, Boolean isBought) {

    public Double totalWeight() {
        if(this.product() == null) return null;
        return multiplyForQuantity(this.product().weight());
    }

    public Double totalAmount() {
        if(this.product() == null) return null;
        return multiplyForQuantity(this.product().amount());
    }

    private Double multiplyForQuantity(Double amount) {
        if(this.isBought() == null || this.quantity() == null) return null;
        return this.isBought() ? amount * this.quantity() : 0;
    }
}
