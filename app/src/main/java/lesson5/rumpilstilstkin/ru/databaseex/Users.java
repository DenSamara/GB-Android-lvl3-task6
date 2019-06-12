package lesson5.rumpilstilstkin.ru.databaseex;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;


@Entity
public class Users {
    private String login;

    @PrimaryKey
    @NonNull
    private String userId;

    private String avatarUrl;

    Users(String login, @NonNull String userId, String avatarUrl){
        this.login = login;
        this.userId = userId;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getUserId() {
        return userId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
