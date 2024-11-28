package com.example.repositories;

import com.example.domains.Fornecedor;
import com.example.domains.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    Optional<Marca> findByRazaoSocial(String razaoSocial);

    Optional<Marca> findByNomeComercial(String nomeComercial);
}
