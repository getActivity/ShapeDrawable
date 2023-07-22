package com.hjq.shape.drawable.demo;

import android.app.Application;

import com.hjq.toast.Toaster;

public class AppApplication extends Application {

   @Override
   public void onCreate() {
      super.onCreate();

      // 初始化吐司工具类
      Toaster.init(this);
   }
}