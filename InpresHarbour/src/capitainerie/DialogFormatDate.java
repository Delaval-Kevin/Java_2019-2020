/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;

import java.text.DateFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;


public class DialogFormatDate extends javax.swing.JDialog 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private boolean _validation;
    private Locale _fuseauPays;
    private int _formatDate;
    private int _formatHeure;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public DialogFormatDate(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setValidation(false);
        
        //Construction de la comboBox FuseauHoraire
        DefaultComboBoxModel dcbmPays = (DefaultComboBoxModel) this.comboBoxFuseauHoraire.getModel();
        dcbmPays.removeAllElements();
        dcbmPays.addElement("France");
        dcbmPays.addElement("Royaume Uni");
        dcbmPays.addElement("Allemagne");
        dcbmPays.addElement("Italie");
        dcbmPays.addElement("U.S.A.");
       
        //Construction de la comboBox FormatDate
        DefaultComboBoxModel dcbmDate = (DefaultComboBoxModel) this.comboBoxFormatDate.getModel();
        dcbmDate.removeAllElements();
        dcbmDate.addElement("Court");
        dcbmDate.addElement("Moyen");
        dcbmDate.addElement("Long");
        dcbmDate.addElement("Complet");
       
        //Construction de la comboBox FormatHeure
        DefaultComboBoxModel dcbmHeure = (DefaultComboBoxModel) this.comboBoxFormatHeure.getModel();
        dcbmHeure.removeAllElements();
        dcbmHeure.addElement("Court");
        dcbmHeure.addElement("Moyen");
        dcbmHeure.addElement("Long");
        dcbmHeure.addElement("Complet");
    }

    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public boolean getValidation()
    {
        return _validation;
    }
    
    public Locale getFuseauHoraire()
    {
        return _fuseauPays;
    }
     
    public int getFormatDate()
    {
        return _formatDate;
    }
    
    public int getFormatHeure()
    {
        return _formatHeure;
    }   
     
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setValidation(boolean validation)
    {
        _validation = validation;
    }
    
     public void setFuseauHoraire(Locale fuseauPays)
    {
        _fuseauPays = fuseauPays;
    }
     
    public void setFormatDate(int formatDate)
    {
        _formatDate = formatDate;
    }
    
    public void setFormatHeure(int formatHeure)
    {
        _formatHeure = formatHeure;
    }      
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupFuseau = new javax.swing.ButtonGroup();
        groupFormDate = new javax.swing.ButtonGroup();
        groupFormTemps = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonOK = new javax.swing.JButton();
        buttonAnnuler = new javax.swing.JButton();
        comboBoxFormatDate = new javax.swing.JComboBox();
        comboBoxFuseauHoraire = new javax.swing.JComboBox();
        comboBoxFormatHeure = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour : Format date");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Reglage du format de la date");

        jLabel2.setText("Choix du fuseau horaire :");

        jLabel3.setText("Choix du format de la date :");

        jLabel4.setText("Choix du format du temps :");

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        buttonAnnuler.setText("Annuler");
        buttonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulerActionPerformed(evt);
            }
        });

        comboBoxFuseauHoraire.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(buttonAnnuler))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxFuseauHoraire, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxFormatHeure, 0, 198, Short.MAX_VALUE)
                            .addComponent(comboBoxFormatDate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxFuseauHoraire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxFormatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxFormatHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(buttonAnnuler))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/   
    
    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        //pour set la valeur du choix de fuseau horaire
        switch(comboBoxFuseauHoraire.getSelectedItem().toString())
        {
            case "France" :
                setFuseauHoraire(Locale.FRANCE);
                break;
            case "Royaume Uni" :
                setFuseauHoraire(Locale.UK);
                break;
            case "Allemagne" :
                setFuseauHoraire(Locale.GERMAN);
                break;
            case "Italie" :
                setFuseauHoraire(Locale.ITALY);
                break;
            case "U.S.A.":
                setFuseauHoraire(Locale.US);
                break;
        }
        
        //pour set la valeur du choix du format de date
        switch(comboBoxFormatDate.getSelectedItem().toString())
        {
            case "Court" :
                setFormatDate(DateFormat.SHORT);
                break;
            case "Moyen" :
                setFormatDate(DateFormat.MEDIUM);
                break;
            case "Long" :
                setFormatDate(DateFormat.LONG);
                break;
            case "Complet" :
                setFormatDate(DateFormat.FULL);
                break;
        }
        
        //pour set la valeur du choix du format de l'heure
        switch(comboBoxFormatHeure.getSelectedItem().toString())
        {
            case "Court" :
                setFormatHeure(DateFormat.SHORT);
                break;
            case "Moyen" :
                setFormatHeure(DateFormat.MEDIUM);
                break;
            case "Long" :
                setFormatHeure(DateFormat.LONG);
                break;
            case "Complet" :
                setFormatHeure(DateFormat.FULL);
                break;  
        }
        setValidation(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonOKActionPerformed

    private void buttonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonAnnulerActionPerformed

    
    /**************************/
    /*                        */
    /*          MAIN          */
    /*                        */
    /**************************/
    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(DialogFormatDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogFormatDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogFormatDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogFormatDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                DialogFormatDate dialog = new DialogFormatDate(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnnuler;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox comboBoxFormatDate;
    private javax.swing.JComboBox comboBoxFormatHeure;
    private javax.swing.JComboBox comboBoxFuseauHoraire;
    private javax.swing.ButtonGroup groupFormDate;
    private javax.swing.ButtonGroup groupFormTemps;
    private javax.swing.ButtonGroup groupFuseau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
