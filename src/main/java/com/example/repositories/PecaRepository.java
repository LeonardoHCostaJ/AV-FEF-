package com.example.repositories;

import com.example.domains.Marca;
import com.example.domains.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {

    Optional<Peca> findByNome(String nome);

    Optional<Peca> findByAplicacao(String aplicacao);

    Optional<Peca> findByCodigoOrig(String codigoOrig);

    Optional<Peca> findByGrupo(String grupo);

    Optional<Peca> findBySubGrupo(String subGrupo);

    Optional<Peca> findByDataCad(LocalDate dataCad);

}
