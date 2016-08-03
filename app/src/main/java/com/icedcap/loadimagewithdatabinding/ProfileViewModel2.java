package com.icedcap.loadimagewithdatabinding;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Author: doushuqi
 * Date: 16-8-2
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class ProfileViewModel2 {
    // The URL will usually come from a model (i.e Profile)
    static final String IMAGE_URL = "http://icedcap.github.io/images/default_avatar.jpg";
    public ObservableField<Drawable> profileImage;
    private BindableFieldTarget bindableFieldTarget;

    public ProfileViewModel2(Context context) {
        profileImage = new ObservableField<>();
        bindableFieldTarget = new BindableFieldTarget(context, profileImage);
        Picasso.with(context).load(IMAGE_URL)
                .placeholder(R.mipmap.ic_launcher)
                .into(bindableFieldTarget);
    }

    public class BindableFieldTarget implements Target {
        private Context mContext;
        private ObservableField<Drawable> mDrawableObservableField;

        public BindableFieldTarget(Context context, ObservableField<Drawable> drawableObservableField) {
            mContext = context;
            mDrawableObservableField = drawableObservableField;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            mDrawableObservableField.set(new BitmapDrawable(mContext.getResources(), bitmap));
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            mDrawableObservableField.set(ContextCompat.getDrawable(mContext, R.drawable.error
            ));
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            mDrawableObservableField.set(placeHolderDrawable);
        }
    }
}
