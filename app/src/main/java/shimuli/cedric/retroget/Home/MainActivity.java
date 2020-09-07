package shimuli.cedric.retroget.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shimuli.cedric.retroget.Class.Apiclient;
import shimuli.cedric.retroget.Model.Users;
import shimuli.cedric.retroget.R;
import shimuli.cedric.retroget.Recyclerview.UserRecyclerview;

public class MainActivity extends AppCompatActivity implements UserRecyclerview.ClickedItem {

    Toolbar toolbar;
    RecyclerView  recyclerView;
    UserRecyclerview userRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration( new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        userRecyclerview = new UserRecyclerview(this::ClickedUser);
        getData();
    }

    private void getData() {
        final Call<List<Users>> userList = Apiclient.getApiService().getUsers();
        userList.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (response.isSuccessful()){
                    List<Users>usersList = response.body();
                    userRecyclerview.setData(usersList);
                    recyclerView.setAdapter(userRecyclerview);
                    Log.e("Success", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.e("Success", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void ClickedUser(Users users) {
        startActivity(new Intent(this,ViewData.class).putExtra("data",users));
        Log.e("Clicked User", users.toString());
    }
}