package com.example.tacademy.samplemenu;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){  //res/menu call back함수
        getMenuInflater().inflate(R.menu.activity_menu, menu); //menu 생성

        MenuItem item = menu.findItem(R.id.menu_item_1);
        SearchView view = (SearchView)MenuItemCompat.getActionView(item);
        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "query : " + query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("MainActivity", "text : " + newText);
                return false;
            }
        });

        return true;
    }
    @Override //메뉴 선택된 menuitem이 넘어와 getItemId()로 id 얻어와 어떤 메뉴가 선택됬는지 확인
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.menu_item_1 :
            case R.id.menu_item_2 :
            case R.id.submenu_item_1 :
            case R.id.submenu_item_2 :
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_check :
                item.setChecked(!item.isChecked()); //!item.ischecked 선택할 때마다 값이 변경
                return true;

            case R.id.menu_check1 :
            case R.id.menu_check2 :
            case R.id.menu_check3 :
                item.setChecked(true);
                return true;
    }
        return super.onOptionsItemSelected(item);
    }
}
