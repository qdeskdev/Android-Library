package com.qdesk.androidlibrary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.qdesk.myutils.Logger;
import com.qdesk.toasty.Toaster;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Simple toast
        Toaster.show(this, "Hello from Toaster library!");

        // Success toast (green background with checkmark)
        Toaster.success(this, "Operation successful!");

        // Error toast (red background with error icon)
        Toaster.error(this, "Something went wrong");

        // Warning toast (orange background with warning icon)
        Toaster.warning(this, "Please check your input");

        // Info toast (blue background with info icon)
        Toaster.info(this, "New update available");

        Logger.log("Hello from My Java Logger!");
    }
}