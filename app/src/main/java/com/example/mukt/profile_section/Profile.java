package com.example.mukt.profile_section;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mukt.R;
import com.example.mukt.profile_section.custom_adapter.interest_type_custom_adapter;
import com.example.mukt.profile_section.model_class.interest_type;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView name, mail, credits, role, events;
    RecyclerView credit_trans, event_types;
    interest_type_custom_adapter adapter;


    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        name = (TextView) v.findViewById(R.id.user_name);
        mail = (TextView) v.findViewById(R.id.user_mail);
        credits = (TextView) v.findViewById(R.id.user_credit);
        role = (TextView) v.findViewById(R.id.user_role);
        events = (TextView) v.findViewById(R.id.user_event);
        credit_trans = (RecyclerView) v.findViewById(R.id.event_types_profile);
        event_types = (RecyclerView) v.findViewById(R.id.event_credits_profile);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference().child("Main").child("Users").child("sKkW4UiDuzXrtw2Wl3bet44WqEo2");

        ref.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profile_info info = snapshot.getValue(profile_info.class);
                assert info != null;
                name.setText(info.getName().toString());
                mail.setText(info.getMail());
                credits.setText(info.getCredit_amount() + "");
                events.setText(info.getEvent_participated() + "");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),"Couldnt Fetch", Toast.LENGTH_SHORT).show();
            }
        });



        event_types.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<interest_type> options =
                new FirebaseRecyclerOptions.Builder<interest_type>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Main").child("Users").child("sKkW4UiDuzXrtw2Wl3bet44WqEo2").child("interests"), interest_type.class)
                        .build();

        adapter = new interest_type_custom_adapter(options);
        event_types.setAdapter(adapter);



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




}