package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import model.Contract;
import model.ContractDetail;
import model.PaymentSchedule;

public class ContractDAO extends DAO {
    public boolean addContract(Contract contract) {
        String sqlContract = "INSERT INTO tblcontract(name, interest_rate, term_loan, created_day, note, user_id, client_id, partner_id) VALUES(?,?,?,?,?,?,?,?)";
        String sqlContractDetail = "INSERT INTO tblcontractdetail(price, quantity, product_id, contract_id) VALUES(?,?,?,?)";
        String sqlPaymentSchedule = "INSERT INTO tblpaymentschedule(payment_date, amount, remain_amount, contract_id) VALUES(?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        boolean result = true;
        try {
            // con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlContract, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contract.getName());
            ps.setFloat(2, contract.getInterestRate());
            ps.setString(3, contract.getTermLoan());
            ps.setString(4, contract.getCreatedDay().format(dtf));
            ps.setString(5, contract.getNote());
            ps.setInt(6, contract.getUser().getId());
            ps.setInt(7, contract.getClient().getId());
            ps.setInt(8, contract.getPartner().getId());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                contract.setId(generatedKeys.getInt(1));
                for (ContractDetail contractDetail : contract.getContractDetails()) {
                    ps = con.prepareStatement(sqlContractDetail);
                    ps.setFloat(1, contractDetail.getPrice());
                    ps.setInt(2, contractDetail.getQuantity());
                    ps.setInt(3, contractDetail.getProduct().getId());
                    ps.setInt(4, contract.getId());
                    ps.executeUpdate();
                }
                for (PaymentSchedule paymentSchedule : contract.getPaymentSchedules()) {
                    ps = con.prepareStatement(sqlPaymentSchedule);
                    ps.setString(1, new SimpleDateFormat("dd-MM-yyyy").format(paymentSchedule.getPaymentDate()));
                    ps.setFloat(2, paymentSchedule.getAmount());
                    ps.setFloat(3, paymentSchedule.getRemainAmount());
                    ps.setInt(4, contract.getId());
                    ps.executeUpdate();
                }
            }

            // con.commit();
        } catch (SQLException e) {
            result = false;
            try {
                con.rollback();
            } catch (SQLException ex) {
                result = false;
                e.printStackTrace();

            }
            e.printStackTrace();
        } finally {
            try {
                // con.setAutoCommit(true);
            } catch (Exception ex) {
                result = false;
                ex.printStackTrace();
            }
        }
        return result;
    }
}
