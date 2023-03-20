package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Item;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseBuilder {

    void setDateReference(LocalDate dateReference);
    void setItems(List<Item> items);
    void setComments(String comments);
    void setIsDone(Boolean isDone);

}
