package shimuli.cedric.retroget.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import shimuli.cedric.retroget.Model.Users;
import shimuli.cedric.retroget.R;

public class ViewData extends AppCompatActivity {

    TextView Name, Email, DateJoined;
    Users users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        Name = findViewById(R.id.view_username);
        Email = findViewById(R.id.view_email);
        DateJoined = findViewById(R.id.view_joined);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            users = (Users) intent.getSerializableExtra("data");
            String username = users.getUsername();
            String user_email = users.getEmail();
            String user_joined = users.getDate_joined();

            Name.setText(username);
            Email.setText(user_email);
            DateJoined.setText(user_joined);
        }
    }
}