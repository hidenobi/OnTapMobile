package ptit.hide.mai_dmo1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Book book);
    @Update
    void  update(Book book);
    @Delete
    void delete(Book book);

    @Query("SELECT * from tblBook")
    List<Book> getListBook();

}
