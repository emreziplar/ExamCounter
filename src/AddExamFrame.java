
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddExamFrame extends javax.swing.JFrame {

    DatabaseOperations dbOperations = new DatabaseOperations();
   
    public AddExamFrame() {
        initComponents();
        
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        examNameField = new javax.swing.JTextField();
        addExamButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adding Exam ");
        setBounds(new java.awt.Rectangle(550, 300, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel2.setText("Exam Name :");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel3.setText("Exam Date   :");

        dateChooser.setDateFormatString("yyyy-MM-dd\n");

        addExamButton.setBackground(new java.awt.Color(255, 204, 255));
        addExamButton.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        addExamButton.setText("Add Exam");
        addExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(addExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    private void addExamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExamButtonActionPerformed
        String examName = examNameField.getText().trim();
        String date = ((JTextField)dateChooser.getDateEditor()).getText().trim();                
      
        if(isExamName()) 
        {
            if(!examName.equals("") && !date.equals(""))
            {
                dbOperations.addData(examName, date);  
                showJOptionPane();          
            }
            else 
                JOptionPane.showMessageDialog(this, "Fields can't be empty");      
        }
        else 
            JOptionPane.showMessageDialog(this, "This exam already exists");
    }//GEN-LAST:event_addExamButtonActionPerformed
        
    private boolean isExamName()
    {
        ArrayList<Data> dataList = new ArrayList<>();
        dataList = dbOperations.getData();
        
        if(dataList != null)
            for(Data c:dataList) 
            {
                if(c.getExamName().equals(examNameField.getText()))
                    return false;
            }
        
        return true;
    }
    private void showJOptionPane() 
    {         
        int optionType = JOptionPane.YES_NO_OPTION;
        int selected = JOptionPane.showConfirmDialog(this, "Do you want to continue adding exam?", "Exam Added", optionType);
                                                                         //message                   //title
        if(optionType != selected) { //if selected --> no
            setVisible(false);
            RemainingDaysFrame remainingDaysFrame = new RemainingDaysFrame();
            remainingDaysFrame.setVisible(true);
        }
        else {
            examNameField.setText("");
            ((JTextField)dateChooser.getDateEditor()).setText("");
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(AddExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddExamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddExamFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExamButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTextField examNameField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
