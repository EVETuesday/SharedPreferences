package com.example.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    TextView name, email, phone, password;
    Button btnSave, btnLoad;
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);
        password=(TextView)findViewById(R.id.password);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }
    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString("name", name.getText().toString());
        ed.putString("email", email.getText().toString());
        ed.putString("phone", phone.getText().toString());
        ed.putString("password", password.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedTextname = sPref.getString("name", "");
        String savedTextemail = sPref.getString("email", "");
        String savedTextphone = sPref.getString("phone", "");
        String savedTextpassword = sPref.getString("password", "");
        name.setText(savedTextname);
        email.setText(savedTextemail);
        phone.setText(savedTextphone);
        password.setText(savedTextpassword);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}



