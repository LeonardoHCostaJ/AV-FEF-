package com.example.domains;

import com.example.domains.dtos.MarcaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca")
    private Integer id;

    @NotNull @NotBlank
    private String razaoSocial;

    @NotNull @NotBlank
    private String nomeComercial;

    @NotNull
    private BigInteger ie;

    @JsonIgnore
    @OneToMany(mappedBy = "marca")
    private List<Peca> pecas = new ArrayList<>();

    public Marca() {}

    public Marca(Integer id, String razaoSocial, String nomeComercial, BigInteger ie) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeComercial = nomeComercial;
        this.ie = ie;
    }

    public Marca(MarcaDTO dto){
        this.id = dto.getId();
        this.razaoSocial = dto.getRazaoSocial();
        this.nomeComercial = dto.getNomeComercial();
        this.ie = dto.getIe();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    @NotNull
    public BigInteger getIe() {
        return ie;
    }

    public void setIe(@NotNull BigInteger ie) {
        this.ie = ie;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return id == marca.id && ie == marca.ie && Objects.equals(razaoSocial, marca.razaoSocial) && Objects.equals(nomeComercial, marca.nomeComercial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razaoSocial, nomeComercial, ie);
    }
}
