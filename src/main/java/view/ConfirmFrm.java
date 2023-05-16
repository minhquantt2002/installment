package view;

import dao.ContractDAO;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Contract;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.Partner;
import model.ContractDetail;
import model.PaymentSchedule;

public class ConfirmFrm extends JFrame {

    private Contract contract;

    public ConfirmFrm(Contract contract) {
        super("Confirm");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(400, 100);
        this.contract = contract;

        initComponents();

        NumberFormat nf = NumberFormat.getNumberInstance();
        // put client to tbl
        Client client = contract.getClient();
        String[][] rowClient = new String[1][6];
        String[] columnClient = {"FullName", "Address", "Telephone", "IDCard", "Email", "Note"};
        rowClient[0][0] = client.getFullName();
        rowClient[0][1] = client.getAddress();
        rowClient[0][2] = client.getTel();
        rowClient[0][3] = client.getIdCard();
        rowClient[0][4] = client.getEmail();
        rowClient[0][5] = client.getNote();
        DefaultTableModel tblModelClient = new DefaultTableModel(rowClient, columnClient) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblClient.setModel(tblModelClient);
        // put partner to tbl
        Partner partner = contract.getPartner();
        String[][] rowPartner = new String[1][5];
        String[] columnPartner = {"Name", "Address", "Telephone", "Email", "Note"};
        rowPartner[0][0] = partner.getName();
        rowPartner[0][1] = partner.getAddress();
        rowPartner[0][2] = partner.getTel();
        rowPartner[0][3] = partner.getEmail();
        rowPartner[0][4] = partner.getNote();
        DefaultTableModel tblModelPartner = new DefaultTableModel(rowPartner, columnPartner) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPartner.setModel(tblModelPartner);
        // put products to tbl
        ArrayList<ContractDetail> listContractDetail = contract.getContractDetails();
        String[][] rowProduct = new String[listContractDetail.size()][4];
        String[] columnProduct = {"Name", "Price", "Description", "Quantity"};
        for (int i = 0; i < listContractDetail.size(); i++) {
            rowProduct[i][0] = listContractDetail.get(i).getProduct().getName();
            rowProduct[i][1] = nf.format(listContractDetail.get(i).getPrice());
            rowProduct[i][2] = listContractDetail.get(i).getProduct().getDescription();
            rowProduct[i][3] = listContractDetail.get(i).getQuantity() + "";
        }
        DefaultTableModel tblModelProduct = new DefaultTableModel(rowProduct, columnProduct) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProduct.setModel(tblModelProduct);
        // put products to tbl
        ArrayList<PaymentSchedule> listPaymentSchedule = contract.getPaymentSchedules();
        String[][] rowPaymentSchedule = new String[listPaymentSchedule.size()][4];
        String[] columnPaymentSchedule = {"Payment Date", "Amount", "Remain", "Is Paid"};
        for (int i = 0; i < listPaymentSchedule.size(); i++) {
            rowPaymentSchedule[i][0] = new SimpleDateFormat("dd-MM-yyyy").format(listPaymentSchedule.get(i).getPaymentDate());
            rowPaymentSchedule[i][1] = nf.format(listPaymentSchedule.get(i).getAmount());
            rowPaymentSchedule[i][2] = nf.format(listPaymentSchedule.get(i).getRemainAmount());
            rowPaymentSchedule[i][3] = listPaymentSchedule.get(i).getIsPaid() + "";
        }
        DefaultTableModel tblModelPaymentSchedule = new DefaultTableModel(rowPaymentSchedule, columnPaymentSchedule) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPaymentSchedule.setModel(tblModelPaymentSchedule);
        // put partner to tbl
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd:MM:yyyy");
        String[][] rowContract = new String[1][5];
        String[] columnContract = {"Name", "Interest Rate", "Term Loan", "Created Day", "Note"};
        contract.setName("Hop dong tra gop");

        rowContract[0][0] = contract.getName();
        rowContract[0][1] = contract.getInterestRate() + " %/year";
        rowContract[0][2] = contract.getTermLoan() + " month";
        rowContract[0][3] = contract.getCreatedDay().format(dtf);
        rowContract[0][4] = contract.getNote();
        DefaultTableModel tblModelContract = new DefaultTableModel(rowContract, columnContract) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return (column == 0 && row == 0) || (column == 4 && row == 0);
            }
        };
        tblContract.setModel(tblModelContract);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPartner = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblContract = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPaymentSchedule = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setText("Confirm");

        tblClient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FullName", "IDCard", "Address", "Telephone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClient);

        tblPartner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPartner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Telephone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPartner);

        tblContract.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblContract.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Interest Rate", "Term Loan", "Contracting Day", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblContract);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Description", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblProduct);

        tblPaymentSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment Date", "Amount", "Remain", "Is Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblPaymentSchedule);

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Client:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Partner:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Product:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Payment Schedule:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Contract: (enable change cell name and note)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirm))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        (new ContractHomeFrm(contract.getUser())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        contract.setName((String) tblContract.getModel().getValueAt(0, 0));
        contract.setNote((String) tblContract.getModel().getValueAt(0, 4));
        ContractDAO contractDAO = new ContractDAO();
        try {
            if (contractDAO.addContract(contract)) {
                JOptionPane.showMessageDialog(this, "The contract is succeffully created.");
                (new ContractHomeFrm(contract.getUser())).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "The contract is failure created.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnConfirmActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblClient;
    private javax.swing.JTable tblContract;
    private javax.swing.JTable tblPartner;
    private javax.swing.JTable tblPaymentSchedule;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
