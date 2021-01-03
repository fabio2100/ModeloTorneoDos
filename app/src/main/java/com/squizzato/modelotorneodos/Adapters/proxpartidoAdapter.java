package com.squizzato.modelotorneodos.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squizzato.modelotorneodos.Clases.Proximopartidoclase;
import com.squizzato.modelotorneodos.R;

import java.util.List;

public class proxpartidoAdapter extends RecyclerView.Adapter<proxpartidoAdapter.ViewHolder> {
    private List<Proximopartidoclase>proximopartidoclases;

    public proxpartidoAdapter(List<Proximopartidoclase> proximopartidoclases) {
        this.proximopartidoclases = proximopartidoclases;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.proxpartido,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull proxpartidoAdapter.ViewHolder holder, int position) {
        String equipoa = proximopartidoclases.get(position).getEquipoA();
        String equipob = proximopartidoclases.get(position).getEquipoB();
        String lugar = proximopartidoclases.get(position).getLugar();
        String dia = proximopartidoclases.get(position).getDia();
        String hora = proximopartidoclases.get(position).getHora();
        String fecha = proximopartidoclases.get(position).getFecha();
        String conexiondiayhora = dia+"  "+hora;

        holder.equipoA.setText(equipoa);
        holder.equipoB.setText(equipob);
        holder.lugar.setText(lugar);
        holder.diayhora.setText(conexiondiayhora);
        holder.fecha.setText(fecha);
    }


    @Override
    public int getItemCount() {
        return proximopartidoclases.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView equipoA;
        private TextView equipoB;
        private TextView lugar;
        private TextView diayhora;
        private TextView fecha;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            equipoA=itemView.findViewById(R.id.equipo1);
            equipoB=itemView.findViewById(R.id.equipo2);
            lugar = itemView.findViewById(R.id.lugar);
            diayhora = itemView.findViewById(R.id.fechayhora);
            fecha = itemView.findViewById(R.id.nrodefecha);
        }
    }
}
