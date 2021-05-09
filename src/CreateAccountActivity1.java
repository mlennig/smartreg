package teamawesome.smartreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity1 extends AppCompatActivity {

    /*
    TODO: Check invalid inputs & matching Password fields
    TODO: Save account info onto SQL server (Sprint 2)
     */

    EditText editTextFirstName = null;
    EditText editTextLastName = null;
    EditText editTextEmail = null;
    EditText editTextPassword = null;
    EditText editTextConfirmPassword = null;
    Button buttonNext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Set title displayed at the top of the activity page
        this.setTitle("Create an Account");

        /* Layout element instantiation */
        EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        EditText editTextLastName = findViewById(R.id.editTextLastName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        Button buttonNext = findViewById(R.id.buttonNext);

        //Set on click listener for next button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: Check invalid inputs & matching Password fields.
                //TODO: If inputs are successful, Send inputs as extra information through the intent to the next page.

                //Go to CreateAccountActivity2
                Intent i = new Intent(view.getContext(), CreateAccountActivity2.class);
                startActivity(i);
            }
        });
    }
}
