package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import algonquin.cst2335.ahmedsandroidlabs.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    binding = ActivitySecondBinding.inflate(getLayoutInflater());
        // Loads the xml file /res/layout/activity_second.xml
        setContentView(binding.getRoot());

        binding.goBack.setOnClickListener( (v) ->{
            finish(); // go back to previous
        } );
    }
}