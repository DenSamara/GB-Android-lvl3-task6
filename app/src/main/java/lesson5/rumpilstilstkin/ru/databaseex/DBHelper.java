package lesson5.rumpilstilstkin.ru.databaseex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "lesson6.db";
    private static final int DATABASE_VERSION = 1;

    /* package */ DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createSchema(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createSchema(SQLiteDatabase db) {
        // User table
        db.execSQL(String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL);",
                PersistenceContract.UserEntity.TABLE_NAME,
                PersistenceContract.UserEntity.COLUMN_ID,
                PersistenceContract.UserEntity.COLUMN_LOGIN,
                PersistenceContract.UserEntity.COLUMN_AVATAR
        ));
    }
}
