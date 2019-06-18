package com.briup.apps.ej.bean.VM;
//顾客详情在前端显示时需要的模型
public class CustomerDetailsVM {
    private Long orderId;
    private String customerName;
    private String waiterName;
    private String address;
    private Double total;
    private Long orderTime;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public String getAddress() {
        return address;
    }

    public Double getTotal() {
        return total;
    }

    public Long getOrderTime() {
        return orderTime;
    }
}
