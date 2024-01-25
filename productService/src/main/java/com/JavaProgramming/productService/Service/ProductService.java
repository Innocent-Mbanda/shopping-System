package com.JavaProgramming.productService.Service;

import com.JavaProgramming.productService.Dto.ProductRequest;
import com.JavaProgramming.productService.Dto.ProductResponse;
import com.JavaProgramming.productService.Model.Product;
import com.JavaProgramming.productService.ProductRepo.ProductRepo;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepo productRepo;
    public void createProduct(ProductRequest productRequest){
      Product product = Product.builder()
              .name(productRequest.getName())
              .price(productRequest.getPrice())
              .description(productRequest.getDescription())
              .build();
      productRepo.save(product);
      log.info("product {} is Save", product.getId());
    }

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepo.findAll();
      return products.stream().map(this::mapToProductResponse).toList();

    }
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .Id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
