package shimuli.cedric.retroget.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shimuli.cedric.retroget.Class.Apiclient;
import shimuli.cedric.retroget.Model.Users;
import shimuli.cedric.retroget.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getData();
    }

    private void getData() {
        Call<List<Users>> userList = Apiclient.getApiService().getUsers();
        userList.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (response.isSuccessful()){
                    Log.e("Success", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.e("Success", t.getLocalizedMessage());
            }
        });
    }
}