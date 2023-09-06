package com.practice.Assignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  ProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {

    log.info("Inside Command Line Runner");
    insertCustomerData();
    insertProductData();
    insertOrderData();

    getALlOrders();

  }

  private void getALlOrders() {
    List<Order> all = orderRepository.findAll();
    all.forEach(System.out::println);
  }

  private static final List<Product> productList = Arrays.asList(
      new Product(1L, "Helen Keller", "Books", 299.0),
      new Product(2L, "Lord of Rings", "Books", 499.0),
      new Product(3L, "AutoBiography of Yogi", "Books", 189.0),
      new Product(4L, "Shampoo", "Baby", 599.0),
      new Product(5L, "Blocks", "Toys", 699.0),
      new Product(6L, "Skin-Care", "Baby", 1099.0),
      new Product(7L, "Games", "Toys", 1599.0),
      new Product(8L, "Doraemon", "Books", 99.0)
  );

  private static final List<Order> orderList = Arrays.asList(
      new Order(1L, "Shipped", LocalDate.of(2023, 5, 15), LocalDate.now(), productList,
          new Customer(1L, "Tim", 3)),
      new Order(2L, "Shipped", LocalDate.of(2022, 2, 11), LocalDate.of(2022, 2, 15),
          Arrays.asList(new Product(4L, "Shampoo", "Baby", 599.0),
              new Product(6L, "Skin-Care", "Baby", 1099.0)),
          new Customer(2L, "Jack", 1)),
      new Order(3L, "Received", LocalDate.of(2023, 5, 26), LocalDate.of(2023, 5, 30), productList,
          new Customer(3L, "Jim", 2))
  );

  private static final List<Customer> customerList = Arrays.asList(new Customer(1L, "Tim", 3),
      new Customer(2L, "Jack", 1), new Customer(3L, "Jim", 2));


  private void insertCustomerData() {
    customerRepository.saveAll(customerList);
  }

  private void insertOrderData() {
    orderRepository.saveAll(orderList);
  }

  private void insertProductData() {
    productRepository.saveAll(productList);
  }

}
