# IpsmapSDK-Android-Robot

IpsmapSDK-Android-Robot 是一套基于 Android 4.3 及以上版本的室内地图应用程序开发接口，供开发者在自己的Android平板中加入室内地图相关的功能，包括：地图显示（多楼层、多栋楼）、室内导航、模拟导航等功能。参考demo

## 

## 获取激活码

请联系dev@ipsmap.com

# 添加依赖

```markdown
compile (com.ipsmap:ipsmap-robot:0.0.1.3, {
        exclude group: 'com.android.support'
    })
```

# 加入权限

```markdown
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_SETTINGS" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
```

# 使用

* _初始化在Application 的onCreate 方法中进行初始化 _

```markdown
     IpsMapRobotSDK.init(new IpsMapRobotSDK.Configuration.Builder(context)
                .debug(false)
                .build()
```

* _启动地图方式1\(建议\) _

```markdown
 IpsMapRobotSDK.openIpsMapActivity(getBaseContext());
```

* _启动地图方式2,\(携带地图targetId\)\(建议\) _

```
IpsMapRobotSDK.openIpsMapActivity(getBaseContext(),targetId);
```

* _启动地图方式3,\(自定义IpsmapRobotFragment显示位置\)  _

```markdown
首先需要获取
Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET
动态权限申请(可以参考demo),然后去打开地图的IpsmapRobotFragment
ipsmapTVFragment = IpsmapRobotFragment.getInstance();
getSupportFragmentManager().beginTransaction()
                            .add(R.id.fl_content, ipsmapTVFragment, "ipsmap")
                            .commit();

调用这个方法前做好做一下延时1500ms 然后调用.
```

* _启动地图方式4,\(自定义IpsmapRobotFragment显示位置,并且携带targetId参数\)  _

```markdown
ipsmapTVFragment=IpsmapRobotFragment.getInstance(targetId);
getSupportFragmentManager().beginTransaction().add(com.daoyixun.robot.R.id.fl_content,ipsmapTVFragment,"ipsmap").commit();
```

* _如果使用自定义自定义IpsmapRobotFragment显示位置,注意activity 结束时调用 _

```markdown
重写一下  
@Override
protected void onDestroy() {
     if (ipsmapTVFragment != null){
            ipsmapTVFragment.onDestroy();
     }
    super.onDestroy();
}
```

# 混淆

```markdown
-keep public class com.sails.engine.patterns.IconPatterns
```



