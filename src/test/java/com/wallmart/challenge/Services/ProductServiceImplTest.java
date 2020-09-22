package com.wallmart.challenge.Services;

import com.wallmart.challenge.AuxMethods.AuxMethods;
import com.wallmart.challenge.AuxMethods.productDescriptionAndBrandAuxMethods;
import com.wallmart.challenge.AuxMethods.productIdAuxMethods;
import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import com.wallmart.challenge.Mock.ProductsMocks;
import com.wallmart.challenge.Repositories.ProductsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.wallmart.challenge.Mock.ProductsMocks.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductServiceImplTest {

    @Mock
    ProductsRepository productsRepository;

    @InjectMocks
    ProductServiceImpl service;

    @DisplayName("Find Product By Id")
    @Test
    void buscarProductoById() throws ExecutionException, InterruptedException {
        String word = "181";
        when(productsRepository.findOneById(Integer.parseInt(word))).thenReturn(CompletableFuture.supplyAsync(() -> getProduct()));
        CompletableFuture<Optional<Products>> products = service.buscarProductoById(word);
        assertThat(products.get().isPresent()).isTrue();
        assertThat((getProduct().get().getId())).isEqualTo(products.get().get().getId());
    }

    @DisplayName("Find All Products ")
    @Test
    void busquedaProductosAll() throws ExecutionException, InterruptedException {
        when(productsRepository.findAllBy(Pageable.unpaged())).thenReturn(CompletableFuture.supplyAsync(() -> getProductsNotPalindrome()));
        CompletableFuture<Page<Products>> products = service.busquedaProductosAll(Pageable.unpaged());
        assertThat(products.get().getSize()).isEqualTo(getProductsNotPalindrome().getSize());
        assertThat(products.get()).isNotNull();
    }

    @DisplayName("Find Product By Description Or Brand")
    @Test
    void buscarProductos() throws ExecutionException, InterruptedException {
        String description = "asddsa";
        String brand = description;
        when(productsRepository.findProductsByDescriptionLikeOrBrandLike(description, brand, Pageable.unpaged())).thenReturn(CompletableFuture.supplyAsync(() -> getProductsPalindrome()));
        CompletableFuture<Page<Products>> products = service.buscarProductos(description, Pageable.unpaged());
        assertThat(products.get().getSize()).isEqualTo(getProductsPalindrome().getSize());
        assertThat(products.get()).isNotNull();
    }

    @DisplayName("Testing product find by id to see if is palindrome,make the price changes and return a ProductsDTO")
    @Test
    void finishId() {
        ProductsDTO productsDTO = service.finishId(getProduct(), "181");
        assertThat(productsDTO.getId()).isEqualTo(181);
        assertThat(productsDTO.getOldPrice()).isEqualTo(3550);
        assertThat(productsDTO.getPrice()).isEqualTo(1775);

        ProductsDTO productsDTO1 = service.finishId(getProduct2(), "1");
        assertThat(productsDTO1.getId()).isEqualTo(1);
        assertThat(productsDTO1.getOldPrice()).isEqualTo(0);
        assertThat(productsDTO1.getPrice()).isEqualTo(498724);
    }

    @DisplayName("Testing product find All and return a Page<ProductsDTO>")
    @Test
    void finishFindAll() {
        Page<Products> productsPage = getProductsNotPalindrome();
        Page<ProductsDTO> productsDTOPage = service.finishFindAll(productsPage);
        assertThat(productsDTOPage.getSize()).isEqualTo(productsPage.getSize());
    }

    @DisplayName("Testing product find by id to see if is palindrome, make the price changes and return a Page<ProductsDTO>")
    @Test
    void finishFindDescriptionAndBrand() {
        String word = "asddsa";
        Page<Products> productsPage = getProductsPalindrome();
        Page<ProductsDTO> productsDTOPage = service.finishFindDescriptionAndBrand(productsPage, word);
        assertThat(productsDTOPage.getSize()).isEqualTo(productsPage.getSize());
        assertThat(productsDTOPage.getContent().get(0).getOldPrice()).isEqualTo(932140);

        word = "zdczs";
        productsPage = getProductsNotPalindrome();
        productsDTOPage = service.finishFindDescriptionAndBrand(productsPage, word);
        assertThat(productsDTOPage.getSize()).isEqualTo(productsPage.getSize());
        assertThat(productsDTOPage.getContent().get(0).getOldPrice()).isEqualTo(0);
    }

}