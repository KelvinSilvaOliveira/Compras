package com.listadecompras.compras.core.usecases.market.impl;

import com.listadecompras.compras.core.dataprovider.CompraDataProvider;
import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.factory.impl.CompraMarketFactory;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.usecases.market.GenerateCompraListUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashMap;

import static java.time.LocalDate.now;

@Slf4j
@RequiredArgsConstructor
public class GenerateCompraMarketUseCase implements GenerateCompraListUseCase {

    private final CompraDataProvider compraDataProvider;

    @Override
    public Compra generateList() {
        log.info("Generating list of compra to the mounth {}", now().getMonth());

        LocalDate lastMounth = LocalDate.of(now().getYear(), now().getMonth().minus(1), now().getDayOfMonth());

        Purchase purchase = (Purchase) compraDataProvider.searchCompra(lastMounth);

        if (purchase == null) return null;

        if (!purchase.isDone()) return purchase;

        var items = new HashMap<String, Integer>();

        purchase.items().forEach(item ->
                items.put(item.product().name(), item.isBought() ? (item.quantity()/3)*2 : item.quantity()));

        return new CompraMarketFactory(items, "Baseada na lista de " + purchase.dateReference().getMonth().name().toLowerCase())
                .create();
    }
}
