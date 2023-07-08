package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // static void main(String args[])
    @Override // This is the starting point:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // do what the parent does

        // Loads the screen:
        setContentView(R.layout.activity_main);
    }
}