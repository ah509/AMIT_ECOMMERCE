package hossny.myhossny.amitproject.ui.fragment.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import hossny.myhossny.amitproject.data.model.categoary.CategoriesItem;
import hossny.myhossny.amitproject.data.Repository.CategoryRepository;

import java.util.List;
import androidx.lifecycle.ViewModel;

public class CategoryViewModel extends ViewModel {
    private LiveData<List<CategoriesItem>> cateLiveData;
    private LiveData<String >messageLiveData;

    private CategoryRepository repository = new CategoryRepository();

    public LiveData<List<CategoriesItem>> getCateLiveData() {
        return cateLiveData;
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }


    public void getAllCategories(){
        repository.getAllCategories();
        cateLiveData=repository.getCategoryLiveData();
        messageLiveData=repository.getMessageLiveData();
    }
}
