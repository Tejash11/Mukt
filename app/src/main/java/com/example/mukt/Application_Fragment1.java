package com.example.mukt;

import android.content.Context;
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
 * Use the {@link Application_Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Application_Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Application_Fragment1() {
        // Required empty public constructor
    }

    public void ChangeToDetailsFragment(){

    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Application_Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Application_Fragment1 newInstance(String param1, String param2) {
        Application_Fragment1 fragment = new Application_Fragment1();
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

//    public void ChangeFrag(JobClass1 job){
//        activity_applications details = (activity_applications) getActivity();
//        details.ChangeToDetailsFragment(job);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_application_1, container, false);

        RecyclerView rcv1 = view.findViewById(R.id.application_recycler1);

        ArrayList<JobClass1> jobs1 = new ArrayList<>();

        jobs1.add(new JobClass1(R.drawable.nmba_logo,"Content Writer",
                R.drawable.background_outlined_green,R.drawable.arrow_forward_green,
                R.color.green,R.color.green_trans));
        jobs1.add(new JobClass1(R.drawable.org_logo,"Event Manager",
                R.drawable.background_outlined_blue,R.drawable.arrow_forward_blue,
                R.color.blue,R.color.blue_trans));
        jobs1.add(new JobClass1(R.drawable.org_logo2,"Video Editor",
                R.drawable.background_outlined_red,R.drawable.arrow_forward_red,
                R.color.red,R.color.red_trans));
        jobs1.add(new JobClass1(R.drawable.org_logo3,"Volunteer",
                R.drawable.background_outlined_yellow,R.drawable.arrow_forward_yellow,
                R.color.yellow,R.color.yellow_trans));

        JobAdapter1 jobAdapter1 = new JobAdapter1(this.getActivity(),jobs1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false);

        rcv1.setLayoutManager(linearLayoutManager);
        rcv1.setAdapter(jobAdapter1);

        rcv1.setNestedScrollingEnabled(false);
        rcv1.hasFixedSize();


        ArrayList<JobClass2> jobs2 = new ArrayList<>();

        jobs2.add(new JobClass2("Media Marketing",R.drawable.nmba_logo,"NMBA",1));
        jobs2.add(new JobClass2("Social Media Intern",R.drawable.org_logo3,"Navjeevan Rehab",2));
        jobs2.add(new JobClass2("Content Creator",R.drawable.nmba_logo,"NMBA",3));
        jobs2.add(new JobClass2("Backend Developer",R.drawable.org_logo2,"NCB",4));
        jobs2.add(new JobClass2("Accounts Intern",R.drawable.org_logo,"Jagruti Rehab",5));


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        JobAdapter2 jobAdapter2 = new JobAdapter2(jobs2,this.getActivity());

        RecyclerView rcv2 = view.findViewById(R.id.application_recycler2);
        rcv2.setNestedScrollingEnabled(false);
        rcv2.hasFixedSize();

        rcv2.setLayoutManager(linearLayoutManager1);
        rcv2.setAdapter(jobAdapter2);




        RecyclerView rcv3 = view.findViewById(R.id.application_recycler3);

        ArrayList<Task> tasks= new ArrayList<>();

        tasks.add(new Task("Share 500 posts",1,500,430));
        tasks.add(new Task("Invite 10 friends",2,10,8));
        tasks.add(new Task("Attend 3 events",3,3,2));
        tasks.add(new Task("Organize an event",4,1,0));

        TaskAdapter taskAdapter = new TaskAdapter(tasks,this.getActivity());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);

        rcv3.setLayoutManager(linearLayoutManager2);
        rcv3.setAdapter(taskAdapter);

        rcv3.setNestedScrollingEnabled(false);
        rcv3.hasFixedSize();


        // Inflate the layout for this fragment
        return view;
    }
}