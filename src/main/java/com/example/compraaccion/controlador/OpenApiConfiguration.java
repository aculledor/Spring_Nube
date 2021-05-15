package com.example.compraaccion.controlador;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Action Buying API REST",
                description = "API da práctica 8 de nube",
                version = "1.2.0",
                contact = @Contact(
                        name = "Abraham Trashorras Rivas",
                        url = "https://www.linkedin.com/in/abraham-trashorras-a853a1175/",
                        email = "abraham.trashorras@rai.usc.es"
                ),
                license = @License(
                        name = "MIT Licence",
                        url = "https://opensource.org/licenses/MIT")),
        servers = {
                @Server(url = "/", description = "General use server")
        }
)
public class OpenApiConfiguration {
}
