package com.example.mukt;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Application_Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Application_Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static JobClass1 job1 = null;
    static JobClass2 job2 = null;


    public Application_Fragment2(JobClass1 job) {
        this.job1 = job;
        // Required empty public constructor
    }
    public Application_Fragment2(JobClass2 job) {
        this.job2 = job;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Application_Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Application_Fragment2 newInstance(String param1, String param2) {
        Application_Fragment2 fragment;
        if(job1==null) {
            fragment = new Application_Fragment2(job2);
        }
        else{
            fragment = new Application_Fragment2(job1);
        }
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
        getActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                activity_applications met = (activity_applications) getActivity();
                met.ChangeToMainFragment();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application_2, container, false);
        // Inflate the layout for this fragment
        return view;
    }
}