package com.example.services;

import com.example.domains.Marca;
import com.example.domains.dtos.MarcaDTO;
import com.example.repositories.MarcaRepository;
import com.example.services.exceptions.DataIntegrityViolationException;
import com.example.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepo;

    public List<MarcaDTO> findAll() {
        return marcaRepo.findAll().stream().map(obj -> new MarcaDTO(obj)).collect(Collectors.toList());
    }

    public Marca findById(int id) {
        Optional<Marca> obj = marcaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada! Id:"+id));
    }

    public Marca findByRazaoSocial(String razaoSocial){
        Optional<Marca> obj = marcaRepo.findByRazaoSocial(razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada! Razão social:"+razaoSocial));
    }

    public Marca findByNomeComercial(String nomeComercial){
        Optional<Marca> obj = marcaRepo.findByNomeComercial(nomeComercial);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada! Nome comercial:"+nomeComercial));
    }

    public Marca create(MarcaDTO dto){
        dto.setId(null);
        Marca obj = new Marca(dto);
        return marcaRepo.save(obj);
    }

    public Marca update(Integer id, MarcaDTO objDto){
        objDto.setId(id);
        Marca oldObj = findById(id);
        oldObj = new Marca(objDto);
        return marcaRepo.save(oldObj);
    }

    public void delete(Integer id) {
        Marca obj = findById(id);
        if (obj.getPecas().size() > 0) {
            throw new DataIntegrityViolationException("Marca não pode ser deletada pois não possui peças vinculadas!");
        }
        marcaRepo.deleteById(id);
    }
}
