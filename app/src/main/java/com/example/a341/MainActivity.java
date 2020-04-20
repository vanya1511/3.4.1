package com.example.a341;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncRequest().execute();
    }
    class AsyncRequest extends AsyncTask<Void,Void,Void>{
        ImageView imgView;
        InputStream stream;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://voip.mephi.ru/public/photos/9108_cps.jpg");
                stream = (InputStream) url.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmap = BitmapFactory.decodeStream(stream);
            return null;
        }

        @Override
        protected void onPreExecute() {
            imgView = findViewById(R.id.img);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            imgView.setImageBitmap(bitmap);
            super.onPostExecute(aVoid);
        }
    }
}



