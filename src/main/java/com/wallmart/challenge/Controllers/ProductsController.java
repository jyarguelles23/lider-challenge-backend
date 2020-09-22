package com.wallmart.challenge.Controllers;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import com.wallmart.challenge.Exceptions.NotFound.NotFoundException;
import com.wallmart.challenge.Services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/product/api")
@CrossOrigin("*")
@Slf4j
public class ProductsController {

    private ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getProductsAll(final Pageable pageable) throws ExecutionException, InterruptedException {
        CompletableFuture<Page<Products>> productsAll = service.busquedaProductosAll(pageable);
        if (productsAll.get().hasContent()) {
            return new ResponseEntity<>(service.finishFindAll(productsAll.get()), HttpStatus.OK);
        } else {
            log.error("Empty Database!");
            throw new NotFoundException("Lo sentimos no se encontraron productos");
        }
    }

    @GetMapping(value = "/{word}")
    public ResponseEntity<?> getProducts(@PathVariable String word, final Pageable pageable) throws ExecutionException, InterruptedException {
        CompletableFuture<Optional<Products>> futureId = service.buscarProductoById(word);
        CompletableFuture<Page<Products>> futureDescBrand = service.buscarProductos(word, pageable);

        if (futureId.get().isPresent()) {
            return new ResponseEntity<>(service.finishId(futureId.get(), word), HttpStatus.OK);
        } else if (futureDescBrand.get().hasContent()) {
            return new ResponseEntity<>(service.finishFindDescriptionAndBrand(futureDescBrand.get(), word), HttpStatus.OK);
        } else {
            log.error("Product not found by criteria");
            throw new NotFoundException("Lo sentimos no se encontro el producto");
        }
    }

}
