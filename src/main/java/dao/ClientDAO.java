package dao;

import model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDAO extends DAO {
    public ClientDAO() {
        super();
    }

    public ArrayList<Client> searchClient(String name, String tel) {
        ArrayList<Client> result = new ArrayList<>();
        String sql = "SELECT * FROM tblclient WHERE full_name LIKE ? and tel LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");            
            ps.setString(2, "%" + tel + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setFullName(rs.getString("full_name"));
                client.setIdCard(rs.getString("id_card"));
                client.setAddress(rs.getString("address"));
                client.setTel(rs.getString("tel"));
                client.setEmail(rs.getString("email"));
                client.setNote(rs.getString("note"));
                result.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Client getClientById(int id) {
        Client client = null;
        String sql = "SELECT * FROM tblclient WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setFullName(rs.getString("full_name"));
                client.setIdCard(rs.getString("id_card"));
                client.setAddress(rs.getString("address"));
                client.setTel(rs.getString("tel"));
                client.setEmail(rs.getString("email"));
                client.setNote(rs.getString("note"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public ArrayList<Client> getAllClient() {
        ArrayList<Client> result = new ArrayList<>();
        String sql = "SELECT * FROM tblclient";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setFullName(rs.getString("full_name"));
                client.setIdCard(rs.getString("id_card"));
                client.setAddress(rs.getString("address"));
                client.setTel(rs.getString("tel"));
                client.setEmail(rs.getString("email"));
                client.setNote(rs.getString("note"));
                result.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Client addClient(Client client) {
        String sql = "INSERT INTO tblclient(full_name, id_card, address, tel, email, note) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFullName());
            ps.setString(2, client.getIdCard());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getTel());
            ps.setString(5, client.getEmail());
            ps.setString(6, client.getNote());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                client.setId(generatedKeys.getInt(1));
            }
            return getClientById(client.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
