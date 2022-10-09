package ss12.bt.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    List<Product> listProduct = new ArrayList<>();

    public void addProduct(Product product) {
        listProduct.add(product);
    }

    public void editProduct(int id, Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId()) {
                listProduct.set(i, product);
            }
        }
        displayProduct();
    }

    public void displayProduct() {
        for (Product element:listProduct){
          System.out.println(element);
          }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id){
                listProduct.remove(i);
            }
        }
    }
    public void searchProduct(String name){
        for (Product product : listProduct) {
            if (name.equals(product.getId())) {
                System.out.println(product);
            }
        }
    }
    public void sortPriceAscending(){
        Collections.sort(listProduct, new SortPriceAscending());
        displayProduct();
    }
    public void sortPriceDecrease(){
        Collections.sort(listProduct, new SortPriceDecrease());
        displayProduct();
    }

}
class SortPriceAscending implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
class SortPriceDecrease implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice()-o1.getPrice();
    }
}

