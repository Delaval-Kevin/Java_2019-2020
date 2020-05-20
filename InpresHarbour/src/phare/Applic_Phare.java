/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package phare;
import add.DialogLogin;
import beans.*;
import java.beans.Beans;
import java.io.IOException;
import network.NetworkBasicClient;
import javax.swing.DefaultListModel;


public class Applic_Phare extends javax.swing.JFrame 
{

    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private String _utilisateur;
    private DefaultListModel _bateauxEntrant;
    private NetworkBasicClient _client;
    private KindOfBoatBean _beanKindOfBoat;
    private BoatBean _beanBoat;
    private NotifyBean _beanNotify;
    private String _tmpType;
    private String _tmpPavillon;
    private String _tmpLongueur;
    private String _tmpNom;
    private String _reponse;

    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public Applic_Phare() 
    {
        initComponents();
        InitList();
        fctLogin();
        InitBeans();

        /* Si l'utilisateur ne se log pas on ferme la fenetre dans la foulée */
        if(!isConnected())
        {
            System.exit(0);
        }
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
    
    public NetworkBasicClient getClient()
    {
        return _client;
    }
    
    public DefaultListModel getBateauxEntrant()
    {
        return _bateauxEntrant;
    }    
    
    public KindOfBoatBean getBeanKindOfBoat()
    {
        return _beanKindOfBoat;
    }   
    
    public BoatBean getBeanBoat()
    {
        return _beanBoat;
    }    
    
    public NotifyBean getBeanNotify()
    {
        return _beanNotify;
    }  
    
    private String getTmpType()
    {
        return _tmpType;
    }
    
    private String getTmpPavillon()
    {
        return _tmpPavillon;
    }
    
    private String getTmpLongueur()
    {
        return _tmpLongueur;
    }
    
    private String getTmpNom()
    {
        return _tmpNom;
    }

    private String getReponse()
    {
        return _reponse;
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
    
    public void setClient(NetworkBasicClient client)
    {
        _client = client;
    }
    
    public void setBateauxEntrant(DefaultListModel bateauxEntrant)
    {
        _bateauxEntrant = bateauxEntrant;
    }
    
    public void setTitre()
    {
        this.setTitle("Phare d'entrée d'Inpres-Harbour : " + getUtilisateur());  
    }
    
    public void setBeanKindOfBoat(KindOfBoatBean bean)
    {
        _beanKindOfBoat = bean;
    } 
    
    public void setBeanBoat(BoatBean beanBoat)
    {
        _beanBoat = beanBoat;
    }    
    
    public void setBeanNotify(NotifyBean beanNotify)
    {
        _beanNotify = beanNotify;
    } 
    
    private void setTmpType(String tmpType)
    {
        _tmpType = tmpType;
    }
    
    private void setTmpPavillon(String tmpPavillon)
    {
        _tmpPavillon = tmpPavillon;
    }
    
    private void setTmpLongueur(String tmpLongueur)
    {
        _tmpLongueur = tmpLongueur;
    }
    
    private void setTmpNom(String tmpNom)
    {
        _tmpNom = tmpNom;
    }
    
    private void setReponse(String reponse)
    {
        _tmpNom = reponse;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    public boolean isConnected()
    {
        if(getUtilisateur() == null)
        {
            return false;
        }
        
        return true;
    }
    
    private void fctLogin()
    {
        this.setVisible(false);
        
        System.out.println("Creation de la boite dialogue de LOGIN - dans Applic_Phare\n");
        
        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à lieu d'avoir de connecion et déconnexion intempestives*/
        DialogLogin login = new DialogLogin(this, true);
        login.setVisible(true);
        
        if(login.getLoginValide())
        {
            setUtilisateur(login.getUtilisateur());
            setTitre();
        }
        
        this.setVisible(true);
        login.dispose();
    }
    
    private void InitList()
    {
        System.out.println("Creation et initialisation de la liste de marins DEFAULTLISTMODEL - dans Applic_Phare\n");
        
        setBateauxEntrant(new DefaultListModel());
       
        listBatEnAttente.setModel(getBateauxEntrant());
    }
    
    private void InitBeans()
    {
        InitKindOfBoat();
        InitBoat();
        InitNotify();
        /* pour envoyer un signal au BeanBoat quand la variable "info" change dans BeanKindOfBoat*/
        getBeanKindOfBoat().addPropertyChangeListener(getBeanBoat());
        getBeanBoat().addBoatListener(getBeanNotify());
    }
    
    private void InitKindOfBoat()
    {
        try 
        {    
            setBeanKindOfBoat((KindOfBoatBean)Beans.instantiate(null, "beans.KindOfBoatBean"));
        } 
        catch(ClassNotFoundException e) 
        {
            System.out.println("Classe KindOfBoatBean non trouvée");
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Erreur d'I/O : KindOfBoatBean !!!");
            System.exit(0);
        }
        
        //config du bean
        getBeanKindOfBoat().init();
        getBeanKindOfBoat().run();
    }
    
    private void InitBoat()
    {
        try 
        {    
            setBeanBoat((BoatBean)Beans.instantiate(null, "beans.BoatBean"));
        } 
        catch(ClassNotFoundException e) 
        {
            System.out.println("Classe BoatBean non trouvée");
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Erreur d'I/O : BoatBean !!!");
            System.exit(0);
        }   
        
    }
    
    private void InitNotify()
    {
        try 
        {    
            setBeanNotify((NotifyBean)Beans.instantiate(null, "beans.NotifyBean"));
        } 
        catch(ClassNotFoundException e) 
        {
            System.out.println("Classe NotifyBean non trouvée");
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Erreur d'I/O : NotifyBean!!!");
            System.exit(0);
        }    
        
        getBeanNotify().setBateauxEntrant(getBateauxEntrant());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImage = new javax.swing.JLabel();
        labelBatEnAttente = new javax.swing.JLabel();
        labelBatIdentif = new javax.swing.JLabel();
        labelCap = new javax.swing.JLabel();
        labelRepCap = new javax.swing.JLabel();
        labelBatEntre = new javax.swing.JLabel();
        textBoxBatIdent = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBatEnAttente = new javax.swing.JList();
        buttonConnexion = new javax.swing.JButton();
        buttonSuivant = new javax.swing.JButton();
        buttonDemAutEntree = new javax.swing.JButton();
        buttonBatEntreRade = new javax.swing.JButton();
        buttonRAZ = new javax.swing.JButton();
        buttonDeconexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phare/phare.jpg"))); // NOI18N

        labelBatEnAttente.setText("Bateaux en attente");

        labelBatIdentif.setText("Bateau identifié :");

        labelCap.setText("Réponse de la capitainerie :");

        labelRepCap.setText("??");

        labelBatEntre.setText("??");

        textBoxBatIdent.setEditable(false);
        textBoxBatIdent.setBackground(new java.awt.Color(0, 255, 102));
        textBoxBatIdent.setText("??");

        jScrollPane1.setViewportView(listBatEnAttente);

        buttonConnexion.setText("Se connecter au serveur");
        buttonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnexionActionPerformed(evt);
            }
        });

        buttonSuivant.setText("Suivant");
        buttonSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSuivantActionPerformed(evt);
            }
        });

        buttonDemAutEntree.setText("Demander autorisation entrée");
        buttonDemAutEntree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDemAutEntreeActionPerformed(evt);
            }
        });

        buttonBatEntreRade.setText("Bateau entré dans la rade");
        buttonBatEntreRade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatEntreRadeActionPerformed(evt);
            }
        });

        buttonRAZ.setText("RAZ");
        buttonRAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRAZActionPerformed(evt);
            }
        });

        buttonDeconexion.setText("Se déconnecter du serveur");
        buttonDeconexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeconexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelImage)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonConnexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(labelBatEnAttente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSuivant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonDeconexion)
                                    .addComponent(buttonRAZ))))
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCap)
                        .addGap(18, 18, 18)
                        .addComponent(labelRepCap, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBatIdentif)
                        .addGap(36, 36, 36)
                        .addComponent(textBoxBatIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonDemAutEntree)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBatEntreRade)
                        .addGap(18, 18, 18)
                        .addComponent(labelBatEntre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labelImage)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBatEnAttente)
                            .addComponent(buttonConnexion))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(buttonSuivant)))
                        .addGap(59, 59, 59)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBatIdentif)
                    .addComponent(textBoxBatIdent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(buttonDemAutEntree)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCap)
                    .addComponent(labelRepCap)
                    .addComponent(buttonRAZ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBatEntreRade)
                    .addComponent(buttonDeconexion)
                    .addComponent(labelBatEntre))
                .addGap(42, 42, 42))
        );

        labelBatEnAttente.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnexionActionPerformed
        setClient(new NetworkBasicClient("localhost", 50005));
        buttonConnexion.setEnabled(false);
    }//GEN-LAST:event_buttonConnexionActionPerformed

    private void buttonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuivantActionPerformed
        String[] parties = getBateauxEntrant().elementAt(0).toString().split("/");
        setTmpType(parties[0]);
        setTmpPavillon(parties[1]);
        
        System.out.println("Creation de la boite de dialogue IDENT BATEAU - dans Applic_Phare\n");
        DialogIdentBateau d = new DialogIdentBateau(this, true);
        
        d.setLabelType(getTmpType());
        d.setLabelPavillon(getTmpPavillon());
        d.setVisible(true);
        
        if(d.isFormValide())
        {
            setTmpLongueur(d.getTextLongueur());
            setTmpNom(d.getTextBoxNomBateau());
            textBoxBatIdent.setText(getTmpNom()+" / "+getTmpLongueur()+" m");
            buttonSuivant.setEnabled(false);
        }    
    }//GEN-LAST:event_buttonSuivantActionPerformed

    private void buttonDemAutEntreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDemAutEntreeActionPerformed
        setReponse(getClient().sendString(getTmpType()+"/"+getTmpPavillon()+"/"+getTmpNom()+"/"+getTmpLongueur())); 
        
        labelRepCap.setText(getReponse());
    }//GEN-LAST:event_buttonDemAutEntreeActionPerformed

    private void buttonBatEntreRadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatEntreRadeActionPerformed
        setReponse(getClient().sendString("Bateau "+getTmpNom()+" est bien entre dans la rade"));
        
        getBateauxEntrant().remove(0);
        
        labelBatEntre.setText(getReponse());
    }//GEN-LAST:event_buttonBatEntreRadeActionPerformed

    private void buttonRAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRAZActionPerformed
        labelBatEntre.setText("??");
        labelRepCap.setText("??");
        textBoxBatIdent.setText("??");
        setReponse("");
        setTmpPavillon("");
        setTmpLongueur("");
        setTmpNom("");
        setTmpType("");
    }//GEN-LAST:event_buttonRAZActionPerformed

    private void buttonDeconexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeconexionActionPerformed
        getClient().setEndSending();
        buttonConnexion.setEnabled(true);
    }//GEN-LAST:event_buttonDeconexionActionPerformed


    /**************************/
    /*                        */
    /*          MAIN          */
    /*                        */
    /**************************/
    
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
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Applic_Phare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Applic_Phare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatEntreRade;
    private javax.swing.JButton buttonConnexion;
    private javax.swing.JButton buttonDeconexion;
    private javax.swing.JButton buttonDemAutEntree;
    private javax.swing.JButton buttonRAZ;
    private javax.swing.JButton buttonSuivant;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBatEnAttente;
    private javax.swing.JLabel labelBatEntre;
    private javax.swing.JLabel labelBatIdentif;
    private javax.swing.JLabel labelCap;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelRepCap;
    private javax.swing.JList listBatEnAttente;
    private javax.swing.JTextField textBoxBatIdent;
    // End of variables declaration//GEN-END:variables
}
