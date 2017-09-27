package org.lovebing.reactnative.baidumap;

import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
/**
 * Created by sybil052 on 5/3/2017.
 */
public class GetDistanceModule extends BaseModule{

    public GetDistanceModule(ReactApplicationContext reactContext) {
        super(reactContext);
        context = reactContext;
    }
    /**
     * getName()方法用于返回一个字符串信息，用来代表JavaScript前端使用这个模块
     * 这边我们返回信息为"BaiduGetDistanceModule"用来代表给模块,这样我们在前端就可以用JavaScript通过React.NativeModules. BaiduGetDistanceModule访问到这个模块了
     */
    public String getName() {
        return "BaiduGetDistanceModule";
    }
    /**
     * @ReactMethod注解，用于给JavaScript进行调用
     * 该桥接方法的返回类型必须要为void。
     * React Native中的桥接通信是异步形式的，如果需要返回值给JavaScript必须需要通过回调方法或者事件发送
     */
    @ReactMethod
    public void getLocationDistance(double lat1, double lng1, double lat2, double lng2) {
        WritableMap params = Arguments.createMap();
        LatLng p1 = new LatLng(lat1, lng1);
        LatLng p2 = new LatLng(lat2, lng2);
        //计算p1、p2两点之间的直线距离，单位：米
        double distance = DistanceUtil.getDistance(p1, p2);

        //Toast.makeText(getReactApplicationContext(), "distance="+distance, 1).show();

        params.putDouble("distance",  distance);
        sendEvent("getDistanceResult", params);
    }
}