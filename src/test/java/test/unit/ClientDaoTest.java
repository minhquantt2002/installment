/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test.unit;

import dao.ClientDAO;
import dao.DAO;
import java.sql.Connection;
import java.util.ArrayList;
import model.Client;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class ClientDaoTest {

    ClientDAO clientDAO = new ClientDAO();

    @Test
    public void testSearchClientWithNameIncorrect() {
        String fullName = "123123";
        String tel = ""; // not search by tel
        ArrayList<Client> listClient = clientDAO.searchClient(fullName, tel);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(0, listClient.size());
    }

    @Test
    public void testSearchClientWithTelIncorrect() {
        String fullName = ""; // not search by name
        String tel = "quan nguyen 02";
        ArrayList<Client> listClient = clientDAO.searchClient(fullName, tel);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(0, listClient.size());
    }

    @Test
    public void testSearchClientWithTelAndNameIncorrect() {
        String fullName = "123123";
        String tel = "quan nguyen 02";
        ArrayList<Client> listClient = clientDAO.searchClient(fullName, tel);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(0, listClient.size());
    }

    @Test
    public void testSearchClientWithNameCorrect() {
        String fullName = "N";
        String tel = ""; // not search by name
        ArrayList<Client> listClient = clientDAO.searchClient(fullName, tel);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(3, listClient.size());
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getFullName().toLowerCase().contains(fullName.toLowerCase()));
        }
    }

    @Test
    public void testSearchClientWithTelCorrect() {
        String fullName = ""; // not search by name
        String tel = "0";
        ArrayList<Client> listClient = clientDAO.searchClient(fullName, tel);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(3, listClient.size());
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getTel().toLowerCase().contains(tel.toLowerCase()));
        }
    }

    @Test
    public void testSearchClientWithTelAndNamCorrect() {
        String fullName = "N";
        String tel = "0";
        ArrayList<Client> listClient = clientDAO.searchClient(fullName, tel);
        Assert.assertNotNull(listClient);
        Assert.assertEquals(3, listClient.size());
        for (int i = 0; i < listClient.size(); i++) {
            Assert.assertTrue(listClient.get(i).getTel().toLowerCase().contains(tel.toLowerCase()));
            Assert.assertTrue(listClient.get(i).getTel().toLowerCase().contains(tel.toLowerCase()));
        }
    }

    @Test
    public void testCreateClient() {
        Connection con = DAO.con;
        String fullName = "Nguyen Minh Minh";
        String address = "Ha Noi";
        String IdCard = "123123";
        String tel = "03311133312";
        String email = "mmqaun@gmail.com";
        String note = "";

        try {
            con.setAutoCommit(false);
            Client client = new Client();
            client.setFullName(fullName);
            client.setAddress(address);
            client.setIdCard(IdCard);
            client.setTel(tel);
            client.setEmail(email);
            client.setNote(note);

            Client newClient = clientDAO.addClient(client);
            Assert.assertTrue(newClient.getFullName().equals(fullName));
            Assert.assertTrue(newClient.getAddress().equals(address));
            Assert.assertTrue(newClient.getTel().equals(tel));
            Assert.assertTrue(newClient.getEmail().equals(email));
            Assert.assertTrue(newClient.getIdCard().equals(IdCard));
            Assert.assertTrue(newClient.getNote().equals(note));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return;
    }
}
