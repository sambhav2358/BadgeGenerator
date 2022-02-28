# BadgeGenerator
Have you ever seen a badge like this while using other library -> <img src="https://img.shields.io/badge/Latest%20Version-1.1-blue"/>

**Do you want to add that to your own app?**

Well, to do this, just use this library.

[![API](https://img.shields.io/badge/API-20%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=20)
  [![API](https://img.shields.io/github/v/release/sambhav2358/BadgeGenerator.svg)](https://img.shields.io/github/v/release/sambhav2358/BadgeGenerator.svg)
  <img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/sambhav2358/BadgeGenerator">
  <a href="https://jitpack.io/#sambhav2358/BadgeGenerator"><img src="https://jitpack.io/v/sambhav2358/BadgeGenerator/month.svg"/></a>
  <img src="https://img.shields.io/github/commits-since/sambhav2358/BadgeGenerator/1.2"/>
  <img alt="GitHub issues" src="https://img.shields.io/github/issues/sambhav2358/BadgeGenerator?color=blue">
  <a href="https://github.com/sambhav2358/BadgeGenerator/network"><img alt="GitHub forks" src="https://img.shields.io/github/forks/sambhav2358/BadgeGenerator?label=Forks"></a>
  <a href="https://github.com/sambhav2358/BadgeGenerator/stargazers"><img alt="GitHub stars" src="https://img.shields.io/github/stars/sambhav2358/BadgeGenerator?label=Stars"></a>
  <img src="https://img.shields.io/badge/State-working-blue"/>
  <img src="https://img.shields.io/badge/Code%20quality-A-blue"/>
  <img src="https://img.shields.io/badge/Built%20using-Android%20Studio-blue"/>
  <img src="https://img.shields.io/badge/Top%20language-Java-blue"/>  
  
  
## Sample


https://user-images.githubusercontent.com/97180951/155985789-4fcd3271-40a6-4862-9ed5-978c79159da2.mp4

  
## Implementation

It is very easy to add it to your project. Just add this to your `settings.gradle` file:
```
maven {url 'https://jitpack.io'}
```

Then add it to your root level `build.gradle` file:
```
implementation 'com.github.sambhav2358:BadgeGenerator:Latest-Version'
```

## How to use?

1. XML
```
<com.sambhav2358.badgegeneratorlibrary.Badge
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
```
This is ideal for when you are getting the text from editext or so. But you are making it in the java without modification, you are prefered to use the `BadgeColor` class for the colors.

Something like this
```
binding.badge.setColor(BadgeColor.blue);
```

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

## Thanks to
[Shields.io](https://shields.io)



[GlideToVectorYou](https://github.com/corouteam/GlideToVectorYou)

## Coming in the future
Different types of badges will be available in the future. You can see those below. Currently only plastic is supported

<img width="239" alt="image" src="https://user-images.githubusercontent.com/97180951/155988758-3a31a0b0-4153-4a50-a812-9c326347fc34.png">

## Feature request
For everyone who wants me to add a feature, just create an issue with the feature you want.

## License
Free to use and modify the code.

## Author
Build with ❤️ by [Sambhav Khandelwal](https://github.com/sambhav2358)
