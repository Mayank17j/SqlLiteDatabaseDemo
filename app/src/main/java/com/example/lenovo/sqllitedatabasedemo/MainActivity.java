package com.example.lenovo.sqllitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,collageName;
    MyCoreDatabase myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editTextName);
        collageName=(EditText)findViewById(R.id.editTextCollageName);

        myData=new MyCoreDatabase(this);
    }

    public void onClickSaveButton(View view) {
        Toast.makeText(this,"POINTER : SAVE ",Toast.LENGTH_SHORT).show();
        Log.i("BUTTON : ","SAVE");
        myData.insertData(name.getText().toString(),collageName.getText().toString());
    }

    public void onClickLoadButton(View view) {
        Toast.makeText(this,"POINTER : LOAD ",Toast.LENGTH_SHORT).show();
        Log.i("BUTTON : ","LOAD");
        myData.getAll();
    }

}
