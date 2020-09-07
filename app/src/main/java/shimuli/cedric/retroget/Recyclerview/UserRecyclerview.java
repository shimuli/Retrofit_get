package shimuli.cedric.retroget.Recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import shimuli.cedric.retroget.Model.Users;
import shimuli.cedric.retroget.R;

public class UserRecyclerview extends RecyclerView.Adapter<UserRecyclerview.UserViewHolder> {
    private List<Users> usersList;
    private Context context;
    private ClickedItem clickedItem;

    public UserRecyclerview(ClickedItem clickedItem){
        this.clickedItem = clickedItem;
    }
    public void setData(List<Users> usersList){
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       context = parent.getContext();
       return  new UserRecyclerview.UserViewHolder(LayoutInflater.from(context).inflate(R.layout.userlist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users users = usersList.get(position);
        String username = users.getUsername();
        String prefix;
        if (users.isIs_active()){
            prefix= "A";
        }
        else {
            prefix = "D";
        }
        holder.Prefix.setText(prefix);
        holder.userName.setText(username);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(users);
            }
        });
    }

    public interface ClickedItem{
        public void ClickedUser(Users users);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userName, Prefix;
        ImageView image;
        public  UserViewHolder(@Nullable View iemView){
            super(iemView);
            userName = iemView.findViewById(R.id.user_name);
            Prefix = iemView.findViewById(R.id.prefix);
            image = iemView.findViewById(R.id.more);
        }
    }
}
