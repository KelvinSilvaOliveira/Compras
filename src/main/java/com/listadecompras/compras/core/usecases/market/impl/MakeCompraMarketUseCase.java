package com.listadecompras.compras.core.usecases.market.impl;

import com.listadecompras.compras.core.dataprovider.CompraDataProvider;
import com.listadecompras.compras.core.domain.factory.impl.CompraMarketFactory;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.usecases.market.MakeCompraListUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class MakeCompraMarketUseCase implements MakeCompraListUseCase {

    private final CompraDataProvider compraDataProvider;

    private static final int RANGE_MONTHS = 1;

    @Override
    public void makeCompraList(Map<String, Integer> items, String comment) {
        Purchase purchase = (Purchase) new CompraMarketFactory(items, comment).create();

        log.info("Received compra of market: {}", purchase);

        if(purchase == null) return;

        if(purchase.isDone()) return;

        if(purchase.items().isEmpty()) return;

        if(!isInsidePeriod(purchase.dateReference())) return;

        compraDataProvider.registerCompra(purchase);

        log.info("Saved compra...");
    }

    private Boolean isInsidePeriod(LocalDate dateReference) {
        LocalDate datePrevious = LocalDate.now().minusMonths(RANGE_MONTHS).withDayOfMonth(1);

        LocalDate dateLater = LocalDate.now().plusMonths(RANGE_MONTHS).withDayOfMonth(1);
        dateLater = dateLater.withDayOfMonth(dateLater.lengthOfMonth());

        return !dateReference.isBefore(datePrevious) && !dateReference.isAfter(dateLater);
    }

}
