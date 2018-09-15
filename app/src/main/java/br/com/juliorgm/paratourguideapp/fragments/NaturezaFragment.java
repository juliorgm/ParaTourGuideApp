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

public class NaturezaFragment extends Fragment {

    private RecyclerView mRecyclerLocais;
    private ArrayList<Locais> mListaLocais;
    private Resources mResourse;
    private String [] mTitulo,mDescricao;
    private int[] mIdImagem;

    public NaturezaFragment(){}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_natureza, container, false);
        geraLista();

        mRecyclerLocais = view.findViewById(R.id.recyclerNatureza);
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
        mTitulo = mResourse.getStringArray(R.array.natureza_titulo);
        mDescricao = mResourse.getStringArray(R.array.natureza_descricao);
        mIdImagem = imgs();
    }

    public int[] imgs(){
        return new int[]{
                R.drawable.naturais1,
                R.drawable.naturais2,
                R.drawable.naturais3,
                R.drawable.naturais4,
                R.drawable.naturais5,
                R.drawable.naturais6,
                R.drawable.naturais7
        };
    }
}
