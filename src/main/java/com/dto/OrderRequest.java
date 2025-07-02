package com.dto;

import java.util.List;

public class OrderRequest {

    private UserDTO user;
    private String paymentMethod;
    private List<OrderItemRequest> items;

    public OrderRequest() {
    }

    public OrderRequest(UserDTO user, String paymentMethod, List<OrderItemRequest> items) {
        this.user = user;
        this.paymentMethod = paymentMethod;
        this.items = items;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
