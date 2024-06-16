package ptit.hide.mai_dmo1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblBook")
public class Book {
    @PrimaryKey(autoGenerate = true)
    int ma;
    String tenSach;
    String tenTG;

    public Book(String tenSach, String tenTG, PhamVi phamVi, boolean cntt, boolean vt, boolean dt, int danhGia) {
        this.tenSach = tenSach;
        this.tenTG = tenTG;
        this.phamVi = phamVi;
        this.cntt = cntt;
        this.vt = vt;
        this.dt = dt;
        this.danhGia = danhGia;
    }

    PhamVi phamVi;

    boolean cntt = false;
    boolean vt = false;
    boolean dt = false;
    int danhGia;

}
