package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Loads the xml file /res/layout/activity_second.xml
        setContentView(R.layout.activity_second);
    }
}