package com.example.repositories;

import com.example.domains.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    Optional<Fornecedor> findByCnpj(String cnpj);

    Optional<Fornecedor> findByRazaoSocial(String razaoSocial);

    Optional<Fornecedor> findByNomeComercial(String nomeComercial);
}
