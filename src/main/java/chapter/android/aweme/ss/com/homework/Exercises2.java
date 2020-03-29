package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {


    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private  TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        int cnt = ll1.getChildCount()+ll2.getChildCount()+ll3.getChildCount();
        System.out.println(cnt);
        tv = findViewById(R.id.textView2);
        String s = Integer.toString(cnt)+"个view";
        tv.setText(s);
    }

}
