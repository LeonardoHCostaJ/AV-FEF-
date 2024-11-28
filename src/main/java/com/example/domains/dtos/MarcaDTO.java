package com.example.domains.dtos;

import com.example.domains.Marca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public class MarcaDTO {

    private Integer id;

    @NotNull(message = "O campo razão social não pode ser nulo")
    @NotBlank(message = "O campo razão social não pode estar vazio")
    private String razaoSocial;

    @NotNull(message = "O campo nome comercial não pode ser nulo")
    @NotBlank(message = "O campo nome comercial não pode estar vazio")
    private String nomeComercial;

    @NotNull(message = "O campo da inscrição estadual não pode ser nulo")
    private BigInteger ie;

    public MarcaDTO() {}

    public MarcaDTO(Marca marca) {
        this.id = marca.getId();
        this.ie = marca.getIe();
        this.nomeComercial = marca.getNomeComercial();
        this.razaoSocial = marca.getRazaoSocial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo razão social não pode ser nulo") @NotBlank(message = "O campo razão social não pode estar vazio") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razão social não pode ser nulo") @NotBlank(message = "O campo razão social não pode estar vazio") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public @NotNull(message = "O campo nome comercial não pode ser nulo") @NotBlank(message = "O campo nome comercial não pode estar vazio") String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(@NotNull(message = "O campo nome comercial não pode ser nulo") @NotBlank(message = "O campo nome comercial não pode estar vazio") String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public @NotNull(message = "O campo da inscrição estadual não pode ser nulo") BigInteger getIe() {
        return ie;
    }

    public void setIe(@NotNull(message = "O campo da inscrição estadual não pode ser nulo") BigInteger ie) {
        this.ie = ie;
    }
}
