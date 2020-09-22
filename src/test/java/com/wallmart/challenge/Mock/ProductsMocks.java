package com.wallmart.challenge.Mock;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsMocks {

    public static Optional<Products> getProduct2() {
        Products model = new Products();
        model.set_id("5f6607ce67e38e81c28a2f11");
        model.setId(1);
        model.setBrand("ooy eqrceli");
        model.setDescription("rlñlw brhrka");
        model.setImage("www.lider.cl/catalogo/images/whiteLineIcon.svg");
        model.setPrice(498724);
        return Optional.of(model);
    }

    public static Optional<Products> getProduct() {
        Products model = new Products();
        model.set_id("asdasd12");
        model.setId(181);
        model.setBrand("sanyo");
        model.setDescription("mocktest dos");
        model.setImage("www.lider.cl/catalogo/images/toysIcon.svg");
        model.setPrice(3550);

        return Optional.of(model);
    }

    public static Page<Products> getProductsPalindrome() {

        List<Products> productsList = new ArrayList<>();
        Products model = new Products();
        model.set_id("5f6607ce67e38e81c28a32c5");
        model.setId(475);
        model.setBrand("asddsa");
        model.setDescription("mwnpc avbafq");
        model.setImage("www.lider.cl/catalogo/images/bicycleIcon.svg");
        model.setPrice(932140);
        productsList.add(model);

        Products model1 = new Products();
        model1.set_id("5f6607ce67e38e81c28a359b");
        model1.setId(838);
        model1.setBrand("asddsa");
        model1.setDescription("xipkg ftlmmj");
        model1.setImage("www.lider.cl/catalogo/images/bedRoomIcon.svg");
        model1.setPrice(625375);
        productsList.add(model1);
        Pageable pageable = PageRequest.of(0, 2);
        List<Products> listOfCharacters = productsList;
        long totalCharacters = 2;
        return new PageImpl<>(listOfCharacters, pageable, totalCharacters);
    }

    public static Page<Products> getProductsNotPalindrome() {

        List<Products> productsList = new ArrayList<>();
        Products model = new Products();
        model.set_id("5f6607ce67e38e81c28a2f33");
        model.setId(18);
        model.setBrand("asdfdsa");
        model.setDescription("zdczs omedat");
        model.setImage("www.lider.cl/catalogo/images/smartphoneIcon.svg");
        model.setPrice(849666);
        productsList.add(model);

        Products model1 = new Products();
        model1.set_id("5f6607ce67e38e81c28a2f49");
        model1.setId(55);
        model1.setBrand("dassad");
        model1.setDescription("zdczs omedat");
        model1.setImage("www.lider.cl/catalogo/images/electronicsIcon.svg");
        model1.setPrice(986817);
        productsList.add(model1);
        Pageable pageable = PageRequest.of(0, 2);
        List<Products> listOfCharacters = productsList;
        long totalCharacters = 2;
        return new PageImpl<>(listOfCharacters, pageable, totalCharacters);
    }

    public static Page<ProductsDTO> getProductsDTO() {

        List<ProductsDTO> productsList = new ArrayList<>();
        ProductsDTO model = new ProductsDTO();
        model.set_id("5f6607ce67e38e81c28a32c5");
        model.setId(475);
        model.setBrand("asddsa");
        model.setDescription("mwnpc avbafq");
        model.setImage("www.lider.cl/catalogo/images/bicycleIcon.svg");
        model.setPrice(932140);
        productsList.add(model);

        ProductsDTO model1 = new ProductsDTO();
        model1.set_id("5f6607ce67e38e81c28a359b");
        model1.setId(838);
        model1.setBrand("asddsa");
        model1.setDescription("xipkg ftlmmj");
        model1.setImage("www.lider.cl/catalogo/images/bedRoomIcon.svg");
        model1.setPrice(625375);
        productsList.add(model1);
        Pageable pageable = PageRequest.of(0, 2);
        List<ProductsDTO> listOfCharacters = productsList;
        long totalCharacters = 2;
        return new PageImpl<>(listOfCharacters, pageable, totalCharacters);
    }

    public static ProductsDTO getProductDTO() {
        ProductsDTO dto = new ProductsDTO();
        dto.set_id("5f6607ce67e38e81c28a3257");
        dto.setId(420);
        dto.setBrand("lxu wrjsyiñ");
        dto.setDescription("zdczs omedat");
        dto.setImage("www.lider.cl/catalogo/images/tvIcon.svg");
        dto.setPrice(392525);
        return dto;
    }
}
