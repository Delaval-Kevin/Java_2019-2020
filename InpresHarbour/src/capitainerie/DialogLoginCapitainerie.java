/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;
import java.awt.Frame;
import java.util.Hashtable;


public class DialogLoginCapitainerie extends javax.swing.JDialog 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private String _utilisateur;
    public static Hashtable repertoire;
    
    static
    {
        repertoire = new Hashtable();
        repertoire.put("Kevin", "test");
        repertoire.put("Samuel", "1234");
        repertoire.put("Loic", "ok");
        repertoire.put("Fabian", "azerty");
        repertoire.put("Bene", "ebene");
    }

    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public DialogLoginCapitainerie(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitre = new javax.swing.JLabel();
        labelNomUtil = new javax.swing.JLabel();
        labelMDP = new javax.swing.JLabel();
        buttonValider = new javax.swing.JButton();
        buttonAnnuler = new javax.swing.JButton();
        textBoxNomUtil = new javax.swing.JTextField();
        textBoxMDP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Capitainerie");

        labelTitre.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        labelTitre.setText("Bienvenue !");

        labelNomUtil.setText("Nom d'utilisateur :");

        labelMDP.setText("Mot de passe :");

        buttonValider.setText("Valider");
        buttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderActionPerformed(evt);
            }
        });

        buttonAnnuler.setText("Annuler");
        buttonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomUtil)
                            .addComponent(labelMDP))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textBoxMDP, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(textBoxNomUtil)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(buttonValider)
                        .addGap(77, 77, 77)
                        .addComponent(buttonAnnuler))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(labelTitre)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(labelTitre)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNomUtil)
                    .addComponent(textBoxNomUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMDP)
                    .addComponent(textBoxMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonValider)
                    .addComponent(buttonAnnuler))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderActionPerformed

        try
        {
            if(verifCompte())
            {
                setUtilisateur(this.textBoxNomUtil.getText());
                this.setVisible(false);
            }
        }
        catch (Exception exc)
        {
            DialogErreur d = new DialogErreur((Frame)this.getParent(), true, exc.getMessage());
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        }
    }//GEN-LAST:event_buttonValiderActionPerformed

    private void buttonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulerActionPerformed
        setUtilisateur(null);
        this.setVisible(false);
    }//GEN-LAST:event_buttonAnnulerActionPerformed

    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/

    public boolean verifCompte() throws LoginException
    {
        if(repertoire.containsKey(this.textBoxNomUtil.getText()) && repertoire.get(this.textBoxNomUtil.getText()).equals(this.textBoxMDP.getText()))
        {
            return true;
        }
        
        throw new LoginException("Erreur de login !!!");
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setUtilisateur(String utilisateur)
    {
        _utilisateur = utilisateur;
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public String getUtilisateur()
    {
        return _utilisateur;
    }
    
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
            java.util.logging.Logger.getLogger(DialogLoginCapitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogLoginCapitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogLoginCapitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogLoginCapitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                DialogLoginCapitainerie dialog = new DialogLoginCapitainerie(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonValider;
    private javax.swing.JLabel labelMDP;
    private javax.swing.JLabel labelNomUtil;
    private javax.swing.JLabel labelTitre;
    private javax.swing.JTextField textBoxMDP;
    private javax.swing.JTextField textBoxNomUtil;
    // End of variables declaration//GEN-END:variables
}
