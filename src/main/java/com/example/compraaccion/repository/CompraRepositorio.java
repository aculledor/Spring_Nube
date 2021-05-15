package com.example.compraaccion.repository;

import com.example.compraaccion.model.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompraRepositorio extends MongoRepository<Compra, String> {
}
