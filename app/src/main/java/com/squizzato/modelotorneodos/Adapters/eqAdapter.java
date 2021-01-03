package com.squizzato.modelotorneodos.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squizzato.modelotorneodos.Clases.Equipo;
import com.squizzato.modelotorneodos.R;

import java.util.List;

public class eqAdapter extends RecyclerView.Adapter <eqAdapter.ViewHolder> {
    private List <Equipo>equipos;

    public eqAdapter(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabla,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = equipos.get(position).getNombre();
        String puntos = Integer.toString(equipos.get(position).getPuntos());
        String PJ = Integer.toString(equipos.get(position).getPJ());
        String PG = equipos.get(position).getPG();
        String PE = equipos.get(position).getPE();
        String PP = equipos.get(position).getPP();
        String GF = equipos.get(position).getGF();
        String GC = equipos.get(position).getGC();
        String DG = Integer.toString(equipos.get(position).getDif());

        holder.nombre.setText(nombre);
        holder.puntos.setText(puntos);
        holder.PJ.setText(PJ);
        holder.PG.setText(PG);
        holder.PE.setText(PE);
        holder.PP.setText(PP);
        holder.GF.setText(GF);
        holder.GC.setText(GC);
        holder.Dif.setText(DG);

    }

    @Override
    public int getItemCount() {
        return equipos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView puntos;
        private TextView PJ;
        private TextView PE;
        private TextView PG;
        private TextView PP;
        private TextView GF;
        private TextView GC;
        private TextView Dif;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tweq);
            puntos = itemView.findViewById(R.id.twptos);
            PJ = itemView.findViewById(R.id.twpj);
            PE = itemView.findViewById(R.id.twpe);
            PG = itemView.findViewById(R.id.twpg);
            PP = itemView.findViewById(R.id.twpp);
            GF = itemView.findViewById(R.id.twgf);
            GC = itemView.findViewById(R.id.twgc);
            Dif = itemView.findViewById(R.id.twdif);
        }
    }
}


///Esta hecho el adapter,,,,solo falta la clase principal