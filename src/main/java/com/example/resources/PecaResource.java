package com.example.resources;

import com.example.domains.Peca;
import com.example.domains.dtos.FornecedorDTO;
import com.example.domains.dtos.PecaDTO;
import com.example.services.PecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/peca")
public class PecaResource {

    @Autowired
    private PecaService pecaService;

    @GetMapping
    public ResponseEntity<List<PecaDTO>> findAll() {
        return ResponseEntity.ok().body(pecaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PecaDTO> findById(@PathVariable Long id){
        Peca obj = this.pecaService.findById(id);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<PecaDTO> findById(@PathVariable String nome){
        Peca obj = this.pecaService.findByNome(nome);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @GetMapping(value = "/aplicacao/{aplicacao}")
    public ResponseEntity<PecaDTO> findByNome(@PathVariable String aplicacao){
        Peca obj = this.pecaService.findByAplicacao(aplicacao);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @GetMapping(value = "/codigoorig/{codigoOrig}")
    public ResponseEntity<PecaDTO> findByAplicacao(@PathVariable String codigoOrig){
        Peca obj = this.pecaService.findByCodigoOrig(codigoOrig);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @GetMapping(value = "/grupo/{grupo}")
    public ResponseEntity<PecaDTO> findByCodigoOrig(@PathVariable String grupo){
        Peca obj = this.pecaService.findByGrupo(grupo);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @GetMapping(value = "/subgrupo/{subGrupo}")
    public ResponseEntity<PecaDTO> findByGrupo(@PathVariable String subGrupo){
        Peca obj = this.pecaService.findBySubGrupo(subGrupo);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @GetMapping(value = "/datacad/{dataCad}")
    public ResponseEntity<PecaDTO> findBySubGrupo(@PathVariable LocalDate dataCad){
        Peca obj = this.pecaService.findByDataCad(dataCad);
        return ResponseEntity.ok().body(new PecaDTO(obj));
    }

    @PostMapping
    public ResponseEntity<PecaDTO> create(@Valid @RequestBody PecaDTO dto){
        Peca peca = pecaService.create(dto);

        URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(peca.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PecaDTO> update(@PathVariable Long id, @Valid @RequestBody PecaDTO objDto){
        Peca Obj = pecaService.update(id, objDto);
        return ResponseEntity.ok().body(new PecaDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PecaDTO> delete(@PathVariable Long id){
        pecaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
