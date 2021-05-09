package teamawesome.smartreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
  TODO: Intent to Summary Activity
  TODO: Add image or title for the login page
  TODO: Check login credentials (Sprint 2)
  TODO: Tidy Up onCreate
*/
public class LoginActivity extends AppCompatActivity {

    /* Layout element instantiation */
    EditText editTextEmail = null;
    EditText editTextPassword = null;
    Button buttonLogin = null;
    TextView textViewCreateAccount = null;
    TextView textViewForgotPassword = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Layout element instantiation */
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        final TextView textViewCreateAccount = findViewById(R.id.textViewCreateAccount);
        TextView textViewForgotPassword = findViewById(R.id.textViewForgotPassword);

        //Set an on click listener to Create an Account Text
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Highlight text on click
                textViewCreateAccount.setTextColor(getResources().getColor(R.color.colorAccent));
                //Switch to CreateAccountActivity1
                Intent i = new Intent(v.getContext(), CreateAccountActivity1.class);
                startActivity(i);
            }
        });

        //Set an on click listener to RoomListActivity
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: Check for invalid inputs in fields
                //TODO: Authenticate login information by comparing with database.
                //TODO: UI: Toast notifications for invalid field entries or invalid username/password combination.


                //Switch to RoomListActivity
                Intent i = new Intent(view.getContext(), RoomListActivity.class);
                startActivity(i);
            }
        });
    }
}
