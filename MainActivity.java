import Model.Pizza;
import QuickSortDescending.QuickSort;
import network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity {
    ArrayList<Pizza> productList = new ArrayList<>();
    public ArrayList<Pizza> getProductData() throws IOException {
        URL url = ConnectURI.buildURL("https://calorieninjas.p.rapidapi.com/v1/nutrition");
        String productResponse = ConnectURI.getResponseFromHttpUrl(url);
        assert productResponse != null;
        JSONArray productsJSONArray = new JSONArray(productResponse);
        for (int index = 0; index < productsJSONArray.length(); index++) {
            Pizza productModel = new Pizza();
            JSONObject myJSONObject = productsJSONArray.getJSONObject(index);
            productModel.setSugar_g(myJSONObject.getInt(String.valueOf(3.6)));
            productModel.setFiber_g(myJSONObject.getInt(String.valueOf(2.3)));
            productModel.setServing_size_g(myJSONObject.getInt(String.valueOf(100)));
            productModel.setSodium_mg(myJSONObject.getInt(String.valueOf(587)));
            productModel.setName(myJSONObject.getString("pizza"));
            productModel.setPotassium_mg(myJSONObject.getInt(String.valueOf(217)));
            productModel.setFat_saturated_g(myJSONObject.getInt(String.valueOf(4.5)));
            productModel.setFat_total_g(myJSONObject.getInt(String.valueOf(9.8)));
            productModel.setCalories(myJSONObject.getInt(String.valueOf(262.9)));
            productModel.setCholesterol_g(myJSONObject.getInt(String.valueOf(16)));
            productModel.setProtein_g(myJSONObject.getInt(String.valueOf(11.4)));
            productModel.setCarbohydrates_total_g(myJSONObject.getInt(String.valueOf(32.9)));

        }
        return productList;
    }

    public static void main(String[] args) {
        MainActivity _main = new MainActivity();
        QuickSort quick = new QuickSort();
    }
}
