package com.listadecompras.compras.core.domain.market.builder;

import com.listadecompras.compras.core.domain.market.Item;
import com.listadecompras.compras.core.domain.market.Product;
import com.listadecompras.compras.core.domain.market.builder.concrete.ItemConcrete;
import com.listadecompras.compras.core.domain.market.builder.director.ItemDirector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemDirectorTest {

    private final ItemConcrete itemConcrete = new ItemConcrete();

    @Test
    public void constructItem_success() {
        // given
        ItemDirector itemDirector = new ItemDirector(this.itemConcrete);

        // when
        itemDirector.constructItem(new Product("teste", 0., 0.), 0);
        Item item = this.itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(false, item.isBought());
    }

    @Test
    public void constructItem_without_product() {
        // given
        ItemDirector itemDirector = new ItemDirector(this.itemConcrete);

        // when
        itemDirector.constructItem(null, 0);
        Item item = this.itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNull(item.product());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(false, item.isBought());
    }

    @Test
    public void constructItem_without_quantity() {
        // given
        ItemDirector itemDirector = new ItemDirector(this.itemConcrete);

        // when
        itemDirector.constructItem(new Product("teste", 0., 0.), null);
        Item item = this.itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals(null, item.quantity());
        Assertions.assertEquals(false, item.isBought());
    }

    @Test
    public void constructItemBought_success() {
        // given
        ItemDirector itemDirector = new ItemDirector(this.itemConcrete);

        // when
        itemDirector.constructItemBought(new Product("teste", 0., 0.), 0);
        Item item = this.itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(true, item.isBought());
    }

    @Test
    public void constructItemBought_without_product() {
        // given
        ItemDirector itemDirector = new ItemDirector(this.itemConcrete);

        // when
        itemDirector.constructItemBought(null, 0);
        Item item = this.itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNull(item.product());
        Assertions.assertEquals(0, item.quantity());
        Assertions.assertEquals(true, item.isBought());
    }

    @Test
    public void constructItemBought_without_quantity() {
        // given
        ItemDirector itemDirector = new ItemDirector(this.itemConcrete);

        // when
        itemDirector.constructItemBought(new Product("teste", 0., 0.), null);
        Item item = this.itemConcrete.getItem();

        // then
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.product());
        Assertions.assertEquals(null, item.quantity());
        Assertions.assertEquals(true, item.isBought());
    }
}
