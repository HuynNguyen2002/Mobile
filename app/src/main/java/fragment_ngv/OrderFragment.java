package fragment_ngv;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.shop.R;
import com.example.shop.view.CategoryActivity;
import com.example.shop.view.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

import Category.Category;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    private RecyclerView recyclerViewCategories;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerViewCategories = view.findViewById(R.id.recyclerViewCategories);
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(getContext()));

        // Tạo danh sách category giả lập
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Các món sợi", R.drawable.category_banhcuon));
        categoryList.add(new Category("Bánh cuốn", R.drawable.menu_order_banhcuon));
        categoryList.add(new Category("Hải sản & Cá", R.drawable.menu_order_haisanca));
        categoryList.add(new Category("Gà, Bò, Heo", R.drawable.menu_order_bogaheo));
        categoryList.add(new Category("Cơm, súp, cháo", R.drawable.menu_order_cschao));
        categoryList.add(new Category("Tráng miệng", R.drawable.menu_order_trangmieng));
        categoryList.add(new Category("Lẩu", R.drawable.menu_order_lau));

        // Kết nối với Adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(),categoryList);
        recyclerViewCategories.setAdapter(categoryAdapter);

        return view;
    }
}