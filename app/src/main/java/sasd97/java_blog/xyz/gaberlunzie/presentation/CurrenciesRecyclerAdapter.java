package sasd97.java_blog.xyz.gaberlunzie.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by alexander on 13/07/2017.
 */

public class CurrenciesRecyclerAdapter {

    public static class CurrenciesRecyclerViewHolder extends RecyclerView.ViewHolder {



        public CurrenciesRecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
