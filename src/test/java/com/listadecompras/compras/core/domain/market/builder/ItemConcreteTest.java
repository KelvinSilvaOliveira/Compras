package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.builder.concrete.ItemConcrete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemConcreteTest {

    @Test
    public void item_complete() {
        // given
        ItemConcrete itemConcrete = new ItemConcrete();
        itemConcrete.setProduct(new Product("teste", 0., 0.));
        itemConcrete.setQuantity(0);
        itemConcrete.setBought(false);

        // when
        Item item = itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals("teste", item.product().name());
        Assertions.assertEquals(0., item.product().weight());
        Assertions.assertEquals(0., item.product().amount());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(false, item.isBought());
        Assertions.assertEquals(0., item.totalWeight());
        Assertions.assertEquals(0., item.totalAmount());
    }

    @Test
    public void item_without_product() {
        // given
        ItemConcrete itemConcrete = new ItemConcrete();
        itemConcrete.setProduct(null);
        itemConcrete.setQuantity(0);
        itemConcrete.setBought(false);

        // when
        Item item = itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNull(item.product());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(false, item.isBought());
        Assertions.assertEquals(null, item.totalWeight());
        Assertions.assertEquals(null, item.totalAmount());
    }

    @Test
    public void item_without_quantity() {
        // given
        ItemConcrete itemConcrete = new ItemConcrete();
        itemConcrete.setProduct(new Product("teste", 0., 0.));
        itemConcrete.setQuantity(null);
        itemConcrete.setBought(false);

        // when
        Item item = itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals("teste", item.product().name());
        Assertions.assertEquals(0., item.product().weight());
        Assertions.assertEquals(0., item.product().amount());
        Assertions.assertEquals(null, item.quantity());
        Assertions.assertEquals(false, item.isBought());
        Assertions.assertEquals(null, item.totalWeight());
        Assertions.assertEquals(null, item.totalAmount());
    }

    @Test
    public void item_without_bought() {
        // given
        ItemConcrete itemConcrete = new ItemConcrete();
        itemConcrete.setProduct(new Product("teste", 0., 0.));
        itemConcrete.setQuantity(0);
        itemConcrete.setBought(null);

        // when
        Item item = itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals("teste", item.product().name());
        Assertions.assertEquals(0., item.product().weight());
        Assertions.assertEquals(0., item.product().amount());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(null, item.isBought());
        Assertions.assertEquals(null, item.totalWeight());
        Assertions.assertEquals(null, item.totalAmount());
    }

    @Test
    public void item_without_product_bought() {
        // given
        ItemConcrete itemConcrete = new ItemConcrete();
        itemConcrete.setProduct(null);
        itemConcrete.setQuantity(0);
        itemConcrete.setBought(true);

        // when
        Item item = itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNull(item.product());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(true, item.isBought());
        Assertions.assertEquals(null, item.totalWeight());
        Assertions.assertEquals(null, item.totalAmount());
    }

    @Test
    public void item_without_quantity_bought() {
        // given
        ItemConcrete itemConcrete = new ItemConcrete();
        itemConcrete.setProduct(new Product("teste", 0., 0.));
        itemConcrete.setQuantity(null);
        itemConcrete.setBought(true);

        // when
        Item item = itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals("teste", item.product().name());
        Assertions.assertEquals(0., item.product().weight());
        Assertions.assertEquals(0., item.product().amount());
        Assertions.assertEquals(null, item.quantity());
        Assertions.assertEquals(true, item.isBought());
        Assertions.assertEquals(null, item.totalWeight());
        Assertions.assertEquals(null, item.totalAmount());
    }

}
