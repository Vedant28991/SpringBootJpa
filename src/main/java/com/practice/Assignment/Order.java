package com.practice.Assignment;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "order100")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @Id
  @Column(name = "order_id")
  private Long id;
  private String status;
  private LocalDate orderDate;
  private LocalDate deliveryDate;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "order_prod",joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn(name = "prod_id"))
  private List<Product> products;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
    this.id = id;
    this.status = status;
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
    this.products = products;
    this.customer = customer;
  }

  public Order() {
  }
}
