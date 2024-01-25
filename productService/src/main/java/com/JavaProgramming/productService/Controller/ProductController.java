package com.JavaProgramming.productService.Controller;

import com.JavaProgramming.productService.Dto.ProductRequest;
import com.JavaProgramming.productService.Dto.ProductResponse;
import com.JavaProgramming.productService.Model.Product;
import com.JavaProgramming.productService.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/product")

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllproducts(){
       return productService.getProducts();
    }


}
