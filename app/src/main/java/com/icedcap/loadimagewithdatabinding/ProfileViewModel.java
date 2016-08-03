package com.icedcap.loadimagewithdatabinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Author: doushuqi
 * Date: 16-8-2
 * Email: shuqi.dou@singuloid.com
 * LastUpdateTime:
 * LastUpdateBy:
 */
public class ProfileViewModel {
    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return "http://icedcap.github.io/images/default_avatar.jpg";
    }

    @BindingAdapter("binding:imageUrl")
    public static void loadImage(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }
}
