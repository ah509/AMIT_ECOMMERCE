package hossny.myhossny.amitproject.data.source.api;
import hossny.myhossny.amitproject.data.model.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface UserService {
    @POST("api/register")
    Call<UserResponse>userRegister(@Body Map<String ,String> user);
}
