package com.example.domains;

import com.example.domains.dtos.FornecedorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fornecedor")
    private Integer id;

    @NotNull @NotBlank
    private String razaoSocial;

    @NotNull @NotBlank
    private String cnpj;

    @NotNull @NotBlank
    private String nomeComercial;

    @NotNull
    private BigInteger ie;

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<Peca> pecas = new ArrayList<>();

    public Fornecedor() {}

    public Fornecedor(Integer id, String razaoSocial, String cnpj, String nomeComercial, BigInteger ie) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeComercial = nomeComercial;
        this.ie = ie;
    }

    public Fornecedor(FornecedorDTO dto){
        this.id = dto.getId();
        this.razaoSocial = dto.getRazaoSocial();
        this.cnpj = dto.getRazaoSocial();
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

    public @NotNull @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull @NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull @NotBlank String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(@NotNull @NotBlank String nomeComercial) {
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
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(id, that.id) && Objects.equals(razaoSocial, that.razaoSocial) && Objects.equals(cnpj, that.cnpj) && Objects.equals(nomeComercial, that.nomeComercial) && Objects.equals(ie, that.ie) && Objects.equals(pecas, that.pecas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razaoSocial, cnpj, nomeComercial, ie, pecas);
    }
}
