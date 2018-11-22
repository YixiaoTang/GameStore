package yixiao.gamestore.common;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewModelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<BaseViewModel> viewModels;
    private final SparseArrayCompat<BaseViewModel> viewTypeMap;

    public ViewModelAdapter() {
        viewModels = new ArrayList<>();
        viewTypeMap = new SparseArrayCompat<>();
    }

    public void addViewModels(Collection<? extends BaseViewModel> viewModels) {
        this.viewModels.clear();
        this.viewTypeMap.clear();
        addAll(viewModels);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewTypeMap.get(viewType).createViewHolder(parent);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewModels.get(position).bindViewHolder(holder);
    }


    @Override
    public int getItemCount() {
        return viewModels.size();
    }


    @Override
    public int getItemViewType(int position) {
        return viewModels.get(position).getViewType();
    }


    private void addAll(Collection<? extends BaseViewModel> viewModels) {
        if (viewModels == null) {
            return;
        }
        for (BaseViewModel baseViewModel : viewModels) {
            this.viewModels.add(baseViewModel);
            viewTypeMap.put(baseViewModel.getViewType(), baseViewModel);
        }
    }

    public boolean isEmpty() {
        return viewModels.isEmpty();
    }
}


