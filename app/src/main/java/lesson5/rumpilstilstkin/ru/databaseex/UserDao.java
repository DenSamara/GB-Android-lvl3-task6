package lesson5.rumpilstilstkin.ru.databaseex;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<Users> getAll();

    @Query("DELETE FROM users")
    int deleteAll();

    @Insert
    void insert(Users employee);

    @Update
    void update(Users employee);

    @Delete
    void delete(Users employee);
}
