package com.app.myattrsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mingming on 2016/5/19.
 */
public class MyView extends View {

    //存储要显示的文本
    private String mCustomText;
    //存储文本的显示颜色
    private int mCustomColor = 0xFF000000;
    //画笔
    private TextPaint mTextPaint;
    //字体大小
    private float fontSize = getResources().getDimension(R.dimen.fontSize);

    public MyView(Context context) {
        super(context);
        init(null, 0);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        //首先判断attrs是否为null
        if(attrs != null){
            //获取AttributeSet中所有的XML属性的数量
            int count = attrs.getAttributeCount();
            //遍历AttributeSet中的XML属性
            for(int i = 0; i < count; i++){
                //获取attr的资源ID
                int attrResId = attrs.getAttributeNameResource(i);
                switch (attrResId){
                    case R.attr.customText:
                        //customText属性
                        mCustomText = attrs.getAttributeValue(i);
                        break;
                    case R.attr.customColor:
                        //customColor属性
                        //如果读取不到对应的颜色值，那么就用黑色作为默认颜色
                        mCustomColor = attrs.getAttributeIntValue(i, 0xFF000000);
                        break;
                }
            }
        }

        //初始化画笔
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(fontSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mCustomText != null && !mCustomText.equals("")){
            mTextPaint.setColor(mCustomColor);
            //将文本绘制显示出来
            canvas.drawText(mCustomText, 0, fontSize, mTextPaint);
        }
    }
}

