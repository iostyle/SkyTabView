package iostyle.com.skytabview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/6/29 0029.
 */

public class SkyTabView extends LinearLayout {

    private Button mLeftBtn;
    private Button mRightBtn;
    private OnClickListener listener;
    private Boolean isLeft = true;

    private Context context;
    private GradientDrawable leftSelectedDrawable;
    private GradientDrawable leftUnSelectedDrawable;
    private GradientDrawable rightSelectedDrawable;
    private GradientDrawable rightUnSelectedDrawable;
    private int selectedTextColor;
    private int unSelectedTextColor;
    private float selectedTextSize;
    private float unSelectedTextSize;
    private int tabWidth;
    private int tabHeight;

    public SkyTabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.skytabview, this);
        this.mLeftBtn = findViewById(R.id.leftBtn);
        this.mRightBtn = findViewById(R.id.rightBtn);
        initAttributeSet(attrs);
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
        mLeftBtn.getLayoutParams().width = tabWidth;
        mLeftBtn.getLayoutParams().height = tabHeight;
        mRightBtn.getLayoutParams().width = tabWidth;
        mRightBtn.getLayoutParams().height = tabHeight;
        if (isLeft) {
            mLeftBtn.setBackgroundDrawable(leftSelectedDrawable);
            mRightBtn.setBackgroundDrawable(rightUnSelectedDrawable);
            mLeftBtn.setTextColor(selectedTextColor);
            mRightBtn.setTextColor(unSelectedTextColor);
            mLeftBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, selectedTextSize);
            mRightBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, unSelectedTextSize);
        } else {
            mLeftBtn.setBackgroundDrawable(leftUnSelectedDrawable);
            mRightBtn.setBackgroundDrawable(rightSelectedDrawable);
            mLeftBtn.setTextColor(unSelectedTextColor);
            mRightBtn.setTextColor(selectedTextColor);
            mLeftBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, unSelectedTextSize);
            mRightBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, selectedTextSize);
        }

        mLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLeft) return;
                isLeft = true;
                mLeftBtn.setBackgroundDrawable(leftSelectedDrawable);
                mLeftBtn.setTextColor(selectedTextColor);
                mRightBtn.setBackgroundDrawable(rightUnSelectedDrawable);
                mRightBtn.setTextColor(unSelectedTextColor);
                mLeftBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, selectedTextSize);
                mRightBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, unSelectedTextSize);
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
                mLeftBtn.setBackgroundDrawable(leftUnSelectedDrawable);
                mLeftBtn.setTextColor(unSelectedTextColor);
                mRightBtn.setBackgroundDrawable(rightSelectedDrawable);
                mRightBtn.setTextColor(selectedTextColor);
                mLeftBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, unSelectedTextSize);
                mRightBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, selectedTextSize);
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

    private static final int DEFAULT_SELECTED_BACKGROUND_COLOR = Color.parseColor("#4199fe");
    private static final int DEFAULT_UNSELECTED_BACKGROUND_COLOR = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_SELECTED_STROKE_COLOR = DEFAULT_SELECTED_BACKGROUND_COLOR;
    private static final int DEFAULT_UNSELECTED_STROKE_COLOR = Color.parseColor("#a6a6a6");
    private static final int DEFAULT_SELECTED_TEXT_COLOR = Color.parseColor("#ffffff");
    private static final int DEFAULT_UNSELECTED_TEXT_COLOR = Color.parseColor("#000000");
    private static final Boolean DEFAULT_ANIMATION_ENABLED = false;


    private void initAttributeSet(AttributeSet attrs) {
        final int selectedBackgroundColor;
        int unSelectedBackgroundColor;
        boolean animationEnabled = DEFAULT_ANIMATION_ENABLED;
        int strokeWidth;
        int strokeSelectedColor;
        int strokeUnSelectedColor;
        int radius;

        @SuppressLint("Recycle") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SkyTabView);
        selectedBackgroundColor = a.getColor(R.styleable.SkyTabView_selected_background_color, DEFAULT_SELECTED_BACKGROUND_COLOR);
        unSelectedBackgroundColor = a.getColor(R.styleable.SkyTabView_unselected_background_color, DEFAULT_UNSELECTED_BACKGROUND_COLOR);
        animationEnabled = a.getBoolean(R.styleable.SkyTabView_animation_enabled, DEFAULT_ANIMATION_ENABLED);
        strokeWidth = a.getDimensionPixelSize(R.styleable.SkyTabView_stroke_width, 1);
        strokeSelectedColor = a.getColor(R.styleable.SkyTabView_stroke_color_selected, DEFAULT_SELECTED_STROKE_COLOR);
        strokeUnSelectedColor = a.getColor(R.styleable.SkyTabView_stroke_color_unselected, DEFAULT_UNSELECTED_STROKE_COLOR);
        radius = a.getDimensionPixelSize(R.styleable.SkyTabView_radius, 5);
        selectedTextColor = a.getColor(R.styleable.SkyTabView_text_color_selected, DEFAULT_SELECTED_TEXT_COLOR);
        unSelectedTextColor = a.getColor(R.styleable.SkyTabView_text_color_unselected, DEFAULT_UNSELECTED_TEXT_COLOR);
        isLeft = (a.getInt(R.styleable.SkyTabView_default_selected, 0)) == 0;
        selectedTextSize = a.getDimension(R.styleable.SkyTabView_text_size_selected, -1);
        unSelectedTextSize = a.getDimension(R.styleable.SkyTabView_text_size_unselected, -1);
        tabWidth = a.getDimensionPixelSize(R.styleable.SkyTabView_tab_width, -1);
        tabHeight = a.getDimensionPixelSize(R.styleable.SkyTabView_tab_height, -1);

        leftSelectedDrawable = new GradientDrawable();
        leftSelectedDrawable.setColor(selectedBackgroundColor);
        leftSelectedDrawable.setStroke(strokeWidth, strokeSelectedColor);
        leftSelectedDrawable.setCornerRadii(new float[]{radius, radius, 0, 0, 0, 0, radius, radius});

        leftUnSelectedDrawable = new GradientDrawable();
        leftUnSelectedDrawable.setColor(unSelectedBackgroundColor);
        leftUnSelectedDrawable.setStroke(strokeWidth, strokeUnSelectedColor);
        leftUnSelectedDrawable.setCornerRadii(new float[]{radius, radius, 0, 0, 0, 0, radius, radius});

        rightSelectedDrawable = new GradientDrawable();
        rightSelectedDrawable.setColor(selectedBackgroundColor);
        rightSelectedDrawable.setStroke(strokeWidth, strokeSelectedColor);
        rightSelectedDrawable.setCornerRadii(new float[]{0, 0, radius, radius, radius, radius, 0, 0});

        rightUnSelectedDrawable = new GradientDrawable();
        rightUnSelectedDrawable.setColor(unSelectedBackgroundColor);
        rightUnSelectedDrawable.setStroke(strokeWidth, strokeUnSelectedColor);
        rightUnSelectedDrawable.setCornerRadii(new float[]{0, 0, radius, radius, radius, radius, 0, 0});

    }

}
