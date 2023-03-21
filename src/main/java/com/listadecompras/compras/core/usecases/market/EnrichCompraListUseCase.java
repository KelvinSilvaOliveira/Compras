package com.listadecompras.compras.core.usecases.market;

import com.listadecompras.compras.core.domain.Compra;

import java.util.AbstractMap;
import java.util.Map;

public interface EnrichCompraListUseCase {

    Compra enrichCompraList(Compra compra, Map<String, AbstractMap.SimpleEntry<Double, Double>> addendum);

}
