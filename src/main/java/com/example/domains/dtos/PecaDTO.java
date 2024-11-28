package com.example.domains.dtos;

import com.example.domains.Peca;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PecaDTO {

    private Long id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo valor não pode ser nulo")
    @Digits(integer = 15 , fraction = 2)
    private BigDecimal valor;

    @NotNull(message = "O campo aplicação não pode ser nulo")
    @NotBlank(message = "O campo aplicação não pode estar vazio")
    private String aplicacao;

    @NotNull(message = "O campo quantidade não pode ser nulo")
    private int quantidade;

    @NotNull(message = "O campo localização não pode ser nulo")
    @NotBlank(message = "O campo localização não pode estar vazio")
    private String localizacao;

    @NotNull(message = "O campo ncm não pode ser nulo")
    private int ncm;

    @NotNull(message = "O campo unidade não pode ser nulo")
    @NotBlank(message = "O campo unidade não pode estar vazio")
    private String unidade;

    @NotNull(message = "O campo codigo original não pode ser nulo")
    @NotBlank(message = "O campo codigo original não pode estar vazio")
    private String codigoOrig;

    @NotNull(message = "O campo grupo não pode ser nulo")
    @NotBlank(message = "O campo grupo não pode estar vazio")
    private String grupo;

    @NotNull(message = "O campo sub grupo não pode ser nulo")
    @NotBlank(message = "O campo sub grupo não pode estar vazio")
    private String subGrupo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCad;

    @NotNull(message = "O campo marca não pode ser nulo")
    private int marca;

    @NotNull(message = "O campo fornecedor não pode ser nulo")
    private int fornecedor;

    private int disponibilidade;

    private int estado;

    public PecaDTO() {}

    public PecaDTO(Peca peca) {
        this.id = peca.getId();
        this.nome = peca.getNome();
        this.valor = peca.getValor();
        this.aplicacao = peca.getAplicacao();
        this.quantidade = peca.getQuantidade();
        this.localizacao = peca.getLocalizacao();
        this.ncm = peca.getNcm();
        this.unidade = peca.getUnidade();
        this.codigoOrig = peca.getCodigoOrig();
        this.grupo = peca.getGrupo();
        this.subGrupo = peca.getSubGrupo();
        this.dataCad = peca.getDataCad();
        this.marca = peca.getMarca().getId();
        this.fornecedor = peca.getFornecedor().getId();
        this.disponibilidade = peca.getDisponibilidade().getId();
        this.estado = peca.getEstado().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo valor não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull(message = "O campo valor não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public @NotNull(message = "O campo aplicação não pode ser nulo") @NotBlank(message = "O campo aplicação não pode estar vazio") String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(@NotNull(message = "O campo aplicação não pode ser nulo") @NotBlank(message = "O campo aplicação não pode estar vazio") String aplicacao) {
        this.aplicacao = aplicacao;
    }

    @NotNull(message = "O campo quantidade não pode ser nulo")
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull(message = "O campo quantidade não pode ser nulo") int quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull(message = "O campo localização não pode ser nulo") @NotBlank(message = "O campo localização não pode estar vazio") String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(@NotNull(message = "O campo localização não pode ser nulo") @NotBlank(message = "O campo localização não pode estar vazio") String localizacao) {
        this.localizacao = localizacao;
    }

    @NotNull(message = "O campo ncm não pode ser nulo")
    public int getNcm() {
        return ncm;
    }

    public void setNcm(@NotNull(message = "O campo ncm não pode ser nulo") int ncm) {
        this.ncm = ncm;
    }

    public @NotNull(message = "O campo unidade não pode ser nulo") @NotBlank(message = "O campo unidade não pode estar vazio") String getUnidade() {
        return unidade;
    }

    public void setUnidade(@NotNull(message = "O campo unidade não pode ser nulo") @NotBlank(message = "O campo unidade não pode estar vazio") String unidade) {
        this.unidade = unidade;
    }

    public @NotNull(message = "O campo codigo original não pode ser nulo") @NotBlank(message = "O campo codigo original não pode estar vazio") String getCodigoOrig() {
        return codigoOrig;
    }

    public void setCodigoOrig(@NotNull(message = "O campo codigo original não pode ser nulo") @NotBlank(message = "O campo codigo original não pode estar vazio") String codigoOrig) {
        this.codigoOrig = codigoOrig;
    }

    public @NotNull(message = "O campo grupo não pode ser nulo") @NotBlank(message = "O campo grupo não pode estar vazio") String getGrupo() {
        return grupo;
    }

    public void setGrupo(@NotNull(message = "O campo grupo não pode ser nulo") @NotBlank(message = "O campo grupo não pode estar vazio") String grupo) {
        this.grupo = grupo;
    }

    public @NotNull(message = "O campo sub grupo não pode ser nulo") @NotBlank(message = "O campo sub grupo não pode estar vazio") String getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(@NotNull(message = "O campo sub grupo não pode ser nulo") @NotBlank(message = "O campo sub grupo não pode estar vazio") String subGrupo) {
        this.subGrupo = subGrupo;
    }

    public LocalDate getDataCad() {
        return dataCad;
    }

    public void setDataCad(LocalDate dataCad) {
        this.dataCad = dataCad;
    }

    @NotNull(message = "O campo marca não pode ser nulo")
    public int getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "O campo marca não pode ser nulo") int marca) {
        this.marca = marca;
    }

    @NotNull(message = "O campo fornecedor não pode ser nulo")
    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(@NotNull(message = "O campo fornecedor não pode ser nulo") int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
