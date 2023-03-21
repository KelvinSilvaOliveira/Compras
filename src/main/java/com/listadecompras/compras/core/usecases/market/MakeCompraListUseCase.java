package com.listadecompras.compras.core.usecases.market;

import java.util.Map;

public interface MakeCompraListUseCase {

    void makeCompraList(Map<String, Integer> items, String comment);

}
