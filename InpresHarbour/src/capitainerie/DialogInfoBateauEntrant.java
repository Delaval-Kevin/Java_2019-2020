/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;
import humain.Equipage;
import java.awt.Frame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import vehicules.Bateau;


public class DialogInfoBateauEntrant extends javax.swing.JDialog 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Bateau _bateau;

    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    //Constructeur par défaut
    public DialogInfoBateauEntrant(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //Constructeur d'initialisation
    public DialogInfoBateauEntrant(java.awt.Frame parent, boolean modal, Bateau bateau) 
    {
        this(parent, modal);
        setBateau(bateau);
        InitComboBox();
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public Bateau getBateau()
    {
        return _bateau;
    }
    
    public String getPortAttache()
    {
        return this.textBoxPortAttache.getText();
    }
    
    public int getTonnage()
    {
        return Integer.parseInt(this.textBoxTonnage.getText());
    }   
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/

    public void setBateau(Bateau bateau)
    {
        _bateau = bateau;
    }   
    
    public void setEmplacemet(String emp)
    {
        this.labelEmplacement.setText(emp);
    }
    
    public void setNomBateau(String Nom)
    {
        this.labelBateau.setText(Nom);
    }
    
    public void setPavillon(String pav)
    {
        this.labelImage.setIcon(new ImageIcon(getClass().getResource(pav)));
        //this.labelImage.repaint();
    }
    
    public void setPortAttache(String port)
    {
        this.textBoxPortAttache.setText(port);
    }
    
    public void setTonnage(int ton)
    {
        this.textBoxTonnage.setText(Integer.toString(ton));
    }
    
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    private void InitComboBox()
    {
        DefaultComboBoxModel dcbmEquipage = (DefaultComboBoxModel) this.comboBoxEquipage.getModel();
        dcbmEquipage.removeAllElements();
        
        if(getBateau().getEquipage().getCapitaine() != null)
        {
            dcbmEquipage.addElement(getBateau().getEquipage().getCapitaine());
        }
        if(getBateau().getEquipage().getSecond() != null)
        {
            dcbmEquipage.addElement(getBateau().getEquipage().getSecond());
        }
           
        getBateau().getEquipage().getMarins().forEach(m -> dcbmEquipage.addElement(m));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textBoxPortAttache = new javax.swing.JTextField();
        textBoxTonnage = new javax.swing.JTextField();
        buttonEquipage = new javax.swing.JButton();
        comboBoxEquipage = new javax.swing.JComboBox();
        buttonOK = new javax.swing.JButton();
        buttonAnnuler = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelEmplacement = new javax.swing.JLabel();
        labelBateau = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour : Informations sur bateau entrant");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Emplacement :");

        jLabel2.setText("Bateau :");

        jLabel3.setText("Pavillon :");

        jLabel4.setText("Port d'attache :");

        jLabel5.setText("Tonnage :");

        textBoxPortAttache.setText("??");

        textBoxTonnage.setText("??");

        buttonEquipage.setText("Equipage");
        buttonEquipage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEquipageActionPerformed(evt);
            }
        });

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

        labelEmplacement.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(buttonEquipage, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textBoxPortAttache)
                            .addComponent(textBoxTonnage)
                            .addComponent(comboBoxEquipage, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBateau)
                                    .addComponent(labelEmplacement)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(buttonAnnuler)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelEmplacement))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelBateau))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textBoxPortAttache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textBoxTonnage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEquipage)
                    .addComponent(comboBoxEquipage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(buttonAnnuler))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonEquipageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEquipageActionPerformed
        if(textBoxPortAttache.getText().length() > 0)
        {
            getBateau().setPortAttache(textBoxPortAttache.getText());
            
            System.out.println("Creation de la boite de dialogue ENREG EQUIPAGE - dans DialogInfoBateauEntrant\n");
            
            DialogEnregEquipage d = new DialogEnregEquipage((Frame)this.getParent(), true, getBateau());
            d.setVisible(true);
            
            InitComboBox();
        }
        else
        {
            System.out.println("Creation de la boite de dialogue ERREUR - dans DialogInfoBateauEntrant\n");
            
            DialogErreur d = new DialogErreur((Frame)this.getParent(), true, "Veuillez mettre le port d'attache !");
            d.setVisible(true); 
        }
    }//GEN-LAST:event_buttonEquipageActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        
        if(textBoxPortAttache.getText().length() > 0)
        {
            getBateau().setPortAttache(textBoxPortAttache.getText());
            this.setVisible(false);
        }
        else
        {
            System.out.println("Creation de la boite de dialogue ERREUR - dans DialogInfoBateauEntrant\n");
            
            DialogErreur d = new DialogErreur((Frame)this.getParent(), true, "Veuillez mettre le port d'attache !");
            d.setVisible(true);            
        }
        
    }//GEN-LAST:event_buttonOKActionPerformed
        
    private void buttonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_buttonAnnulerActionPerformed

    /**************************/
    /*                        */
    /*         EVENTS         */
    /*                        */
    /**************************/    
    
    //A l'activation de la page, les données seront mise a jour
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setNomBateau(getBateau().getNom());
        setPavillon(getBateau().getPavillon());

        setPortAttache(getBateau().getPortAttache());
        setTonnage(getBateau().getTonnage());
    }//GEN-LAST:event_formWindowActivated

    
    
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
            java.util.logging.Logger.getLogger(DialogInfoBateauEntrant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogInfoBateauEntrant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogInfoBateauEntrant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogInfoBateauEntrant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                DialogInfoBateauEntrant dialog = new DialogInfoBateauEntrant(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonEquipage;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox comboBoxEquipage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelBateau;
    private javax.swing.JLabel labelEmplacement;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField textBoxPortAttache;
    private javax.swing.JTextField textBoxTonnage;
    // End of variables declaration//GEN-END:variables
}
