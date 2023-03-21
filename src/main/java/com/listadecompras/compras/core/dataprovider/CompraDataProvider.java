package com.listadecompras.compras.core.dataprovider;

import com.listadecompras.compras.core.domain.Compra;

import java.time.LocalDate;
import java.util.List;

public interface CompraDataProvider {

    public Compra registerCompra(Compra compra);

    public Compra updateCompra(Compra compra);

    public Compra searchCompra(LocalDate dateReference);

    public List<Compra> searchCompras();
}
