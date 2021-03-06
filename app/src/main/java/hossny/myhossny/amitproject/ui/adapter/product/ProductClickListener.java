package hossny.myhossny.amitproject.ui.adapter.product;
import hossny.myhossny.amitproject.data.model.product.Product;
public interface ProductClickListener {

    void showProductDetails(Product product);

    void addProductToCart(Product product);
}
