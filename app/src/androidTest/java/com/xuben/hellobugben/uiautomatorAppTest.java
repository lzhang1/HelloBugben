package com.xuben.hellobugben;

/**
 * Created by zhanglei on 2018/3/1.
 */
import java.io.File;
import java.util.regex.Pattern;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.xuben.change.Change;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class uiautomatorAppTest {
    private UiDevice mDevice = null;
    private Context mContext = null;
    String APP = "com.xuben.hellobugben";

    String bugben_txt1 = "巴哥本";
    String bugben_txt2 = "bugben";
    String storePath = "./displayCheck.png";


    @Before
    public void launcherActivity() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mContext = InstrumentationRegistry.getContext();
        try {
            if (!mDevice.isScreenOn()) {
                mDevice.wakeUp();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        mDevice.pressHome();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);  //启动app
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(myIntent);
        //Log.v("testUI", String.valueOf(mDevice.waitForWindowUpdate(APP, 5000)));
        mDevice.wait(Until.hasObject(By.pkg(APP).depth(0)), 5000);
        Log.v("testUI", String.valueOf(mDevice.getDisplaySizeDp()));
        int h = mDevice.getDisplayHeight()/2;
        int w = mDevice.getDisplayWidth()/2;
        mDevice.swipe( h, w, h, 0,14);
	//
//        //Log.v("testUI", String.valueOf(Until.hasObject(By.pkg(APP))));
//        if (mDevice.isNaturalOrientation()){
//            Log.v("testUI", String.valueOf(mDevice.getCurrentPackageName()));
//            Log.v("testUI", String.valueOf(mDevice.getProductName()));
//
//        }

//        try {
//            mDevice.unfreezeRotation();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testChangeActivity(){
        //mDevice.findObject(By.res(APP, "txt1")).setText(bugben_txt1);
        //mDevice.findObject(By.text("Bugben微信：巴哥奔")).setText(bugben_txt1);
        //mDevice.findObject(By.clazz("android.widget.EditText").minDepth(5)).setText(bugben_txt1);
        //mDevice.findObject(By.clazz("android.widget.EditText").maxDepth(5)).setText(bugben_txt1);
        //Log.v("testUI", String.valueOf(mDevice.findObject(By.checked(true))));
        //Log.v("testUI", String.valueOf(mDevice.findObject(By.textContains("Bugben"))));
        //Log.v("testUI", String.valueOf(mDevice.findObject(By.pkg(APP))));
        //Log.v("testUI", String.valueOf(mDevice.findObject(By.longClickable(true))));
//        Pattern p = Pattern.compile("BugbenQQ：[0-9]{10}+");
//        Log.v("testUI", String.valueOf(mDevice.findObject(By.text(p))));
        mDevice.findObject(By.clazz("android.widget.EditText").depth(5)).setText(bugben_txt1);
        mDevice.findObject(By.res(APP, "txt2")).setText(bugben_txt2);
        mDevice.findObject(By.res(APP, "bold")).click();
        //assertEquals(mDevice.findObject(By.text("加粗")).isChecked(),true);
        mDevice.findObject(By.res(APP, "big")).click();
        assertEquals(mDevice.findObject(By.text("大号")).isChecked(),true);
        //Log.v("testUI", String.valueOf(mDevice.findObject(By.checked(true))));
        //Log.v("testUI", String.valueOf(mDevice.findObject(By.scrollable(true))));
        //Log.v("testUI", String.valueOf(mDevice.waitForWindowUpdate(APP, 500)));
        mDevice.findObject(By.res(APP, "myButton01")).click();
        //Log.v("testUI", String.valueOf(mDevice.waitForWindowUpdate(APP, 500)));

        UiObject2 changedText01 = mDevice
                .wait(Until.findObject(By.res(APP, "myTextView01")),500);
        assertEquals(bugben_txt1, changedText01.getText().toString());

        UiObject2 changedText02 = mDevice
                .wait(Until.findObject(By.res(APP, "myTextView02")),500);
        assertEquals(bugben_txt2, changedText02.getText().toString());

    }

}
