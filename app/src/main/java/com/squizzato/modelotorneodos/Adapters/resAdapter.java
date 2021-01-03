package com.squizzato.modelotorneodos.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squizzato.modelotorneodos.Clases.Resultado;
import com.squizzato.modelotorneodos.R;
import com.squizzato.modelotorneodos.Clases.Resultado;

import java.util.List;

public class resAdapter extends RecyclerView.Adapter  <resAdapter.ViewHolder>{
    List <Resultado>resultados;

    public resAdapter(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.partido,parent,false);
        resAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String equipoA = resultados.get(position).getEquipoA();
        String equipoB = resultados.get(position).getEquipoB();
        String golA = resultados.get(position).getGolA();
        String golB = resultados.get(position).getGolB();

        holder.equipoA.setText(equipoA);
        holder.equipoB.setText(equipoB);
        holder.golA.setText(golA);
        holder.golB.setText(golB);

    }



    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView equipoA;
        private TextView equipoB;
        private TextView golA;
        private TextView golB;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            equipoA=itemView.findViewById(R.id.name_eq1);
            equipoB = itemView.findViewById(R.id.name_eq2);
            golA = itemView.findViewById(R.id.gol_eq1);
            golB = itemView.findViewById(R.id.gol_eq2);
        }
    }
}
