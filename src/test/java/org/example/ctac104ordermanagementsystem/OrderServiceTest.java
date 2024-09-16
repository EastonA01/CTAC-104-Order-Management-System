package org.example.ctac104ordermanagementsystem;

import org.example.ctac104ordermanagementsystem.entity.Order;
import org.example.ctac104ordermanagementsystem.repository.OrderRepository;
import org.example.ctac104ordermanagementsystem.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;


@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setCustomerName("John Doe");

        Mockito.when(orderRepository.save(order)).thenReturn(order);
        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertEquals("John Doe", createdOrder.getCustomerName());
    }

    @Test
    public void testGetOrderById() {
        Order order = new Order();
        order.setId(1L);
        order.setCustomerName("John Doe");

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Order fetchedOrder = orderService.getOrderById(1L);

        assertNotNull(fetchedOrder);
        assertEquals("John Doe", fetchedOrder.getCustomerName());
    }

    // Similar tests for updateOrder, deleteOrder

    @Test
    public void testUpdateOrder() {
        Order existingOrder = new Order(1L, "John Doe", LocalDate.now(), null);
        Order updatedOrder = new Order(1L, "Jane Smith", LocalDate.now(), null);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(existingOrder));
        Mockito.when(orderRepository.save(existingOrder)).thenReturn(updatedOrder);

        Order result = orderService.updateOrder(1L, updatedOrder);

        assertNotNull(result);
        assertEquals("Jane Smith", result.getCustomerName());
    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order(1L, "John Doe", LocalDate.now(), null);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        doNothing().when(orderRepository).deleteById(1L);

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).deleteById(1L);  // Expect deleteById to be called
    }
}
