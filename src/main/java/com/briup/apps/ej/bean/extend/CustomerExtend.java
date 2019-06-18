package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderLine;

import java.util.List;

public class CustomerExtend extends Customer {
    private Address address;
    private Order order;
    private List<OrderLine> orderLines;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Address getAddress() {
        return address;
    }

    public Order getOrder() {
        return order;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
}
