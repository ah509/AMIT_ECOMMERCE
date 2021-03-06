package hossny.myhossny.amitproject.ui.fragment.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import hossny.myhossny.amitproject.data.model.AddCartResponse;
import hossny.myhossny.amitproject.data.model.product.Product;
import hossny.myhossny.amitproject.data.Repository.ProductRepository;
import hossny.myhossny.amitproject.data.source.api.apimanager;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class HomeViewModel {

    private LiveData<List<Product>> productsLiveData;
    private LiveData<String> messageLiveData ;

    public LiveData<List<Product>> getProductsLiveData() {
        return productsLiveData;
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    private ProductRepository repository = new ProductRepository();

    public void getProducts() {
        repository.getAllProducts();
        productsLiveData=repository.getProductLiveData();
        messageLiveData=repository.getMessageLiveData();

    }

    private MutableLiveData<String> addCartResponseLiveData = new MutableLiveData<>() ;
    private MutableLiveData<String> messageAddCartLiveData = new MutableLiveData<>();


    public MutableLiveData<String> getAddCartResponseLiveData() {
        return addCartResponseLiveData;
    }

    public MutableLiveData<String> getMessageCartLiveData() {
        return messageAddCartLiveData;
    }


    public void addProductToCart(int id, String token, int amount) {
        apimanager.getProductService()
                .addProductToCart(id,
                        "Bearer " + token,
                        1).enqueue(new Callback<AddCartResponse>() {
            @Override
            public void onResponse(Call<AddCartResponse> call, Response<AddCartResponse> response) {
                if (response.isSuccessful())
                    addCartResponseLiveData.setValue(response.body().getMessage());

            }

            @Override
            public void onFailure(Call<AddCartResponse> call, Throwable t) {
                messageAddCartLiveData.setValue(t.getLocalizedMessage());
            }
        });

    }

}
