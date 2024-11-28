package com.example.domains.enums;

public enum Estado {

    NOVO(0, "NOVO"), USADA(1, "USADA");

    private Integer id;
    private String status;

    Estado(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Estado toEnum(Integer id){
        if(id==null) return null;
        for(Estado x : Estado.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Estado inválido");
    }
}

