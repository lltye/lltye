package com.lltye;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lltye.permission.EasyPermissions;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
	private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		//初始化
        init();
    }
	
	 private void init() {
//         String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION};
//         EasyPermissions.requestPermissions(
//                 new PermissionRequest.Builder(this, 200, perms)
//                         .setRationale("ssss")
//                         .setPositiveButtonText("ffffff")
//                         .setNegativeButtonText("gggggg")
//                         .setTheme(R.style.AppTheme)
//                         .build());

         String[] perms = {Manifest.permission.CAMERA};
         if (EasyPermissions.hasPermissions(this, perms)) {
             // Already have permission, do the thing
             // ...
         } else {
             // Do not have permissions, request them now
             EasyPermissions.requestPermissions(this, "我们检测到您禁止了摄像头,请先打开,否则将无法使用相机功能",
                     200, perms);

         }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(MainActivity.this, "onPermissionsGranted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(MainActivity.this, "onPermissionsDenied", Toast.LENGTH_SHORT).show();
    }
}
