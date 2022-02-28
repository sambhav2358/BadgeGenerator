package com.sambhav2358.badgegeneratorlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;


public class Badge extends AppCompatImageView {
    private String label = "Label";
    private String message = "Message";
    private String color = "blue";
    private final String startUrl = "https://img.shields.io/badge/";
    private final String spaceReplaceText = "%20";
    TypedArray a;

    public Badge(Context c, AttributeSet attrs) {
        super(c);
        a = c.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Badge,
                0, 0);
        String badgeLabel;
        String badgeMessage;
        try {
            badgeLabel = a.getString(R.styleable.Badge_badgeLabel) != null ? a.getString(R.styleable.Badge_badgeLabel).replaceAll(" ",spaceReplaceText) : "Label";
            badgeMessage = a.getString(R.styleable.Badge_badgeMessage) != null ? a.getString(R.styleable.Badge_badgeMessage).replaceAll(" ",spaceReplaceText) : "Message";
//            String badgeColor = a.getString(R.styleable.Badge_badgeColor) != null ? a.getString(R.styleable.Badge_badgeColor) : "#000";
        } finally {
            a.recycle();
        }
        GlideToVectorYou
                .init()
                .with(c)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                        Toast.makeText(c, "Load failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResourceReady() {
                        Toast.makeText(c, "Image ready", Toast.LENGTH_SHORT).show();
                    }
                })
                .load(Uri.parse(startUrl + badgeLabel.replaceAll(" ",spaceReplaceText) + "-" + badgeMessage.replaceAll(" ",spaceReplaceText) + "-" + color), this);
    }

    public void setLabel(String label){
        this.label = label;
//        Glide.with(this).load(startUrl + label.replaceAll(" ",spaceReplaceText) + "-" + message.replaceAll(" ",spaceReplaceText) + "-" + color).into(this);
    }

    public void setMessage(String message){
        this.message = message;
//        Glide.with(this).load(startUrl + label.replaceAll(" ",spaceReplaceText) + "-" + message.replaceAll(" ",spaceReplaceText) + "-" + color).into(this);
    }

    public void setColor(String color){
        this.color = color;
//        Glide.with(this).load(startUrl + label.replaceAll(" ",spaceReplaceText) + "-" + message.replaceAll(" ",spaceReplaceText) + "-" + color).into(this);
    }

    public String getLabel() {
        return label;
    }

    public String getMessage() {
        return message;
    }

    public String getColor() {
        return color;
    }
}
