package dao;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO extends DAO {
    public ProductDAO() {
        super();
    }

    public ArrayList<Product> searchProduct(String key) {
        ArrayList<Product> result = new ArrayList<>();
        String sql = "SELECT * FROM tblproduct WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getFloat("price"));
                product.setDescription(rs.getString("description"));
                result.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
