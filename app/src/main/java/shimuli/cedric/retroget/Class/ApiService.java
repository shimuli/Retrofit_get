package shimuli.cedric.retroget.Class;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import shimuli.cedric.retroget.Model.Users;

public interface ApiService {
    @GET("users/")
    Call<List<Users>>getUsers();
}
