package cn.inspot.lsh.com.inspot.viewinject;

import android.app.Activity;
import android.widget.TableRow;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by 123 on 2017/3/30.
 */

public class InjectUtil {
    private static final String METHOD_SET_CONTENTVIEW = "setContentView";
    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";
    public static void inject(Activity activity){
        injectContenView(activity);
    }
    private static void injectView(Activity activity){
        Class<? extends Activity> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
    }
    private static void injectContenView(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        //查询是否存在注解
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView!=null){
            int contentViewId = contentView.value();
            try {
                Method method = clazz.getMethod(METHOD_SET_CONTENTVIEW,int.class);
                method.setAccessible(true);
                method.invoke(activity,contentViewId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
