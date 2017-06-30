# SkyTabView
[![](https://jitpack.io/v/ITDreamSKY/SkyTabView.svg)](https://jitpack.io/#ITDreamSKY/SkyTabView) 

![Alt text](https://github.com/ITDreamSKY/SkyTabView/blob/master/screen.gif) 
![Alt text](https://github.com/ITDreamSKY/SkyTabView/blob/master/TAB1.png) 
![Alt text](https://github.com/ITDreamSKY/SkyTabView/blob/master/TAB2.png)

## How to use
  ```Groovy
   repositories {
        ...
        maven { url "https://jitpack.io" }
   }
   dependencies {
        compile 'com.github.ITDreamSKY:SkyTabView:0.1.7'
   }
   ```
   
## Easy to use
XML 
```Groovy
 <iostyle.com.skytabview.View.SkyTabView
        android:id="@+id/skyTabView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
 ```
 Activity 
```Groovy
  mSkyTabView.setText("TAB1", "TAB2");
  mSkyTabView.setListener(new SkyTabView.OnClickListener() {
    @Override
    public void onLeftClick() {
        Log.d("SKY", "leftBtn is click!");
    }

    @Override
    public void onRightClick() {
        Log.d("SKY", "rightBtn is click!");
    }
  });
 ```
