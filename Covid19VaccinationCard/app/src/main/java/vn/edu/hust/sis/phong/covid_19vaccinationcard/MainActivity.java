package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.User;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccination_info;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccine;

public class MainActivity extends AppCompatActivity {

    List<Vaccine> vaccineList;

    TextView dose_1_date;
    TextView manufacture_name_1;
    TextView dose_2_date;
    TextView manufacture_name_2;
    TextView patient_name;
    TextView patient_dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dose_1_date = findViewById(R.id.dose_1_date);
        manufacture_name_1 = findViewById(R.id.manufacture_name_1);
        dose_2_date = findViewById(R.id.dose_2_date);
        manufacture_name_2 = findViewById(R.id.manufacture_name_2);
        patient_name = findViewById(R.id.patient_name);
        patient_dob = findViewById(R.id.patient_dob);

        Bundle bundle = getIntent().getExtras();

        String dose_1_id = bundle.getString(HomeScreen.msg_dose_1_id);
        String dose_2_id = bundle.getString(HomeScreen.msg_dose_2_id);

        ListVaccineGetter listVaccineGetter = new ListVaccineGetter();
        listVaccineGetter.execute();


    }


    private class ListVaccineGetter extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Retrofit API_vaccine = new Retrofit.Builder().baseUrl("http://10.0.2.2/laravel_api/public/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_Service vaccineAPI = API_vaccine.create(API_Service.class);

            Call<List<Vaccine>> call_vaccine = vaccineAPI.getVaccine();

            try {
                vaccineList = call_vaccine.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void unused) {
//            for (Vaccination_info vaccination_info_get_dose : vaccinationInfoList){
//                if(message.equals(vaccination_info_get_dose.getVaccinationInfoId())){
//
//                    str_dose_1_id = vaccination_info_get_dose.getVaccinationInjection1();
//                    str_dose_2_id = vaccination_info_get_dose.getVaccinationInjection2();
//
//                }
//
//            }

            dose_1_date.setText(vaccineList.get(0).getInjectedDate());
            dose_2_date.setText(vaccineList.get(1).getInjectedDate());
            manufacture_name_1.setText(vaccineList.get(0).getManufacturer());
            manufacture_name_2.setText(vaccineList.get(1).getManufacturer());
            patient_name.setText(LoginForm.user_info.getName());
            patient_dob.setText(LoginForm.user_info.getDob());
        }
    }

}