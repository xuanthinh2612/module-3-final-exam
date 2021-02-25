package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private Connection connection = MyConnection.getConnection();

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product "); //get all product from database
            //join category on product.id_category = category.id;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int number = resultSet.getInt("number");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int id_category = resultSet.getInt("id_category");
                Product product = new Product(id, name, price, number, color, description, id_category);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into product (name, price, number, color, description, id_category) VALUE (?,?,?,?,?,?);");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getNumber());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getId_category());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from product where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int number = resultSet.getInt("number");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int id_category = resultSet.getInt("id_category");
                product = new Product(id, name, price, number, color, description, id_category);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *from product where name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int number = resultSet.getInt("number");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int id_category = resultSet.getInt("id_category");
                product = new Product(id, name, price, number, color, description, id_category);

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;

    }

    @Override
    public boolean update(Product product) {

        try {
            PreparedStatement ps = connection.prepareStatement("update product set name = ?, price=?,number = ?, color = ?,description = ?, id_category = ? where  id = ?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getNumber());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getId_category());
            ps.setInt(7, product.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;

    }


    @Override
    public boolean delete(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete  from product where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

        return true;
    }
}
