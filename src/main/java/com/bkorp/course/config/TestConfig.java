package com.bkorp.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bkorp.course.entities.Category;
import com.bkorp.course.entities.OrderItem;
import com.bkorp.course.entities.Orders;
import com.bkorp.course.entities.Product;
import com.bkorp.course.entities.User;
import com.bkorp.course.entities.enums.OrderStatus;
import com.bkorp.course.repositories.CategoryRepository;
import com.bkorp.course.repositories.OrderItemRepository;
import com.bkorp.course.repositories.OrderRepository;
import com.bkorp.course.repositories.ProductRepository;
import com.bkorp.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999887774", "12345679");
        User u2 = new User(null, "Alex Green", "Alex@gmail.com", "198888785", "12345679");
        Orders o1 = new Orders(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Orders o2 = new Orders(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Orders o3 = new Orders(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        // Save categories first
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, null);
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, null);
        Product p3 = new Product(null, "Ero Manga Sensei", "Nam eleifend maximus tortor, at mollis.", 100.0, null);
        Product p4 = new Product(null, "PC Gamer", "Nam eleifend maximus tortor, at mollis.", 100.0, null);
        Product p5 = new Product(null, "Rails for Dummies", "Nam eleifend maximus tortor, at mollis.", 100.0, null);

        // Associate products with categories after categories are saved
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        // Save products after categories
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        // save order items
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

    }
}
