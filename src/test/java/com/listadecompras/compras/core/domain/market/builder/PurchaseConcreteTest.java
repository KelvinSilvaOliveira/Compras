package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.Compra;
import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.domain.market.builder.concrete.PurchaseConcrete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PurchaseConcreteTest {

    @Test
    public void purchase_complete() {
        // given
        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        purchaseConcrete.setDateReference(LocalDate.now());
        purchaseConcrete.setItems(List.of());
        purchaseConcrete.setComments("testando");
        purchaseConcrete.setIsDone(false);

        // when
        Compra compra = purchaseConcrete.getPurchase();
        Purchase purchase = (Purchase) compra;

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
        Assertions.assertEquals(LocalDate.now().getMonth().getValue(), purchase.getMonth());
        Assertions.assertEquals(LocalDate.now().getYear(), purchase.getYear());
    }

    @Test
    public void purchase_without_dateReference() {
        // given
        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        purchaseConcrete.setDateReference(null);
        purchaseConcrete.setItems(List.of());
        purchaseConcrete.setComments("testando");
        purchaseConcrete.setIsDone(false);

        // when
        Compra compra = purchaseConcrete.getPurchase();
        Purchase purchase = (Purchase) compra;

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(null, purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
        Assertions.assertEquals(null, purchase.getMonth());
        Assertions.assertEquals(null, purchase.getYear());
    }

    @Test
    public void purchase_without_items() {
        // given
        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        purchaseConcrete.setDateReference(LocalDate.now());
        purchaseConcrete.setItems(null);
        purchaseConcrete.setComments("testando");
        purchaseConcrete.setIsDone(false);

        // when
        Compra compra = purchaseConcrete.getPurchase();
        Purchase purchase = (Purchase) compra;

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(null, purchase.items());
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
        Assertions.assertEquals(LocalDate.now().getMonth().getValue(), purchase.getMonth());
        Assertions.assertEquals(LocalDate.now().getYear(), purchase.getYear());
    }

    @Test
    public void purchase_without_comments() {
        // given
        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        purchaseConcrete.setDateReference(LocalDate.now());
        purchaseConcrete.setItems(List.of());
        purchaseConcrete.setComments(null);
        purchaseConcrete.setIsDone(false);

        // when
        Compra compra = purchaseConcrete.getPurchase();
        Purchase purchase = (Purchase) compra;

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals(null, purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
        Assertions.assertEquals(LocalDate.now().getMonth().getValue(), purchase.getMonth());
        Assertions.assertEquals(LocalDate.now().getYear(), purchase.getYear());
    }

    @Test
    public void purchase_without_isDone() {
        // given
        PurchaseConcrete purchaseConcrete = new PurchaseConcrete();
        purchaseConcrete.setDateReference(LocalDate.now());
        purchaseConcrete.setItems(List.of());
        purchaseConcrete.setComments("testando");
        purchaseConcrete.setIsDone(null);

        // when
        Compra compra = purchaseConcrete.getPurchase();
        Purchase purchase = (Purchase) compra;

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(null, purchase.isDone());
        Assertions.assertEquals(LocalDate.now().getMonth().getValue(), purchase.getMonth());
        Assertions.assertEquals(LocalDate.now().getYear(), purchase.getYear());
    }

}
