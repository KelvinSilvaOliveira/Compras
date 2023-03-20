package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.builder.concrete.ProductConcrete;
import com.listadecompras.compras.core.domain.market.builder.director.ProductDirector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductDirectorTest {

    private final ProductConcrete productConcrete = new ProductConcrete();

    @Test
    public void createProduct_success() {
        // given
        ProductDirector productDirector = new ProductDirector(this.productConcrete);

        // when
        productDirector.createProduct("teste");
        Product product = this.productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(null, product.weight());
        Assertions.assertEquals(null, product.amount());
    }

    @Test
    public void createProduct_without_name() {
        // given
        ProductDirector productDirector = new ProductDirector(this.productConcrete);

        // when
        productDirector.createProduct(null);
        Product product = this.productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals(null, product.name());
        Assertions.assertEquals(null, product.weight());
        Assertions.assertEquals(null, product.amount());
    }

    @Test
    public void createProductBought_success() {
        // given
        ProductDirector productDirector = new ProductDirector(this.productConcrete);

        // when
        productDirector.createProductBought("teste", 0., 0.);
        Product product = this.productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(0., product.weight());
        Assertions.assertEquals(0., product.amount());
    }

    @Test
    public void createProductBought_without_name() {
        // given
        ProductDirector productDirector = new ProductDirector(this.productConcrete);

        // when
        productDirector.createProductBought(null, 0., 0.);
        Product product = this.productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals(null, product.name());
        Assertions.assertEquals(0., product.weight());
        Assertions.assertEquals(0., product.amount());
    }

    @Test
    public void createProductBought_without_weight() {
        // given
        ProductDirector productDirector = new ProductDirector(this.productConcrete);

        // when
        productDirector.createProductBought("teste", null, 0.);
        Product product = this.productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(null, product.weight());
        Assertions.assertEquals(0., product.amount());
    }

    @Test
    public void createProductBought_without_amount() {
        // given
        ProductDirector productDirector = new ProductDirector(this.productConcrete);

        // when
        productDirector.createProductBought("teste", 0., null);
        Product product = this.productConcrete.getProduct();

        // then
        Assertions.assertNotNull(product);
        Assertions.assertEquals("teste", product.name());
        Assertions.assertEquals(0., product.weight());
        Assertions.assertEquals(null, product.amount());
    }
}
