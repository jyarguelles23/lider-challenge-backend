package com.wallmart.challenge.Services;

import com.wallmart.challenge.AuxMethods.AuxMethods;
import com.wallmart.challenge.AuxMethods.productDescriptionAndBrandAuxMethods;
import com.wallmart.challenge.AuxMethods.productIdAuxMethods;
import com.wallmart.challenge.DTO.ProductsDTO;
import com.wallmart.challenge.Entities.Products;
import com.wallmart.challenge.Exceptions.NotFound.NotFoundException;
import com.wallmart.challenge.Repositories.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.wallmart.challenge.AuxMethods.AuxMethods.*;
import static com.wallmart.challenge.AuxMethods.productDescriptionAndBrandAuxMethods.changeWWWDescriptionBrand;
import static com.wallmart.challenge.AuxMethods.productDescriptionAndBrandAuxMethods.cincuentaPorcientoByBrandAndDescription;
import static com.wallmart.challenge.AuxMethods.productIdAuxMethods.changeWWWById;
import static com.wallmart.challenge.AuxMethods.productIdAuxMethods.cincuentaPorcientoById;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductsRepository repository;
    private DozerBeanMapper mapper;

    public ProductServiceImpl(ProductsRepository repository) {
        this.repository = repository;
        mapper = new DozerBeanMapper();
    }

    @Override
    public CompletableFuture<Page<Products>> busquedaProductosAll(final Pageable pageable) throws ExecutionException, InterruptedException {
       return repository.findAllBy(pageable);
    }

    @Override
    @Async("miEjecutadorHilos")
    public CompletableFuture<Page<Products>> buscarProductos(final String word, final Pageable pageable) throws ExecutionException, InterruptedException {
        return repository.findProductsByDescriptionLikeOrBrandLike(word, word, pageable);
    }

    @Override
    @Async("miEjecutadorHilos")
    public CompletableFuture<Optional<Products>> buscarProductoById(String word) throws ExecutionException, InterruptedException {
        Optional<Products> productsOptional = Optional.empty();
        CompletableFuture<Optional<Products>> pr = CompletableFuture.completedFuture(productsOptional);
        return (esNumerico(word)) ? repository.findOneById(Integer.parseInt(word)) : pr;
    }

    @Override
    public Page<ProductsDTO> finishFindAll(Page<Products> products) {
        Page<ProductsDTO> productsDTOS = llenarProductsDTO(products, mapper);
        return changeWWWDescriptionBrand(productsDTOS);
    }

    @Override
    public ProductsDTO finishId(Optional<Products> products, String word) {
        ProductsDTO productsDTO = mapper.map(products.get(), ProductsDTO.class);
        return ((esPalindromo(word)) && (word.length() >=3))
                ? cincuentaPorcientoById(productsDTO)
                : changeWWWById(productsDTO);
    }

    @Override
    public Page<ProductsDTO> finishFindDescriptionAndBrand(Page<Products> products, String word) {
        Page<ProductsDTO> productsDTOS = llenarProductsDTO(products, mapper);
        return (esPalindromo(word) && word.length() > 3)
                ? (cincuentaPorcientoByBrandAndDescription(productsDTOS))
                : (changeWWWDescriptionBrand(productsDTOS));
    }

}
