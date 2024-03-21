package br.com.rankanimes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Anime implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int classificacaoIndicativa;
    private float notaMedia;
    private float numeroEpisodios;
    
    @OneToMany(mappedBy = "anime", orphanRemoval = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Avaliacao> avals = new ArrayList<>();

    public Anime() {
    }


    public Anime(long id, int classificacaoIndicativa, float notaMedia, float numeroEpisodios) {
        this.id = id;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.notaMedia = notaMedia;
        this.numeroEpisodios = numeroEpisodios;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }


    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }


    public float getNotaMedia() {
        return notaMedia;
    }


    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }


    public float getNumeroEpisodios() {
        return numeroEpisodios;
    }


    public void setNumeroEpisodios(float numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    

    
}
