package com.wallmart.challenge.Services;

import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface ProductService {
    public CompletableFuture<Page<Products>> busquedaProductosAll(final Pageable pageable)
            throws ExecutionException, InterruptedException;

    public CompletableFuture<Page<Products>> buscarProductos(final String word, final Pageable pageable)
            throws ExecutionException, InterruptedException;

    public CompletableFuture<Optional<Products>> buscarProductoById(String id) throws ExecutionException, InterruptedException;

    public Page<ProductsDTO> finishFindAll(Page<Products> products);

    public ProductsDTO finishId(Optional<Products> products, String word);

    public Page<ProductsDTO> finishFindDescriptionAndBrand(Page<Products> products, String word);

}
