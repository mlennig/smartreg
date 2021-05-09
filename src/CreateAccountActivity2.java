package teamawesome.smartreg;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*

 */

public class CreateAccountActivity2 extends AppCompatActivity {

    EditText editTextCountry = null;
    EditText editTextStateProvince = null;
    EditText editTextNumFloors = null;
    Button buttonBack = null;
    Button buttonSubmit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account2);
        //TEST JULIEN/
/*
        Database test = new Database();
        test.push_user_info("username with spaces", "password", "first_name", "last_name", "email", "country", "state_province", "city", "postal_code", "number_of_floors");

        //END TEST JULIEN
        //Set title displayed at the top of the activity page
        */
        this.setTitle("Create an Account");

        /* Instantiate Layout elements */
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextStateProvince = findViewById(R.id.editTextStateProvince);
        editTextNumFloors = findViewById(R.id.editTextNumFloors);
        buttonBack = findViewById(R.id.buttonBack);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        //Define what happens when the back button is pressed
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Go to CreateAccountActivity1
                Intent i = new Intent(view.getContext(), CreateAccountActivity1.class);
                startActivity(i);
            }
        });

        //Define what happens when the submit button is pressed
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: Check invalid inputs & matching Password fields
                //TODO: If user input is successful, Register info from this page and the last page into a user account and give it an ID on the Database.
                //Inputs from the last activity should be accessible through an "extras" package sent with the intent.
                //TODO: Login after submission
                //TODO: UI: Toast notifications for invalid field inputs (perhaps a marker to the invalid field also).


                //Go to RoomListActivity
                Intent i = new Intent(v.getContext(), RoomListActivity.class);
                startActivity(i);
            }
        });

    }

}
