package com.example.optionsmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int MENU_PHONE_SETTINGS = 2, MENU_BLUETOOTH_SETTINGS = 3, MENU_DISPLAY_SETTINGS = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mt("onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "onCreate Called", Toast.LENGTH_SHORT).show();
        SubMenu subMenu = menu.addSubMenu(1,1,1,"Settings");
                            subMenu.add(1,MENU_PHONE_SETTINGS,2,"Phone Settings");
                            subMenu.add(1,MENU_BLUETOOTH_SETTINGS,3,"Bluetooth Settings");
                            subMenu.add(1,MENU_DISPLAY_SETTINGS,4,"Display Settings");
        MenuItem aboutMenuItem = menu.add(2, 2,5,"About");
        MenuItem helpMenuItem = menu.add(3,3,6,"Help");
        MenuItem historyMenuItem = menu.add(4,4,7,"History");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "onOptions Called", Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case MENU_BLUETOOTH_SETTINGS:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

                Toast.makeText(this, "Bluetooth Settings", Toast.LENGTH_SHORT).show();
                break;
            case MENU_DISPLAY_SETTINGS:
                Toast.makeText(this, "Display Settings", Toast.LENGTH_SHORT).show();
                break;
            case MENU_PHONE_SETTINGS:
                Toast.makeText(this, "Phone Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this, "onPrepare Called", Toast.LENGTH_SHORT).show();
        //menu.findItem(MENU_BLUETOOTH_SETTINGS).setEnabled(false);
        MenuItem menuItem = menu.getItem(2);
        menuItem.getTitle();
        menuItem.getGroupId();
        menuItem.setVisible(true);
        menuItem.setEnabled(false);
        menuItem.getOrder();

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mt("onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mt("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mt("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mt("onDestroy");
    }

    private void mt(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}