package demo2.com.qf.com.myqiushibaike.welcom.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.LinkedList;
import java.util.List;

import demo2.com.qf.com.myqiushibaike.MainActivity;
import demo2.com.qf.com.myqiushibaike.R;
import demo2.com.qf.com.myqiushibaike.welcom.adapter.MyAdapter;


public class WelcomActivity extends AppCompatActivity {
    @ViewInject(R.id.vp_id)
    private ViewPager mVp;//界面上ViewPager控件实例

    @ViewInject(R.id.ll_container_id)
    private LinearLayout mLlContainer;//界面上LinearLayout控件实例
    private List<View> ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //①界面控件实例的获取（启用注解）
        ViewUtils.inject(this);

        //②关于ViewPager的操作 --》ViewPager决定小圆点随之联动
        aboutViewPager();

        //③关于线性布局的操作--》小圆点决定ViewPager页面的联动
        aboutLittleDots();

    }

    private void aboutLittleDots() {
    }

    private void aboutViewPager() {
        //思路：
        //①数据源
        ds = new LinkedList<>();
        fillDataSource();

        //②适配器
        PagerAdapter adapter = new MyAdapter(ds, mVp);

        //③设置适配器
        mVp.setAdapter(adapter);

        //④监听器
        mVp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //ViewPager决定小圆点的状态
                //思路：
                //①从LinearLayout中找子控件，让所有的小圆点都可以被点击

                for (int i = 0; i < mLlContainer.getChildCount(); i++) {
                    //① 获得当前的子控件实例
                    View view = mLlContainer.getChildAt(i);

                    //②设置View的属性
                    view.setEnabled(true);
                }

                //②让当前位置的小圆点不可点击
                if (position < mLlContainer.getChildCount()) {
                    mLlContainer.getChildAt(position).setEnabled(false);
                }
            }
        });
    }

    /**
     * 填充数据源
     */
    private void fillDataSource() {
        //①根据图片的张数，构建ImageView的实例
        int[] imageIds = {R.mipmap.welcom_01, R.mipmap.welcom_02};
        for (int imageId : imageIds) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(imageId);
            ds.add(iv);
        }
       //②最后一张图片（通过布局文件来单独定制）
        View view = View.inflate(this, R.layout.last_welcome_page, null);
        //关于子控件的操作
        ImageView enterIv = (ImageView) view.findViewById(R.id.iv_id);
        enterIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomActivity.this, MainActivity.class));
                finish();
            }
        });

        ds.add(view);
    }


}
