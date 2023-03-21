package com.listadecompras.compras.core.usecases.market.impl;

import com.listadecompras.compras.core.dataprovider.CompraDataProvider;
import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.factory.impl.CompraMarketRenewedFactory;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.usecases.market.EnrichCompraListUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class EnrichCompraMarketUseCase implements EnrichCompraListUseCase {

    private final CompraDataProvider compraDataProvider;

    @Override
    public Compra enrichCompraList(Compra compra, Map<String, AbstractMap.SimpleEntry<Double, Double>> addendum) {
        Purchase purchase = (Purchase) new CompraMarketRenewedFactory((Purchase) compra, addendum).create();

        log.info("Received compra of market: {}", purchase);

        if(purchase == null) return null;

        if(!purchase.isDone()) return null;

        if(purchase.items().isEmpty()) return null;

        compraDataProvider.updateCompra(purchase);
        log.info("Compra renewed...");

        return purchase;
    }
}
