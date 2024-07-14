package com.hjq.shape.drawable;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/ShapeDrawable
 *    time   : 2021/08/15
 *    desc   : Shape 渐变方向
 */
public enum ShapeGradientOrientation {

    /** 从左到右绘制渐变（0 度） */
    LEFT_TO_RIGHT,
    START_TO_END,

    /** 从右到左绘制渐变（180 度） */
    RIGHT_TO_LEFT,
    END_TO_START,

    /** 从下到上绘制渐变（90 度） */
    BOTTOM_TO_TOP,

    /** 从上到下绘制渐变（270 度） */
    TOP_TO_BOTTOM,

    // ------------------------------ //

    /** 从左上角到右下角绘制渐变（315 度） */
    TOP_LEFT_TO_BOTTOM_RIGHT,
    TOP_START_TO_BOTTOM_END,

    /** 从右上角到左下角绘制渐变（225 度） */
    TOP_RIGHT_TO_BOTTOM_LEFT,
    TOP_END_TO_BOTTOM_START,

    /** 从左下角到右上角绘制渐变（45 度） */
    BOTTOM_LEFT_TO_TOP_RIGHT,
    BOTTOM_START_TO_TOP_END,

    /** 从右下角到左上角绘制渐变（135 度） */
    BOTTOM_RIGHT_TO_TOP_LEFT,
    BOTTOM_END_TO_TOP_START
}