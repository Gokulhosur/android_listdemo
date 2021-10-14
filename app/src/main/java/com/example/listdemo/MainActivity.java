package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> nameLists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void names(View v){
        Button submitButton = findViewById(R.id.submit);
        EditText names =findViewById(R.id.names);

        submitButton.setOnClickListener(view -> {
            if(TextUtils.isEmpty(names.getText().toString() )){
               return;
            }else{
                nameLists.add(names.getText().toString());
                Log.d("value", String.valueOf(nameLists));
                namelist();
                names.setText("");
            }
        });


    }
    public void namelist(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, nameLists);

        ListView listView = findViewById(R.id.nameslist);
        listView.setAdapter(adapter);
    }
}