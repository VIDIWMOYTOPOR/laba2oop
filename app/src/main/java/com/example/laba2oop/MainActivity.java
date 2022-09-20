package com.example.laba2oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.internal.TextWatcherAdapter;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText el1;
    private EditText el2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        el1 = findViewById(R.id.Num1);
        el2 = findViewById(R.id.editTextNumber2);

        el1.addTextChangedListener(Result);
        el2.addTextChangedListener(Result);
        button = findViewById(R.id.button);
    }

    public void on_Button_Click(View view) {

        EditText el1 = (EditText) findViewById(R.id.Num1);
        EditText el2 = (EditText) findViewById(R.id.editTextNumber2);

        Spinner el3 = findViewById(R.id.spinner);
        Spinner el4 = findViewById(R.id.selection);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());

        int x = 0;
        String selected = el3.getSelectedItem().toString();
        if (selected.equals("Любой")) {
            x = 10;
        } else if (selected.equals("Новостройка")) {
            x = 100;
        } else if (selected.equals("Вторичное")) {
            x = 150;
        } else if (selected.equals("Строительство")) {
            x = 200;
        }

        int y = 0;
        String selected1 = el4.getSelectedItem().toString();
        if (selected1.equals("Любой")) {
            y = 10;
        } else if (selected1.equals("3Года")) {
            y = 100;
        } else if (selected1.equals("4Года")) {
            y = 150;
        } else if (selected1.equals("5Лет")) {
            y = 200;
        }

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();

        int z = 0;
        switch (checkedButtonIndex) {
            case R.id.radioButton:
                z = 20;
                break;
            case R.id.radioButton2:
                z = 40;
                break;
        }


        TextView resText = (TextView) findViewById(R.id.textView2);
        int resSum = num1 + x + y + num2 + z;

        resText.setText(String.format("Рассчёт кредита %d", resSum));
    }

//    private Button button;
//    private EditText el1;
//    private EditText el2;

    //el1.addTextChangedListener(Result);
    //el2.addTextChangedListener(Result);

    //    Button1 = findViewById(R.id.button);
    private final TextWatcher Result = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String elem1 = el1.getText().toString().trim();
            String elem2 = el2.getText().toString().trim();
            //int elem3 = Integer.parseInt(el2.getText().toString());
            //!(elem2.length() >=3)
            button.setEnabled(!elem1.isEmpty() && !elem2.isEmpty() && !(elem2.length() >=3));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}