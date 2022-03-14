package com.example.crmleads;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crmleads.model.LeadsAdapter;
import com.example.crmleads.model.LeadsRepository;


public class LeadsFragment extends Fragment {
    private ListView mLeadsList;
    private ArrayAdapter<String> mLeadsStringAdapter;

    private LeadsAdapter adaptadorClientes;

    private final String[] leadsNames = {
            "Guillermo del Toro",
            "Pedro Infante",
            "Cesar Ortega",
            "Alex Iñarritu",
            "Josue Naum",
            "Juan Lopez",
            "Mauricio Bernan",
            "Gabriel Garcia"
    };


    public LeadsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View raiz = inflater.inflate(R.layout.fragment_leads, container, false);
        mLeadsList = raiz.findViewById(R.id.leads_listview);
        mLeadsStringAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                leadsNames
        );

        adaptadorClientes = new LeadsAdapter(
                getActivity(), LeadsRepository.getInstance().getLeads()
        );
       // mLeadsList.setAdapter(mLeadsStringAdapter);
        mLeadsList.setAdapter(adaptadorClientes);

        return raiz;
    }
}