package com.example.services;

import com.example.domains.Fornecedor;
import com.example.domains.dtos.FornecedorDTO;
import com.example.repositories.FornecedorRepository;
import com.example.services.exceptions.DataIntegrityViolationException;
import com.example.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<FornecedorDTO> findAll() {
        return fornecedorRepo.findAll().stream().map(obj -> new FornecedorDTO(obj)).collect(Collectors.toList());
    }

    public Fornecedor findById(int id) {
        Optional<Fornecedor> obj = fornecedorRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Id:" + id));
    }

    public Fornecedor findByCnpj(String cnpj) {
        Optional<Fornecedor> obj = fornecedorRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Cnpj:" + cnpj));
    }

    public Fornecedor findByRazaoSocial(String razaoSocial) {
        Optional<Fornecedor> obj = fornecedorRepo.findByRazaoSocial(razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Razao social:" + razaoSocial));
    }

    public Fornecedor findByNomeComercial(String nomeComercial) {
        Optional<Fornecedor> obj = fornecedorRepo.findByNomeComercial(nomeComercial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Nome comercial:" + nomeComercial));
    }

    public Fornecedor create(FornecedorDTO dto) {
        dto.setId(null);
        Fornecedor obj = new Fornecedor(dto);
        return fornecedorRepo.save(obj);
    }

    public Fornecedor update(Integer id, FornecedorDTO objDto) {
        objDto.setId(id);
        Fornecedor oldObj = findById(id);
        oldObj = new Fornecedor(objDto);
        return fornecedorRepo.save(oldObj);
    }

    public void delete(Integer id) {
        Fornecedor obj = findById(id);
        if (obj.getPecas().size() > 0) {
            throw new DataIntegrityViolationException("Fornecedor não pode ser deletado pois não possui peças vinculadas!");
        }
        fornecedorRepo.deleteById(id);
    }
}
