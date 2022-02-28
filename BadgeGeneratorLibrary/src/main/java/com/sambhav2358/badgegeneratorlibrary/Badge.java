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
    private String type = BadgeType.plastic;
    private final String startUrl = "https://img.shields.io/badge/";
    private final String spaceReplaceText = "%20";
    private final String colorReplaceText = "%23";
    TypedArray a;

    private void init(Context c){
        a = c.getTheme().obtainStyledAttributes(
                null,
                R.styleable.Badge,
                0, 0);
        String badgeLabel;
        String badgeMessage;
        String badgeColor = "blue";
        try {
            badgeLabel = a.getString(R.styleable.Badge_badgeLabel) != null ? a.getString(R.styleable.Badge_badgeLabel).replaceAll(" ",spaceReplaceText) : "Label";
            badgeMessage = a.getString(R.styleable.Badge_badgeMessage) != null ? a.getString(R.styleable.Badge_badgeMessage).replaceAll(" ",spaceReplaceText) : "Message";
        } finally {
            a.recycle();
        }
        GlideToVectorYou
                .init()
                .with(c)
                .load(Uri.parse(startUrl + badgeLabel.replaceAll(" ",spaceReplaceText) + "-" + badgeMessage.replaceAll(" ",spaceReplaceText) + "-" + badgeColor + type), this);
    }

    public Badge(Context c){
        super(c);
        init(c);
    }

    public Badge(Context c, AttributeSet attrs) {
        super(c,attrs);
        init(c);
    }

    public void setLabel(String label){
        this.label = label;
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ",spaceReplaceText) + "-" + message.replaceAll(" ",spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + type), this);
    }

    public void setMessage(String message) {
        this.message = message;
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + type), this);
    }

    public void setColor(String color) {
        this.color = color;
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + type), this);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + type), this);
    }
}
