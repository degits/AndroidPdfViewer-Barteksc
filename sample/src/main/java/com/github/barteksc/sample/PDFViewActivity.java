package com.github.barteksc.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class PDFViewActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setContentView(int layoutResID) {   //   R.layout.activity_main = int layoutResID


        //   Layer - 01
        super.setContentView(layoutResID);

        this.pdfView = findViewById(R.id.pdfView);


        //   Layer - 02
        pdfView.setBackgroundColor(Color.CYAN);//.LTGRAY);


        //   Layer - 03
        pdfView.fromAsset("sample.pdf")
                .defaultPage(10)
                //.onPageChange(this)
                .enableAnnotationRendering(true)
                //.onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                //.onPageError(this)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();
    }
}