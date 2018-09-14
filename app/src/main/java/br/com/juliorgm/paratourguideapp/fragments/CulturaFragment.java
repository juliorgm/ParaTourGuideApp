package br.com.juliorgm.paratourguideapp.fragments;

import android.content.res.Resources;
import android.os.Bundle;
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

public class CulturaFragment extends Fragment {

    private RecyclerView mRecyclerLocais;
    private ArrayList<Locais> mListaLocais;
    private Resources mResourse;
    private String [] mTitulo,mDescricao;
    private int[] mIdImagem;

    public CulturaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cultura, container, false);
        geraListaCultura();

        mRecyclerLocais = view.findViewById(R.id.recyclerCultura);
        mRecyclerLocais.setHasFixedSize(true);
        mRecyclerLocais.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter adapter = new Adapter(getContext(), mListaLocais);
        mRecyclerLocais.setAdapter(adapter);

        return view;
    }

    public void geraListaCultura(){
        mListaLocais = new ArrayList<>();
        carregaRecursos();
        addListaCultura();
    }

    public void addListaCultura(){
        for (int i = 0; i < mTitulo.length; i++) {
            mListaLocais.add(new Locais(mTitulo[i],mDescricao[i],mIdImagem[i]));
        }
    }

    public void carregaRecursos(){
        mResourse = getResources();
        mTitulo = mResourse.getStringArray(R.array.cultura_titulo);
        mDescricao = mResourse.getStringArray(R.array.cultura_descricao);
        mIdImagem = imgs();
    }

    public int[] imgs(){
        int [] img = new int[]{
           R.drawable.cultura1,
           R.drawable.cultura2,
           R.drawable.cultura3,
           R.drawable.cultura4,
           R.drawable.cultura5,
           R.drawable.cultura6,
           R.drawable.cultura7,
        } ;
        return img;
    }
}
