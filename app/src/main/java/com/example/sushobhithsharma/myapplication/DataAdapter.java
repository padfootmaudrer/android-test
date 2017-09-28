package com.example.sushobhithsharma.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sushobhith.sharma on 28/09/17.
 */

public class DataAdapter extends BaseAdapter {
    private Activity activity;
    private List<DataItem> dataItems;
    private LayoutInflater inflater;

    public DataAdapter(Activity activity, List<DataItem> dataItems) {
        this.activity = activity;
        this.dataItems = dataItems;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.data_item, null);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView title = (TextView) view.findViewById(R.id.card_title);
        TextView text = (TextView) view.findViewById(R.id.card_text);
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView timestamp = (TextView) view.findViewById(R.id.timestamp);
        ImageView cardImage = (ImageView) view.findViewById(R.id.card_image);



        DataItem item = dataItems.get(i);

        name.setText(item.getName());

        // Converting timestamp into x ago format
        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
                Long.parseLong(item.getTimeStamp()),
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
        timestamp.setText(timeAgo);

        // Chcek for empty status message
//        if (!TextUtils.isEmpty(item.getStatus())) {
//            statusMsg.setText(item.getStatus());
//            statusMsg.setVisibility(View.VISIBLE);
//        } else {
//            // status is empty, remove from view
//            statusMsg.setVisibility(View.GONE);
//        }

        // Checking for null feed url
//        if (item.getUrl() != null) {
//            url.setText(Html.fromHtml("<a href=\"" + item.getUrl() + "\">"
//                    + item.getUrl() + "</a> "));
//
//            // Making url clickable
//            url.setMovementMethod(LinkMovementMethod.getInstance());
//            url.setVisibility(View.VISIBLE);
//        } else {
//            // url is null, remove from the view
//            url.setVisibility(View.GONE);
//        }

        // user profile pic
//        profilePic.setImageUrl(item.getProfilePic(), imageLoader);
//
//        // Feed image
//        if (item.getImge() != null) {
//            feedImageView.setImageUrl(item.getImge(), imageLoader);
//            feedImageView.setVisibility(View.VISIBLE);
//            feedImageView
//                    .setResponseObserver(new FeedImageView.ResponseObserver() {
//                        @Override
//                        public void onError() {
//                        }
//
//                        @Override
//                        public void onSuccess() {
//                        }
//                    });
//        } else {
//            feedImageView.setVisibility(View.GONE);
//        }

        return view;
    }



    }
}
