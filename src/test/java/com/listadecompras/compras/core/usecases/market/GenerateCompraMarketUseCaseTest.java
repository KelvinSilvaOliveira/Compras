package com.listadecompras.compras.core.usecases.market;

import com.listadecompras.compras.core.dataprovider.CompraDataProvider;
import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.usecases.market.impl.GenerateCompraMarketUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class GenerateCompraMarketUseCaseTest {

    private CompraDataProvider compraDataProvider = newCompraDataProvider();

    @Test
    public void generateList_success() {
        // given
        var generateCompraListUseCase  = new GenerateCompraMarketUseCase(this.compraDataProvider);
        var product = new Product("teste", 1., 1.);
        var item = new Item(product, 3, true);
        var compra = new Purchase(LocalDate.now().minusMonths(1), List.of(item), "testando", true);
        this.compraDataProvider.registerCompra(compra);

        // when
        var purchase = (Purchase) generateCompraListUseCase.generateList();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), LocalDate.now());
        Assertions.assertEquals(
                List.of(new Item(new Product("teste", null, null), 2, false)),
                purchase.items()
        );
        Assertions.assertEquals(
                "Baseada na lista de "+purchase.dateReference().minusMonths(1).getMonth().name().toLowerCase(),
                purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
    }

    @Test
    public void generateList_without_compra() {
        // given
        var generateCompraListUseCase  = new GenerateCompraMarketUseCase(this.compraDataProvider);

        // when
        var purchase = (Purchase) generateCompraListUseCase.generateList();

        // then
        Assertions.assertNull(purchase);
    }

    @Test
    public void generateList_with_compra_no_done() {
        // given
        var generateCompraListUseCase  = new GenerateCompraMarketUseCase(this.compraDataProvider);
        var product = new Product("teste", null, null);
        var item = new Item(product, 3, false);
        var compra = new Purchase(LocalDate.now().minusMonths(1), List.of(item), "testando", false);
        this.compraDataProvider.registerCompra(compra);

        // when
        var purchase = (Purchase) generateCompraListUseCase.generateList();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), LocalDate.now());
        Assertions.assertEquals(
                List.of(new Item(new Product("teste", null, null), 3, false)),
                purchase.items()
        );
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
    }

    private CompraDataProvider newCompraDataProvider() {
        return new CompraDataProvider() {

            private Compra compra;

            @Override
            public Compra registerCompra(Compra compra) {
                return this.compra = compra;
            }

            @Override
            public Compra updateCompra(Compra compra) {
                return this.compra = compra;
            }

            @Override
            public Compra searchCompra(LocalDate dateReference) {
                Purchase purchase = (Purchase) this.compra;
                if(purchase == null) return null;
                return purchase.dateReference().getMonth().equals(dateReference.getMonth()) ?
                        purchase : null;
            }

            @Override
            public List<Compra> searchCompras() {
                return List.of(this.compra);
            }
        };
    }
}
