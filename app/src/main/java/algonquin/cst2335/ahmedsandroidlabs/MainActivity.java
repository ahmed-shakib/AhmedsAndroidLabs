package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

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

        // Where can you save files?
        File myDir = getFilesDir();
        String path = myDir.getAbsolutePath();

        // Shared preferences
        // Instantiate an SharedPreferences object
        SharedPreferences savedPrefs = getSharedPreferences("MyFileName", Context.MODE_PRIVATE);
        // Initiate an editor
        SharedPreferences.Editor edit = savedPrefs.edit();

        // Setting the value of the saved email address as email text
        binding.email.setText(
                savedPrefs.getString("Name", "default")
        );



        binding.loginButton.setOnClickListener( (v) -> {
            Log.e(TAG, "You clicked the button");

            String whatIsTyped = binding.email.getText().toString();

            // Edit variables
            edit.putInt("Age", 26);
            edit.putString("Name", whatIsTyped);
            // Save to disk

            edit.commit();

            Intent nextPage = new Intent( this, SecondActivity.class);



            nextPage.putExtra("EMAIL", whatIsTyped);
            nextPage.putExtra("AGE", 25);
            nextPage.putExtra("DAY", "Tuesday");

            // Go to another page with all the extra value above
            startActivity(nextPage); // Carries all the data to the next page

            // Pre-defined intents: https://developer.android.com/guide/components/intents-common

            // A dialing intent - clicking the button invokes dialing
            //Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            //intent.setData(Uri.parse("tel: "+ "6137274723"));
            //startActivity(dialIntent); // Carries all the data to the next page

            // A web browse intent - clicking the button opens up the specified URL
            // Intent browseIntent = new Intent(Intent.ACTION_VIEW);
            // intent.setData(Uri.parse("https://www.algonquincollege.com"));
            //startActivity(browseIntent); // Carries all the data to the next page

            // An email intent
//            Intent emailIntent = new Intent(Intent.ACTION_SEND);
//            emailIntent.setType("*/*");
//            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"A@A.com", "B@B.com"});
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//            startActivity(emailIntent);

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