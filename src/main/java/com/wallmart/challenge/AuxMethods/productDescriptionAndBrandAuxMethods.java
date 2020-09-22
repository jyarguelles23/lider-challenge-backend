package com.wallmart.challenge.AuxMethods;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

import static com.wallmart.challenge.AuxMethods.AuxMethods.calcularCincuentaPorciento;
import static com.wallmart.challenge.AuxMethods.AuxMethods.changeWWWForHttps;

@Component
public class productDescriptionAndBrandAuxMethods {


    public static Page<ProductsDTO> cincuentaPorcientoByBrandAndDescription(Page<ProductsDTO> products) {

        products.forEach(x -> {
            StringBuilder builder = new StringBuilder(x.getImage());
            x.setOldPrice(x.getPrice());
            x.setPrice(calcularCincuentaPorciento(x.getPrice()));
            x.setImage(changeWWWForHttps(builder));
        });
        return products;
    }

    public static Page<ProductsDTO> changeWWWDescriptionBrand(Page<ProductsDTO> products) {
        products.forEach(x -> {
            StringBuilder builder = new StringBuilder(x.getImage());
            x.setImage(changeWWWForHttps(builder));
        });
        return products;
    }
}
