package Nagigationkey;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.shop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragment_ngv.ngv_ViewPageApdate;

public class Nagigationkey extends AppCompatActivity {
    private ViewPager ngv_viewpage;
    private View ngv_view;
    private BottomNavigationView ngv_bottomngvview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nagigationkey);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Ánh xạ ViewPager
        ngv_viewpage = (ViewPager) findViewById(R.id.ngv_viewPager);
        // Ánh xạ cho BottomNavigationView
        ngv_bottomngvview = (BottomNavigationView) findViewById(R.id.ngv_bottomNavigation);

        ngv_ViewPageApdate ngv_apdate = new ngv_ViewPageApdate(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ngv_viewpage.setAdapter(ngv_apdate);

        ngv_viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // Nếu page thay đổi thì bottomngv tương úng cũng thay đổi
            @Override
            public void onPageSelected(int position) {
               switch(position)
               {
                   case 0 : ngv_bottomngvview.getMenu().findItem(R.id.home).setChecked(true); break;
                   case 1 : ngv_bottomngvview.getMenu().findItem(R.id.order).setChecked(true); break;
                   case 2 : ngv_bottomngvview.getMenu().findItem(R.id.book).setChecked(true); break;
                   case 3 : ngv_bottomngvview.getMenu().findItem(R.id.favourite).setChecked(true); break;
                   case 4 : ngv_bottomngvview.getMenu().findItem(R.id.account).setChecked(true); break;
                   default: ngv_bottomngvview.getMenu().findItem(R.id.home).setChecked(true); break;
               }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       // Thiết lập phương thức khi chọn bottomngvView thì ViewPage tương ứng cũng sẽ thay đổi theo
        ngv_bottomngvview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                                                                  @Override
                                                                  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                                      int id;
                                                                      id = item.getItemId();
                                                                      if (id == R.id.home) {
                                                                          ngv_viewpage.setCurrentItem(0);
                                                                      } else if (id == R.id.order) {
                                                                          ngv_viewpage.setCurrentItem(1);
                                                                      } else if (id == R.id.book) {
                                                                          ngv_viewpage.setCurrentItem(2);
                                                                      } else if (id == R.id.favourite) {
                                                                          ngv_viewpage.setCurrentItem(3);
                                                                      } else if (id == R.id.account) {
                                                                          ngv_viewpage.setCurrentItem(4);
                                                                      } else {
                                                                          throw new IllegalStateException("Unexpected value: " + id);
                                                                      }
                                                                      return true;
                                                                  }
                                                              });
    }
}