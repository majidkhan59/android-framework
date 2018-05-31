package android.framework.forms;

import java.awt.Color;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import android.framework.utilities.Constants;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JDialog; 
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author majidkhan
 */
public class frmColors extends JDialog implements ChangeListener {

    public frmColors() {
 
        //this.disableFormActionAbleComponents();
        //this.enableFormActionAbleComponents();
    }
    
     /**
     * Creates new form labelInput
     */
    public frmColors(JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        colorChooser.getSelectionModel().addChangeListener(this);
        txtHexButton.setEditable(false);
        
        cbHexButton.setSelected(true);
        cbHexTitleBar.setSelected(true);
        cbHexBackground.setSelected(true);
        
        map.put(cbHexButton, txtHexButton);
        map.put(cbHexTitleBar, txtHexTitleBar);
        map.put(cbHexBackground, txtHexBackground);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        colorChooser = new javax.swing.JColorChooser();
        jLabel4 = new javax.swing.JLabel();
        txtHexButton = new javax.swing.JTextField();
        cbHexButton = new javax.swing.JCheckBox();
        cbHexTitleBar = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtHexTitleBar = new javax.swing.JTextField();
        cbHexBackground = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtHexBackground = new javax.swing.JTextField();

        setTitle(Constants.TITLE+" User Preferences");
        setBackground(new java.awt.Color(Constants.RED,Constants.GREEN,Constants.BLUE));

        jLabel7.setBackground(new java.awt.Color(Constants.RED,Constants.GREEN,Constants.BLUE));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Theme Color Settings");

        jPanel2.setBackground(new java.awt.Color(Constants.RED,Constants.GREEN,Constants.BLUE));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(204, 0, 102));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnExit))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(Constants.RED,Constants.GREEN,Constants.BLUE));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Application Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        colorChooser.setBackground(new java.awt.Color(Constants.RED,Constants.GREEN,Constants.BLUE));
        colorChooser.setColor(new java.awt.Color(Constants.RED,Constants.GREEN,Constants.BLUE));
        colorChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                colorChooserMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Button:");

        txtHexButton.setEditable(false);
        txtHexButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        cbHexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHexButtonActionPerformed(evt);
            }
        });

        cbHexTitleBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHexTitleBarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Title Bar:");

        txtHexTitleBar.setEditable(false);
        txtHexTitleBar.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        cbHexBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHexBackgroundActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Background:");

        txtHexBackground.setEditable(false);
        txtHexBackground.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbHexButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(cbHexTitleBar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHexTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(cbHexBackground)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHexBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbHexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbHexTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHexTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbHexBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHexBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7)
                    .addContainerGap(432, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initializeApplication() {

        java.awt.EventQueue.invokeLater(() -> {
            new frmColors().setVisible(true);
        });
    }


    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        Constants.HEX_BUTTON = (txtHexButton.getText().trim());
        Constants.HEX_TITLE_BAR = (txtHexTitleBar.getText().trim());
        Constants.HEX_BACKGROUND = (txtHexBackground.getText().trim());

}//GEN-LAST:event_btnSaveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
}//GEN-LAST:event_btnExitActionPerformed

    private void cbHexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHexButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHexButtonActionPerformed

    private void cbHexTitleBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHexTitleBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHexTitleBarActionPerformed

    private void cbHexBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHexBackgroundActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHexBackgroundActionPerformed

    private void colorChooserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorChooserMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_colorChooserMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox cbHexBackground;
    private javax.swing.JCheckBox cbHexButton;
    private javax.swing.JCheckBox cbHexTitleBar;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtHexBackground;
    private javax.swing.JTextField txtHexButton;
    private javax.swing.JTextField txtHexTitleBar;
    // End of variables declaration//GEN-END:variables
    
    int red = 0;
    int green = 0;
    int blue = 0;
    String hex = "";
    
    HashMap<JCheckBox,JTextField> map = new HashMap<>();

    @Override
    public void stateChanged(ChangeEvent e) {
        
        

        Color color = colorChooser.getColor();
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        
        int count = 0;
        for(JCheckBox check : map.keySet()){
            if(!check.isSelected()){
                count++;
            }
        }
        
        if(count == 3){
            JOptionPane.showMessageDialog(this, "Error! Please select proper checkboxes.");
            //return;
        }
        
        //Convert RGB to HEX
        hex = String.format("#%02X%02X%02X", red, green, blue);
        //System.out.println("RED: " + red + " GREEN: " + green + " BLUE: " + blue + " -> HEX: " + hex);
        //txtHexButton.setText("" + hex);
        
        for(JCheckBox check : map.keySet()){
            if(check.isSelected()){
                JTextField textField = map.get(check);
                textField.setText(hex);
            }
        }

    }

}
