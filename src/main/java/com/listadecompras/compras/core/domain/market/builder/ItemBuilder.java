package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Product;

public interface ItemBuilder {

    void setProduct(Product product);

    void setQuantity(Integer quantity);

    void setBought(Boolean isBought);
}
