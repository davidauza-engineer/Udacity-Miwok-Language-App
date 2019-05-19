package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for each
 * list item based on a data source which is a list of {@link Word} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm       is the FragmentManager that will keep each fragment's state in the adapter across
     *                 swipes.
     * @param pContext is the Context of the app.
     */
    public CategoryAdapter(FragmentManager fm, Context pContext) {
        super(fm);
        mContext = pContext;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            default:
                return new PhrasesFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        // There are a total of 4 fragments which will be displayed in the ViewPager.
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.main_category_numbers);
            case 1:
                return mContext.getString(R.string.main_category_family);
            case 2:
                return mContext.getString(R.string.main_category_colors);
            default:
                return mContext.getString(R.string.main_category_phrases);
        }
    }
}
