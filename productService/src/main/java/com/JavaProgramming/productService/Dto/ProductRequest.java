package com.JavaProgramming.productService.Dto;

import com.JavaProgramming.productService.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long Id;
    private String name;
    private BigDecimal price;
    private String description;


}
