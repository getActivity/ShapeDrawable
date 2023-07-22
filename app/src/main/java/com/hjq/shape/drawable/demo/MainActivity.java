package com.hjq.shape.drawable.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.shape.drawable.ShapeDrawable;
import com.hjq.shape.drawable.ShapeGradientOrientation;
import com.hjq.shape.drawable.ShapeGradientType;
import com.hjq.shape.drawable.ShapeType;

public class MainActivity extends AppCompatActivity {

    private float mRadiusSize;

    private ShapeDrawable mShapeDrawable;

    private View mExampleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TitleBar titleBar = findViewById(R.id.tb_main_bar);
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onTitleClick(TitleBar titleBar) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(titleBar.getTitle().toString()));
                startActivity(intent);
            }
        });

        mExampleView = findViewById(R.id.v_main_example);

        mRadiusSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());

        int shapeSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());

        mShapeDrawable = new ShapeDrawable()
                .setWidth(shapeSize)
                .setHeight(shapeSize)
                .setSolidColor(ContextCompat.getColor(this, android.R.color.black));
        mShapeDrawable.intoBackground(mExampleView);

        findViewById(R.id.btn_main_shape_type_rectangle).setOnClickListener(mShapeTypeClickListener);
        findViewById(R.id.btn_main_shape_type_oval).setOnClickListener(mShapeTypeClickListener);
        findViewById(R.id.btn_main_shape_type_line).setOnClickListener(mShapeTypeClickListener);
        findViewById(R.id.btn_main_shape_type_ring).setOnClickListener(mShapeTypeClickListener);

        findViewById(R.id.btn_main_shape_rectangle_radius_top_left).setOnClickListener(mRectangleRadiusClickListener);
        findViewById(R.id.btn_main_shape_rectangle_radius_top_right).setOnClickListener(mRectangleRadiusClickListener);
        findViewById(R.id.btn_main_shape_rectangle_radius_bottom_left).setOnClickListener(mRectangleRadiusClickListener);
        findViewById(R.id.btn_main_shape_rectangle_radius_bottom_right).setOnClickListener(mRectangleRadiusClickListener);
        findViewById(R.id.btn_main_shape_rectangle_radius_all).setOnClickListener(mRectangleRadiusClickListener);
        findViewById(R.id.btn_main_shape_rectangle_radius_not).setOnClickListener(mRectangleRadiusClickListener);

        findViewById(R.id.btn_main_shape_width).setOnClickListener(mCommonPropertyClickListener);
        findViewById(R.id.btn_main_shape_height).setOnClickListener(mCommonPropertyClickListener);

        findViewById(R.id.btn_main_shape_solid_color).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_color).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_orientation).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_type_linear).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_type_radial).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_type_sweep).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_center_x).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_center_y).setOnClickListener(mSolidPropertyClickListener);
        findViewById(R.id.btn_main_shape_solid_gradient_radius).setOnClickListener(mSolidPropertyClickListener);

        findViewById(R.id.btn_main_shape_stroke_color).setOnClickListener(mStrokePropertyClickListener);
        findViewById(R.id.btn_main_shape_stroke_gradient_color).setOnClickListener(mStrokePropertyClickListener);
        findViewById(R.id.btn_main_shape_stroke_gradient_orientation).setOnClickListener(mStrokePropertyClickListener);
        findViewById(R.id.btn_main_shape_stroke_size).setOnClickListener(mStrokePropertyClickListener);
        findViewById(R.id.btn_main_shape_stroke_dash_gap).setOnClickListener(mStrokePropertyClickListener);

        findViewById(R.id.btn_main_shape_shadow_size).setOnClickListener(mShadowPropertyClickListener);
        findViewById(R.id.btn_main_shape_shadow_color).setOnClickListener(mShadowPropertyClickListener);
        findViewById(R.id.btn_main_shape_shadow_offset_x).setOnClickListener(mShadowPropertyClickListener);
        findViewById(R.id.btn_main_shape_shadow_offset_y).setOnClickListener(mShadowPropertyClickListener);

        findViewById(R.id.btn_main_shape_ring_inner_radius_size).setOnClickListener(mRingPropertyClickListener);
        findViewById(R.id.btn_main_shape_ring_inner_radius_ratio).setOnClickListener(mRingPropertyClickListener);
        findViewById(R.id.btn_main_shape_ring_thickness_size).setOnClickListener(mRingPropertyClickListener);
        findViewById(R.id.btn_main_shape_ring_thickness_ratio).setOnClickListener(mRingPropertyClickListener);

        findViewById(R.id.btn_main_shape_line_gravity_left).setOnClickListener(mLineGravityPropertyClickListener);
        findViewById(R.id.btn_main_shape_line_gravity_top).setOnClickListener(mLineGravityPropertyClickListener);
        findViewById(R.id.btn_main_shape_line_gravity_right).setOnClickListener(mLineGravityPropertyClickListener);
        findViewById(R.id.btn_main_shape_line_gravity_bottom).setOnClickListener(mLineGravityPropertyClickListener);
        findViewById(R.id.btn_main_shape_line_gravity_start).setOnClickListener(mLineGravityPropertyClickListener);
        findViewById(R.id.btn_main_shape_line_gravity_center).setOnClickListener(mLineGravityPropertyClickListener);
        findViewById(R.id.btn_main_shape_line_gravity_end).setOnClickListener(mLineGravityPropertyClickListener);
    }

    private final View.OnClickListener mShapeTypeClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_type_rectangle) {
                mShapeDrawable.setType(ShapeType.RECTANGLE);
            } else if (viewId == R.id.btn_main_shape_type_oval) {
                mShapeDrawable.setType(ShapeType.OVAL);
            } else if (viewId == R.id.btn_main_shape_type_line) {
                mShapeDrawable.setType(ShapeType.LINE)
                        .setStrokeSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                2, getResources().getDisplayMetrics()))
                        .setStrokeColor(ContextCompat.getColor(MainActivity.this, android.R.color.black));
            } else if (viewId == R.id.btn_main_shape_type_ring) {
                mShapeDrawable.setType(ShapeType.RING)
                        .setRingInnerRadiusRatio(4)
                        .setRingThicknessRatio(4);
            }
        }
    };

    private final View.OnClickListener mCommonPropertyClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_width) {
                mShapeDrawable.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        200, getResources().getDisplayMetrics()));
                // 这次修改需要重新测量 View，所以要调用 requestLayout
                mExampleView.requestLayout();
            } else if (viewId == R.id.btn_main_shape_height) {
                mShapeDrawable.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        200, getResources().getDisplayMetrics()));
                // 这次修改需要重新测量 View，所以要调用 requestLayout
                mExampleView.requestLayout();
            }
        }
    };

    private final View.OnClickListener mSolidPropertyClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_solid_color) {
                mShapeDrawable.setSolidColor(ContextCompat.getColor(MainActivity.this, android.R.color.darker_gray));
            } else if (viewId == R.id.btn_main_shape_solid_gradient_color) {
                mShapeDrawable.setSolidColor(0xFF49DAFA, 0xFFED58FF);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_orientation) {
                mShapeDrawable.setSolidGradientOrientation(ShapeGradientOrientation.RIGHT_TO_LEFT);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_type_linear) {
                mShapeDrawable.setSolidGradientType(ShapeGradientType.LINEAR_GRADIENT);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_type_radial) {
                // 设置径向渐变前需要先设置渐变色和渐变半径大小才能有效果
                mShapeDrawable.setSolidColor(0xFF49DAFA, 0xFFED58FF);
                mShapeDrawable.setSolidGradientRadius((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics()));
                mShapeDrawable.setSolidGradientType(ShapeGradientType.RADIAL_GRADIENT);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_type_sweep) {
                mShapeDrawable.setSolidGradientType(ShapeGradientType.SWEEP_GRADIENT);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_center_x) {
                mShapeDrawable.setSolidGradientCenterX(0.7f);
                mShapeDrawable.setSolidGradientCenterY(0.5f);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_center_y) {
                mShapeDrawable.setSolidGradientCenterX(0.5f);
                mShapeDrawable.setSolidGradientCenterY(0.7f);
            } else if (viewId == R.id.btn_main_shape_solid_gradient_radius) {
                mShapeDrawable.setSolidGradientRadius((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics()));
            }
        }
    };

    private final View.OnClickListener mStrokePropertyClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_stroke_color) {
                // 设置边框色之前需要先设置边框大小
                mShapeDrawable.setStrokeSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                mShapeDrawable.setStrokeColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_blue_bright));
            } else if (viewId == R.id.btn_main_shape_stroke_gradient_color) {
                // 设置边框色之前需要先设置边框大小才能有效果
                mShapeDrawable.setStrokeSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                mShapeDrawable.setStrokeColor(0xFFFEFA54, 0xFFF08833);
            } else if (viewId == R.id.btn_main_shape_stroke_gradient_orientation) {
                mShapeDrawable.setStrokeGradientOrientation(ShapeGradientOrientation.BOTTOM_TO_TOP);
            } else if (viewId == R.id.btn_main_shape_stroke_size) {
                mShapeDrawable.setStrokeSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
            } else if (viewId == R.id.btn_main_shape_stroke_dash_gap) {
                mShapeDrawable.setStrokeDashSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                mShapeDrawable.setStrokeDashGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
            }
        }
    };


    private final View.OnClickListener mShadowPropertyClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_shadow_color) {
                // 设置阴影颜色需要先设置阴影大小才能生效
                mShapeDrawable.setShadowSize((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                mShapeDrawable.setShadowColor(0xAA5A8DDF);
            } else if (viewId == R.id.btn_main_shape_shadow_size) {
                mShapeDrawable.setShadowSize((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics()));
            } else if (viewId == R.id.btn_main_shape_shadow_offset_x) {
                mShapeDrawable.setShadowOffsetY(0);
                mShapeDrawable.setShadowOffsetX((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
            } else if (viewId == R.id.btn_main_shape_shadow_offset_y) {
                mShapeDrawable.setShadowOffsetX(0);
                mShapeDrawable.setShadowOffsetY((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
            }
        }
    };

    private final View.OnClickListener mRectangleRadiusClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mShapeTypeClickListener.onClick(findViewById(R.id.btn_main_shape_type_rectangle));
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_rectangle_radius_top_left) {
                mShapeDrawable.setRadius(mRadiusSize, 0, 0, 0);
            } else if (viewId == R.id.btn_main_shape_rectangle_radius_top_right) {
                mShapeDrawable.setRadius(0, mRadiusSize, 0, 0);
            } else if (viewId == R.id.btn_main_shape_rectangle_radius_bottom_left) {
                mShapeDrawable.setRadius(0, 0, mRadiusSize, 0);
            } else if (viewId == R.id.btn_main_shape_rectangle_radius_bottom_right) {
                mShapeDrawable.setRadius(0, 0, 0, mRadiusSize);
            } else if (viewId == R.id.btn_main_shape_rectangle_radius_all) {
                mShapeDrawable.setRadius(mRadiusSize);
            } else if (viewId == R.id.btn_main_shape_rectangle_radius_not) {
                mShapeDrawable.setRadius(0);
            }
        }
    };

    private final View.OnClickListener mRingPropertyClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            mShapeTypeClickListener.onClick(findViewById(R.id.btn_main_shape_type_ring));

            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_ring_inner_radius_size) {
                mShapeDrawable.setRingInnerRadiusSize((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                // 这次修改需要重新测量 View，所以要调用 requestLayout
                mExampleView.requestLayout();
            } else if (viewId == R.id.btn_main_shape_ring_inner_radius_ratio) {
                mShapeDrawable.setRingInnerRadiusRatio(6);
                // 这次修改需要重新测量 View，所以要调用 requestLayout
                mExampleView.requestLayout();
            } else if (viewId == R.id.btn_main_shape_ring_thickness_size) {
                mShapeDrawable.setRingThicknessSize((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics()));
                // 这次修改需要重新测量 View，所以要调用 requestLayout
                mExampleView.requestLayout();
            } else if (viewId == R.id.btn_main_shape_ring_thickness_ratio) {
                mShapeDrawable.setRingThicknessRatio(6);
                // 这次修改需要重新测量 View，所以要调用 requestLayout
                mExampleView.requestLayout();
            }
        }
    };

    private final View.OnClickListener mLineGravityPropertyClickListener = new View.OnClickListener() {

        @SuppressLint("RtlHardcoded")
        @Override
        public void onClick(View v) {
            mShapeTypeClickListener.onClick(findViewById(R.id.btn_main_shape_type_line));
            int viewId = v.getId();
            if (viewId == R.id.btn_main_shape_line_gravity_left) {
                mShapeDrawable.setLineGravity(Gravity.LEFT);
            } else if (viewId == R.id.btn_main_shape_line_gravity_top) {
                mShapeDrawable.setLineGravity(Gravity.TOP);
            } else if (viewId == R.id.btn_main_shape_line_gravity_right) {
                mShapeDrawable.setLineGravity(Gravity.RIGHT);
            } else if (viewId == R.id.btn_main_shape_line_gravity_bottom) {
                mShapeDrawable.setLineGravity(Gravity.BOTTOM);
            } else if (viewId == R.id.btn_main_shape_line_gravity_start) {
                mShapeDrawable.setLineGravity(Gravity.START);
            } else if (viewId == R.id.btn_main_shape_line_gravity_center) {
                mShapeDrawable.setLineGravity(Gravity.CENTER);
            } else if (viewId == R.id.btn_main_shape_line_gravity_end) {
                mShapeDrawable.setLineGravity(Gravity.END);
            }
        }
    };
}