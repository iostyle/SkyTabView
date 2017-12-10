# SkyTabView
[![](https://jitpack.io/v/ITDreamSKY/SkyTabView.svg)](https://jitpack.io/#ITDreamSKY/SkyTabView) 

![Alt text](https://github.com/ITDreamSKY/SkyTabView/blob/master/TAB1.png) 
![Alt text](https://github.com/ITDreamSKY/SkyTabView/blob/master/TAB2.png) 

Sample 

![Alt text](https://github.com/ITDreamSKY/SkyTabView/blob/master/screenShot.gif) 

## How to use
  ```Groovy
   repositories {
        ...
        maven { url "https://jitpack.io" }
   }
   dependencies {
        compile 'com.github.ITDreamSKY:SkyTabView:0.1.9'
   }
   ```
   
## Easy To Use
XML 
```Groovy
 <iostyle.com.skytabview.SkyTabView
        android:id="@+id/skyTabView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
 ```
 Custom in XML above V0.1.9+ (You can choose to add it or not)
 ```Groovy
        app:tab_width="90dp"
        app:tab_height="40dp"
        app:default_selected="right"
        app:selected_background_color="#4199fe"
        app:unselected_background_color="#fff"
        app:text_color_selected="#fff"
        app:text_color_unselected="#000"
        app:text_size_selected="16sp"
        app:text_size_unselected="14sp"
        app:stroke_width="1dp"
        app:radius="5dp"
        app:stroke_color_selected="#4199fe"
        app:stroke_color_unselected="#a6a6a6"/>
 ```
 Activity 
```Groovy
  mSkyTabView.setText("TAB1", "TAB2");
  mSkyTabView.setListener(new SkyTabView.OnClickListener() {
    @Override
    public void onLeftClick() {
        Log.d("SKY", "leftBtn is clicked!");
        //do something
    }

    @Override
    public void onRightClick() {
        Log.d("SKY", "rightBtn is clicked!");
        //do something
    }
  });
 ```
## Update
V0.1.8 Resolve a double app icon problem  
V0.1.9 Support custom in XML
