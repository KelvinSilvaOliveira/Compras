package com.listadecompras.compras.application.dataprovider.memory;

import com.listadecompras.compras.core.dataprovider.CompraDataProvider;
import com.listadecompras.compras.core.domain.Compra;

import java.time.LocalDate;
import java.util.List;

public class CompraMemoryRepository implements CompraDataProvider {

    private Compra compraSaved;

    @Override
    public Compra registerCompra(Compra compra) {
        return this.compraSaved = compra;
    }

    @Override
    public Compra updateCompra(Compra compra) {
        return this.compraSaved = compra;
    }

    @Override
    public Compra searchCompra(LocalDate dateReference) {
        return this.compraSaved;
    }

    @Override
    public List<Compra> searchCompras() {
        return List.of(this.compraSaved);
    }
}
