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
    private EditText et_mobile,et1;
    private Button btn_regist;
    private RelativeLayout root;
    private RecyclerView recyclerView,recycler1;
    private ArrayList<String> arrayList = new ArrayList<>();
    private LinearLayout linearLayout,ll1;
    private RelativeLayout main ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtil.inject(this);

        //setContentView(R.layout.activity_main);
        Bmob.initialize(this,"070a5f92784589ba3b209f0cde228178");
        for (int a = 0 ; a <5 ;a++){
            arrayList.add("我是"+a);
        }
        initView();
    }
    int top;
    private void initView() {
        main = (RelativeLayout) findViewById(R.id.main);
        linearLayout = (LinearLayout) findViewById(R.id.ll);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        root = (RelativeLayout) findViewById(R.id.root);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setVisibility(View.GONE);
        recycler1 = (RecyclerView) findViewById(R.id.recycler1);
        et1 = (EditText) findViewById(R.id.et1);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recycler1.setLayoutManager(manager1);
        recyclerView.setAdapter(new MyAdapter());
        recycler1.setAdapter(new MyAdapter());
        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    top = ll1.getTop();
                    Log.e("aaa","焦点"+top);
                    root.scrollTo(0,0);
                    recycler1.setVisibility(View.VISIBLE);
                }else {
                    root.scrollTo(0,-top);
                    recycler1.setVisibility(View.GONE);
                }
            }
        });
        et_mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    int top = linearLayout.getTop();
                    Log.e("aaa","焦点"+top);
                    main.scrollTo(linearLayout.getLeft(),100);
                    recyclerView.setVisibility(View.VISIBLE);
                }else {
                    Log.e("aaa","无焦点");
                    recyclerView.setVisibility(View.GONE);
                    main.scrollTo(linearLayout.getLeft(),0);
                }
            }
        });
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new MyHolder(View.inflate(parent.getContext(),R.layout.item,null));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.textView.setText(arrayList.get(position));
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
        public class MyHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            public MyHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }
    }
}
