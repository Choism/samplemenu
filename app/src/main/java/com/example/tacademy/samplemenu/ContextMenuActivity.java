package com.example.tacademy.samplemenu;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ContextMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        registerForContextMenu(findViewById(R.id.text_menu));
        registerForContextMenu(findViewById(R.id.image_menu));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.text_menu) {
            getMenuInflater().inflate(R.menu.view_text_menu, menu);
        } else if (v.getId() == R.id.image_menu) {
            getMenuInflater().inflate(R.menu.view_image_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ctx_1 :
            case R.id.menu_ctx_2 :
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}