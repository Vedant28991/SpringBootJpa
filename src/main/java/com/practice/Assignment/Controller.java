package com.practice.Assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  OrderRepository orderRepository;

  @GetMapping("/category/books")
  public ResponseEntity<List<Product>> getProduct() {

    return new ResponseEntity<>(productRepository.findByCategoryAndPriceGreaterThan("Books", 100.0),
        HttpStatus.OK);
  }

  @GetMapping("/order/Baby")
  public ResponseEntity<List<Order>> getOrderBelongingToCategoryBaby(){

    List<Order> allBaby = orderRepository.findAll();
    
    List<Order> reqbaby=new ArrayList<>();
    allBaby.forEach(
        order -> {
          order.getProducts().forEach(e->{
            if(e.getCategory().equals("Baby")){
              reqbaby.add(order);
            }
          });
        }
    );

    return new ResponseEntity<>(reqbaby,HttpStatus.OK);
  }

  @GetMapping("/toys/discounted")
  public ResponseEntity<HashMap<String,Double>> getToysAndApply10Discount(){

    List<Product> toysDiscount = productRepository.findAll();

    HashMap<String,Double> hashMap=new HashMap<>();

    toysDiscount.forEach(p->{
      boolean toys = p.getCategory().equals("Toys");
      Double discountedPrice=0.0;

      if(toys){
        discountedPrice=+p.getPrice()*0.9;
        hashMap.put(p.getName(),discountedPrice);
      }
    });

    return new ResponseEntity<>(hashMap,HttpStatus.OK);

  }

  @GetMapping("/cheapest/book")
  public ResponseEntity<Double> getCheapestBook(){

    List<Product> cheapestBook = productRepository.findAll();

    Double price = cheapestBook.stream().min(Comparator.comparing(Product::getPrice)).get()
        .getPrice();

    return new ResponseEntity<>(price,HttpStatus.OK);

  }

  @GetMapping("/recent/orders")
  public ResponseEntity<List<Order>> recent3Orders(){

    List<Order> recent = orderRepository.findAll();

    List<Order> recent3Orders = recent.stream()
        .sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3).collect(
            Collectors.toList());

    return new ResponseEntity<>(recent3Orders,HttpStatus.OK);

  }
}
