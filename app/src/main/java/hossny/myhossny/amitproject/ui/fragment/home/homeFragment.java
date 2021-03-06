package hossny.myhossny.amitproject.ui.fragment.home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import hossny.myhossny.amitproject.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import android.widget.Toast;
import hossny.myhossny.amitproject.data.model.product.Product;
import hossny.myhossny.amitproject.helper.TokenManager;
import hossny.myhossny.amitproject.ui.adapter.product.ProductAdapter;
import hossny.myhossny.amitproject.ui.adapter.product.ProductClickListener;


public class homeFragment extends Fragment implements ProductClickListener {


    public homeFragment() {
        // Required empty public constructor
    }
    private HomeViewModel homeViewModel;
    private NavController navController;
    RecyclerView productRecycler;
    RecyclerView.LayoutManager layoutManager;
    ProductAdapter adapter;

    private void intiRecycler(View v) {
        productRecycler = v.findViewById(R.id.product_recycler);
        adapter = new ProductAdapter(getContext(), this);
        layoutManager = new GridLayoutManager(getContext(), 2);
        productRecycler.setLayoutManager(layoutManager);
        productRecycler.setAdapter(adapter);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        intiRecycler(view);

        homeViewModel.getProducts();

        homeViewModel.getProductsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setProducts(products);
            }
        });

        homeViewModel.getMessageLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });


        homeViewModel.getAddCartResponseLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });

        homeViewModel.getMessageCartLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public void showProductDetails(Product product) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        navController
                .navigate(R.id.action_homefragmnt_to_categoryFragment, bundle);

    }

    @Override
    public void addProductToCart(Product product) {
        TokenManager tokenManager = new TokenManager(getContext());
        String token = tokenManager.getToken();
        homeViewModel.addProductToCart(product.getId(), token, 1);

    }
    }
