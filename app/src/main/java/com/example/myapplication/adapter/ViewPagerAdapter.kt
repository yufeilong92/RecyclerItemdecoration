package com.example.myapplication.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @Author : YFL  is Creating a porject in zhujie
 * @Package com.example.myapplication.adapter
 * @Email : yufeilong92@163.com
 * @Time :2019/4/30 11:55
 * @Purpose :
 */
class ViewPagerAdapter(fm: FragmentManager?, var mData: MutableList<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        return mData[p0];
    }

    override fun getCount(): Int {
        return mData.size
    }
}