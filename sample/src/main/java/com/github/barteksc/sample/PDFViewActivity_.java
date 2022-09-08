package com.github.barteksc.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class PDFViewActivity_ extends PDFViewActivity implements HasViews, OnViewChangedListener {



    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate ================================================================");
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        OnViewChangedNotifier.registerOnViewChangedListener(this);          //added from init_() method
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setContentView(int layoutResID) {
        System.out.println(layoutResID + "================================================================");
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        System.out.println("internalFindViewById++++++++++++++++++++++++++++++++++++++++++++++++++");
        return ((T) this.findViewById(id));
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        System.out.println("onViewChanged++++++++++++++++++++++++++++++++++++++++++++++++++");
        this.pdfView = hasViews.internalFindViewById(R.id.pdfView);
        afterViews();                                                       //super class concrete method
    }














    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("onActivityResult++++++++++++++++++++++++++++++++++++++++++++++++++");
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case  42 :
            {
                PDFViewActivity_.this.onResult(resultCode, data);           // onResult() is a super class concrete method
                break;
            }
        }
    }
}
