package lesson5.rumpilstilstkin.ru.databaseex;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public final class UserEntityMapper {
    private static final String TAG = UserEntityMapper.class.getSimpleName();

    private UserEntityMapper() {
    }

    public static long insert(SQLiteDatabase db, Model entity) throws SQLException {
        ContentValues values = new ContentValues(2);
        values.put(PersistenceContract.UserEntity.COLUMN_LOGIN, entity.getLogin());
        values.put(PersistenceContract.UserEntity.COLUMN_AVATAR, entity.getAvatar());

        return db.insertOrThrow(PersistenceContract.UserEntity.TABLE_NAME, null, values);
    }

    public static int clear(SQLiteDatabase db) throws SQLException {
        return db.delete(PersistenceContract.UserEntity.TABLE_NAME, null, null);
    }

    public static List<SQLiteModel> get(SQLiteDatabase db, String where, String[] args,
                                 String orderBy, String limit) throws SQLException {
        List<SQLiteModel> result = new ArrayList<>();

        Cursor cursor = db.query(PersistenceContract.UserEntity.TABLE_NAME, null, where, args,
                null, null, orderBy, limit);

        try {
            if (cursor.getCount() <= 0) return result;

            int idColumnIdx = cursor.getColumnIndex(PersistenceContract.UserEntity.COLUMN_ID);
            int loginColumnIdx = cursor.getColumnIndex(PersistenceContract.UserEntity.COLUMN_LOGIN);
            int avatarColumnIdx = cursor.getColumnIndex(PersistenceContract.UserEntity.COLUMN_AVATAR);

            while (cursor.moveToNext()) {
                SQLiteModel user = new SQLiteModel(
                        cursor.getLong(idColumnIdx),
                        cursor.getString(loginColumnIdx),
                        cursor.getString(avatarColumnIdx)
                );

                result.add(user);
            }
        } finally {
            cursor.close();
        }

        return result;
    }

    public static List<SQLiteModel> getAll(SQLiteDatabase db) throws SQLException{
        return get(db, null, null, null, null);
    }

    public static void saveAll(SQLiteDatabase db, List<Model> items){
        db.beginTransaction();
        for (Model item : items) {
            try {
                insert(db, item);
            }catch (SQLException e){
                Log.e(TAG, e.toString());
                continue;
            }
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}
