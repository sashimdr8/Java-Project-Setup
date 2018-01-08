package com.dharmasun.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by brain on 2/23/17.
 */

public class TypeFaceProvider {
    private Context context;

    public TypeFaceProvider(Context context) {
        this.context = context;
    }

    public Typeface getFontIcon(){
        return Typeface.createFromAsset(context.getAssets(), "fonticons/sageflick.ttf");
    }
}
