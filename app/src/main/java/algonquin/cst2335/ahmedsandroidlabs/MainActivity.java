package algonquin.cst2335.ahmedsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // static void main(String args[])
    @Override // This is the starting point:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // do what the parent does

        // Loads the screen:
        setContentView(R.layout.activity_main);

        //look for something with the id "theText", retunr the object
        TextView theText = findViewById( R.id.theText );
        EditText theEdit = findViewById(R.id.theEditText);

        Button b = findViewById( R.id.theButton ); // will search the xml for something with id theButton
        b.setOnClickListener(new View.OnClickListener() {
            // Provide the missing function:
            @Override
            public void onClick(View v) {
                // Reading the text from edit text and saving it to "words"
                String words = theEdit.getText().toString(); // returns what's in the edit text

                // Setting the text view text from "words"
                theText.setText(words);
            }
        });


    }
}