package com.example.compraaccion.controlador;

import com.example.compraaccion.fachada.CompraFachada;
import com.example.compraaccion.model.Compra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("compras")
@Tag(name = "Buying API", description = "Action operations")
public class CompraControlador {

    private CompraFachada compras;

    @Autowired
    public CompraControlador(CompraFachada compras) {
        this.compras = compras;
    }


    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            operationId = "create",
            summary = "Create an action transaction",
            description = "Creates an action buy transaction and saves it in the database"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "The buying action was created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Compra.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(schema = @Schema(implementation = Void.class))
            )
    })
    ResponseEntity<Compra> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Buy action to be created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Compra.class)
                    )
            ) @RequestBody @Valid Compra compra)
    {
        //Tratamos de crear la compra:
        Optional<Compra> inserted = compras.create(compra);
        //Si se crea correctamente, devolvemos la información de la compra creada.
        return ResponseEntity.created(URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() +
                        "/compras/" + inserted.get().getId()))
                .body(inserted.get());
    }

    @GetMapping(
            path = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            operationId = "get",
            summary = "Gets a buying transaction",
            description = "Get the buying transaction referenced by the given id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "The buying transaction",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Compra.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(schema = @Schema(implementation = Void.class))
            )
    })
    ResponseEntity<Compra> get(@Parameter(description = "The unique id that identifies the transaction wanted to be retrieved", example = "60955b34f04eb642d289db9e") @PathVariable(value = "id", required = true) String id) {
        //Tratamos de crear la compra:
        return ResponseEntity.of(compras.get(id));
    }
}
