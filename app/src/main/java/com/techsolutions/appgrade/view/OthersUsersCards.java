package com.techsolutions.appgrade.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.techsolutions.appgrade.model.OtherUser;
import com.techsolutions.appgrade.R;

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
