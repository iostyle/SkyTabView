package iostyle.com.skytabview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import iostyle.com.skytabview.View.SkyTabView;

/**
 * Created by Administrator on 2017/6/29 0029.
 */

public class MainActivity extends AppCompatActivity {

    private SkyTabView mSkyTabView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSkyTabView = (SkyTabView) findViewById(R.id.skyTabView);
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
    }
}
