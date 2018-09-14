package br.com.juliorgm.paratourguideapp.fragments;


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

public class MaisVisitadosFragment extends Fragment {

    private RecyclerView mRecyclerLocais;

    public MaisVisitadosFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mais_visitados, container, false);
        mRecyclerLocais = view.findViewById(R.id.recyclerMaisVisitados);
        ArrayList<Locais> listaLocais = new ArrayList<>();
        listaLocais.add(new Locais("Bragança","É bonito",R.drawable.braganca));
        listaLocais.add(new Locais("Bragança","É bonito",R.drawable.braganca));

        mRecyclerLocais.setHasFixedSize(true);
        mRecyclerLocais.setLayoutManager(new LinearLayoutManager(getContext()));
        Adapter adapter = new Adapter(getContext(), listaLocais);
        mRecyclerLocais.setAdapter(adapter);
        return view;
    }
}
