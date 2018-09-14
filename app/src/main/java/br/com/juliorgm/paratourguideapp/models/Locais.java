package br.com.juliorgm.paratourguideapp.models;

public class Locais {
    private String mNome;
    private String mDescricao;
    private int mImagem;

    public Locais(String mNome, String mDescricao, int mImagem) {
        this.mNome = mNome;
        this.mDescricao = mDescricao;
        this.mImagem = mImagem;
    }

    public String getmNome() {
        return mNome;
    }

    public String getmDescricao() {
        return mDescricao;
    }

    public int getmImagem() {
        return mImagem;
    }
}
