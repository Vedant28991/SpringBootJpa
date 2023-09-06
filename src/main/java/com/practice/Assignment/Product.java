package com.practice.Assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product100")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
  @Id
  @Column(name = "prod_id")
  private Long id;
  private String name;
  private String category;
  private Double price;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Product(Long id, String name, String category, Double price) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
  }

  public Product() {
  }
}
