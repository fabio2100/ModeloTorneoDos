package com.squizzato.modelotorneodos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squizzato.modelotorneodos.Adapters.eqAdapter;
import com.squizzato.modelotorneodos.Clases.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Grupob.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Grupob#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Grupob extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RequestQueue mQueue;
    List<Equipo> equipos = new ArrayList<>();
    RecyclerView recyclerView;
    com.squizzato.modelotorneodos.Adapters.eqAdapter eqAdapter;
    View vista;

    private Grupoa.OnFragmentInteractionListener mListener;

    public Grupob() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Grupoa.
     */
    // TODO: Rename and change types and number of parameters
    public static Grupoa newInstance(String param1, String param2) {
        Grupoa fragment = new Grupoa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_grupoa,container,false);
        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        recyclerView = vista.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        jsonParse();
        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Grupoa.OnFragmentInteractionListener) {
            mListener = (Grupoa.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private void jsonParse() {
        equipos.clear();
        String url = "https://dl.dropbox.com/s/frzaon208qdkwxh/tabla.json";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Tabla");

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject posicion = jsonArray.getJSONObject(i);
                        //String pos=posicion.getString("POSICION");
                        String equi=posicion.getString("Equipo");
                        //String ptos=posicion.getString("Ptos");
                        //String pj=posicion.getString("PJ");
                        String pg=posicion.getString("PG");
                        String pe=posicion.getString("PE");
                        String pp=posicion.getString("PP");
                        String gf = posicion.getString("GF");
                        String gc = posicion.getString("GC");
                        //String dif = posicion.getString("Dif");
                        //String zona = posicion.getString("Zona");
                        equipos.add(new Equipo(equi,pg,pe,pp,gf,gc));

                    }
                    Collections.sort(equipos, new Comparator<Equipo>() {
                        @Override
                        public int compare(Equipo o1, Equipo o2) {
                            return new Integer(o2.getPuntos()).compareTo(o1.getPuntos());
                        }
                    });
                    eqAdapter = new eqAdapter(equipos);
                    recyclerView.setAdapter(eqAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"EN JSON",LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}
