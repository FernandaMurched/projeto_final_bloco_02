package com.generation.farmacia.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI springFarmaciaOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Projeto Farmácia")
						.description("API REST do Projeto Farmácia - Generation Brasil").version("v1.0.0")
						.license(new License().name("Generation Brasil").url("https://brazil.generation.org/"))
						.contact(new Contact().name("Fernanda Murched").url("https://github.com/FernandaMurched")
								.email("fernanda_murched@outlook.com.br")))
				.externalDocs(new ExternalDocumentation().description("Repositório no GitHub")
						.url("https://github.com/FernandaMurched/projeto_farmacia"));
	}

	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> openApi.getPaths().values()
				.forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
					ApiResponses apiResponses = operation.getResponses();

					apiResponses.addApiResponse("200", createApiResponse("✔️ Sucesso na requisição!"));
					apiResponses.addApiResponse("201", createApiResponse("✔️ Objeto criado com sucesso!"));
					apiResponses.addApiResponse("204", createApiResponse("✔️ Objeto deletado com sucesso!"));
					apiResponses.addApiResponse("400", createApiResponse("⚠️ Requisição inválida!"));
					apiResponses.addApiResponse("401", createApiResponse("🔒 Acesso não autorizado!"));
					apiResponses.addApiResponse("403", createApiResponse("⛔ Acesso proibido!"));
					apiResponses.addApiResponse("404", createApiResponse("❌ Objeto não encontrado!"));
					apiResponses.addApiResponse("500", createApiResponse("💥 Erro interno no servidor!"));
				}));
	}

	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}
}
