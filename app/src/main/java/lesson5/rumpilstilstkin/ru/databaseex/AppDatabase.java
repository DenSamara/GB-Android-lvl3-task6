package lesson5.rumpilstilstkin.ru.databaseex;


import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Users.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
