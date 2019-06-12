package lesson5.rumpilstilstkin.ru.databaseex;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Users {
    @PrimaryKey
    @NonNull
    private String userId;
    private String login;
    private String avatarUrl;

    Users(String login, @NonNull String userId, String avatarUrl){
        this.login = login;
        this.userId = userId;
        this.avatarUrl = avatarUrl;
    }

    public String getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
