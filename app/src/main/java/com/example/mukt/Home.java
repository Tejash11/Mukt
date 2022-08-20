package com.example.mukt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    Context context;
    public Home(Context context){
        this.context = context;
    }

//    private StorageReference StorageReference;

//    private ViewPager2 viewPager2;
//    private List<Video> videoList;
//    private VideoAdapter videoAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.posts_recycler);
        ArrayList<Post> arrayListPost = new ArrayList<>();
        arrayListPost.add(new Post(1,1,1,1,1,"Android Dev","https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7,https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7",
                "Tejash","20th August","3:52"));

        arrayListPost.add(new Post(1,1,1,1,1,"Android Dev","https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost2.png?alt=media&token=75429583-e55e-4a40-aba3-7cc85f875491",
                "Ayush","21th August","3:53"));

        arrayListPost.add(new Post(1,1,1,1,1,"Android Dev","https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7,https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7",
                "Soumen","22th August","3:54"));

        arrayListPost.add(new Post(1,1,1,1,1,"Android Dev","https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost2.png?alt=media&token=75429583-e55e-4a40-aba3-7cc85f875491",
                "Kritish","23rd August","3:55"));


        PostAdapter postAdapter = new PostAdapter(context,arrayListPost);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
//        ImageView imageView = view.findViewById(R.id.imageView);
//        Glide.with(view)
//                .load("https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7,https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7 ")
//                .into(imageView);

//        Glide.with(this)
//                .asBitmap()
//                .load("https://firebasestorage.googleapis.com/v0/b/mukt---drug-free-india.appspot.com/o/images%2Fpost1.jpg?alt=media&token=862e04fc-0d08-4047-ac4e-4d53cb09dad7")
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(@NonNull Bitmap resource, Transition<? super Bitmap> transition) {
//                        imageView.setImageBitmap(resource);
////                        imageview2.setImageBitmap(resource);
//                    }
//                });
//        StorageReference = FirebaseStorage.getInstance().getReference().child("images/post1.jpg");
//
//        try {
//           final File localFile = File.createTempFile("post1","jpg");
//           StorageReference.getFile(localFile)
//           .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//               @Override
//               public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
//                   Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                   (ImageView)view.findViewById(R.id.imageView).setImageBitmap(bitmap);
//               }
//           }).addOnFailureListener(new OnFailureListener() {
//               @Override
//               public void onFailure(@NonNull Exception e) {
//
//               }
//           });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        return  view;
    }
}