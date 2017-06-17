package com.techsolutions.appgrade.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.techsolutions.appgrade.Model.OtherUser;
import com.techsolutions.appgrade.R;

import java.io.File;

/**
 * Created by Udi on 6/11/2017.
 */


public class OthersUsersCards extends Activity{

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherusercard_activity);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f).isAnimateScale(false));

        OtherUser user = new OtherUser("Udi.valer@gmail.com" , "Udi" , "0506963363" , 23 , "realm" , null);
        OneCard oneCard = new OneCard(mContext , user ,mSwipeView);
        mSwipeView.addView(oneCard);
    }

}
