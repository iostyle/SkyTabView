# SkyTabView
[![](https://jitpack.io/v/ITDreamSKY/SkyTabView.svg)](https://jitpack.io/#ITDreamSKY/SkyTabView)


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
```Groovy
  mSkyTabView.setText("列表", "地图");
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
