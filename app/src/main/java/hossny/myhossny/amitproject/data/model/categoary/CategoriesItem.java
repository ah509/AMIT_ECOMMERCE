package hossny.myhossny.amitproject.data.model.categoary;
import com.google.gson.annotations.SerializedName;
public class CategoriesItem {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("avatar")
    private String avatar;

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getAvatar(){
        return avatar;
    }
}
