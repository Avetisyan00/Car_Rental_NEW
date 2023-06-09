package am.itspace.car_rental.retrofit;

import java.util.List;

import am.itspace.car_rental.dto.RegistrationDto;
import am.itspace.car_rental.dto.UserDetailsDto;
import am.itspace.car_rental.model.User;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {
    @GET("users/verify")
    Call<Void> verifyUser(@Query("email") String email, @Query("token") String token);

    @GET("user/detail/getImage")
    Call<ResponseBody> getUserImage(@Query("fileName") String fileName);

    @GET("/user/details/{id}")
    Call<UserDetailsDto> getUserDetails(@Path("id") int id);

    @Multipart
    @POST("/user/upload/{id}")
    Call<User> addUserImage(@Part("pictures") List<MultipartBody.Part> files, @Path("id") int id);

    @POST("/registration/client")
    Call<User> clientRegistration(@Body RegistrationDto registrationDto);

    @POST("/registration/dealer")
    Call<User> dealerRegistration(@Body RegistrationDto registrationDto);

    @POST("/registration/driver")
    Call<User> driverRegistration(@Body RegistrationDto registrationDto);
}
