package com.practice.Assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer100")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @Id
  @Column(name = "customer_id")
  private Long id;
  private String name;
  private Integer tier;

  public Customer() {
  }

  public Customer(Long id, String name, Integer tier) {
    this.id = id;
    this.name = name;
    this.tier = tier;
  }

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

  public Integer getTier() {
    return tier;
  }

  public void setTier(Integer tier) {
    this.tier = tier;
  }
}
