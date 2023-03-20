package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.builder.concrete.ProductConcrete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductConcreteTest {

    @Test
    public void product_complete() {
        // given
        ProductConcrete productConcrete = new ProductConcrete();
        productConcrete.setName("teste");
        productConcrete.setWeight(0.);
        productConcrete.setAmount(0.);

        // when
        Product product = productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(0., product.weight());
        Assertions.assertEquals(0., product.amount());
    }

    @Test
    public void product_without_name() {
        // given
        ProductConcrete productConcrete = new ProductConcrete();
        productConcrete.setName(null);
        productConcrete.setWeight(0.);
        productConcrete.setAmount(0.);

        // when
        Product product = productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals(null, product.name());
        Assertions.assertEquals(0., product.weight());
        Assertions.assertEquals(0., product.amount());
    }

    @Test
    public void product_without_weight() {
        // given
        ProductConcrete productConcrete = new ProductConcrete();
        productConcrete.setName("teste");
        productConcrete.setWeight(null);
        productConcrete.setAmount(0.);

        // when
        Product product = productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(null, product.weight());
        Assertions.assertEquals(0., product.amount());
    }

    @Test
    public void product_without_amount() {
        // given
        ProductConcrete productConcrete = new ProductConcrete();
        productConcrete.setName("teste");
        productConcrete.setWeight(0.);
        productConcrete.setAmount(null);

        // when
        Product product = productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(0., product.weight());
        Assertions.assertEquals(null, product.amount());
    }

}
