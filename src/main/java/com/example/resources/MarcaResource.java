package com.example.resources;


import com.example.domains.Marca;
import com.example.domains.dtos.MarcaDTO;
import com.example.services.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/marca")
public class MarcaResource {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> findAll() {
        return ResponseEntity.ok().body(marcaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MarcaDTO> findById(@PathVariable int id) {
        Marca obj = this.marcaService.findById(id);
        return ResponseEntity.ok().body(new MarcaDTO(obj));
    }

    @GetMapping(value = "/razaosocial/{razaoSocial}")
    public ResponseEntity<MarcaDTO> findById(@PathVariable String razaoSocial) {
        Marca obj = this.marcaService.findByRazaoSocial(razaoSocial);
        return ResponseEntity.ok().body(new MarcaDTO(obj));
    }

    @GetMapping(value = "/nomecomercial/{nomeComercial}")
    public ResponseEntity<MarcaDTO> findByRazaoSocial(@PathVariable String nomeComercial) {
        Marca obj = this.marcaService.findByNomeComercial(nomeComercial);
        return ResponseEntity.ok().body(new MarcaDTO(obj));
    }

    @PostMapping
    public ResponseEntity<MarcaDTO> create(@Valid @RequestBody MarcaDTO dto) {
        Marca marca = marcaService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MarcaDTO> update(@PathVariable Integer id, @Valid @RequestBody MarcaDTO objDto){
        Marca Obj = marcaService.update(id, objDto);
        return ResponseEntity.ok().body(new MarcaDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MarcaDTO> delete(@PathVariable Integer id){
        marcaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
