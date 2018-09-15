package br.com.juliorgm.paratourguideapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.juliorgm.paratourguideapp.R;
import br.com.juliorgm.paratourguideapp.models.Locais;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Locais> mLocais;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_local,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Locais local = mLocais.get(position);

        holder.mTitulo.setText(local.getmNome());
        holder.mDescricao.setText(local.getmDescricao());
        holder.mImagem.setImageResource(local.getmImagem());
    }

    @Override
    public int getItemCount() {
        return mLocais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitulo, mDescricao;
        private ImageView mImagem;
        private ViewHolder(View itemView) {
            super(itemView);

            mTitulo = itemView.findViewById(R.id.txtTitulo);
            mDescricao = itemView.findViewById(R.id.txtDescricao);
            mImagem = itemView.findViewById(R.id.imageView);
        }
    }
}
