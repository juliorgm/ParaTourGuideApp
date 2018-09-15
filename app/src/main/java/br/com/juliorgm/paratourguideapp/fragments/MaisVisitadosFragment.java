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
import java.util.Arrays;
import java.util.List;

import br.com.juliorgm.paratourguideapp.Adapter;
import br.com.juliorgm.paratourguideapp.R;
import br.com.juliorgm.paratourguideapp.models.Locais;

public class MaisVisitadosFragment extends Fragment {

    private RecyclerView mRecyclerLocais;
    private ArrayList<Locais> mListaLocais;
    private Resources mResourse;
    private List<String> mTitulo;
    private List<String> mDescricao;
    private List<Integer> mIdImagem;

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
        addLista();
    }

    public void addLista(){
        for (int i = 0; i < mTitulo.size(); i++) {
            mListaLocais.add(new Locais(mTitulo.get(i),mDescricao.get(i),mIdImagem.get(i)));
        }
    }

    public void carregaRecursos(){
        mResourse = getResources();
        mTitulo = Arrays.asList(mResourse.getStringArray(R.array.principais_titulo));
        mDescricao = Arrays.asList(mResourse.getStringArray(R.array.principais_descricao));
        mIdImagem = imgs();
    }

    public ArrayList<Integer> imgs(){

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(R.drawable.principais1);
        lista.add(R.drawable.principais2);
        lista.add(R.drawable.principais3);
        lista.add(R.drawable.principais4);
        lista.add(R.drawable.principais5);
        lista.add(R.drawable.principais6);
        lista.add(R.drawable.principais7);

        return lista;
    }
}
