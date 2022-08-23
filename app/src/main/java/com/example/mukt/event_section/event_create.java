package com.example.mukt.event_section;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mukt.MainActivity;
import com.example.mukt.R;
import com.example.mukt.event_section.model_class.event_info;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class event_create extends AppCompatActivity {

    RelativeLayout img;
    EditText event_name, event_date, event_day, event_time, documentation, lat, lon, venue, venue_address, org_name, event_type;
    String img_url, name, date, day, time, doc, lati, longi, ven, add, org, type;


    TextView add_btn;
    Uri filepath;
    Bitmap bitmap;
    ImageView add_img;
    ImageView cover_pic;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onBackPressed();
            return true;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        //this is only needed if you have specific things
        //that you want to do when the user presses the back button.

        /* your specific things...*/

        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.putExtra("direction", "event");
        startActivity(i);

        super.onBackPressed();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==101 && resultCode==RESULT_OK)
        {
            filepath = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(filepath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                img.setVisibility(View.GONE);
                cover_pic.setVisibility(View.VISIBLE);
                cover_pic.setImageBitmap(bitmap);

            }
            catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);

        cover_pic = (ImageView) findViewById(R.id.cover_pic) ;
        img = (RelativeLayout) findViewById(R.id.img_parent);
        event_name = (EditText) findViewById(R.id.name_txt);
        event_day = (EditText) findViewById(R.id.day_txt);
        event_date = (EditText) findViewById(R.id.date_txt);
        event_time = (EditText) findViewById(R.id.time_txt);
        documentation = (EditText) findViewById(R.id.documentation_txt);
        lat = (EditText) findViewById(R.id.latitude_txt);
        lon = (EditText) findViewById(R.id.longitude_txt);
        venue = (EditText) findViewById(R.id.venue_txt);
        venue_address = (EditText) findViewById(R.id.address_txt);
        org_name = (EditText) findViewById(R.id.ogr_name_txt);
        event_type = (EditText) findViewById(R.id.type_txt);


        add_btn = (TextView) findViewById(R.id.add_btn);

        add_img = (ImageView) findViewById(R.id.addimg_btn);

        add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(event_create.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Choose event coverpage"), 101);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog pg = new ProgressDialog(event_create.this);
                pg.setTitle("Event Uploading");
                pg.show();

                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference uploader = storage.getReference().child("users/" + filepath + ".jpg");
                uploader.putFile(filepath)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                pg.dismiss();
                                Toast.makeText(getApplicationContext(), "Event Added Sucessfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                                float percent = (100*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                                pg.setMessage("Uploaded : " + (int)percent + "%");

                            }
                        });


                img_url = filepath.toString();
                name = event_name.getText().toString();
                date = event_date.getText().toString();
                day = event_day.getText().toString();
                time = event_time.getText().toString();
                doc = documentation.getText().toString();
                lati = lat.getText().toString();
                longi = lon.getText().toString();
                ven = venue.getText().toString();
                add = venue_address.getText().toString();
                org = org_name.getText().toString();
                type = event_type.getText().toString();

                event_info model = new event_info(type,org,name,date,day,doc,time,add,ven,img_url,lati,longi);

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference().child("Main").child("Events").child("Ghaziabad");
                node.child(name).setValue(model);








            }
        });


    }
}