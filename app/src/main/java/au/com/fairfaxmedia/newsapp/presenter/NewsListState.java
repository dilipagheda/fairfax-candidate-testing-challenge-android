package au.com.fairfaxmedia.newsapp.presenter;

import android.os.Parcel;
import android.os.Parcelable;

import au.com.fairfaxmedia.newsapp.NewsListContract;

/**
 * A kind of Bundle class to save instance data with no Android reference.
 */
public class NewsListState implements NewsListContract.State, Parcelable {
    private int mCurrentPosition;

    public NewsListState(int currentPosition) {
        mCurrentPosition = currentPosition;
    }

    @Override
    public int getCurrentPosition() {
        return mCurrentPosition;
    }

    protected NewsListState(Parcel in) {
        mCurrentPosition = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCurrentPosition);
    }

    @SuppressWarnings("unused")
    public static final Creator<NewsListState> CREATOR = new Creator<NewsListState>() {
        @Override
        public NewsListState createFromParcel(Parcel in) {
            return new NewsListState(in);
        }

        @Override
        public NewsListState[] newArray(int size) {
            return new NewsListState[size];
        }
    };
}