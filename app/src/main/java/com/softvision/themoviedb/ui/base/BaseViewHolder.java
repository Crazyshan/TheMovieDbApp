package com.softvision.themoviedb.ui.base;

import android.support.v7.widget.*;
import android.view.*;


public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    protected abstract void onBind(int position);
}
