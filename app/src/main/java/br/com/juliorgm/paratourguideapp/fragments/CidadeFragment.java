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

public class CidadeFragment extends Fragment {

    private RecyclerView mRecyclerLocais;
    private ArrayList<Locais> mListaLocais;
    private Resources mResourse;
    private List<String> mTitulo;
    private List<String> mDescricao;
    private List<Integer> mIdImagem;

    public CidadeFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cidade, container, false);
        geraLista();

        mRecyclerLocais = view.findViewById(R.id.recyclerCidade);
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
        mTitulo = Arrays.asList(mResourse.getStringArray(R.array.cidade_titulo));
        mDescricao = Arrays.asList(mResourse.getStringArray(R.array.cidade_descricao));
        mIdImagem = imgs();
    }

    public ArrayList<Integer> imgs(){
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(R.drawable.cidade1);
        lista.add(R.drawable.cidade2);
        lista.add(R.drawable.cidade3);
        lista.add(R.drawable.cidade4);
        lista.add(R.drawable.cidade5);

        return lista;
    }
}
