package hossny.myhossny.amitproject.data.Repository;
import androidx.lifecycle.MutableLiveData;

import hossny.myhossny.amitproject.data.model.categoary.CategoriesItem;
import hossny.myhossny.amitproject.data.source.api.apimanager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import hossny.myhossny.amitproject.data.model.categoary.CategoryResponse;


public class CategoryRepository {
    private MutableLiveData<List<CategoriesItem>>categoryLiveData;
    private MutableLiveData<String>messageLiveData;

    public CategoryRepository() {
        categoryLiveData = new MutableLiveData<>();
        messageLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<CategoriesItem>> getCategoryLiveData() {
        return categoryLiveData;
    }

    public MutableLiveData<String> getMessageLiveData() {
        return messageLiveData;
    }

    public void getAllCategories(){
        apimanager.getProductService().getAllCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                if (response.isSuccessful())
                    categoryLiveData.setValue(response.body().getCategories());
                else
                    messageLiveData.setValue(response.message());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                messageLiveData.setValue(t.getLocalizedMessage());

            }
        });
    }




}
