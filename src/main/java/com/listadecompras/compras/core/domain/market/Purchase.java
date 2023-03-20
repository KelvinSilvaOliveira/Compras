package com.listadecompras.compras.core.domain.market;

import com.listadecompras.compras.core.domain.Compra;

import java.time.LocalDate;
import java.util.List;

public record Purchase(LocalDate dateReference, List<Item> items, String comments, Boolean isDone) implements Compra {

    public Integer getMonth() {
        if(this.dateReference() == null) return null;
        return this.dateReference().getMonth().getValue();
    }

    public Integer getYear() {
        if(this.dateReference() == null) return null;
        return this.dateReference().getYear();
    }

}
