package com.alves.backproduto;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BackProdutoApplication", version = "1", description = " Api CRUD de produtos"))
public class BackProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackProdutoApplication.class, args);
	}

}
