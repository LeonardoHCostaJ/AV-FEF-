package com.example.resources;

import com.example.domains.Fornecedor;
import com.example.domains.dtos.FornecedorDTO;
import com.example.services.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> findAll(){
        return ResponseEntity.ok().body(fornecedorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable int id) {
        Fornecedor obj = this.fornecedorService.findById(id);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable String cnpj) {
        Fornecedor obj = this.fornecedorService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @GetMapping(value = "/razaosocial/{razaoSocial}")
    public ResponseEntity<FornecedorDTO> findByCnpj(@PathVariable String razaoSocial) {
        Fornecedor obj = this.fornecedorService.findByRazaoSocial(razaoSocial);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @GetMapping(value = "/nomecomercial/{nomeComercial}")
    public ResponseEntity<FornecedorDTO> findByRazaoSocial(@PathVariable String nomeComercial) {
        Fornecedor obj = this.fornecedorService.findByNomeComercial(nomeComercial);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> create(@Valid @RequestBody FornecedorDTO dto){
        Fornecedor fornecedor = fornecedorService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fornecedor.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> update(@PathVariable Integer id, @Valid @RequestBody FornecedorDTO objDto){
        Fornecedor Obj = fornecedorService.update(id, objDto);
        return ResponseEntity.ok().body(new FornecedorDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> delete(@PathVariable Integer id){
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
