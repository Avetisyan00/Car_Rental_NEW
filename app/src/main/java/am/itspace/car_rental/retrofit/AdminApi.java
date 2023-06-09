package am.itspace.car_rental.retrofit;

import java.util.List;

import am.itspace.car_rental.dto.UpdateUserDto;
import am.itspace.car_rental.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface AdminApi {

    @GET("/list/clients")
    Call<List<User>> listOfClients();

    @GET("/list/drivers")
    Call<List<User>> listOfDrivers();

    @GET("/list/dealers")
    Call<List<User>> listOfDealers();

    @DELETE("user/delete/{id}")
    Call<Void> deleteUserById(@Path("id") int id);

    @PATCH("user/change/{id}")
    Call<User> changeUserById(@Path("id") int id, @Body UpdateUserDto updateUserDto);


}
