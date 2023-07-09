package algonquin.cst2335.ahmedsandroidlabs.ui;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import algonquin.cst2335.ahmedsandroidlabs.data.MainActivityViewModel;
import algonquin.cst2335.ahmedsandroidlabs.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    MainActivityViewModel model;
    // static void main(String args[])
    @Override // This is the starting point:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // The new way of variable binding, replaces findViewById
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView( variableBinding.getRoot() );

        TextView theText = variableBinding.theText;
        Button myButton = variableBinding.theButton;
        EditText myEdit = variableBinding.theEdit;
        CheckBox myCheckbox = variableBinding.theCheckbox;
        Switch mySwitch = variableBinding.theSwitch;

        myCheckbox.setOnCheckedChangeListener( (a, b) -> theText.setText("The checkbox is on?" + b));
        mySwitch.setOnCheckedChangeListener( (a, b) -> theText.setText("The switch is on?" + b));

        theText.setText( model.theText );
        myButton.setText( model.buttonText);

//        variableBinding.theCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
        //Listen for changes to MutableLiveData
//        model.isOn.observe(this, (newValue) -> {
//            // In here, isOn has changed and the new value us newValue
//            variableBinding.theCheckbox.setChecked(newValue);
//            variableBinding.theSwitch.setChecked(newValue);
//        });

        //Lamda Notation:
        variableBinding.theCheckbox.setOnCheckedChangeListener( (a, b) -> {
            model.isOn.postValue(b); // set to b, notify all observers
        });

        variableBinding.theSwitch.setOnCheckedChangeListener( (a, b) -> {
            model.isOn.postValue(b);
        });


        variableBinding.theText.setText(model.theText);
// This must be an onClickListener class
        variableBinding.theButton.setOnClickListener(( click ) -> {
                    model.theText = variableBinding.theEdit.getText().toString();
                    variableBinding.theText.setText(model.theText);
                }
        );

//        variableBinding.theButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String words = variableBinding.theEditText.getText().toString();
//                variableBinding.theText.setText(words);
//            }
//        });


        // Loads the screen:
//        setContentView(R.layout.activity_main);

//        //look for something with the id "theText", retunr the object
//        TextView theText = findViewById( R.id.theText );
//        EditText theEdit = findViewById(R.id.theEditText);
//
//        Button b = findViewById( R.id.theButton ); // will search the xml for something with id theButton
//        b.setOnClickListener(new View.OnClickListener() {
//            // Provide the missing function:
//            @Override
//            public void onClick(View v) {
//                // Reading the text from edit text and saving it to "words"
//                String words = theEdit.getText().toString(); // returns what's in the edit text
//
//                // Setting the text view text from "words"
//                theText.setText(words);
//            }
//        });
//

    }
}