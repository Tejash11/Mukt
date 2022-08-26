package com.example.mukt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingExploreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrainingExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingExploreFragment newInstance(String param1, String param2) {
        TrainingExploreFragment fragment = new TrainingExploreFragment();
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
        View view = inflater.inflate(R.layout.fragment_training_explore, container, false);

        RecyclerView rcv1 = view.findViewById(R.id.Training_recycler1);

        ArrayList<Training> trainings = new ArrayList<>();

        trainings.add(new Training(1,"Event Management Training","NMBA",45,R.drawable.vec_course));
        trainings.add(new Training(2,"Know NMBA in detail","NMBA",5,R.drawable.vec_course1));
        trainings.add(new Training(3,"How to quit smocking","NCB",1,R.drawable.vec_course2));
        trainings.add(new Training(4,"Learn counselling drug addicts","YourDost",20,R.drawable.vec_course3));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        TrainingAdapter trainingAdapter = new TrainingAdapter(trainings,getContext());

        rcv1.setLayoutManager(linearLayoutManager);
        rcv1.setAdapter(trainingAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}