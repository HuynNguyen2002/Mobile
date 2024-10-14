package Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Home_ViewPageApdate extends FragmentStatePagerAdapter {
    public Home_ViewPageApdate(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new Tab1_HomeFragment();
            case 1 : return new Tab2_HomeFragment();
            case 2: return new Tab3_HomeFragment();
            default: return new Tab1_HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0 : return "Tab1";
            case 1 : return "Tab2";
            case 2 : return "Tab3";
            default: return "Tab1" ;
        }
    }
}
