package view;

import model.Contract;
import model.PaymentSchedule;
import model.ContractDetail;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PaymentScheduleFrm extends JFrame {

    private Contract contract;
    private ArrayList<PaymentSchedule> listPaymentSchedule;
    private String typeTermLoan = "Day";

    public PaymentScheduleFrm(Contract contract) {
        super("Payment Schedule");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(400, 100);
        this.contract = contract;

        initComponents();

        menuTypeTermLoan.addItem("Day");
        menuTypeTermLoan.addItem("Month");
        menuTypeTermLoan.addItem("Year");
        menuTypeTermLoan.addItemListener((ItemEvent e) -> {
            if (e.getSource() == menuTypeTermLoan) {
                typeTermLoan = menuTypeTermLoan.getSelectedItem() + "";
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTermLoan = new javax.swing.JTextField();
        menuTypeTermLoan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtInterestRate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaymentSchedule = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setText("Payment Schedule");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Term Loan");

        txtTermLoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuTypeTermLoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Interest Rate");

        txtInterestRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("% / year");

        btnOk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        tblPaymentSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment Date", "Amount", "Remain", "Is Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPaymentSchedule);
        if (tblPaymentSchedule.getColumnModel().getColumnCount() > 0) {
            tblPaymentSchedule.getColumnModel().getColumn(3).setResizable(false);
        }

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTermLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(menuTypeTermLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTermLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(menuTypeTermLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        String log = "";
        if (txtTermLoan.getText().equals("")) {
            log += "Term loan field is empty.\n";
        }
        if (txtInterestRate.getText().equals("")) {
            log += "Interest rate field is empty.";
        }
        if (!log.equals("")) {
            JOptionPane.showMessageDialog(this, log);
            return;
        }
        listPaymentSchedule = new ArrayList<>();
        contract.setTermLoan(txtTermLoan.getText());
        contract.setInterestRate(Float.parseFloat(txtInterestRate.getText()));

        // get total cost of products       
        float totalAmount = 0;
        for (ContractDetail ctd : contract.getContractDetails()) {
            totalAmount += ctd.getPrice() * ctd.getQuantity();
        }

        // get total month of term loan       
        int num = Integer.parseInt(txtTermLoan.getText());
        int totalMonth = num;
        if (typeTermLoan.equals("Year")) {
            totalMonth = 12 * num;
        } else if (typeTermLoan.equals("Day")) {
            totalMonth = num / 30 + (num % 30 != 0 ? 1 : 0);
        }

        // put payment schedule of each month to list
        float amountEachMonth = totalAmount / totalMonth;
        float remain = totalAmount;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        LocalDate preDate = LocalDate.parse(contract.getCreatedDay().format(dtf), dtf);
        for (int i = 1; i <= totalMonth; i++) {
            PaymentSchedule paymentSchedule = new PaymentSchedule();
            paymentSchedule.setIsPaid(false);

            LocalDate nextDate = preDate.plusMonths(1);
            String nextDateFormatted = nextDate.format(dtf);
            try {
                paymentSchedule.setPaymentDate(df.parse(nextDateFormatted));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            preDate = nextDate;

            paymentSchedule.setAmount(amountEachMonth + remain * contract.getInterestRate() / 12 / 100);
            remain = (remain - amountEachMonth >= 0 ? remain - amountEachMonth : 0);
            paymentSchedule.setRemainAmount(remain);
            listPaymentSchedule.add(paymentSchedule);
            if (i == totalMonth && remain > 0) {
                totalMonth += 1;
                amountEachMonth = remain;
            }
        }

        // put list payment schedule to table 
        String[][] value = new String[listPaymentSchedule.size()][4];
        String[] columnNames = {"Payment Date", "Amount", "Remain", "Is Paid"};
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(true);
        for (int i = 0; i < listPaymentSchedule.size(); i++) {
            value[i][0] = new SimpleDateFormat("dd-MM-yyyy").format(listPaymentSchedule.get(i).getPaymentDate());
            float amount = (float) Math.ceil(listPaymentSchedule.get(i).getAmount());
            value[i][1] = nf.format(amount);
            float remainAmount = (float) Math.ceil(listPaymentSchedule.get(i).getRemainAmount());
            value[i][2] = nf.format(remainAmount);
            value[i][3] = listPaymentSchedule.get(i).getIsPaid() + "";
        }
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPaymentSchedule.setModel(tableModel);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (listPaymentSchedule.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter term loan, interest rate and click Ok.");
        } else {
            contract.setPaymentSchedules(listPaymentSchedule);
            (new ConfirmFrm(contract)).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> menuTypeTermLoan;
    private javax.swing.JTable tblPaymentSchedule;
    private javax.swing.JTextField txtInterestRate;
    private javax.swing.JTextField txtTermLoan;
    // End of variables declaration//GEN-END:variables
}
