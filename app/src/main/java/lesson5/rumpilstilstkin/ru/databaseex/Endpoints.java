package lesson5.rumpilstilstkin.ru.databaseex;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Endpoints {

    @GET("users")
    Call<List<Model>> loadUsers(@Query("since") String id);
}
