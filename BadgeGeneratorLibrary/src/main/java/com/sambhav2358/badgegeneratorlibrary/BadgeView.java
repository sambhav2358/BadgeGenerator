package com.sambhav2358.badgegeneratorlibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.browser.customtabs.CustomTabsIntent;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Logger;


public class BadgeView extends AppCompatImageView {
    private String label = "Label";
    private String message = "Message";
    private String color = "blue";
    private String type = BadgeType.plastic;
    private String logo = "";
    private String link = "";
    private String logoWidth = "10";
    private String labelColor = "#555";
    private String logoColor = "";
    private final String startUrlNormal = "https://img.shields.io/badge/";
    private final String startUrlRaster = "https://raster.shields.io/badge/"; //for png files. This will be used because a badge with a logo cannot be a svg file.
    private final String spaceReplaceText = "%20";
    private final String colorReplaceText = "%23";
    private boolean isStyle = true;
    private boolean isLogo = false;
    private boolean isPNG = false;
    private boolean isLogoSize = false;
    private boolean isLogoColor = false;
    private String currentUrl = "";

    private void init(Context c, AttributeSet attributeSet){
        TypedArray values = c.getTheme().obtainStyledAttributes(
                attributeSet,
                R.styleable.Badge,
                0, 0 );
        String badgeLabel;
        String badgeMessage;
        String badgeColor = "blue";
        try {
            badgeLabel = values.getString(R.styleable.Badge_badgeLabel) != null ? values.getString(R.styleable.Badge_badgeLabel).replaceAll(" ",spaceReplaceText) : "Label";
            badgeMessage = values.getString(R.styleable.Badge_badgeMessage) != null ? values.getString(R.styleable.Badge_badgeMessage).replaceAll(" ",spaceReplaceText) : "Message";
            String redirectUrl = values.getString(R.styleable.Badge_redirectUrl) != null ? values.getString(R.styleable.Badge_redirectUrl) : null;
            String logo = values.getString(R.styleable.Badge_logoImage) != null ? values.getString(R.styleable.Badge_logoImage) : null;
            String customLogo = values.getString(R.styleable.Badge_logoBase64) != null ? values.getString(R.styleable.Badge_logoBase64) : null;
            String logoWidth = values.getString(R.styleable.Badge_logoWidth) != null ? values.getString(R.styleable.Badge_logoWidth) : null;
            setLink(redirectUrl);
            setLogo(logo);
            setCustomLogo(customLogo);
            setLogoWidth(logoWidth);
        } finally {
            values.recycle();
        }
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + badgeLabel.replaceAll(" ", spaceReplaceText) + "-" + badgeMessage.replaceAll(" ", spaceReplaceText) + "-" + badgeColor.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "");
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + badgeLabel.replaceAll(" ", spaceReplaceText) + "-" + badgeMessage.replaceAll(" ", spaceReplaceText) + "-" + badgeColor.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public BadgeView(Context c){
        super(c);
        init(c,null);
    }

    public BadgeView(Context c, AttributeSet attrs) {
        super(c,attrs);
        init(c,attrs);
    }

    private void showCurrentUrlLog(){
        Log.d("","******************************************");
        Log.d("",currentUrl);
        Log.d("","******************************************");
    }

    public void setLabel(String label){
        this.label = label;
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public void setMessage(String message) {
        this.message = message;
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public void setColor(String color) {
        this.color = color;
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
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
        if (type == null || type.trim().equals( "" )) {
            isStyle = false;
            return;
        }
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
        isLogo = true;
        isPNG = true;
        if (logo == null || logo.trim().equals( "" )) {
            isLogo = false;
            isPNG = false;
            return;
        }
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public void setCustomLogo(String customLogoBase64) {
        this.logo = customLogoBase64;
        isLogo = true;
        isPNG = false;
        if (customLogoBase64 == null || customLogoBase64.trim().equals( "" )) {
            isLogo = false;
            return;
        }
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=data:image/png;base64," + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=data:image/png;base64," + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
        Log.d("thisTheLink:" , currentUrl);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        if (link == null || link.trim().equals( "" )) {
            setOnClickListener(null);
            return;
        }
        if (!link.contains("https://") || !link.contains("http://")) this.link = "http://" + link;
        else this.link = link;
        setOnClickListener(v -> {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getContext(), Uri.parse(this.link));
        });
    }

    public void downloadBadgePNG(String location){
        DownloadManager downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(currentUrl);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setVisibleInDownloadsUi(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(location, uri.getLastPathSegment());
        downloadManager.enqueue(request);
    }

    public void downloadBadgeSVG(String location){
        DownloadManager downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(currentUrl.replaceAll(startUrlNormal,"https://img.shields.io/badge/"));
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setVisibleInDownloadsUi(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(location, uri.getLastPathSegment());
        downloadManager.enqueue(request);
    }

    public String getLogoWidth() {
        return logoWidth;
    }

    public void setLogoWidth(String logoWidth) {
        this.logoWidth = logoWidth;
        isLogoSize = true;
        if (logoWidth == null || logoWidth.trim().equals( "" )) {
            isLogoSize = false;
            return;
        }
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = (labelColor != null && !labelColor.trim().isEmpty() ? labelColor : "555");
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + this.labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor=" + this.labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + this.labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public String getBadgeColor() {
        return logoColor;
    }

    public void setLogoColor(String logoColor) {
        this.logoColor = logoColor;
        isLogoColor = true;
        if (logoColor == null || logoColor.trim().equals( "" )) {
            isLogoColor = false;
            return;
        }
        currentUrl = (!isPNG ? startUrlNormal : startUrlRaster) + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "");
        showCurrentUrlLog();
        GlideToVectorYou
                .init()
                .with(getContext())
                .load(Uri.parse(startUrlNormal + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoSize ? "&logoWidth=" + logoWidth : "") + (isLogoColor ? "&logoColor=" + logoColor : "")), this);
        if (!isPNG) return;
        Log.d("logoColor",isLogoColor + "");
        Picasso.get().load(startUrlRaster + label.replaceAll(" ", spaceReplaceText) + "-" + message.replaceAll(" ", spaceReplaceText) + "-" + color.replaceAll("#",colorReplaceText) + "?" + (isStyle ? type : BadgeType.plastic) + (isLogo ? "&logo=" + logo : "") + (isLogoSize ? "&logoWidth=" + logoWidth : "") + "&labelColor="  + labelColor.replaceAll("#",colorReplaceText) + (isLogoColor ? "&logoColor=" + logoColor : "")).into(this);
    }

    public void makeBadgeFromUrl(String url){
        GlideToVectorYou.justLoadImage((Activity) getContext(),Uri.parse(url),this);
    }
}
