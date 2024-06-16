package ptit.hide.mai_dmo1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Book.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
   abstract BookDao getBookDao();
   private static AppDatabase appDatabase;

   public static AppDatabase getAppDatabase(Context context) {
      if (appDatabase == null) {
         appDatabase = Room
                 .databaseBuilder(context, AppDatabase.class, "demeoooooo")
                 .allowMainThreadQueries()
                 .build();
      }
      return appDatabase;
   }
    
}
