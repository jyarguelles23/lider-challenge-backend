package com.wallmart.challenge.AuxMethods;

import com.wallmart.challenge.DTO.ProductsDTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.wallmart.challenge.Mock.ProductsMocks.getProductDTO;

import static org.junit.jupiter.api.Assertions.*;

class productIdAuxMethodsTest {

    @DisplayName("Testing 50 % By Id")
    @Test
    void cincuentaPorcientoById() {
        Integer price = 196262;
        Integer oldPrice = 392525;
        ProductsDTO productsDTO = productIdAuxMethods.cincuentaPorcientoById(getProductDTO());
        assertEquals(price, productsDTO.getPrice());
        assertEquals(oldPrice, productsDTO.getOldPrice());
    }

    @DisplayName("Testing Change www por https://")
    @Test
    void changeWWWById() {
        String image = "https://lider.cl/catalogo/images/tvIcon.svg";
        ProductsDTO productsDTO = productIdAuxMethods.changeWWWById(getProductDTO());
        assertEquals(image, productsDTO.getImage());
    }


}