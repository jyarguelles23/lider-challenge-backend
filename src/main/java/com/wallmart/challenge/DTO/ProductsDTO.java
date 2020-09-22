package com.wallmart.challenge.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class ProductsDTO {

    String _id;
    Integer id;
    String brand;
    String description;
    String image;
    Integer price;
    Integer oldPrice = 0;
}
