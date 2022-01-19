package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.User;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccination_info;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccine;

public interface API_Service {

    @GET("user")
    Call<List<User>> getUser();

    @GET("vaccination_info")
    Call<List<Vaccination_info>> getVaccination_info();

    @GET("vaccine")
    Call<List<Vaccine>> getVaccine();

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @PUT("user/{user_id}")
        //on below line we are creating a method to post our data.
    Call<User> modifyUser(@Path("user_id") String user_id,
                          @Body User user);

}
