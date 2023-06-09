package am.itspace.car_rental.retrofit;

import am.itspace.car_rental.dto.AuthenticationRequest;
import am.itspace.car_rental.dto.AuthenticationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("/user/auth")
    Call<AuthenticationResponse> authenticateUser(@Body AuthenticationRequest authenticationRequest);
}
