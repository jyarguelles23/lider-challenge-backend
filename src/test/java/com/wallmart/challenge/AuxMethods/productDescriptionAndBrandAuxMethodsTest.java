package com.wallmart.challenge.AuxMethods;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static com.wallmart.challenge.Mock.ProductsMocks.getProductsDTO;
import static org.junit.jupiter.api.Assertions.*;

class productDescriptionAndBrandAuxMethodsTest {


    @DisplayName("Testing 50 % By Description and Brand")
    @Test
    void cincuentaPorcientoByBrandAndDescription() {
        Integer price = 466070;
        Integer oldPrice = 932140;
        Page<ProductsDTO> productsPageDTO = productDescriptionAndBrandAuxMethods.cincuentaPorcientoByBrandAndDescription(getProductsDTO());
        assertEquals(price, productsPageDTO.getContent().get(0).getPrice());
        assertEquals(oldPrice, productsPageDTO.getContent().get(0).getOldPrice());

        price = 312687;
        oldPrice = 625375;
        assertEquals(price, productsPageDTO.getContent().get(1).getPrice());
        assertEquals(oldPrice, productsPageDTO.getContent().get(1).getOldPrice());
    }

    @DisplayName("Testing Change www por https:// By Description and Brand")
    @Test
    void changeWWWDescriptionBrand() {
        String image = "https://lider.cl/catalogo/images/bicycleIcon.svg";
        Page<ProductsDTO> productsPageDTO = productDescriptionAndBrandAuxMethods.changeWWWDescriptionBrand(getProductsDTO());
        assertEquals(image, productsPageDTO.getContent().get(0).getImage());

        image = "https://lider.cl/catalogo/images/bedRoomIcon.svg";
        productsPageDTO = productDescriptionAndBrandAuxMethods.changeWWWDescriptionBrand(getProductsDTO());
        assertEquals(image, productsPageDTO.getContent().get(1).getImage());
    }


}