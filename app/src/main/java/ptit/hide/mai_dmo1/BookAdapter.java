package ptit.hide.mai_dmo1;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ptit.hide.mai_dmo1.databinding.ItemBookBinding;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private ArrayList<Book> list;
    private OnClickBook onClickBook;

    public BookAdapter(ArrayList<Book> list, OnClickBook onClickBook) {
        this.list = list;
        this.onClickBook = onClickBook;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBookBinding binding = ItemBookBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding,this.onClickBook);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = list.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<Book> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private OnClickBook onClickBook;
        private ItemBookBinding itemBookBinding;

        public ViewHolder(ItemBookBinding itemBookBinding, OnClickBook onClickBook) {
            super(itemBookBinding.getRoot());
            this.onClickBook = onClickBook;
            this.itemBookBinding = itemBookBinding;

        }

        void bind(Book book) {
            itemBookBinding.tenSach.setText(book.tenSach);
            itemBookBinding.tenTacGia.setText(book.tenTG);
            switch (book.phamVi) {
                case HOC:
                    itemBookBinding.hoc.setChecked(true);
                    itemBookBinding.traCuu.setChecked(false);
                case TRA_CUU:
                    itemBookBinding.traCuu.setChecked(true);
                    itemBookBinding.hoc.setChecked(false);

            }
            itemBookBinding.cntt.setChecked(book.cntt);
            itemBookBinding.vt.setChecked(book.vt);
            itemBookBinding.dt.setChecked(book.dt);

            itemBookBinding.rate.setRating(book.danhGia);

            itemBookBinding.update.setOnClickListener(view -> {
                onClickBook.update(book.ma);
            });
            itemBookBinding.delete.setOnClickListener(view -> {
                onClickBook.delete(book);
            });


        }
    }
}
