package com.algonquincollege.benn0039.loginExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById( R.id.btn_login );

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Reference and get value of username field
                EditText userName = (EditText) findViewById( R.id.email_input );
                String user = userName.getText().toString();

                // Reference and get value of password field
                EditText passWord = (EditText) findViewById( R.id.pass_input );
                String password = passWord.getText().toString();

                // Reference and get state of Remember me checkbox.
                CheckBox remember = (CheckBox) findViewById(R.id.checkBox);
                 Boolean checkboxState = remember.isChecked();

                // Validate that there is text in the username field
                if (user.isEmpty() || user == null) {

                    userName.setError(getString(R.string.err_login));
                    userName.requestFocus();
                    return;
                }
                else {

                    // Display toast message when login button clicked
                    Toast.makeText(getApplicationContext(), getString(R.string.tst_loginOnClick), Toast.LENGTH_SHORT).show();

                    /*
                 *  Trying to keep to best practices by using string resource.
                 *
                 *  Display username, password and checkbox status in toast message.
                 */
                    String tstString = getString(R.string.tst_user) + user +
                            '\n' + getString(R.string.tst_password) + password +
                            '\n' + getString(R.string.tst_chk_state) + checkboxState;

                    Toast.makeText(getApplicationContext(), tstString, Toast.LENGTH_SHORT).show();

                }


            }
        });

        // Reference and create listener for forgot password
        TextView forgotPassword = (TextView) findViewById(R.id.forgot_pw);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tstForgotString = getString(R.string.tst_forgotOnClick);
                Toast.makeText(getApplicationContext(),tstForgotString, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
