package com.example.jayb.ppl_shopping_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class tr extends AppCompatActivity {
    //Intent mIntent = getIntent();
    //nt pos = mIntent.getIntExtra("position :", 0);
    private static final String TAG = "MainActivity";
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;
    private Switch switch11;
    public void AddData(String newEntry, int pos) {
        boolean insertData;
        insertData = mDatabaseHelper.addData(newEntry, pos);
        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr);
        Bundle extras = getIntent().getExtras();
            final int temp = extras.getInt("id");
            Toast.makeText(getApplicationContext(), "Position :" + String.valueOf(temp), Toast.LENGTH_LONG).show();

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry, temp);
                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //int itemPosition = position;


                Intent myointent = new Intent(tr.this, ListDataActivity.class);
                myointent.putExtra("id", temp);
                //startActivity(myintent);
                //Intent intent = new Intent(tr.this, ListDataActivity.class);
                startActivity(myointent);
            }
        });


    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =  new Intent(tr.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}

