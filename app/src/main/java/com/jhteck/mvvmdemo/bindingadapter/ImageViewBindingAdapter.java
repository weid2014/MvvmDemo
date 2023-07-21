package com.jhteck.mvvmdemo.bindingadapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.jhteck.mvvmdemo.R;

/**
 * @author wade
 * @Description:(用一句话描述)
 * @date 2023/7/21 11:16
 */
public class ImageViewBindingAdapter {
    @BindingAdapter(value = {"image","defaultImageResource"},requireAll = false)
    public  static  void  setImage(ImageView image, String imageUrl, int imageResource){
        if(!TextUtils.isEmpty(imageUrl)){
            Glide.with(image.getContext())
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image);
        }else{
            image.setImageResource(imageResource);
        }
    }
}


