package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import algonquin.cst2335.ahmedsandroidlabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    protected ActivityMainBinding binding;
    // static void main(String args[])
    @Override // This is the starting point:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // do what the parent does

        binding = ActivityMainBinding.inflate((getLayoutInflater()));

        Log.e(TAG, "In OnCreate()");
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener( (v) -> {
            Log.e(TAG, "You clicked the button");

            Intent nextPage = new Intent( this, SecondActivity.class);
            // Go to another page
            startActivity(nextPage);
        } );

    }

    @Override // garbage collected, app is gone
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In OnDestroy()");
    }

    @Override // Now visible, not listening for clicks
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "In OnStart()");
    }

    @Override // No longer visible on screen
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "In OnStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "In OnResume()");
    }

    @Override // Leaving the screen, no longer listening for input
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "In OnPause()");
    }
}