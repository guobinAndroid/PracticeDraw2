package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
        * LightingColorFilter 的构造方法是 LightingColorFilter(int mul, int add) ，
        * 参数里的 mul 和 add 都是和颜色值格式相同的 int 值，
        * 其中 mul 用来和目标像素相乘，add 用来和目标像素相加：
        *
        * R' = R * mul.R / 0xff + add.R
        * G' = G * mul.G / 0xff + add.G
        * B' = B * mul.B / 0xff + add.B
        * 一个「保持原样」的「基本 LightingColorFilter 」
        * mul 为 0xffffff，add 为 0x000000（也就是0）
        * 那么对于一个像素，它的计算过程就是：
        * R' = R * 0xff / 0xff + 0x0 = R // R' = R
        * G' = G * 0xff / 0xff + 0x0 = G // G' = G
        * B' = B * 0xff / 0xff + 0x0 = B // B' = B
        *
        * */

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        // 第一个 LightingColorFilter：去掉红色部分
        ColorFilter redColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        paint.setColorFilter(redColorFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        // 第二个 LightingColorFilter：增强绿色部分
        ColorFilter lightingColorFilter = new LightingColorFilter(0xffffff, 0x003000);
        paint.setColorFilter(lightingColorFilter);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
