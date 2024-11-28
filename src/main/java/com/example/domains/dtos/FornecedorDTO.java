package com.example.domains.dtos;

import com.example.domains.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public class FornecedorDTO {

    private Integer id;

    @NotNull(message = "O campo razão social não pode ser nulo")
    @NotBlank(message = "O campo razão social não pode estar vazio")
    private String razaoSocial;

    @NotNull(message = "O campo cnpj não pode ser nulo")
    @NotBlank(message = "O campo cnpj não pode estar vazio")
    private String cnpj;

    @NotNull(message = "O campo nome comercial não pode ser nulo")
    @NotBlank(message = "O campo nome comercial não pode estar vazio")
    private String nomeComercial;

    @NotNull(message = "O campo da inscrição estadual não pode ser nulo")
    private BigInteger ie;

    public FornecedorDTO() {}

    public FornecedorDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.razaoSocial = fornecedor.getRazaoSocial();
        this.cnpj = fornecedor.getCnpj();
        this.nomeComercial = fornecedor.getNomeComercial();
        this.ie = fornecedor.getIe();
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

    public @NotNull(message = "O campo cnpj não pode ser nulo") @NotBlank(message = "O campo cnpj não pode estar vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo cnpj não pode ser nulo") @NotBlank(message = "O campo cnpj não pode estar vazio") String cnpj) {
        this.cnpj = cnpj;
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
