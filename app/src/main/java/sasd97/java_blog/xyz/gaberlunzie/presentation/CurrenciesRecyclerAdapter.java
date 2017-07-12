package sasd97.java_blog.xyz.gaberlunzie.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sasd97.java_blog.xyz.gaberlunzie.R;
import sasd97.java_blog.xyz.gaberlunzie.data.models.CurrencyModel;

/**
 * Created by alexander on 13/07/2017.
 */

public class CurrenciesRecyclerAdapter extends RecyclerView.Adapter<CurrenciesRecyclerAdapter.CurrenciesRecyclerViewHolder> {

    private List<CurrencyModel> currenciesList = new ArrayList<>();

    public static class CurrenciesRecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_currency_avatar) public ImageView currencyAvatar;
        @BindView(R.id.row_currency_title) public TextView currencyTitle;

        public CurrenciesRecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void add(@NonNull CurrencyModel item) {
        currenciesList.add(item);
        notifyItemInserted(getItemCount());
    }

    public void addAll(@NonNull Collection<CurrencyModel> collection) {
        int lastSize = getItemCount();
        currenciesList.addAll(collection);
        notifyItemRangeInserted(lastSize, getItemCount());
    }

    @Override
    public CurrenciesRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.row_currency, parent, false);
        return new CurrenciesRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CurrenciesRecyclerViewHolder holder, int position) {
        CurrencyModel currency = currenciesList.get(position);
        holder.currencyTitle.setText(currency.getTitle());
    }

    @Override
    public int getItemCount() {
        return currenciesList.size();
    }

}
