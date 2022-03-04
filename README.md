# BadgeGenerator
Have you ever seen a badge like this while using other library -> <img src="https://img.shields.io/badge/Latest%20Version-2.1-blue"/>

**Do you want to add that to your own app?**

Well, to do this, just use this library.

[![API](https://img.shields.io/badge/API-20%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=20)
  <img src="https://img.shields.io/badge/Latest%20Version-2.1-blue"/>
  <img src="https://img.shields.io/badge/Library%20Size-9KB-blue">
  <a href="https://jitpack.io/#sambhav2358/BadgeGenerator"><img src="https://jitpack.io/v/sambhav2358/BadgeGenerator/month.svg"/></a>
  <img src="https://img.shields.io/github/commits-since/sambhav2358/BadgeGenerator/2.1"/>
  <img alt="GitHub issues" src="https://img.shields.io/github/issues/sambhav2358/BadgeGenerator?color=blue">
  <a href="https://github.com/sambhav2358/BadgeGenerator/network"><img alt="GitHub forks" src="https://img.shields.io/github/forks/sambhav2358/BadgeGenerator?label=Forks"></a>
  <a href="https://github.com/sambhav2358/BadgeGenerator/stargazers"><img alt="GitHub stars" src="https://img.shields.io/github/stars/sambhav2358/BadgeGenerator?label=Stars"></a>
  <img src="https://img.shields.io/badge/State-working-blue"/>
  <img src="https://img.shields.io/badge/Code%20quality-A-blue"/>
  <img src="https://img.shields.io/badge/Built%20using-Android%20Studio-blue"/>
  <img src="https://img.shields.io/badge/Top%20language-Java-blue"/>  
  
  
## Sample

https://user-images.githubusercontent.com/97180951/156024192-b4e1bdb5-2241-4908-9940-9352781db01d.mp4

**Note:** This is not updated to the features supported in the latest version.

## Tutorial


[This is the youtube tutorial](https://youtu.be/AdBj-rSsBog)


**Note:** This is not updated to the features supported in the latest version.

## Recent updates
* Now you can make the following type of badges with this library.

<img width="237" alt="image" src="https://user-images.githubusercontent.com/97180951/156022374-ae4c3834-c750-4930-aa14-2ed24aab1131.png">
 
* Download the badge as PNG or SVG.
* Add a logo to your badge
![image](https://user-images.githubusercontent.com/97180951/156128379-bf486305-afb1-4bd1-9e30-13ccc427ce02.png)

All the logos will be suppoted only from [this](https://simpleicons.org/) and [this](https://github.com/simple-icons/simple-icons/blob/develop/slugs.md) website
* Add a redirect link on the click
* Change the color of the label of the background of the left part.
* Add a custom logo from Base64.
  
## Implementation

It is very easy to add it to your project. Just add this to your `settings.gradle` file:
```
maven {url 'https://jitpack.io'}
```

Then add it to your root level `build.gradle` file:
```
implementation 'com.github.sambhav2358:BadgeGenerator:Latest-Version'
```

And if you dont feel this convenient, you can download the `.aar` file from [here](https://jitpack.io/com/github/sambhav2358/BadgeGenerator/2.1/BadgeGenerator-2.1.aar) and then add it to your app.

## How to use?

1. XML
```
<com.sambhav2358.badgegeneratorlibrary.BadgeView
        android:id="@+id/badge"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:badgeMessage="This is a sample message"
        app:badgeLabel="This is a sample label"
        android:layout_weight="1"/>
```

NOTE: This libraray does not support to change the badge color from xml.

---

2. Java 
```
binding.badge.setColor(binding.colorED.getText().toString());
binding.badge.setMessage(binding.messageED.getText().toString());
binding.badge.setLabel(binding.labelED.getText().toString());
binding.badge.setType(BadgeType.social);
```

If you want to get the input of `BadgeType` from edittext or something for the type, you can do like this
```
binding.badge.setType(BadgeType.startText + ed.getText().toString());
```
---

You can now also add redirect links. In this, you provide the link, and then it will open the browser and you can view the webpage. You can provide a url like this.
```
binding.badge.setLink("https://stackoverflow.com");
```
**Note:** Do not add OnClickListener when you are adding a redirect link. This will override the redirect task.

---

You can now change the color of the of the right side part of the message part like this
```
binding.badge.setLabelColor("#abcdef");
// You can also use the predefined ones like this
binding.badge.setLabelColor(BadgeColor.blue);
```
---

You can also add a logo now(Added on 2 March 2022)
```
binding.badge.setLogo("anta");
```
All the logos will be suppoted only from [this](https://simpleicons.org/) and [this](https://github.com/simple-icons/simple-icons/blob/develop/slugs.md) website

---

The logos provided in those links might not help you. So, you can also use a custom logo which is encoded as a `Base64` string.

It works something like this
```
binding.badge.setCustomLogo("your base64 string.");
```

Sometimes you might not have a image in `Base64`. This library does it for you. Just use the `Base64Converter` class. Something like this.
```
binding.badge.setCustomLogo(Base64Converter.getBase64FromBitmap(myBitmap));
```

You can convert the following types of files to base 64. More coming in the future.
* Uri
* Bitmap
* File
* FilePath


---

Also you can modify the tint of the logo like this
```
binding.badge.setLogoColor("aaa");
// You can also use the predefined ones like this
binding.badge.setLogoColor(BadgeColor.yellow);
```
---

Also you can change the width of the logo like this
```
binding.badge.setLogoWidth("40");
```
---

You can change the background color of the right side part or the message part Something like this
```
binding.badge.setColor(BadgeColor.blue);
```
---

You can also use custom colors for the badge like this
```
binding.badge.setColor("#FF6200EE");
```

The default colors present in the `BadgeColor` class are:-
1. brightGreen
2. green
3. yellowGreen
4. yellow
5. orange
6. red
7. lightGrey
8. blue
9. And a lot more. Refer to the [BadgeColor](https://github.com/sambhav2358/BadgeGenerator/blob/main/BadgeGeneratorLibrary/src/main/java/com/sambhav2358/badgegeneratorlibrary/BadgeColor.java) to see all the available colors.

## Downloading the badge

Also sometimes you might want to save the badge. You can save it the following types
* Png
* SVG
 
 Downloading SVG
 ```
 binding.badge.downloadBadgeSVG(Environment.DIRECTORY_PICTURES);
 ```
 
 Download PNG
 ```
 binding.badge.downloadBadgePNG(Environment.DIRECTORY_PICTURES);
 ```
 
 ## Badge from url.
 Now you dont want to add all these properties and use it, just provide the url and the library does the rest for you.
 
 **Note:** You should only provide a valid url. You can refer to [this](shields.io) website and try all the possible combination. Providing a wrong url will not load thw badge.
 
Eg:
```
binding.badge.makeBadgeFromUrl("https://img.shields.io/github/downloads/sambhav2358/BadgeGenerator/total");
```

To get the url, you need to follow these steps.
1. Open the shiels.io website.
2. Pick any of the category

<img width="269" alt="image" src="https://user-images.githubusercontent.com/97180951/156612502-ead3b2cf-11ff-4416-a61e-bd04d4fb7166.png">
3. Here i am taking Downlaod category.

<img width="1440" alt="image" src="https://user-images.githubusercontent.com/97180951/156612678-a7879158-7edb-4ea0-b94c-bbab1f48bb57.png">

4. Then i will pick any type. Here i choose `GitHub release (latest by date)` And provide the details.
 <img width="1262" alt="image" src="https://user-images.githubusercontent.com/97180951/156612886-48e3697c-f952-4ae8-9e90-5ff0157008e1.png">
5. Click on copy badge url.

<img width="170" alt="image" src="https://user-images.githubusercontent.com/97180951/156612992-bf5a2926-2dcf-4d28-b7f5-e2c12ca9b296.png">
6. Paste the url in the method.
<br/>
7. Done. Now the badge will be loaded

 
 
 ## Drawbacks
 #### When using an image, the badge quality decreases by too much.
 When we use a picture, it cannot be converted to svg. So, the the badge is made in png form. This decreases the image quality

## Coming in the future
I have no ideas of what to add next. Please suggest me by adding an issue.


## Thanks to
[Shields.io](https://shields.io)


[Picasso](https://github.com/square/picasso)


[GlideToVectorYou](https://github.com/corouteam/GlideToVectorYou)

## Feature request
For everyone who wants me to add a feature, just create an issue with the feature you want.

## License
Free to use and modify the code.

## Author
Build with ❤️ by [Sambhav Khandelwal](https://github.com/sambhav2358)
