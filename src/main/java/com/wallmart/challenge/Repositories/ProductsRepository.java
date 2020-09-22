package com.wallmart.challenge.Repositories;

import com.wallmart.challenge.Entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {

    @Async
    CompletableFuture<Page<Products>> findProductsByDescriptionLikeOrBrandLike(final String description, final String brand, final Pageable pageable);

    /*@Async
    CompletableFuture<Optional<Products>> findOneById(final String id);*/

    @Async()
    CompletableFuture<Page<Products>> findAllBy(final Pageable pageable);

    @Async
    CompletableFuture<Optional<Products>> findOneById(final Integer id);

}
