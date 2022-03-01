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
    private String logo = "";
    private final String startUrl = "https://img.shields.io/badge/";
    private final String spaceReplaceText = "%20";
    private final String colorReplaceText = "%23";
    private boolean isStyle = true;
    private boolean isLogo = false;

    private void init(Context c){
        TypedArray values = c.getTheme().obtainStyledAttributes(
                null,
                R.styleable.Badge,
                0, 0 );
        String badgeLabel;
        String badgeMessage;
        String badgeColor = "blue";
        try {
            badgeLabel = values.getString(R.styleable.Badge_badgeLabel) != null ? values.getString(R.styleable.Badge_badgeLabel).replaceAll(" ",spaceReplaceText) : "Label";
            badgeMessage = values.getString(R.styleable.Badge_badgeMessage) != null ? values.getString(R.styleable.Badge_badgeMessage).replaceAll(" ",spaceReplaceText) : "Message";
        } finally {
            values.recycle();
        }
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + badgeLabel.replaceAll(" ", spaceReplaceText) + "-" + badgeMessage.replaceAll(" ", spaceReplaceText) + "-" + badgeColor.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&" + logo : "")), this);
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
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&" + logo : "")), this);
    }

    public void setMessage(String message) {
        this.message = message;
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&" + logo : "")), this);
    }

    public void setColor(String color) {
        this.color = color;
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&" + logo : "")), this);
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
        isStyle = true;
        if (type != null || !type.trim().equals( "" )) {
            isStyle = false;
            return;
        }
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&" + logo : "")), this);
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
        isLogo = true;
        if (logo != null || !logo.trim().equals( "" )) {
            isLogo = false;
            return;
        }
        GlideToVectorYou
                .init()
                .with(this.getContext())
                .load(Uri.parse(startUrl + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&" + logo : "")), this);
    }
}
