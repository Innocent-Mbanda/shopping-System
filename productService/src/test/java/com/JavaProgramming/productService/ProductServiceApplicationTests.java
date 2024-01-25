package com.JavaProgramming.productService;


import com.JavaProgramming.productService.Dto.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
@Container
	static MySQLContainer mysql = new MySQLContainer(DockerImageName.parse("mysql:8.0.33"));

@Autowired
    private MockMvc mockMvc;
	private ObjectMapper objectMapper;
static {
	mysql.start();
}
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.url", mysql::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", mysql::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", mysql::getPassword);
	}
	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest =getProductRequest();

	String productRequestString =	objectMapper.writeValueAsString(productRequest);
	mockMvc.perform(MockMvcRequestBuilders.post("\"/api/product\"")
			.contentType(MediaType.APPLICATION_JSON)
			.content(productRequestString))
			.andExpect(status().isCreated());
}

private ProductRequest getProductRequest(){
	return ProductRequest.builder()
			.name("iphone 13")
			.description("Iphone 13")
			.price(BigDecimal.valueOf(1200))
			.build();
}

}
