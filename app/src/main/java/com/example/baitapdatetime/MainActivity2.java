package com.example.baitapdatetime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        List<String> list = new ArrayList<>();
        btn = findViewById(R.id.btnAdd);
        list2 = findViewById(R.id.lista);
        editText = findViewById(R.id.textName);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                list.add(name);
                ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, android.R.layout.simple_expandable_list_item_1,list);
                list2.setAdapter(adapter);
            }
        });
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.GREEN);
                index = i;
            }

        });
       list2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               adapterView.setBackgroundColor(Color.WHITE);
               index  = -1;
               return true;
           }
       });
    }
    private ListView list2;
    private Button btn;
    public int index;
    private EditText editText;
}