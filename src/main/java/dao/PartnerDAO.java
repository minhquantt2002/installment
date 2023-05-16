package  dao;

import model.Partner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartnerDAO extends DAO {
    public PartnerDAO() {
        super();
    }

    public ArrayList<Partner> searchPartner(String key) {
        ArrayList<Partner> result = new ArrayList<>();
        String sql = "SELECT * FROM tblpartner WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Partner partner = new Partner();
                partner.setId(rs.getInt("id"));
                partner.setName(rs.getString("name"));
                partner.setAddress(rs.getString("address"));
                partner.setTel(rs.getString("tel"));
                partner.setEmail(rs.getString("email"));
                partner.setNote(rs.getString("note"));
                result.add(partner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
