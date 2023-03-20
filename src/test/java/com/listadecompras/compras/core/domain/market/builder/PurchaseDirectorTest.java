package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Purchase;
import com.listadecompras.compras.core.domain.market.builder.concrete.PurchaseConcrete;
import com.listadecompras.compras.core.domain.market.builder.director.PurchaseDirector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PurchaseDirectorTest {

    private final PurchaseConcrete purchaseConcrete = new PurchaseConcrete();

    @Test
    public void constructPurchase_success() {
        // give
        PurchaseDirector purchaseDirector = new PurchaseDirector(this.purchaseConcrete);

        // when
        purchaseDirector.constructPurchase(List.of(), "testando");
        Purchase purchase = this.purchaseConcrete.getPurchase();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
    }

    @Test
    public void constructPurchase_without_items() {
        // give
        PurchaseDirector purchaseDirector = new PurchaseDirector(this.purchaseConcrete);

        // when
        purchaseDirector.constructPurchase(null, "testando");
        Purchase purchase = this.purchaseConcrete.getPurchase();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(null, purchase.items());
        Assertions.assertEquals("testando", purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
    }

    @Test
    public void constructPurchase_without_comment() {
        // give
        PurchaseDirector purchaseDirector = new PurchaseDirector(this.purchaseConcrete);

        // when
        purchaseDirector.constructPurchase(List.of(), null);
        Purchase purchase = this.purchaseConcrete.getPurchase();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals(null, purchase.comments());
        Assertions.assertEquals(false, purchase.isDone());
    }

    @Test
    public void constructPurchaseDone_success() {
        // give
        PurchaseDirector purchaseDirector = new PurchaseDirector(this.purchaseConcrete);

        // when
        purchaseDirector.constructPurchaseDone(List.of(), new Purchase(LocalDate.now(), List.of(), "teste", false));
        Purchase purchase = this.purchaseConcrete.getPurchase();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(LocalDate.now(), purchase.dateReference());
        Assertions.assertEquals(List.of(), purchase.items());
        Assertions.assertEquals("teste", purchase.comments());
        Assertions.assertEquals(true, purchase.isDone());
    }

    @Test
    public void constructPurchaseDone_without_purchaseReference() {
        // give
        PurchaseDirector purchaseDirector = new PurchaseDirector(this.purchaseConcrete);

        // when
        purchaseDirector.constructPurchaseDone(null, null);
        Purchase purchase = this.purchaseConcrete.getPurchase();

        // then
        Assertions.assertNotNull(purchase);
        Assertions.assertEquals(null, purchase.dateReference());
        Assertions.assertEquals(null, purchase.items());
        Assertions.assertEquals(null, purchase.comments());
        Assertions.assertEquals(null, purchase.isDone());
    }
}
