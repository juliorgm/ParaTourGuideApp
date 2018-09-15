package br.com.juliorgm.paratourguideapp.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import br.com.juliorgm.paratourguideapp.Adapter;
import br.com.juliorgm.paratourguideapp.R;
import br.com.juliorgm.paratourguideapp.models.Locais;

public class MaisVisitadosFragment extends Fragment {

    private RecyclerView mRecyclerLocais;
    private ArrayList<Locais> mListaLocais;
    private Resources mResourse;
    private String [] mTitulo,mDescricao;
    private int[] mIdImagem;

    public MaisVisitadosFragment(){}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mais_visitados, container, false);
        geraLista();

        mRecyclerLocais = view.findViewById(R.id.recyclerMaisVisitados);
        mRecyclerLocais.setHasFixedSize(true);
        mRecyclerLocais.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter adapter = new Adapter(getContext(), mListaLocais);
        mRecyclerLocais.setAdapter(adapter);
        return view;
    }

    public void geraLista(){
        mListaLocais = new ArrayList<>();
        carregaRecursos();
        addListaPrincipais();
    }

    public void addListaPrincipais(){
        for (int i = 0; i < mTitulo.length; i++) {
            mListaLocais.add(new Locais(mTitulo[i],mDescricao[i],mIdImagem[i]));
        }
    }

    public void carregaRecursos(){
        mResourse = getResources();
        mTitulo = mResourse.getStringArray(R.array.principais_titulo);
        mDescricao = mResourse.getStringArray(R.array.principais_descricao);
        mIdImagem = imgs();
    }

    public int[] imgs(){
        int [] img = new int[]{
                R.drawable.principais1,
                R.drawable.principais2,
                R.drawable.principais3,
                R.drawable.principais4,
                R.drawable.principais5,
                R.drawable.principais6,
                R.drawable.principais7
        } ;
        return img;
    }
}
