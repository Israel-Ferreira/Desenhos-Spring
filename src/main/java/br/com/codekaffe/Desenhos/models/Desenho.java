package br.com.codekaffe.Desenhos.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Desenho {

    @Id
    private String id;

    private String nomeDoDesenho;

    private int qtdeTemporadas;

    private String rating;

    private String produtora;


    public Desenho(String nomeDoDesenho, int qtdeTemporadas, String produtora,String rating){
        this.nomeDoDesenho = nomeDoDesenho;
        this.qtdeTemporadas = qtdeTemporadas;
        this.produtora = produtora;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNomeDoDesenho() {
        return nomeDoDesenho;
    }

    public void setNomeDoDesenho(String nomeDoDesenho) {
        this.nomeDoDesenho = nomeDoDesenho;
    }

    public int getQtdeTemporadas() {
        return qtdeTemporadas;
    }

    public void setQtdeTemporadas(int qtdeTemporadas)  {
        if(qtdeTemporadas <= 0){
            throw new IllegalArgumentException("number of seasons == 8");
        }

        this.qtdeTemporadas = qtdeTemporadas;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getProdutora() {
        return produtora;
    }


    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

}
