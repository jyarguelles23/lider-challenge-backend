package com.wallmart.challenge.Controllers;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import com.wallmart.challenge.Mock.ProductsMocks;
import com.wallmart.challenge.Services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.CompletableFuture;

import static com.wallmart.challenge.Mock.ProductsMocks.getProduct;
import static com.wallmart.challenge.Mock.ProductsMocks.getProductsNotPalindrome;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    ProductsController productsController;
    @Mock
    ProductService productService;


    @Test
    void getProductsAll() throws Exception {

        log.info("Obtener Listado de productos :: inicio de test");
        ResponseEntity<?> responseEntity;
        when(productService.busquedaProductosAll(Pageable.unpaged())).thenReturn(CompletableFuture.supplyAsync(() -> getProductsNotPalindrome()));
        responseEntity = productsController.getProductsAll(Pageable.unpaged());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.info("Obtener Listado de productos :: fin de test");
    }

    @Test
    @Async
    void getProducts() throws Exception {
        log.info("Obtener Productos  by Description Or Brand haciendo busqueda asincrona :: inicio de test");
        String word = "zdczs";
        ResponseEntity<?> responseEntity;
        when(productService.buscarProductos(word, Pageable.unpaged())).thenReturn(CompletableFuture.supplyAsync(() -> getProductsNotPalindrome()));
        when(productService.buscarProductoById(word)).thenReturn(CompletableFuture.supplyAsync(() -> getProduct()));

        responseEntity = productsController.getProducts(word, Pageable.unpaged());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.info("Obtener Productos  by Description Or Brand haciendo busqueda asincrona :: fin de test");

        log.info("Obtener Productos  by Id haciendo busqueda asincrona :: inicio de test");
        String palabra = "181";
        ResponseEntity<?> responseEntity1;
        when(productService.buscarProductoById(palabra)).thenReturn(CompletableFuture.supplyAsync(() -> getProduct()));
        when(productService.buscarProductos(palabra, Pageable.unpaged())).thenReturn(CompletableFuture.supplyAsync(() -> getProductsNotPalindrome()));
        responseEntity1 = productsController.getProducts(palabra, Pageable.unpaged());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.info("Obtener Productos  by Id haciendo busqueda asincrona :: fin de test");

    }


}