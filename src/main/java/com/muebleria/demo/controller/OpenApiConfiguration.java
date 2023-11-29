package com.muebleria.demo.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        //
        info = @Info(title = "API de Mueblerías",
                version = "1.0.0",
                description = "API de Mueblerías del grupo Zida pa ti",
                contact = @Contact(email = "zidapati@elbicho.com", name = "Alexander Tica")),

        servers = {
                @Server(url = "http://localhost:8080", description = "Local"),
                @Server(url = "https://mueblería.zida.com", description = "QA"),
        }

)
public class OpenApiConfiguration {
    
}
