package com.example.mukt.event_section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mukt.R;
import com.example.mukt.event_section.model_class.event_type;
import com.example.mukt.event_section.custom_adapters.event_types_fliter_custom_adapter;

import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Event#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Event extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView event_types;
    event_types_fliter_custom_adapter adapter;
    ImageView create_event_btn;



    String previous;

    public Event() {
        // Required empty public constructor
    }

    public Event(String previous) {
        // Required empty public constructor
        this.previous = previous;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Event.
     */
    // TODO: Rename and change types and number of parameters
    public static Event newInstance(String param1, String param2) {
        Event fragment = new Event();
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
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        event_types = (RecyclerView) v.findViewById(R.id.event_types);
        event_types.setItemAnimator(null);
        event_types.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<event_type> options =
                new FirebaseRecyclerOptions.Builder<event_type>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Main").child("Events").child("Types"), event_type.class)
                        .build();

        adapter = new event_types_fliter_custom_adapter(options,previous,getContext());
        event_types.setAdapter(adapter);

        //Assigning nested fragment to showcase event of list
        Fragment childFragment = new event_showcase_list("Nukkad Natak");
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.event_frag, childFragment).commit();

        //Create event button
        create_event_btn = (ImageView) v.findViewById(R.id.create_event_btn);
        create_event_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),event_create.class);
                startActivity(i);
            }
        });



        return v;
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onStart() {
        super.onStart();

        event_types.getRecycledViewPool().clear();
        event_types.setItemAnimator(null);
        adapter.notifyDataSetChanged();

        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }


    public static class WrapContentLinearLayoutManager extends LinearLayoutManager {
        public WrapContentLinearLayoutManager(Context context) {
            super(context);
        }

        public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public WrapContentLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                // Log.e("TAG", "meet a IOOBE in RecyclerView");
            }
        }
    }


}