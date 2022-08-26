package com.example.mukt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Ticket_generator extends AppCompatActivity {

    ImageView qr_code;
    TextView name,venue,times,address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_generator);

        qr_code = (ImageView) findViewById(R.id.qr_code);
        name = (TextView) findViewById(R.id.name);
        venue = (TextView) findViewById(R.id.venue);
        address = (TextView) findViewById(R.id.address);
        times = (TextView) findViewById(R.id.time);


        Intent i = this.getIntent();

        String event_name = i.getStringExtra("name");
        String date =  i.getStringExtra("date");
        String time = i.getStringExtra("time");
        String venues = i.getStringExtra("venue");
        String addresss = i.getStringExtra("address");
        String doc = i.getStringExtra("doc");

        name.setText(event_name);
        times.setText(time);
        address.setText(addresss);
        venue.setText(venues);




        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = writer.encode(event_name+","+date+","+time+","+venues+","+addresss+","+doc,BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qr_code.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }


    }
}