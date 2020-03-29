package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class msg_activity extends AppCompatActivity {

    public CharSequence sequence = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        Log.e("传来的值是",title);

        TextView textView1 = (TextView)findViewById(R.id.tv_with_name);
        String s = "我和"+title+"的对话";
        textView1.setText(s);

        final EditText etOne= (EditText) findViewById(R.id.ed_say);
        etOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("监听输入","内容改变之前调用:"+s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("监听输入","内容改变:"+s);
                setSequence(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("监听输入","内容改变之后调用:"+s);
            }
        });

        ImageView imageView = (ImageView)findViewById(R.id.btn_send_info);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView2 = (TextView)findViewById(R.id.tv_content_info);
                set_tv(textView2);
                etOne.setText("");
            }
        });

        //TextView textView2 = (TextView)findViewById(R.id.tv_content_info);

    }

    public CharSequence getSequence() {
        return sequence;
    }

    public void setSequence(CharSequence sequence) {
        this.sequence = sequence;
    }

    public void set_tv(TextView tv){
        System.out.println(this.getSequence());
        tv.setText(this.getSequence()+"\n"+this.getSequence());
    }

}
