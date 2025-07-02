package com.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.OrderItemRequest;
import com.dto.OrderRequest;
import com.entity.Book;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.User;
import com.repository.BookRepository;
import com.repository.OrderRepository;
import com.repository.UserRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final BookRepository bookRepo;
    private final UserRepository userRepo;

    public OrderService(OrderRepository orderRepo, BookRepository bookRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public ResponseEntity<String> placeOrder(OrderRequest request) {

    	User user = new User();
        user.setName(request.getUser().getName());
        user.setEmail(request.getUser().getEmail());
        user.setAddress(request.getUser().getAddress());
        user = userRepo.save(user);

        Order order = new Order();
        order.setUser(user);
        order.setPaymentMethod(request.getPaymentMethod());
        LocalDateTime utcTime = LocalDateTime.now(ZoneId.of("UTC"));
        order.setOrderDate(utcTime);

        double total = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequest itemDTO : request.getItems()) {
            Optional<Book> bookOpt = bookRepo.findById(itemDTO.getBookId());
            if (bookOpt.isEmpty()) continue;

            Book book = bookOpt.get();
            if (!book.getIsAvailable()) continue;

            book.setIsAvailable(false); 
            bookRepo.save(book);

            OrderItem item = new OrderItem();
            item.setBook(book);
            item.setOrder(order);
            item.setTitle(book.getTitle());
            item.setPrice(book.getPrice());
            item.setCreatedAt(utcTime);
            total += book.getPrice() * itemDTO.getQuantity();

            orderItems.add(item);
        }

        order.setTotal(total);
        order.setItems(orderItems);
        orderRepo.save(order); 

        return ResponseEntity.ok("Order placed successfully.");
    }
}
