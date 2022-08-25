package com.example.mukt.event_section;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mukt.R;
import com.example.mukt.event_section.custom_adapters.event_showcase_info_custom_adapter;
import com.example.mukt.event_section.model_class.event_info;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link event_showcase_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class event_showcase_list extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView showcase_recycler;
    event_showcase_info_custom_adapter adapter;


    public event_showcase_list() {
        // Required empty public constructor
    }

    String query_event_type;

    public event_showcase_list(String query_event_type)
    {
        this.query_event_type = query_event_type;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment event_showcase_list.
     */
    // TODO: Rename and change types and number of parameters
    public static event_showcase_list newInstance(String param1, String param2) {
        event_showcase_list fragment = new event_showcase_list();
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
        View view = inflater.inflate(R.layout.fragment_event_showcase_list, container, false);
        showcase_recycler = (RecyclerView) view.findViewById(R.id.event_showcase_list_frag);
        showcase_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        Toast.makeText(getContext(), query_event_type, Toast.LENGTH_SHORT).show();

        FirebaseRecyclerOptions<event_info> options =
                new FirebaseRecyclerOptions.Builder<event_info>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Main").child("Events").child("Ghaziabad").orderByChild("event_type").equalTo(query_event_type), event_info.class)
                        .build();

        adapter = new event_showcase_info_custom_adapter(options);
        showcase_recycler.setAdapter(adapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}