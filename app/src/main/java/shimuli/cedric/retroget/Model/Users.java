package shimuli.cedric.retroget.Model;

import java.io.Serializable;

public class Users implements Serializable {
    public int id;
    public boolean is_active;
    public String username, first_name,last_name,email,date_joined;

    /*public Users(int id, boolean is_active, String username, String first_name, String last_name, String email, String date_joined) {
        this.id = id;
        this.is_active = is_active;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_joined = date_joined;
    }

     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", is_active=" + is_active +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", date_joined='" + date_joined + '\'' +
                '}';
    }
}
