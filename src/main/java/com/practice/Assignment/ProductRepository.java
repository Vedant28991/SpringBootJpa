package com.practice.Assignment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

  List<Product> findByCategoryAndPriceGreaterThan(String category,Double price);

}
