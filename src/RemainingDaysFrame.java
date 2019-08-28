
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
import javax.swing.table.JTableHeader;



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
        JTableHeader header = informationsTable.getTableHeader();
        
        header.setFont(new Font("Tw Cen MT",Font.BOLD,18));
        header.setForeground(Color.red);
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
                model.addRow(rowData); //added to table
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
        jLabel3 = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        backLabel = new javax.swing.JLabel();

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
        informationsTable.setRowHeight(45);
        informationsTable.setSelectionBackground(new java.awt.Color(255, 153, 255));
        informationsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        informationsTable.setShowHorizontalLines(false);
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

        updateButton.setBackground(new java.awt.Color(51, 255, 0));
        updateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateButtonMouseExited(evt);
            }
        });
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
        messageLabel.setForeground(new java.awt.Color(51, 51, 255));

        deleteButton.setBackground(new java.awt.Color(255, 204, 0));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        quitButton.setBackground(new java.awt.Color(255, 204, 204));
        quitButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quitButton.setText("Exit");
        quitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quitButtonMouseExited(evt);
            }
        });
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_back_50px.png"))); // NOI18N
        backLabel.setMaximumSize(new java.awt.Dimension(50, 50));
        backLabel.setMinimumSize(new java.awt.Dimension(50, 50));
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)))
                                    .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


       
    
    private int selectedRow; //on informationsTable
    
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
                String examName = examNameField.getText().trim();
                String examDate = ((JTextField)dateChooser.getDateEditor()).getText().trim();
                
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

    ButtonOperations buttonOperations = new ButtonOperations();
    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        buttonOperations.buttonMouseEntered(deleteButton, deleteButton.getBackground());
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        buttonOperations.buttonMouseExited(deleteButton, Color.black);
    }//GEN-LAST:event_deleteButtonMouseExited

    private void updateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseEntered
        buttonOperations.buttonMouseEntered(updateButton, updateButton.getBackground());
    }//GEN-LAST:event_updateButtonMouseEntered

    private void updateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseExited
        buttonOperations.buttonMouseExited(updateButton, Color.black);
    }//GEN-LAST:event_updateButtonMouseExited

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void quitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseEntered
        buttonOperations.buttonMouseEntered(quitButton, quitButton.getBackground());
    }//GEN-LAST:event_quitButtonMouseEntered

    private void quitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseExited
        buttonOperations.buttonMouseExited(quitButton, Color.black);
    }//GEN-LAST:event_quitButtonMouseExited

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        setVisible(false);
        AddExamFrame addExamFrame = new AddExamFrame();
        addExamFrame.setVisible(true);
    }//GEN-LAST:event_backLabelMouseClicked

    private void backLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseEntered
        backLabel.setOpaque(true);
        backLabel.setBackground(new Color(204,204,255,255));
    }//GEN-LAST:event_backLabelMouseEntered

    private void backLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseExited
        backLabel.setBackground(Color.white);
        backLabel.setOpaque(false);
        
    }//GEN-LAST:event_backLabelMouseExited
    
    
    
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
    private javax.swing.JLabel backLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField examNameField;
    private javax.swing.JTable informationsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
