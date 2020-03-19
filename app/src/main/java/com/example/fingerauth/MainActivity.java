package com.example.fingerauth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.marcoscg.fingerauth.FingerAuth;
import com.marcoscg.fingerauth.FingerAuthDialog;

public class MainActivity extends AppCompatActivity {
    private FingerAuthDialog fingerAuthDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAndShowDialog();
    }

    private void createAndShowDialog() {
        fingerAuthDialog = new FingerAuthDialog(this)
                .setTitle("Sign in")
                .setCancelable(false)
                .setPositiveButton("Use password", null)
                .setNegativeButton("Cancel", null)
                .setOnFingerAuthListener(new FingerAuth.OnFingerAuthListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();
                    }
                });
        fingerAuthDialog.show();
    }
}
