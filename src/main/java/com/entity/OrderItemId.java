package com.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long order;
    private Long book;

    public OrderItemId() {}

    public OrderItemId(Long order, Long book) {
        this.order = order;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemId)) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(order, that.order) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, book);
    }
}
