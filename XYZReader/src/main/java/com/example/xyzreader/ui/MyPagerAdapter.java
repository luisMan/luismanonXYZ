package com.example.xyzreader.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.ArticleLoader;

//base on the coding review I follow instruction very well and now my Page Adpapter is a class


public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private ArticleDetailActivity parent;

    public MyPagerAdapter(FragmentManager fm, ArticleDetailActivity parent) {
        super(fm); this.parent =  parent;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        ArticleDetailFragment fragment = (ArticleDetailFragment) object;
        if (fragment != null) {
            parent.mSelectedItemUpButtonFloor = fragment.getUpButtonFloor();
            parent.updateUpButtonPosition();
        }
    }

    @Override
    public Fragment getItem(int position) {
        parent.mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(parent.mCursor.getLong(ArticleLoader.Query._ID));
    }

    @Override
    public int getCount() {
        return (parent.mCursor != null) ? parent.mCursor.getCount() : 0;
    }
}