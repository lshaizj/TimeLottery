package cn.inspot.lsh.com.inspot;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cn.bmob.v3.Bmob;
import cn.inspot.lsh.com.inspot.Base.BaseActivity;
import cn.inspot.lsh.com.inspot.viewinject.ContentView;
import cn.inspot.lsh.com.inspot.viewinject.InjectUtil;
@ContentView(value =R.layout.activity_main )
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtil.inject(this);

        Bmob.initialize(this,"070a5f92784589ba3b209f0cde228178");
        initView();
    }
    private void initView() {

    }
}
