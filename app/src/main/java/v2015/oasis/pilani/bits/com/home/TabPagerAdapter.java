package v2015.oasis.pilani.bits.com.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public CharSequence getPageTitle(int position) {

        if (position == 0)
        {
            return "28th Oct";
        }
        if (position == 1)
        {
            return "29th Oct";
        }
        if (position == 2)
        {
            return "30th Oct";
        }
        if (position == 3)
        {
            return "31st Oct";
        }
        if (position ==4)
        {
            return "1st Nov";
        }

        return null;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            case 3:
                return new Tab4();
            case 4:
                return new Tab5();
        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 5;
    }

}
