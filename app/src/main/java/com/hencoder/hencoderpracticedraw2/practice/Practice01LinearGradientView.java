package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context,@Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    public Practice01LinearGradientView(Context context,@Nullable AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
        paint.setShader(new LinearGradient(100,100,500,500,Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),Shader.TileMode.CLAMP));
        // TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和  REPEAT。
        // CLAMP 会在端点之外延续端点处的颜色 (如果着色器超出原始边界范围，会复制边缘颜色。)
        // MIRROR 是镜像模式；横向和纵向的重复着色器的图像，交替镜像图像是相邻的图像总是接合。说白了，就是图像不停翻转来平铺，直到平铺完毕。
        // REPEAT 是重复模式。 横向和纵向的重复着色器的图像。
        //辅助此文章看 https://www.jianshu.com/p/1efcc9c9f286
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300,300,200,paint);
    }
}
