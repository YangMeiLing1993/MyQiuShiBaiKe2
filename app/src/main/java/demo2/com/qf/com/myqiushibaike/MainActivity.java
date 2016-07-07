package demo2.com.qf.com.myqiushibaike;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import demo2.com.qf.com.myqiushibaike.friends.fragment.FriendsFragment;
import demo2.com.qf.com.myqiushibaike.qiushi.QiuShiFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager supportFragmentManager;
    private RadioGroup rg_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到fragmentManager
        supportFragmentManager = getSupportFragmentManager();
        // 思路：
        // 0、使用MyMainFragment来替换占位的容器控件
        replaceContainerWidget(new QiuShiFragment());

        // 1、找到界面上的控件
        rg_id = (RadioGroup) findViewById(R.id.rg_id);

        // 2、添加监听器
        addListenerToRadioGroup();
    }

    private void addListenerToRadioGroup() {
        rg_id.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_qiushi_id:
                        replaceContainerWidget(new QiuShiFragment() );
                        break;
                    case R.id.rb_qiuyoucircle_id:
                        replaceContainerWidget(new FriendsFragment() );
                        break;
                    case R.id.rb_message_id:
                        break;
                    case R.id.rb_mine_id:
                        break;
                }
            }
        });

    }
    /**
     * 初始化主界面
     */
    private void replaceContainerWidget(Fragment fragment) {

        FragmentTransaction transaction = supportFragmentManager
                .beginTransaction();
        transaction.replace(R.id.ff_content_id, fragment);
        transaction.commit();
    }
}
