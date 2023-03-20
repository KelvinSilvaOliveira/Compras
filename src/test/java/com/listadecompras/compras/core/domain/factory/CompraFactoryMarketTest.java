package com.listadecompras.compras.core.domain.factory;

import com.listadecompras.compras.core.domain.factory.impl.CompraMarketFactory;
import com.listadecompras.compras.core.domain.factory.impl.CompraMarketRenewedFactory;
import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.Purchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class CompraFactoryMarketTest {

    @Test
    public void getCompraMarket_success() {
        // given
        var items = new HashMap<String, Integer>();
        items.put("teste", 1);

        CompraFactory compraFactory = new CompraMarketFactory(items, "teste");

        // when
        Purchase purchase = (Purchase) compraFactory.create();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(
                List.of(new Item(new Product("teste", null, null), 1, false)),
                purchase.items()
        );
        Assertions.assertEquals("teste", purchase.comments());
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertFalse(purchase.isDone());
    }

    @Test
    public void getCompraMarket_without_items() {
        // given
        CompraFactory compraFactory = new CompraMarketFactory(null, "teste");

        // when
        Purchase purchase = (Purchase) compraFactory.create();

        // then
        Assertions.assertNull(purchase);
    }

    @Test
    public void getCompraMarket_with_items_empty() {
        // given
        CompraFactory compraFactory = new CompraMarketFactory(new HashMap<>(), "teste");

        // when
        Purchase purchase = (Purchase) compraFactory.create();

        // then
        Assertions.assertNull(purchase);
    }

    @Test
    public void getCompraMarket_without_comment() {
        // given
        var items = new HashMap<String, Integer>();
        items.put("teste", 1);

        CompraFactory compraFactory = new CompraMarketFactory(items, null);

        // when
        Purchase purchaseRenewed = (Purchase) compraFactory.create();

        // then
        Assertions.assertNotNull(purchaseRenewed);
        Assertions.assertEquals(
                List.of(new Item(new Product("teste", null, null), 1, false)),
                purchaseRenewed.items()
        );
        Assertions.assertNull(purchaseRenewed.comments());
        Assertions.assertEquals(LocalDate.now(), purchaseRenewed.dateReference());
        Assertions.assertFalse(purchaseRenewed.isDone());
    }

    @Test
    public void getCompraMarketRenewed_success() {
        // given
        Purchase purchase = new Purchase(LocalDate.now(),
                List.of(new Item(new Product("teste", null, null), 1, false),
                        new Item(new Product("outro", null, null), 1, false)
                ), "teste", false);

        var complement = new HashMap<String, AbstractMap.SimpleEntry<Double, Double>>();
        complement.put("teste", new AbstractMap.SimpleEntry<>(1., 1.));
        complement.put("outro", new AbstractMap.SimpleEntry<>(null, null));
        complement.put("testando", new AbstractMap.SimpleEntry<>(1., 1.));

        CompraFactory compraFactory = new CompraMarketRenewedFactory(purchase, complement);

        // when
        Purchase purchaseRenewed = (Purchase) compraFactory.create();

        // then
        Assertions.assertNotNull(purchaseRenewed);
        Assertions.assertEquals(
                List.of(
                        new Item(new Product("teste", 1., 1.), 1, true),
                        new Item(new Product("outro", null, null), 1, false)
                ),
                purchaseRenewed.items()
        );
        Assertions.assertEquals("teste", purchaseRenewed.comments());
        Assertions.assertEquals(LocalDate.now(), purchaseRenewed.dateReference());
        Assertions.assertTrue(purchaseRenewed.isDone());
    }

    @Test
    public void getCompraMarketRenewed_without_compra() {
        // given
        var complement = new HashMap<String, AbstractMap.SimpleEntry<Double, Double>>();
        complement.put("teste", new AbstractMap.SimpleEntry<>(1., 1.));

        CompraFactory compraFactory = new CompraMarketRenewedFactory(null, complement);

        // when
        Purchase purchaseRenewed = (Purchase) compraFactory.create();

        // then
        Assertions.assertNull(purchaseRenewed);
    }

    @Test
    public void getCompraMarketRenewed_without_complement() {
        // given
        Purchase purchase = new Purchase(LocalDate.now(), List.of(), "teste", false);

        CompraFactory compraFactory = new CompraMarketRenewedFactory(purchase, null);

        // when
        Purchase purchaseRenewed = (Purchase) compraFactory.create();

        // then
        Assertions.assertNotNull(purchaseRenewed);
        Assertions.assertEquals(List.of(), purchaseRenewed.items());
        Assertions.assertEquals("teste", purchaseRenewed.comments());
        Assertions.assertEquals(LocalDate.now(), purchaseRenewed.dateReference());
        Assertions.assertFalse(purchaseRenewed.isDone());
    }

    @Test
    public void getCompraMarketRenewed_with_complement_empty() {
        // given
        Purchase purchase = new Purchase(LocalDate.now(), List.of(), "teste", false);

        CompraFactory compraFactory = new CompraMarketRenewedFactory(purchase, new HashMap<>());

        // when
        Purchase purchaseRenewed = (Purchase) compraFactory.create();

        // then
        Assertions.assertNotNull(purchaseRenewed);
        Assertions.assertEquals(List.of(), purchaseRenewed.items());
        Assertions.assertEquals("teste", purchaseRenewed.comments());
        Assertions.assertEquals(LocalDate.now(), purchaseRenewed.dateReference());
        Assertions.assertFalse(purchaseRenewed.isDone());
    }

    @Test
    public void getCompraMarketRenewed_without_compra_and_addendum() {
        // given
        CompraFactory compraFactory = new CompraMarketRenewedFactory(null, null);

        // when
        Purchase purchaseRenewed = (Purchase) compraFactory.create();

        // then
        Assertions.assertNull(purchaseRenewed);
    }
}
