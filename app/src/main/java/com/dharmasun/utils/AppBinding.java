package com.dharmasun.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.text.TextUtils.isEmpty;

/**
 * Created by brain on 11/6/17.
 */

public class AppBinding {

    @BindingAdapter("textFromHtml")
    public static void setFromHtml(TextView textView, String text) {
        if (!isEmpty(text)) {
            textView.setText(Html.fromHtml(text));

        }
    }
/*

    @BindingAdapter({"productDetailImages", "indicator"})
    public static void setImagePages(ViewPager viewPager, String[] images, CirclePageIndicator pageIndicator) {
        if (images == null) images = new String[0];
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(viewPager.getContext(), images);
        imagePagerAdapter.setSupportImageZoom(true);
        viewPager.setAdapter(imagePagerAdapter);
        if (pageIndicator != null) {
            pageIndicator.setViewPager(viewPager);
            pageIndicator.notifyDataSetChanged();
        }
    }
*/


    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (!isEmpty(url))
            Glide.with(imageView.getContext()).load(url).into(imageView);
    }

//    @BindingAdapter({"imageUrl", "placeholder"})
//    public static void setImageUrl(ImageView imageView, String url, Drawable placeholder) {
//        if (!isEmpty(url))
//            Glide.with(imageView.getContext()).load(url)
//                    .placeholder(placeholder).into(imageView);
//        else
//            imageView.setImageDrawable(placeholder);
//    }


//    @BindingAdapter({"imageUrl", "placeholder"})
//    public static void setImageUrl(ImageView imageView, String url, @DrawableRes int placeholder) {
//        if (!isEmpty(url)) {
//            DrawableTypeRequest creator = Glide.with(imageView.getContext()).load(url);
//            if (placeholder > 0)
//                creator.placeholder(placeholder).error(placeholder);
//            creator.into(imageView);
//        } else
//            imageView.setImageResource(placeholder);
//    }

    @BindingAdapter("visible")
    public static void setVisibility(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("spinnerStringAdapter")
    public static void setSpinnerStringAdapter(Spinner spinner, List<String> items) {
        if (items != null && !items.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(),
                    android.R.layout.simple_spinner_item, items);
            spinner.setAdapter(adapter);
        }
    }

    @BindingAdapter("selected")
    public static void setSelected(View view, boolean select) {
        view.setSelected(select);
    }

}
