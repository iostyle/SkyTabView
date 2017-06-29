package iostyle.com.skytabview.View;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import iostyle.com.skytabview.R;

/**
 * Created by Administrator on 2017/6/29 0029.
 */

public class SkyTabView extends LinearLayout {

    private Button mLeftBtn;
    private Button mRightBtn;
    private OnClickListener listener;

    private Boolean isLeft = true;

    public SkyTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.skytabview, this);
        this.mLeftBtn = (Button) findViewById(R.id.leftBtn);
        this.mRightBtn = (Button) findViewById(R.id.rightBtn);
//        initBtn();
    }

    public interface OnClickListener {
        void onLeftClick();

        void onRightClick();
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
        initBtn();
    }

    private void initBtn() {
        mLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLeft) return;
                isLeft = true;
                mLeftBtn.setBackgroundResource(R.drawable.shape_tab1);
                mLeftBtn.setTextColor(Color.WHITE);
                mRightBtn.setBackgroundResource(R.drawable.shape_tab4);
                mRightBtn.setTextColor(Color.BLACK);
                if (null != listener) {
                    listener.onLeftClick();
                }
            }
        });
        mRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLeft) return;
                isLeft = false;
                mLeftBtn.setBackgroundResource(R.drawable.shape_tab2);
                mLeftBtn.setTextColor(Color.BLACK);
                mRightBtn.setBackgroundResource(R.drawable.shape_tab3);
                mRightBtn.setTextColor(Color.WHITE);
                if (null != listener) {
                    listener.onRightClick();
                }
            }
        });
    }

    public void setText(String textLeft, String textRight) {
        mLeftBtn.setText(textLeft);
        mRightBtn.setText(textRight);
    }

}
