package com.example.optionsmenudemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.badge.BadgeUtils;

public class SecondActivity extends Activity {
    ImageView imgView;
    Button btnMoveToPreviousActivity;
     int itemId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        initListeners();
        registerForContextMenu(imgView);
    }

    private void initViews(){
        imgView = findViewById(R.id.imgView);
        btnMoveToPreviousActivity = findViewById(R.id.btnMoveToPreviousActivity);
    }


    private void initListeners(){
        btnMoveToPreviousActivity.setOnClickListener(
                new BtnBackClickListener()
        );
    }

    class BtnBackClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.download_menu,menu);
        menu.setHeaderTitle("Context Menu For Image");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        itemId = item.getItemId();
        switch (itemId){
            case R.id.saveAs:
                Toast.makeText(this, "Save As", Toast.LENGTH_SHORT).show();
            break;
            case R.id.copy:
                Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
            break;
            case R.id.copyImageUrl:
                Toast.makeText(this,"Copy Image Url",Toast.LENGTH_LONG ).show();
                break;
            case R.id.search:
                Toast.makeText(this, "Serach",Toast.LENGTH_LONG).show();
            break;
            case R.id.download:
                Toast.makeText(this,"Download",Toast.LENGTH_LONG).show();
            break;
        }
        return super.onContextItemSelected(item);
    }
}
