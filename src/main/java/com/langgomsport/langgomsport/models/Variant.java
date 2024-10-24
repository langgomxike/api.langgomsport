package com.langgomsport.langgomsport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "variants")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private long created_at;
    private long updated_at;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCreated_at() {
        return created_at;
    }
    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    public Variant(int id, int quantity, long created_at, long updated_at, Product product, Color color, Size size) {
        this.id = id;
        this.quantity = quantity;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.product = product;
        this.color = color;
        this.size = size;
    }

    public Variant() {
    }
}
