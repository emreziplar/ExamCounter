
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Font;
import java.time.Duration;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class RemainingDaysFrame extends javax.swing.JFrame{
    
    DatabaseOperations dbOperations = new DatabaseOperations();
    
    DefaultTableModel model;
    
    LocalDate date = LocalDate.now();    
            
    ArrayList<Data> dataList = new ArrayList<>(); 
    
    public RemainingDaysFrame() {
        initComponents();
        model = (DefaultTableModel) informationsTable.getModel();
       
        calculateDayDiff();
        sortDataList();
        
        JTextFieldDateEditor editor = (JTextFieldDateEditor)dateChooser.getDateEditor();
        editor.setEditable(false);
        
        editTableHeader();       
    }

   
    private void editTableHeader() {
        informationsTable.getTableHeader().setFont(new Font("Tw Cen MT",Font.BOLD,16));
        informationsTable.getTableHeader().setOpaque(false);
        informationsTable.getTableHeader().setBackground(Color.black);
        informationsTable.getTableHeader().setForeground(new Color(255,255,255));
    }
    
    private void calculateDayDiff() {
        ArrayList<Data> tempArrayList = new ArrayList<>();       
        tempArrayList = dbOperations.getData();           
                
        if(tempArrayList != null)
            for(Data d:tempArrayList) 
            {
                LocalDate d1 = LocalDate.parse(String.valueOf(date));
                LocalDate d2 = LocalDate.parse(d.getExamDate());
                
                Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
                long dayDiff = diff.toDays(); //remaining day               
               
                this.dataList.add(new Data(d.getExamName(),d.getExamDate(),dayDiff)); //for table                    
            }               
    }

    private void sortDataList() {
        Collections.sort(this.dataList); //sort remaining days from small to large    
        
        for(Data d:this.dataList) 
        {
            if(d.getDayDiff()>0)  
            {
                Object[] rowData = {d.getExamName(),d.getExamDate(),d.getDayDiff()+" Day"};
                model.addRow(rowData);
            }
            else //if day diff is less from 0 
               dbOperations.deleteData(d.getExamName()); 
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        informationsTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        examNameField = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        informationsTable.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        informationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Name", "Exam Date", "Remaining Day"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        informationsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        informationsTable.setGridColor(new java.awt.Color(0, 0, 0));
        informationsTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        informationsTable.setRowHeight(25);
        informationsTable.setSelectionBackground(new java.awt.Color(255, 153, 255));
        informationsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        informationsTable.setShowVerticalLines(false);
        informationsTable.getTableHeader().setReorderingAllowed(false);
        informationsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informationsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(informationsTable);
        if (informationsTable.getColumnModel().getColumnCount() > 0) {
            informationsTable.getColumnModel().getColumn(0).setResizable(false);
            informationsTable.getColumnModel().getColumn(1).setResizable(false);
            informationsTable.getColumnModel().getColumn(2).setResizable(false);
            informationsTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        dateChooser.setDateFormatString("yyyy-MM-dd\n");

        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel1.setText("Exam Name :");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel2.setText("Exam Date  :");

        messageLabel.setFont(new java.awt.Font("Source Sans Pro", 1, 18)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 0, 0));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


       
    private int selectedRow;
    
    private void informationsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informationsTableMouseClicked
        sendInformationsToField();
    }//GEN-LAST:event_informationsTableMouseClicked

    private void sendInformationsToField()
    {
        this.selectedRow = informationsTable.getSelectedRow();
        
        examNameField.setText(informationsTable.getValueAt(selectedRow, 0).toString());
        ((JTextField)dateChooser.getDateEditor()).setText(informationsTable.getValueAt(selectedRow, 1).toString());
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        this.selectedRow = selectedRow();
        
        if(!isRowSelected())
            messageForUnselectedRow();
        else 
        {
            if(!areFieldsEmpty())
            {
                String examName = (String)informationsTable.getValueAt(selectedRow, 0);
                dbOperations.deleteData(examName);
                
                messageLabel.setText("Exam successfully DELETED");                
                cleaning();
                
                calculateDayDiff(); 
                sortDataList();
            }
            else 
                JOptionPane.showMessageDialog(this, "Fields can not be empty!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private int selectedRow() {
        return informationsTable.getSelectedRow();        
    }
    
    private boolean isRowSelected() {
        //if no row is selected (-1) -- > return false;
        return this.selectedRow != -1; 
    }
    
    private void messageForUnselectedRow() {
        if(informationsTable.getRowCount() == 0) //if table is empty
            JOptionPane.showMessageDialog(this, "Table is empty");
        else 
            JOptionPane.showMessageDialog(this, "You must select a row!");           
    }
    
    private boolean areFieldsEmpty() {
        return !(!examNameField.getText().equals("") && !((JTextField)dateChooser.getDateEditor()).getText().equals(""));
    }
            
    private void cleaning() {
        model.setRowCount(0);
        dataList.clear();
        examNameField.setText("");
        ((JTextField)dateChooser.getDateEditor()).setText("");     
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        this.selectedRow = selectedRow();
        
        if(!isRowSelected())
            messageForUnselectedRow();
        else 
        {
            if(!areFieldsEmpty()) {
                String examName = examNameField.getText();
                String examDate = ((JTextField)dateChooser.getDateEditor()).getText();
                
                dbOperations.updateData(examName, examDate, informationsTable.getValueAt(selectedRow, 0).toString());
                                                                    //currentExamName
                messageLabel.setText("Exam successfully UPDATED");
                cleaning();
                
                calculateDayDiff();
                sortDataList();
            }
            else 
                JOptionPane.showMessageDialog(this, "Fields can not be empty!");
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RemainingDaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemainingDaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemainingDaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemainingDaysFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemainingDaysFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField examNameField;
    private javax.swing.JTable informationsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
