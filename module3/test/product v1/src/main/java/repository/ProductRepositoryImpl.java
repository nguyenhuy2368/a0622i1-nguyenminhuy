package repository;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    public static final String SELECT_ALL_PRODUCT = "SELECT product.*, category.category FROM product\n" +
            "LEFT JOIN category ON product.id_category = category.id;";

    public static final String INSERT_INTO_PRODUCT = "INSERT INTO `csdl_thi`.`product` (`id`, `name`, `count`, `amount`, `color`, `described`, `id_category`) VALUES (?,?,?,?,?,?,?);";

    public static final String SELECT_PRODUCT_BY_ID = "SELECT product.*, category.category FROM product\n" +
            "LEFT JOIN category ON product.id_category = category.id\n" +
            "where product.id = ?;";

    public static final String UPDATE_PRODUCT_BY_ID = "UPDATE `csdl_thi`.`product` SET `name` = ?, `count` = ?, `amount` = ?, `color` = ?, `described` = ?, `id_category` = ? WHERE (`id` = ?);";

    public static final String DELETE_PRODUCT_BY_ID = "delete from product where id = ?;";

    public static final String SELECT_PRODUCT_BY_NAME = "SELECT product.*, category.category FROM product\n" +
            "LEFT JOIN category ON product.id_category = category.id\n" +
            "where name like concat('%',?,'%');";
    @Override
    public List<Product> selectAllProduct() {
        List<Product> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    double count = resultSet.getDouble(3);
                    int amount = resultSet.getInt(4);
                    String color = resultSet.getString(5);
                    String described = resultSet.getString(6);
                    int idCategory = resultSet.getInt(7);
                    String nameCategory = resultSet.getString(8);
                    list.add(new Product(id, name, count, amount, color, described, new Category(idCategory, nameCategory)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public void save(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_INTO_PRODUCT);
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getCount());
                statement.setInt(4, product.getAmount());
                statement.setString(5, product.getColor());
                statement.setString(6, product.getDescribed());
                statement.setInt(7, product.getCategory().getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Product getProductById(int id) {
        Product product = new Product();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    double count = resultSet.getDouble(3);
                    int amount = resultSet.getInt(4);
                    String color = resultSet.getString(5);
                    String described = resultSet.getString(6);
                    int idCategory = resultSet.getInt(7);
                    String nameCategory = resultSet.getString(8);
                    product = new Product(id_product, name, count, amount, color, described, new Category(idCategory, nameCategory));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getCount());
                statement.setInt(3, product.getAmount());
                statement.setString(4, product.getColor());
                statement.setString(5, product.getDescribed());
                statement.setInt(6, product.getCategory().getId());
                statement.setInt(7, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Product> getListProductByName(String name) {
        List<Product> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
                statement.setString(1, name);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String nameProduct = resultSet.getString(2);
                    double count = resultSet.getDouble(3);
                    int amount = resultSet.getInt(4);
                    String color = resultSet.getString(5);
                    String described = resultSet.getString(6);
                    int idCategory = resultSet.getInt(7);
                    String nameCategory = resultSet.getString(8);
                    list.add(new Product(id_product, nameProduct, count, amount, color, described, new Category(idCategory, nameCategory)));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return list;
    }
}
