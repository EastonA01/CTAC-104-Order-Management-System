package org.example.ctac104ordermanagementsystem;


import org.example.ctac104ordermanagementsystem.entity.Product;
import org.example.ctac104ordermanagementsystem.repository.ProductRepository;
import org.example.ctac104ordermanagementsystem.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        Product product = new Product(null, "Laptop", 10, 1000.0, null);

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product createdProduct = productService.createProduct(product);

        assertNotNull(createdProduct);
        assertEquals("Laptop", createdProduct.getProductName());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product(1L, "Laptop", 10, 1000.0, null);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Product fetchedProduct = productService.getProductById(1L);

        assertNotNull(fetchedProduct);
        assertEquals("Laptop", fetchedProduct.getProductName());
    }


    @Test
    public void testGetAllProducts() {
        Product product1 = new Product(1L, "Laptop", 10, 1000.0, null);
        Product product2 = new Product(2L, "Smartphone", 20, 500.0, null);

        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));
        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Laptop", products.get(0).getProductName());
        assertEquals("Smartphone", products.get(1).getProductName());
    }

    @Test
    public void testUpdateProduct() {
        Product existingProduct = new Product(1L, "Laptop", 10, 1000.0, null);
        Product updatedProduct = new Product(1L, "Desktop", 5, 800.0, null);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        Product result = productService.updateProduct(1L, updatedProduct);

        assertNotNull(result);
        assertEquals("Desktop", result.getProductName());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product(1L, "Laptop", 10, 1000.0, null);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        doNothing().when(productRepository).delete(product);

        productService.deleteProduct(1L);

        verify(productRepository, times(1)).delete(product);
    }
}
