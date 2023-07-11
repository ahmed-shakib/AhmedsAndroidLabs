package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        Intent fromPrevious = getIntent(); // Return th eintent that got us here

        String EMAIL = fromPrevious.getStringExtra("EMAIL"); // String doesn't take default value
        int age = fromPrevious.getIntExtra("AGE", 0);
        String day = fromPrevious.getStringExtra("DAY");
        int something = fromPrevious.getIntExtra("SOMETHING",0);

        binding.textView.setText("You passed " + EMAIL + " and " + day + "and: " + age);

        binding.goBack.setOnClickListener( (v) ->{
            finish(); // go back to previous
        } );
    }
}