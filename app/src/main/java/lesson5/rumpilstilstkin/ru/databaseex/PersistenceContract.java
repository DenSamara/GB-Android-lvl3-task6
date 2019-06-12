package lesson5.rumpilstilstkin.ru.databaseex;

public final class PersistenceContract {
    private PersistenceContract(){
    }

    public static abstract class UserEntity {
        public static final String TABLE_NAME = "user";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_AVATAR = "avatar";
    }
}
