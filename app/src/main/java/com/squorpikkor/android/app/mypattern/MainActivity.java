package com.squorpikkor.android.app.mypattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squorpikkor.android.app.mypattern.SaveMe.Controller;

public class MainActivity extends AppCompatActivity {

    //    ListWS listWS;
    Controller controller;
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Controller(this);
        editText = (EditText)findViewById(R.id.edit1);
        button = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.text1);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        controller.createObj(editText.getText().toString());
                        break;
                    case R.id.button2:
                        controller.loadObjList();
                        String s = controller.getObjVarArray(editText.getText().toString()).get(0);
                        textView.setText(s);
                }
            }
        };

        button.setOnClickListener(listener);

    }
}
