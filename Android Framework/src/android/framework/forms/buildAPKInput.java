/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android.framework.forms;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author shoaibahmed
 */
public class buildAPKInput extends javax.swing.JDialog {

    String selectedTheme = "Black";
    String pressedButton = "Cancel";

    /**
     * Creates new form labelInput
     */
    public buildAPKInput(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public boolean okPressed() {
        return pressedButton.equals("Ok");
    }

    public String[] getValue() {
        return new String[]{appIconPath.getText(), keystorePath.getText(), keyAlias.getText(), keyPass.getText(), selectedTheme};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        themeGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        keystorePath = new javax.swing.JTextField();
        keyAlias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        browseBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        themeLight = new javax.swing.JRadioButton();
        themeDark = new javax.swing.JRadioButton();
        themeHolo = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        appIconPath = new javax.swing.JTextField();
        browseBTN1 = new javax.swing.JButton();
        keyPass = new javax.swing.JPasswordField();
        btnCustomColor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.title")); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        OkButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OkButton.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.OkButton.text")); // NOI18N
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CancelButton.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.CancelButton.text")); // NOI18N
        CancelButton.setPreferredSize(new java.awt.Dimension(75, 29));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.jLabel2.text")); // NOI18N

        keystorePath.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.keystorePath.text")); // NOI18N

        keyAlias.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.keyAlias.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.jLabel3.text")); // NOI18N

        browseBTN.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.browseBTN.text")); // NOI18N
        browseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBTNActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.jLabel4.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.jLabel5.text")); // NOI18N

        themeGroup.add(themeLight);
        themeLight.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.themeLight.text")); // NOI18N
        themeLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeLightActionPerformed(evt);
            }
        });

        themeGroup.add(themeDark);
        themeDark.setSelected(true);
        themeDark.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.themeDark.text")); // NOI18N
        themeDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeDarkActionPerformed(evt);
            }
        });

        themeGroup.add(themeHolo);
        themeHolo.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.themeHolo.text")); // NOI18N
        themeHolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeHoloActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.jLabel6.text")); // NOI18N

        appIconPath.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.appIconPath.text")); // NOI18N

        browseBTN1.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.browseBTN1.text")); // NOI18N
        browseBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBTN1ActionPerformed(evt);
            }
        });

        keyPass.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.keyPass.text")); // NOI18N

        btnCustomColor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCustomColor.setText(org.openide.util.NbBundle.getMessage(buildAPKInput.class, "buildAPKInput.btnCustomColor.text")); // NOI18N
        btnCustomColor.setPreferredSize(new java.awt.Dimension(75, 29));
        btnCustomColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(OkButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(themeDark)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(themeHolo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(themeLight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCustomColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(keystorePath)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(browseBTN))
                                        .addComponent(keyPass, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(keyAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appIconPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseBTN1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(appIconPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseBTN1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(keystorePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(keyAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(keyPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(themeLight)
                    .addComponent(themeHolo)
                    .addComponent(themeDark)
                    .addComponent(btnCustomColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        if (keystorePath.getText().isEmpty() || keyAlias.getText().isEmpty() || keyPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error! Please Input Keystore Information", "Keystore Information Missing", JOptionPane.ERROR_MESSAGE);
        } else {
            pressedButton = "Ok";
            this.dispose();
        }
    }//GEN-LAST:event_OkButtonActionPerformed

    private void themeDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeDarkActionPerformed
        this.selectedTheme = "Black";
    }//GEN-LAST:event_themeDarkActionPerformed

    private void themeHoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeHoloActionPerformed
        this.selectedTheme = "Holo";
    }//GEN-LAST:event_themeHoloActionPerformed

    private void themeLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeLightActionPerformed
        this.selectedTheme = "Light";
    }//GEN-LAST:event_themeLightActionPerformed

    private void browseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBTNActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose the keystore for signing APK file: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setMultiSelectionEnabled(false);
        FileFilter imageFilter = new FileNameExtensionFilter(
                "Keystore Files", new String[]{"keystore"});
        jfc.setFileFilter(imageFilter);
        jfc.setAcceptAllFileFilterUsed(false);

        int returnValue = jfc.showDialog(this, "Select");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().exists()) {
                keystorePath.setText(jfc.getSelectedFile().toString());
            }
        }
    }//GEN-LAST:event_browseBTNActionPerformed

    private void browseBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBTN1ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose the App Icon for APK file: ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setMultiSelectionEnabled(false);
        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());
        jfc.setFileFilter(imageFilter);

        int returnValue = jfc.showDialog(this, "Select");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().exists()) {
                appIconPath.setText(jfc.getSelectedFile().toString());
            }
        }
    }//GEN-LAST:event_browseBTN1ActionPerformed

    private void btnCustomColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomColorActionPerformed
        // TODO add your handling code here:
        frmColors form = new frmColors(this,true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        form.setLocation(screenSize.width / 3, screenSize.height / 3);
        form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        form.setVisible(true);
        //form.show();
    }//GEN-LAST:event_btnCustomColorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton OkButton;
    private javax.swing.JTextField appIconPath;
    private javax.swing.JButton browseBTN;
    private javax.swing.JButton browseBTN1;
    private javax.swing.JButton btnCustomColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField keyAlias;
    private javax.swing.JPasswordField keyPass;
    private javax.swing.JTextField keystorePath;
    private javax.swing.JRadioButton themeDark;
    private javax.swing.ButtonGroup themeGroup;
    private javax.swing.JRadioButton themeHolo;
    private javax.swing.JRadioButton themeLight;
    // End of variables declaration//GEN-END:variables
}
