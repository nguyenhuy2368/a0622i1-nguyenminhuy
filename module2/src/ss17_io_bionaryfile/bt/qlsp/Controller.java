package ss17_io_bionaryfile.bt.qlsp;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("001","ip11","apple",100000,"đen"));
        productList.add(new Product("002","ip12","apple",100000,"đen1"));
        productList.add(new Product("003","ip13","apple",100000,"đen2"));
        productList.add(new Product("004","ip14","apple",100000,"đen3"));
        productList.add(new Product("005","ip15","apple",100000,"đen4"));
        productList.add(new Product("006","ip16","apple",100000,"đen5"));

        FileUtils.writeFile(productList,"D:\\A0622I1\\module2\\src\\ss17_io_bionaryfile\\bt\\qlsp\\products.txt");
        List<Product> products = FileUtils.readFile("D:\\A0622I1\\module2\\src\\ss17_io_bionaryfile\\bt\\qlsp\\products.txt");
        products.forEach(System.out::println);
    }
}
