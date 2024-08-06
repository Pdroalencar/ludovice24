package com.example.ludovice2.model;

public class Vaga {
    private int id;
    private String titulo;
    private String empresa;
    private String descricao;
    private String localizacao;
    private String salario;
    private String dataPublicacao;
    private String urlDetalhes;

    public Vaga(int id, String titulo, String empresa, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.empresa = empresa;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.salario = salario;
        this.dataPublicacao = dataPublicacao;
        this.urlDetalhes = urlDetalhes;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {return localizacao; }

    public String getSalario() {return salario; }

    public String getDataPublicacao() {return dataPublicacao; }

    public String getUrlDetalhes() { return urlDetalhes; }

}

