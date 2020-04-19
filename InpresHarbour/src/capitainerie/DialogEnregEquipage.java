/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;
import humain.Marin;
import java.awt.Frame;
import humain.Equipage;
import vehicules.Bateau;
import javax.swing.DefaultListModel;
import humain.SailorWithoutIdentificationException;

public class DialogEnregEquipage extends javax.swing.JDialog
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Bateau _bateau;
    private DefaultListModel _listeMarins;
    private Equipage _equipageDeBase;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
 
    //Constructeur par défaut
    public DialogEnregEquipage(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Constructeur d'initialisation
    public DialogEnregEquipage(java.awt.Frame parent, boolean modal, Bateau bateau) 
    {
        this(parent, modal);
        setBateau(bateau);
        labelNomBateau.setText(getBateau().getNom() + " (" + getBateau().getPortAttache() + ")");
        InitList();
        InitEquipDeBase();
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
    
    public void setListeMarins(DefaultListModel listeMarins)
    {
        _listeMarins = listeMarins;
    }
    
    public void setEquipageDeBase(Equipage equipageDeBase)
    {
        _equipageDeBase = equipageDeBase;
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
    
    public DefaultListModel getListeMarins()
    {
        return _listeMarins;
    }
    
    public Equipage getEquipageDeBase()
    {
        return _equipageDeBase;
    }   
    
    private String getSelection()
    {
        if(this.radioCapitaine.isSelected())
        {
            return this.radioCapitaine.getText();
        }
        else if(this.radioSecond.isSelected())
        {
            return this.radioSecond.getText();
        }
        else if(this.radioMatelot.isSelected())
        {
            return this.radioMatelot.getText();
        }
        else if(this.radioBosco.isSelected())
        {
            return this.radioBosco.getText();
        }
        else
        {
            return this.radioPassager.getText();
        }
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/ 
    
    private void InitList()
    {
        System.out.println("Creation et initialisation de la liste de marins DEFAULTLISTMODEL - dans DialogEnregEquipage\n");
        
        setListeMarins(new DefaultListModel());
        
        if(getBateau().getEquipage().getCapitaine() != null)
        {
            getListeMarins().addElement(getBateau().getEquipage().getCapitaine());
        }
        if(getBateau().getEquipage().getSecond() != null)
        {
            getListeMarins().addElement(getBateau().getEquipage().getSecond());
        }
           
       getBateau().getEquipage().getMarins().forEach(m -> getListeMarins().addElement(m));
       
       listMarins.setModel(getListeMarins());
    }
   
    private void InitEquipDeBase()
    {
        System.out.println("Creation et initialisation de l'equipage de base EQUIPAGE - dans DialogEnregEquipage\n");
 
        setEquipageDeBase(new Equipage());
        
        if(getBateau().getEquipage().getCapitaine() != null)
        {
            System.out.println("Creation du capitaine de l'equipe de base MARIN - dans DialogEnregEquipage\n");
            
            getEquipageDeBase().setCapitaine(getBateau().getEquipage().getCapitaine());
        }
        if(getBateau().getEquipage().getSecond() != null)
        {
            System.out.println("Creation du second de l'equipe de base MARIN - dans DialogEnregEquipage\n");
            
            getEquipageDeBase().setSecond(getBateau().getEquipage().getSecond());
        }
        
        getBateau().getEquipage().getMarins().forEach(m -> getEquipageDeBase().AddMarins(m));
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFonction = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textBoxDateNaiss = new javax.swing.JTextField();
        textBoxPrenom = new javax.swing.JTextField();
        textBoxNom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMarins = new javax.swing.JList();
        radioBosco = new javax.swing.JRadioButton();
        radioCapitaine = new javax.swing.JRadioButton();
        radioSecond = new javax.swing.JRadioButton();
        radioMatelot = new javax.swing.JRadioButton();
        radioPassager = new javax.swing.JRadioButton();
        buttonOK = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonValEquip = new javax.swing.JButton();
        buttonAbandon = new javax.swing.JButton();
        labelNomBateau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour : Enregistrement d'un équipage");
        setResizable(false);

        jLabel1.setText("Bateau :");

        jLabel2.setText("Nom :");

        jLabel3.setText("Prénom :");

        jLabel4.setText("Date de naissance :");

        jScrollPane1.setViewportView(listMarins);

        buttonGroupFonction.add(radioBosco);
        radioBosco.setText("Bosco");

        buttonGroupFonction.add(radioCapitaine);
        radioCapitaine.setSelected(true);
        radioCapitaine.setText("Capitaine");

        buttonGroupFonction.add(radioSecond);
        radioSecond.setText("Second");

        buttonGroupFonction.add(radioMatelot);
        radioMatelot.setText("Matelot");

        buttonGroupFonction.add(radioPassager);
        radioPassager.setText("Passager");

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        buttonValEquip.setText("Valider équipage");
        buttonValEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValEquipActionPerformed(evt);
            }
        });

        buttonAbandon.setText("Abandonner");
        buttonAbandon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbandonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radioBosco)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioMatelot)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioPassager))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(radioCapitaine)
                                    .addGap(42, 42, 42)
                                    .addComponent(radioSecond))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(296, 296, 296)
                                    .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomBateau)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textBoxDateNaiss, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(textBoxPrenom)
                                            .addComponent(textBoxNom))
                                        .addGap(49, 49, 49)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(buttonValEquip)
                        .addGap(86, 86, 86)
                        .addComponent(buttonAbandon)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNomBateau))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textBoxNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textBoxPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textBoxDateNaiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCapitaine)
                    .addComponent(radioSecond))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBosco)
                    .addComponent(radioMatelot)
                    .addComponent(radioPassager))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonValEquip)
                    .addComponent(buttonAbandon))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        try 
        {
            System.out.println("Creation d'un nouveau MARIN - dans DialogEnregEquipage\n");
            
            Marin marin = new Marin(this.textBoxNom.getText(), this.textBoxPrenom.getText(), this.textBoxDateNaiss.getText(), getSelection());

            if(marin.getFonction().equals("Capitaine"))
            {
                if(getBateau().getEquipage().getCapitaine() == null)
                {
                    getBateau().getEquipage().setCapitaine(marin);
                }
                else
                {
                    throw new SailorWithoutIdentificationException("Il y a déjà un Capitaine !");                    
                }
            }
            else if(marin.getFonction().equals("Second"))
            {
                if(getBateau().getEquipage().getSecond()== null)
                {
                    getBateau().getEquipage().setSecond(marin);
                }
                else
                {
                    throw new SailorWithoutIdentificationException("Il y a déjà un Second !"); 
                }
            }
            else
            {
                getBateau().getEquipage().AddMarins(marin);
            }
            
            getListeMarins().addElement(marin);
            
            this.textBoxNom.setText(null);
            this.textBoxPrenom.setText(null);
            this.textBoxDateNaiss.setText(null);  
        } 
        catch (SailorWithoutIdentificationException exc) 
        {
            System.out.println("Creation de la boite de dialogue ERREUR - dans DialogEnregEquipage\n");
            
            DialogErreur d = new DialogErreur((Frame)this.getParent(), true, exc.getMessage());
            d.setVisible(true);
        }
        
    }//GEN-LAST:event_buttonOKActionPerformed

    private void buttonValEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValEquipActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_buttonValEquipActionPerformed

    private void buttonAbandonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbandonActionPerformed
        getBateau().setEquipage(getEquipageDeBase());
        this.setVisible(false);
    }//GEN-LAST:event_buttonAbandonActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(DialogEnregEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogEnregEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogEnregEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogEnregEquipage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                DialogEnregEquipage dialog = new DialogEnregEquipage(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonAbandon;
    private javax.swing.ButtonGroup buttonGroupFonction;
    private javax.swing.JButton buttonOK;
    private javax.swing.JButton buttonValEquip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelNomBateau;
    private javax.swing.JList listMarins;
    private javax.swing.JRadioButton radioBosco;
    private javax.swing.JRadioButton radioCapitaine;
    private javax.swing.JRadioButton radioMatelot;
    private javax.swing.JRadioButton radioPassager;
    private javax.swing.JRadioButton radioSecond;
    private javax.swing.JTextField textBoxDateNaiss;
    private javax.swing.JTextField textBoxNom;
    private javax.swing.JTextField textBoxPrenom;
    // End of variables declaration//GEN-END:variables
}
