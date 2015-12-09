package com.angcyo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;

/**
 * Created by angcyo on 15-12-09 009 15:28 下午.
 */
public class HighlightTextView extends AppCompatTextView {
    private int mHighlightPosition = -1;//高亮的位置, 默认不高亮
    private int mHighlightColor = Color.RED;//高亮的颜色, 默认红色
    private int mHighlightNum = 1;//高亮字符的数量,默认1个

    public HighlightTextView(Context context) {
        this(context, null);
    }

    public HighlightTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public HighlightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HighlightTextView);
        mHighlightPosition = typedArray.getInt(R.styleable.HighlightTextView_highlight_position, mHighlightPosition);
        mHighlightColor = typedArray.getColor(R.styleable.HighlightTextView_highlight_color, mHighlightColor);
        mHighlightNum = typedArray.getInt(R.styleable.HighlightTextView_highlight_num, mHighlightNum);
        typedArray.recycle();

        init();
    }

    private void init() {
        if (getText() == null) {
            return;
        }

        if (mHighlightPosition < 0) {
            return;
        }

        if (mHighlightNum < 1) {
            return;
        }

        int textLength = getText().length();
        if (mHighlightPosition > textLength) {
            return;
        }

        int endPosition = mHighlightPosition + mHighlightNum;
        if (mHighlightPosition + mHighlightNum > textLength) {
            endPosition = textLength;
        }

        SpannableStringBuilder builder = new SpannableStringBuilder(getText().toString());
        builder.setSpan(new ForegroundColorSpan(mHighlightColor), mHighlightPosition, endPosition,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(builder);
    }

    public void setHighlightPosition(int mHighlightPosition) {
        this.mHighlightPosition = mHighlightPosition;
        init();
    }

    public void setHighlightColor(@ColorInt int mHighlightColor) {
        this.mHighlightColor = mHighlightColor;
        init();
    }

    public void setHighlightNum(int mHighlightNum) {
        this.mHighlightNum = mHighlightNum;
        init();
    }
}
