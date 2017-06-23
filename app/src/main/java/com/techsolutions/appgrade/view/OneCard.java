package com.techsolutions.appgrade.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.techsolutions.appgrade.model.OtherUser;
import com.techsolutions.appgrade.R;

/**
 * Created by Udi on 6/12/2017.
 */

@Layout(R.layout.cardlayout)
public class OneCard {

    @View(R.id.profileImageView)
    private ImageView otherUserImageView;

    @View(R.id.nameAgeTxt)
    private TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    private TextView locationNameTxt;

    private OtherUser mProfile;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public OneCard(Context context, OtherUser profile, SwipePlaceHolderView swipeView) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        Glide.with(mContext).load("http://scontent-a.cdninstagram.com/hphotos-xaf1/t51.2885-15/10624158_694652173966291_65999198_n.jpg").into(otherUserImageView);
        nameAgeTxt.setText(mProfile.getName() + ", " + mProfile.getAge());
        locationNameTxt.setText("Israel");
    }

//    @SwipeOut
//    private void onSwipedOut(){
//        Log.d("EVENT", "onSwipedOut");
//        mSwipeView.addView(this);
//    }
//
//    @SwipeCancelState
//    private void onSwipeCancelState(){
//        Log.d("EVENT", "onSwipeCancelState");
//    }
//
//    @SwipeIn
//    private void onSwipeIn(){
//        Log.d("EVENT", "onSwipedIn");
//    }
//
//    @SwipeInState
//    private void onSwipeInState(){
//        Log.d("EVENT", "onSwipeInState");
//    }
//
//    @SwipeOutState
//    private void onSwipeOutState(){
//        Log.d("EVENT", "onSwipeOutState");
//    }

}
