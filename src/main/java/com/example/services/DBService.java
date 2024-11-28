package com.example.services;

import com.example.domains.Fornecedor;
import com.example.domains.Marca;
import com.example.domains.Peca;
import com.example.domains.enums.Disponibilidade;
import com.example.domains.enums.Estado;
import com.example.repositories.FornecedorRepository;
import com.example.repositories.MarcaRepository;
import com.example.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private PecaRepository pecaRepo;

    @Autowired
    private MarcaRepository marcaRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    public void initDB(){

        Marca marca01 = new Marca(null, "Rodobens Caminhões e Onibus", "Mercedes", new BigInteger("304512457587"));
        Marca marca02 = new Marca(null, "Volkswagen do Brasil Industria de Veiculos Automotores", "Volkswagen", new BigInteger("154785987526"));

        Fornecedor fornecedor01 = new Fornecedor(null, "Vannucci Importacao Exportacao e Com. de Pecas", "11623920000182", "Vannucci", new BigInteger("147038291117"));
        Fornecedor fornecedor02 = new Fornecedor(null, "Pacaembu Autopecas", "61295473000905", "Pacaembu", new BigInteger("647109389113"));

        Peca peca01 = new Peca(null, "Lona de Freio", new BigDecimal("77"), "MB 710", 2, "A.2.19", 87083090, "PC", "A6884203020", "Freio", "Lonas", LocalDate.of(2024,11,15), Disponibilidade.DISPONIVEL,  Estado.NOVO, marca01, fornecedor01);
        Peca peca02 = new Peca(null, "Retentor Cubo Dianteiro", new BigDecimal("95"), "VOLKS 8.160", 3, "B.7.23", 87149310, "PC", "00188BA", "Roda", "Retentores", LocalDate.of(2024, 11, 16    ), Disponibilidade.DISPONIVEL, Estado.NOVO, marca02, fornecedor02);

        marcaRepo.save(marca01);
        marcaRepo.save(marca02);
        fornecedorRepo.save(fornecedor01);
        fornecedorRepo.save(fornecedor02);
        pecaRepo.save(peca01);
        pecaRepo.save(peca02);
    }
}
