package com.hjq.shape.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.View;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/ShapeDrawable
 *    time   : 2023/07/15
 *    desc   : ShapeDrawable 工具类（仅供内部使用）
 */
final class ShapeDrawableUtils {
   
   static void saveCanvasLayer(Canvas canvas, float left, float top, float right, float bottom, @Nullable Paint paint) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
         canvas.saveLayer(left, top, right, bottom, paint);
      } else {
         canvas.saveLayer(left, top, right, bottom, paint, 0x04);
      }
   }

   static float[] computeLinearGradientCoordinate(int layoutDirection, RectF r, float level, ShapeGradientOrientation orientation) {
      float x0, x1, y0, y1;
      switch (orientation) {
         case START_TO_END:
            return computeLinearGradientCoordinate(layoutDirection, r, level,
                layoutDirection == View.LAYOUT_DIRECTION_RTL ?
                    ShapeGradientOrientation.RIGHT_TO_LEFT : ShapeGradientOrientation.LEFT_TO_RIGHT);
         case END_TO_START:
             return computeLinearGradientCoordinate(layoutDirection, r, level,
                 layoutDirection == View.LAYOUT_DIRECTION_RTL ?
                    ShapeGradientOrientation.LEFT_TO_RIGHT : ShapeGradientOrientation.RIGHT_TO_LEFT);
         case TOP_START_TO_BOTTOM_END:
             return computeLinearGradientCoordinate(layoutDirection, r, level,
                  layoutDirection == View.LAYOUT_DIRECTION_RTL ?
                      ShapeGradientOrientation.TOP_RIGHT_TO_BOTTOM_LEFT : ShapeGradientOrientation.TOP_LEFT_TO_BOTTOM_RIGHT);
         case TOP_END_TO_BOTTOM_START:
             return computeLinearGradientCoordinate(layoutDirection, r, level,
                  layoutDirection == View.LAYOUT_DIRECTION_RTL ?
                      ShapeGradientOrientation.TOP_LEFT_TO_BOTTOM_RIGHT : ShapeGradientOrientation.TOP_RIGHT_TO_BOTTOM_LEFT);
         case BOTTOM_START_TO_TOP_END:
             return computeLinearGradientCoordinate(layoutDirection, r, level,
                  layoutDirection == View.LAYOUT_DIRECTION_RTL ?
                      ShapeGradientOrientation.BOTTOM_RIGHT_TO_TOP_LEFT : ShapeGradientOrientation.BOTTOM_LEFT_TO_TOP_RIGHT);
         case BOTTOM_END_TO_TOP_START:
             return computeLinearGradientCoordinate(layoutDirection, r, level,
                  layoutDirection == View.LAYOUT_DIRECTION_RTL ?
                      ShapeGradientOrientation.BOTTOM_LEFT_TO_TOP_RIGHT : ShapeGradientOrientation.BOTTOM_RIGHT_TO_TOP_LEFT);
         case TOP_TO_BOTTOM:
            x0 = r.left;            y0 = r.top;
            x1 = x0;                y1 = level * r.bottom;
            break;
         case TOP_RIGHT_TO_BOTTOM_LEFT:
            x0 = r.right;           y0 = r.top;
            x1 = level * r.left;    y1 = level * r.bottom;
            break;
         case RIGHT_TO_LEFT:
            x0 = r.right;           y0 = r.top;
            x1 = level * r.left;    y1 = y0;
            break;
         case BOTTOM_RIGHT_TO_TOP_LEFT:
            x0 = r.right;           y0 = r.bottom;
            x1 = level * r.left;    y1 = level * r.top;
            break;
         case BOTTOM_TO_TOP:
            x0 = r.left;            y0 = r.bottom;
            x1 = x0;                y1 = level * r.top;
            break;
         case BOTTOM_LEFT_TO_TOP_RIGHT:
            x0 = r.left;            y0 = r.bottom;
            x1 = level * r.right;   y1 = level * r.top;
            break;
         case LEFT_TO_RIGHT:
            x0 = r.left;            y0 = r.top;
            x1 = level * r.right;   y1 = y0;
            break;
         case TOP_LEFT_TO_BOTTOM_RIGHT:
         default:
            x0 = r.left;            y0 = r.top;
            x1 = level * r.right;   y1 = level * r.bottom;
            break;
      }
      return new float[] {x0, y0, x1, y1};
   }

   /**
    * 设置颜色的透明度，参考 Support 包中的 ColorUtils.setAlphaComponent 方法
    */
   @ColorInt
   public static int setColorAlphaComponent(@ColorInt int color,
                                       @IntRange(from = 0x0, to = 0xFF) int alpha) {
      if (alpha < 0 || alpha > 255) {
         throw new IllegalArgumentException("alpha must be between 0 and 255.");
      }
      return (color & 0x00ffffff) | (alpha << 24);
   }
}