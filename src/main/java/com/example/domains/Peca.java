package com.example.domains;

import com.example.domains.dtos.PecaDTO;
import com.example.domains.enums.Disponibilidade;
import com.example.domains.enums.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="peca")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_peca")
    private Long id;

    @NotNull @NotBlank
    private String nome;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @NotNull @NotBlank
    private String aplicacao;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Integer quantidade;

    @NotNull @NotBlank
    private String localizacao;

    @NotNull
    private Integer ncm;

    @NotNull @NotBlank
    private String unidade;

    @NotNull @NotBlank
    @Column(unique = true)
    private String codigoOrig;

    @NotNull @NotBlank
    private String grupo;

    @NotNull @NotBlank
    private String subGrupo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCad;

    @ManyToOne
    @JoinColumn(name="idmarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idfornecedor")
    private Fornecedor fornecedor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="disponibilidade")
    private Disponibilidade disponibilidade;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="estado")
    private Estado estado;


    public Peca() {
        this.valor = BigDecimal.ZERO;
        this.disponibilidade = Disponibilidade.DISPONIVEL;
    }

    public Peca(Long id, String nome, BigDecimal valor, String aplicacao, Integer quantidade, String localizacao, Integer ncm, String unidade, String codigoOrig, String grupo, String subGrupo, LocalDate dataCad, Disponibilidade disponibilidade, Estado estado, Marca marca, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.aplicacao = aplicacao;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.ncm = ncm;
        this.unidade = unidade;
        this.codigoOrig = codigoOrig;
        this.grupo = grupo;
        this.subGrupo = subGrupo;
        this.dataCad = dataCad;
        this.disponibilidade = disponibilidade;
        this.estado = estado;
        this.marca = marca;
        this.fornecedor = fornecedor;
    }

    public Peca(PecaDTO dto)    {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.valor = dto.getValor();
        this.aplicacao = dto.getAplicacao();
        this.quantidade = dto.getQuantidade();
        this.localizacao = dto.getLocalizacao();
        this.ncm = dto.getNcm();
        this.unidade = dto.getUnidade();
        this.codigoOrig = dto.getCodigoOrig();
        this.grupo = dto.getGrupo();
        this.subGrupo = dto.getSubGrupo();
        this.dataCad = dto.getDataCad();
        this.disponibilidade = Disponibilidade.toEnum(dto.getDisponibilidade());
        this.estado = Estado.toEnum(dto.getEstado());

        this.marca = new Marca();
        this.marca.setId(dto.getMarca());

        this.fornecedor = new Fornecedor();
        this.fornecedor.setId(dto.getFornecedor());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public @NotNull @NotBlank String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(@NotNull @NotBlank String aplicacao) {
        this.aplicacao = aplicacao;
    }

    @NotNull
    @Digits(integer = 3, fraction = 2)
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull @Digits(integer = 3, fraction = 2) Integer quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull @NotBlank String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(@NotNull @NotBlank String localizacao) {
        this.localizacao = localizacao;
    }

    @NotNull
    public Integer getNcm() {
        return ncm;
    }

    public void setNcm(@NotNull Integer ncm) {
        this.ncm = ncm;
    }

    public @NotNull @NotBlank String getUnidade() {
        return unidade;
    }

    public void setUnidade(@NotNull @NotBlank String unidade) {
        this.unidade = unidade;
    }

    public @NotNull @NotBlank String getCodigoOrig() {
        return codigoOrig;
    }

    public void setCodigoOrig(@NotNull @NotBlank String codigoOrig) {
        this.codigoOrig = codigoOrig;
    }

    public @NotNull @NotBlank String getGrupo() {
        return grupo;
    }

    public void setGrupo(@NotNull @NotBlank String grupo) {
        this.grupo = grupo;
    }

    public @NotNull @NotBlank String getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(@NotNull @NotBlank String subGrupo) {
        this.subGrupo = subGrupo;
    }

    public LocalDate getDataCad() {
        return dataCad;
    }

    public void setDataCad(LocalDate dataCad) {
        this.dataCad = dataCad;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peca peca = (Peca) o;
        return id == peca.id && quantidade == peca.quantidade && ncm == peca.ncm && Objects.equals(nome, peca.nome) && Objects.equals(aplicacao, peca.aplicacao) && Objects.equals(localizacao, peca.localizacao) && Objects.equals(unidade, peca.unidade) && Objects.equals(codigoOrig, peca.codigoOrig) && Objects.equals(grupo, peca.grupo) && Objects.equals(subGrupo, peca.subGrupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, aplicacao, quantidade, localizacao, ncm, unidade, codigoOrig, grupo, subGrupo);
    }
}
