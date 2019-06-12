package lesson5.rumpilstilstkin.ru.databaseex;

public class SQLiteModel {
    private long id;
    private String login;
    private String avatar;

    public SQLiteModel(long id, String login, String avatar){
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }

    public long getUserId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLogin() {
        return login;
    }
}
