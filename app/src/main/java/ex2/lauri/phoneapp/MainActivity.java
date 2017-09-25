package ex2.lauri.phoneapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttoncall);
        number = (EditText) findViewById(R.id.phonenumber);
        // add button listener
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String phoneNumber = number.getText().toString();
                String callData = new String("tel:") + phoneNumber;

                call(callData);
            }
        });
    }

    protected void call(String callData) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        //dial
        callIntent.setData(Uri.parse(callData));
        //Intent in = new Intent(Intent.ACTION_CALL,Uri.parse("0401415086"));
        try {
            startActivity(callIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
        }
    }
}