package g2e.navigatioindrawer.Adapter;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import g2e.navigatioindrawer.R;
import g2e.navigatioindrawer.utility.ObjectDrawerItem;


/**
 * Created by brpadhy on 2/5/2016.
 */
public class DrawerItemCustomAdapter extends BaseAdapter {
    ObjectAnimator textColorAnim,textColorAnim2 ;
    Context mContext;
    int mLayoutResourceId;
    ObjectDrawerItem mData[] = null;
    TextView nameTextView, notification, notification2;

    public DrawerItemCustomAdapter(Context context, int layoutResourceId, ObjectDrawerItem[] data) {
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mData = data;

    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;

        ObjectDrawerItem objectDrawerItem = mData[position];

        // First let's verify the convertView is not null
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            listItem = inflater.inflate(mLayoutResourceId, parent, false);
            // Now we can fill the layout with the right values
            ImageView iconImageView = (ImageView) listItem.findViewById(R.id.drawer_item_icon);
            nameTextView = (TextView) listItem.findViewById(R.id.drawer_item_name);
            notification = (TextView)listItem.findViewById(R.id.notificationid);
            notification2 = (TextView)listItem.findViewById(R.id.notificationid);

            iconImageView.setImageDrawable(listItem.getResources().getDrawable(objectDrawerItem.getIcon()));
            nameTextView.setText(objectDrawerItem.getName());
            //blink();
           if(position == 1) {
                notification.setText("Coming soon");

               blink();

            }else if(position == 2) {
               notification2.setText("Coming soon");

               blink2();

           }


        }


        return listItem;
    }
    private void blink() {
        if(textColorAnim != null) {
            textColorAnim.cancel();
            notification.setTextColor(Color.BLACK);
        }

        textColorAnim = ObjectAnimator.ofInt(notification, "textColor", Color.RED, Color.TRANSPARENT);
        textColorAnim.setDuration(800);
        textColorAnim.setEvaluator(new ArgbEvaluator());
        textColorAnim.setRepeatCount(ValueAnimator.INFINITE);
        textColorAnim.setRepeatMode(ValueAnimator.REVERSE);
        textColorAnim.start();


    }
    private void blink2() {
        if(textColorAnim2 != null) {
            textColorAnim2.cancel();
            notification.setTextColor(Color.BLACK);
        }

        textColorAnim2 = ObjectAnimator.ofInt(notification, "textColor", Color.RED, Color.TRANSPARENT);
        textColorAnim2.setDuration(850);
        textColorAnim2.setEvaluator(new ArgbEvaluator());
        textColorAnim2.setRepeatCount(ValueAnimator.INFINITE);
        textColorAnim2.setRepeatMode(ValueAnimator.REVERSE);
        textColorAnim2.start();


    }
}
