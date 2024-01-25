package com.JavaProgramming.productService.ProductRepo;

import com.JavaProgramming.productService.Model.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Id> {
}
