package com.example.handlerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button save;
    private EditText enterName;
    private TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.btnSave);
        enterName=findViewById(R.id.edtName);
        name=findViewById(R.id.txtName);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                name.setText(enterName.getText().toString());
                intent.putExtra("name",enterName.getText().toString());
                startService(intent);
            }
        });
    }
}