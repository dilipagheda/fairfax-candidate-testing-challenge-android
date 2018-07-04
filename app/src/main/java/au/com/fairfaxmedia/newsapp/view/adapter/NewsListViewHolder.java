package au.com.fairfaxmedia.newsapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import au.com.fairfaxmedia.newsapp.NewsListContract;
import au.com.fairfaxmedia.newsapp.R;
import au.com.fairfaxmedia.newsapp.model.Asset;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListViewHolder extends RecyclerView.ViewHolder implements NewsListContract.ViewHolder {

    @BindView(R.id.thumbnail)
    ImageView mThumbnail;

    @BindView(R.id.headline)
    TextView mHeadlineTextView;

    @BindView(R.id.theAbstract)
    TextView mAbstractTextView;

    @BindView(R.id.byLine)
    TextView mLineTextView;



    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

    public NewsListViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        if (onItemClickListener != null) {
            itemView.setOnClickListener(v -> onItemClickListener.onItemClicked(getAdapterPosition()));
        }
    }

    @Override
    public void bind(Asset asset) {
        if (asset.getRelatedImages() != null && !asset.getRelatedImages().isEmpty()) {
            Picasso.with(itemView.getContext()).load(asset.getRelatedImages().get(0).getUrl()).into(mThumbnail);
        }
        mHeadlineTextView.setText(asset.getHeadline());
        mAbstractTextView.setText(asset.getTheAbstract());
        mLineTextView.setText(asset.getByLine());

    }
}