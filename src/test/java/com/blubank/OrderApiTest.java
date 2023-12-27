package com.blubank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderApiTest {

    @Test
    void testCreateOrder() {
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setName("A");
        item1.setPrice(new BigDecimal(100));

        Item item2 = new Item();
        item2.setItemId(2);
        item2.setName("B");
        item2.setPrice(new BigDecimal(200));

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Order order = new Order();
        order.setOrderId(1);
        order.setCustomerId(325);
        order.setItems(items);
        order.setCreateDate(new Date());

        OrderManager orderManager = new InMemoryOrderManager();
        orderManager.addOrder(order);

        ListOrder listOrder = orderManager.getByCustomerId(order.getCustomerId());
        assertEquals(1, listOrder.getOrder().size());
        assertEquals(new BigDecimal(300), listOrder.getTotalPrice());
    }
}
