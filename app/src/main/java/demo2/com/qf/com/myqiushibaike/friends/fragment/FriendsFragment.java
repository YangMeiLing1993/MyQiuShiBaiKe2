package demo2.com.qf.com.myqiushibaike.friends.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import java.util.LinkedList;
import java.util.List;

import demo2.com.qf.com.myqiushibaike.R;

/**
 * Created by ymll on 2016/7/7.
 */
public class FriendsFragment extends Fragment {

    private FragmentActivity activity;
    private TabPageIndicator mtpi_id;//上面的标签
    private ViewPager mvp_id;//页面侧滑

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friendds, null);
        //初始化界面实例
        mtpi_id = (TabPageIndicator) view.findViewById(R.id.tpi_id);
        mvp_id = (ViewPager) view.findViewById(R.id.vp_id);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //关于ViewPager的操作
        aboutViewPager();
        //关于TabPageIndicator的操作
        aboutTabPageIndicator();
        super.onActivityCreated(savedInstanceState);
    }
  /*
  关于TabPageIndicator的操作
   */
    private void aboutTabPageIndicator() {
        // 思路：
        // 1、设定TabPageIndicator与ViewPager之间的关系
        mtpi_id.setViewPager(mvp_id);
    }
  /*
  关于ViewPager的操作
   */
    private void aboutViewPager() {
        //数据源
          List<Fragment> fragments=new LinkedList<>();

        //适配器
        //绑定视频器
    }
}
