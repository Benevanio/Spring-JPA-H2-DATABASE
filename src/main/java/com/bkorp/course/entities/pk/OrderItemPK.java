package com.bkorp.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.bkorp.course.entities.Orders;
import com.bkorp.course.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItemPK)) {
            return false;
        }
        OrderItemPK orderItemPK = (OrderItemPK) o;
        return Objects.equals(orders, orderItemPK.orders) && Objects.equals(product, orderItemPK.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, product);
    }

}
