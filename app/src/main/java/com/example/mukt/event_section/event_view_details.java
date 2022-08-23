package com.example.mukt.event_section;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mukt.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.InputStream;
import java.lang.ref.Reference;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link event_view_details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class event_view_details extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView img;
    TextView name, date, time, venue, address, type, doc;



    public event_view_details() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment event_view_details.
     */
    // TODO: Rename and change types and number of parameters
    public static event_view_details newInstance(String param1, String param2) {
        event_view_details fragment = new event_view_details();
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
        View v = inflater.inflate(R.layout.fragment_event_view_details, container, false);

        name = (TextView) v.findViewById(R.id.event_name_view);
        date = (TextView) v.findViewById(R.id.event_date_view);
        time = (TextView) v.findViewById(R.id.event_time_view);
        venue = (TextView) v.findViewById(R.id.event_venue_view);
        address = (TextView) v.findViewById(R.id.event_address_view);
        doc = (TextView) v.findViewById(R.id.event_doc_view);
        img = (ImageView) v.findViewById(R.id.event_img_view);

        Bundle b = this.getArguments();
        assert b != null;
        String event_name = b.getString("event_name");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Main").child("Events").child("Ghaziabad");


                ref.child(event_name).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {

                        if(task.isSuccessful())
                        {
                            DataSnapshot snapshot = task.getResult();
                            name.setText(String.valueOf(snapshot.child("event_name").getValue()));
                            date.setText(String.valueOf(snapshot.child("event_date").getValue()));
                            time.setText(String.valueOf(snapshot.child("event_time").getValue()));
                            venue.setText(String.valueOf(snapshot.child("venue_name").getValue()));
                            address.setText(String.valueOf(snapshot.child("venue_address").getValue()));
                            doc.setText(String.valueOf(snapshot.child("event_documentation").getValue()));

                            //Toast.makeText(getContext(),String.valueOf(snapshot.child("event_name")),Toast.LENGTH_LONG).show();

                            Glide.with(getActivity().getApplicationContext()).load(String.valueOf(snapshot.child("event_url1").getValue())).centerCrop().into(img);


                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });





        return v;
    }
}