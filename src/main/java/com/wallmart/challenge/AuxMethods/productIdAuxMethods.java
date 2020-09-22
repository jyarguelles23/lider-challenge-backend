package com.wallmart.challenge.AuxMethods;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.wallmart.challenge.AuxMethods.AuxMethods.calcularCincuentaPorciento;
import static com.wallmart.challenge.AuxMethods.AuxMethods.changeWWWForHttps;

@Component
public class productIdAuxMethods {

    public static ProductsDTO cincuentaPorcientoById(ProductsDTO productId) {
        StringBuilder builder = new StringBuilder(productId.getImage());
        productId.setOldPrice(productId.getPrice());
        productId.setPrice(calcularCincuentaPorciento(productId.getPrice()));
        productId.setImage(changeWWWForHttps(builder));
        return productId;

    }

    public static ProductsDTO changeWWWById(ProductsDTO productId) {
        StringBuilder builder = new StringBuilder(productId.getImage());
        productId.setImage(changeWWWForHttps(builder));
        return productId;
    }
}
