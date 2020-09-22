package com.wallmart.challenge.AuxMethods;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import lombok.NoArgsConstructor;
import org.bson.json.Converter;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

@Component
public class AuxMethods {

    public static boolean esPalindromo(String s) {
        String temp = s.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }

    public static String changeWWWForHttps(StringBuilder image) {
        final String var = "https://";
        return image.replace(0, 4, var).toString();
    }

    public static Integer calcularCincuentaPorciento(Integer price) {
        return price * 50 / 100;
    }

    public static Page<ProductsDTO> llenarProductsDTO(Page<Products> productsPage, DozerBeanMapper mapper) {
        Page<ProductsDTO> dto = productsPage.map(products -> {
            ProductsDTO dt = mapper.map(products, ProductsDTO.class);
            return dt;
        });
        return dto;
    }

    public static boolean esNumerico(String word) {
        for (char w : word.toCharArray()) {
            if (!Character.isDigit(w)) {
                return false;
            }
        }
        return true;
    }
}
