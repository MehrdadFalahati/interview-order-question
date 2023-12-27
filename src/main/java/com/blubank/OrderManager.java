package com.blubank;

public interface OrderManager {
    void addOrder(Order order);

    ListOrder getByCustomerId(int customerId);
}
