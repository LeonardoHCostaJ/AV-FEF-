package com.example.domains.enums;

public enum Disponibilidade {

    DISPONIVEL(0, "DISPONIVEL"), RESERVADO(1, "RESERVADO"), INDISPONIVEL(2, "INDISPONIVEL");

    private Integer id;
    private String situacao;

    Disponibilidade(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static Disponibilidade toEnum(Integer id){
        if(id==null) return null;
        for(Disponibilidade x : Disponibilidade.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Disponibilidade inválido");
    }
}
