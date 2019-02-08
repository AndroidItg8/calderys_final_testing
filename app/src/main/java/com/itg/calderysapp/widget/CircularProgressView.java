package com.itg.calderysapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.itg.calderysapp.R;


public class CircularProgressView extends View {
    private final float strokeWidth;
    private Paint totalPaint, progressPaint;
    private float progress = 360;
    private float total = 360;
    public TextView textView;
    private static final String TAG = "CircularProgressView";

    public CircularProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        strokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, context.getResources().getDisplayMetrics());

        totalPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        totalPaint.setStyle(Paint.Style.STROKE);
        totalPaint.setColor(ContextCompat.getColor(context, R.color.colorGrayLight));
        totalPaint.setStrokeWidth(strokeWidth);

        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
        progressPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        drawProgress(canvas, (int) 360f, totalPaint);
        if(total != 0 && progress != 0)
            drawProgress(canvas, total == progress ? 360 : (int) ((360f / total) * progress), progressPaint);

        canvas.restore();
    }

    private void drawProgress(Canvas canvas, int total, Paint paint) {
        canvas.drawArc(new RectF(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth), -90, total, false, paint);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public void setProgressColor(int rgb) {
        progressPaint.setColor(rgb);
        invalidate();
    }

    public void setTotal(int total) {
        this.total = total;
        if(textView != null)
            textView.setText(String.valueOf(total));
        invalidate();
    }

    public void setTotalTextView(TextView view) {
        this.textView = view;
        textView.setText(String.valueOf((int)total));
        Log.d(TAG, "setTotalTextView: TextView"+total);
    }
}