
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
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
        seeRemainingDaysButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adding Exam ");
        setBounds(new java.awt.Rectangle(550, 300, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel2.setText("Exam Name :");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 36)); // NOI18N
        jLabel3.setText("Exam Date   :");

        dateChooser.setDateFormatString("yyyy-MM-dd\n");

        addExamButton.setBackground(new java.awt.Color(0, 204, 204));
        addExamButton.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        addExamButton.setText("Add Exam");
        addExamButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addExamButton.setFocusable(false);
        addExamButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addExamButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addExamButtonMouseExited(evt);
            }
        });
        addExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExamButtonActionPerformed(evt);
            }
        });

        seeRemainingDaysButton.setBackground(new java.awt.Color(204, 204, 0));
        seeRemainingDaysButton.setFont(new java.awt.Font("Gisha", 1, 16)); // NOI18N
        seeRemainingDaysButton.setText("See Remaining Days");
        seeRemainingDaysButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seeRemainingDaysButton.setFocusable(false);
        seeRemainingDaysButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seeRemainingDaysButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seeRemainingDaysButtonMouseExited(evt);
            }
        });
        seeRemainingDaysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeRemainingDaysButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seeRemainingDaysButton)
                .addGap(18, 18, 18)
                .addComponent(addExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seeRemainingDaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
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
            
            try {
            if(!isExamName()) 
            {
                if(!examName.equals("") && !date.equals(""))
                {
                    dbOperations.createTable();
                    dbOperations.addData(examName, date);                                       
                    showJOptionPane();          
                }
                else 
                    JOptionPane.showMessageDialog(this, "Fields can't be empty");      
            }
            else 
                JOptionPane.showMessageDialog(this, "This exam already exists");
            }
            catch(NullPointerException ex) {                
                JOptionPane.showMessageDialog(this, "File named 'sqlite' not found on disk C");
                System.exit(0);
            }
                     
        
        
            
    }//GEN-LAST:event_addExamButtonActionPerformed

    private boolean isExamName()
    {
        ArrayList<Data> dataList = new ArrayList<>();
        dataList = dbOperations.getData();
        
        if(dataList != null)
            for(Data c:dataList) 
            {
                if(c.getExamName().equals(examNameField.getText()))
                    return true;
            }
        
        return false;
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
    
    private void seeRemainingDaysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeRemainingDaysButtonActionPerformed
       try{
        setVisible(false);
        dbOperations.createTable();
        RemainingDaysFrame remainingDaysFrame = new RemainingDaysFrame();
        remainingDaysFrame.setVisible(true);
       }
       catch(NullPointerException ex) {
           JOptionPane.showMessageDialog(this, "File named 'sqlite' not found on disk C");
           System.exit(0);
       }      
    }//GEN-LAST:event_seeRemainingDaysButtonActionPerformed

    
    ButtonOperations buttonOperations = new ButtonOperations();
    private void addExamButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addExamButtonMouseEntered
        buttonOperations.buttonMouseEntered(addExamButton, addExamButton.getBackground());
    }//GEN-LAST:event_addExamButtonMouseEntered

    private void addExamButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addExamButtonMouseExited
        buttonOperations.buttonMouseExited(addExamButton, Color.black);
    }//GEN-LAST:event_addExamButtonMouseExited

  
    private void seeRemainingDaysButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeRemainingDaysButtonMouseEntered
        buttonOperations.buttonMouseEntered(seeRemainingDaysButton, seeRemainingDaysButton.getBackground());
    }//GEN-LAST:event_seeRemainingDaysButtonMouseEntered

    private void seeRemainingDaysButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seeRemainingDaysButtonMouseExited
        buttonOperations.buttonMouseExited(seeRemainingDaysButton, Color.black);
    }//GEN-LAST:event_seeRemainingDaysButtonMouseExited

    
    
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
    private javax.swing.JButton seeRemainingDaysButton;
    // End of variables declaration//GEN-END:variables
}
