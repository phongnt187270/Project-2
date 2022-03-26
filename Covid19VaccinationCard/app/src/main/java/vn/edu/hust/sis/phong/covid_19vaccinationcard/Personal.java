package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.User;

public class Personal extends AppCompatActivity {

    private EditText idEdt, phoneEdt, nameEdt, divisionEdt, roleEdt, dateEdt, monthEdt, yearEdt;

    private String dobEdt;

    Button saveButton;

    private TextView date_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        date_error = findViewById(R.id.date_error);

        // initializing our views
        nameEdt = findViewById(R.id.name_input);
        idEdt = findViewById(R.id.id_input);
        dateEdt = findViewById(R.id.date_spinner);


        monthEdt = findViewById(R.id.month_spinner);
        yearEdt = findViewById(R.id.year_spinner);
        divisionEdt = findViewById(R.id.division_input);
        roleEdt = findViewById(R.id.role_input);
        phoneEdt = findViewById(R.id.phone_input);
        saveButton = findViewById(R.id.save_button);

        dob_format();

        nameEdt.setHint(LoginForm.user_info.getName());
        idEdt.setHint(LoginForm.user_info.getUserId());
        divisionEdt.setHint(LoginForm.user_info.getDivision());
        roleEdt.setHint(LoginForm.user_info.getRole());


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameEdt.getText().toString().equals("") &
                        divisionEdt.getText().toString().equals("") &
                        dateEdt.getText().toString().equals("") &
                        monthEdt.getText().toString().equals("") &
                        yearEdt.getText().toString().equals("") &
                        roleEdt.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(), "Missing",
                            Toast.LENGTH_SHORT).show();
                } else {
                    updateUser();
                }


            }
        });
    }

    private void updateUser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/laravel_api/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();

        API_Service updateUser = retrofit.create(API_Service.class);

        dobEdt = yearEdt.getText().toString()  + "-" + monthEdt.getText().toString() + "-" + dateEdt.getText().toString();

        User user = new User(LoginForm.user_info.getUserId(), LoginForm.user_info.getPhonenumber(), LoginForm.user_info.getPassword(),
                nameEdt.getText().toString(), dobEdt, divisionEdt.getText().toString(), roleEdt.getText().toString());

        if (nameEdt.getText().toString().equals(""))
            user.setName(LoginForm.user_info.getName());

        if (divisionEdt.getText().toString().equals(""))
            user.setDivision(LoginForm.user_info.getDivision());

        if (roleEdt.getText().toString().equals(""))
            user.setRole(LoginForm.user_info.getRole());

        checkEditDate();



        Call<User> call = updateUser.modifyUser(LoginForm.user_info.getUserId(), user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                Toast.makeText(getApplicationContext(), "Saved",
                        Toast.LENGTH_SHORT).show();

                // on below line we are getting our data from modal class and adding it to our string.
                String responseString = "Response Code : " + response.code();

                Log.v("PUT ", responseString);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.e("ERROR: ", t.getMessage());

            }
        });

    }

    private void dob_format(){
        String str_dob = LoginForm.user_info.getDob();
        String[] str = str_dob.split("-");
        dateEdt.setHint(str[2]);
        monthEdt.setHint(str[1]);
        yearEdt.setHint(str[0]);
    }

    private void checkEditDate(){
        String str_dob = LoginForm.user_info.getDob();
        String[] str = str_dob.split("-");

        if (dateEdt.getText().toString().equals(""))
            dateEdt.setText(str[2]);

        if (monthEdt.getText().toString().equals(""))
            monthEdt.setText(str[1]);

        if (yearEdt.getText().toString().equals(""))
            yearEdt.setText(str[0]);
    }

}