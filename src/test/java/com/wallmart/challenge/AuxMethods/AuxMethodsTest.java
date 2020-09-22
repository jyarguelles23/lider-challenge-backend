package com.wallmart.challenge.AuxMethods;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;
import static com.wallmart.challenge.Mock.ProductsMocks.getProductsPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class AuxMethodsTest {

    @DisplayName("Testing Es Palindromo")
    @Test
    void esPalindromo() {
        String yes = "181";
        String no = "sadassdshsghsdu";
        boolean result = AuxMethods.esPalindromo(yes);
        boolean resultFalse = AuxMethods.esPalindromo(no);
        assertTrue(result);
        assertFalse(resultFalse);
    }

    @DisplayName("Testing Calcular el 50 porciento")
    @Test
    void calcularCincuentaPorciento() {
        Integer price = 500000;
        Integer result = AuxMethods.calcularCincuentaPorciento(price);
        Integer resultadoCalculado = 250000;
        assertEquals(resultadoCalculado, result);
    }

    @DisplayName("Mover productos de Page<Products> to Page<ProductsDTO>")
    @Test
    void llenarProductsDTO() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        Page<Products> productsPage = getProductsPalindrome();
        Page<ProductsDTO> productsDTOPage = AuxMethods.llenarProductsDTO(productsPage, mapper);
        assertEquals(productsDTOPage.getContent().size(), getProductsPalindrome().getSize());
    }

    @DisplayName("Verificar si un String es un numero")
    @Test
    void esNumerico() {
        String no = "ada";
        String yes = "181";
        boolean result = AuxMethods.esNumerico(yes);
        boolean resultFalse = AuxMethods.esNumerico(no);
        assertTrue(result);
        assertFalse(resultFalse);

    }


}