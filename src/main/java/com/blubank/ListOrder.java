package com.blubank;

import java.math.BigDecimal;
import java.util.List;

public interface ListOrder {
    List<Order> getOrder();

    BigDecimal getTotalPrice();
}
