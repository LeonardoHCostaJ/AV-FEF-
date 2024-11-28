package com.example.services;


import com.example.domains.Fornecedor;
import com.example.domains.Marca;
import com.example.domains.Peca;
import com.example.domains.dtos.PecaDTO;
import com.example.repositories.FornecedorRepository;
import com.example.repositories.MarcaRepository;
import com.example.repositories.PecaRepository;
import com.example.services.exceptions.DataIntegrityViolationException;
import com.example.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    @Autowired
    private MarcaRepository marcaRepo;

    public List<PecaDTO> findAll() {
        return pecaRepo.findAll().stream().map(obj -> new PecaDTO(obj)).collect(Collectors.toList());
    }

    public Peca findById(Long id) {
        Optional<Peca> obj = pecaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Id:"+id));
    }

    public Peca findByNome(String nome) {
        Optional<Peca> obj = pecaRepo.findByNome(nome);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Nome:"+nome));
    }

    public Peca findByAplicacao(String aplicacao) {
        Optional<Peca> obj = pecaRepo.findByAplicacao(aplicacao);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Aplicação:"+aplicacao));
    }

    public Peca findByCodigoOrig(String codigoOrig) {
        Optional<Peca> obj = pecaRepo.findByCodigoOrig(codigoOrig);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Codigo original:"+codigoOrig));
    }

    public Peca findByGrupo(String grupo) {
        Optional<Peca> obj = pecaRepo.findByGrupo(grupo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Grupo:"+grupo));
    }

    public Peca findBySubGrupo(String subGrupo) {
        Optional<Peca> obj = pecaRepo.findBySubGrupo(subGrupo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Sub grupo:"+subGrupo));
    }

    public Peca findByDataCad(LocalDate dataCad) {
        Optional<Peca> obj = pecaRepo.findByDataCad(dataCad);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Peça não encontrada! Data de cadastro:"+dataCad));
    }

    public Peca create(PecaDTO dto){
        dto.setId(null);
        validaPeca(dto);
        Peca obj = new Peca(dto);
        return pecaRepo.save(obj);
    }

    private void validaPeca(PecaDTO dto){
        Optional<Peca> obj = pecaRepo.findByCodigoOrig(dto.getCodigoOrig());
        if(obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new DataIntegrityViolationException("Codigo original já cadastrado!");
        }

        Optional<Fornecedor> fornecedor = fornecedorRepo.findById(dto.getFornecedor());
        if(!fornecedor.isPresent()){
            throw new DataIntegrityViolationException("Fornecedor - "+dto.getFornecedor()+" não está cadastrado!");
        }

        Optional<Marca> marca = marcaRepo.findById(dto.getMarca());
        if(!marca.isPresent()){
            throw new DataIntegrityViolationException("Marca - "+dto.getMarca()+" não está cadastrada!");
        }

    }
    public Peca update(Long id, PecaDTO objDto){
        objDto.setId(id);
        Peca oldObj = findById(id);
        validaPeca(objDto);
        oldObj = new Peca(objDto);
        return pecaRepo.save(oldObj);
    }

    public void delete(Long id){
        Peca obj = findById(id);
        pecaRepo.deleteById(id);
    }
}
