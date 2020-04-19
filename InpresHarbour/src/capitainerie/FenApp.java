/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;
import amarrages.Amarrage;
import humain.Equipage;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import vehicules.Bateau;
import vehicules.Combustible;
import vehicules.ShipWithoutIdentificationException;


public class FenApp extends javax.swing.JFrame 
{
  
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private String _utilisateur;
    private DefaultListModel _amarrage;
    private Bateau _infoBateauEntrant;
    private String _infoDate;
    


    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public FenApp() 
    {
        initComponents();
        fctLogin();      
        formatageDate(DateFormat.MEDIUM , DateFormat.MEDIUM ,Locale.FRANCE);
        
        InitList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonDemarServ = new javax.swing.JButton();
        buttonLire = new javax.swing.JButton();
        buttonChoisir = new javax.swing.JButton();
        buttonEnvChoix = new javax.swing.JButton();
        buttonEnvConf = new javax.swing.JButton();
        buttonBateauAmar = new javax.swing.JButton();
        buttonArretServeur = new javax.swing.JButton();
        checkRequeteEnAtt = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        textBoxLecture = new javax.swing.JTextField();
        textBoxChoix = new javax.swing.JTextField();
        textBoxConfChoix = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelHeure = new javax.swing.JLabel();
        scrollPanelBateaux = new javax.swing.JScrollPane();
        listeBateaux = new javax.swing.JList();
        menuBar = new javax.swing.JMenuBar();
        menuUtil = new javax.swing.JMenu();
        menuItemLogin = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuItemNouveau = new javax.swing.JMenuItem();
        menuAmarrages = new javax.swing.JMenu();
        menuItemPlaisance = new javax.swing.JMenuItem();
        menuItemPeche = new javax.swing.JMenuItem();
        menuBateaux = new javax.swing.JMenu();
        menuItemListeComp = new javax.swing.JMenuItem();
        menuItemRechBateau = new javax.swing.JMenuItem();
        menuPersonnel = new javax.swing.JMenu();
        menuItemEquipBateau = new javax.swing.JMenuItem();
        menuItemRechMarin = new javax.swing.JMenuItem();
        menuParam = new javax.swing.JMenu();
        menuItemFormatDate = new javax.swing.JMenuItem();
        menuItemCheckFichLog = new javax.swing.JCheckBoxMenuItem();
        menuItemCheckDateHeure = new javax.swing.JCheckBoxMenuItem();
        menuAPropos = new javax.swing.JMenu();
        menuItemAuteur = new javax.swing.JMenuItem();
        menuItemAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour");

        buttonDemarServ.setText("Démarrer le serveur");
        buttonDemarServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDemarServActionPerformed(evt);
            }
        });

        buttonLire.setText("Lire");
        buttonLire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLireActionPerformed(evt);
            }
        });

        buttonChoisir.setText("Choisir");
        buttonChoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoisirActionPerformed(evt);
            }
        });

        buttonEnvChoix.setText("Envoyer choix");
        buttonEnvChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnvChoixActionPerformed(evt);
            }
        });

        buttonEnvConf.setText("Envoyer confirmation");
        buttonEnvConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnvConfActionPerformed(evt);
            }
        });

        buttonBateauAmar.setText("Bateau amarré");
        buttonBateauAmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBateauAmarActionPerformed(evt);
            }
        });

        buttonArretServeur.setText("Arrêter le serveur");
        buttonArretServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonArretServeurActionPerformed(evt);
            }
        });

        checkRequeteEnAtt.setText("Requête en attente");

        jLabel1.setText("Amarrage possible :");

        textBoxLecture.setBackground(new java.awt.Color(0, 255, 102));
        textBoxLecture.setForeground(new java.awt.Color(0, 0, 0));
        textBoxLecture.setText("??");

        textBoxChoix.setText("??");

        textBoxConfChoix.setText("???");

        jLabel2.setText("Bateaux en entrée");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capitainerie/voilier.jpeg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capitainerie/peche1.jpg"))); // NOI18N

        labelHeure.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelHeure.setToolTipText("");

        scrollPanelBateaux.setViewportView(listeBateaux);

        menuUtil.setText("Utilisateurs");

        menuItemLogin.setText("Login");
        menuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLoginActionPerformed(evt);
            }
        });
        menuUtil.add(menuItemLogin);

        menuItemLogout.setText("Logout");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        menuUtil.add(menuItemLogout);

        menuItemNouveau.setText("Nouveau");
        menuItemNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNouveauActionPerformed(evt);
            }
        });
        menuUtil.add(menuItemNouveau);

        menuBar.add(menuUtil);

        menuAmarrages.setText("Amarrages");

        menuItemPlaisance.setText("Plaisance");
        menuItemPlaisance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPlaisanceActionPerformed(evt);
            }
        });
        menuAmarrages.add(menuItemPlaisance);

        menuItemPeche.setText("Pêche");
        menuItemPeche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPecheActionPerformed(evt);
            }
        });
        menuAmarrages.add(menuItemPeche);

        menuBar.add(menuAmarrages);

        menuBateaux.setText("Bateaux");

        menuItemListeComp.setText("Liste complète");
        menuItemListeComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListeCompActionPerformed(evt);
            }
        });
        menuBateaux.add(menuItemListeComp);

        menuItemRechBateau.setText("Rechercher un bateau");
        menuItemRechBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRechBateauActionPerformed(evt);
            }
        });
        menuBateaux.add(menuItemRechBateau);

        menuBar.add(menuBateaux);

        menuPersonnel.setText("Personnel");

        menuItemEquipBateau.setText("Equipage d'un bateau");
        menuItemEquipBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEquipBateauActionPerformed(evt);
            }
        });
        menuPersonnel.add(menuItemEquipBateau);

        menuItemRechMarin.setText("Rechercher un marin");
        menuItemRechMarin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRechMarinActionPerformed(evt);
            }
        });
        menuPersonnel.add(menuItemRechMarin);

        menuBar.add(menuPersonnel);

        menuParam.setText("Paramètres");

        menuItemFormatDate.setText("Format date");
        menuItemFormatDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFormatDateActionPerformed(evt);
            }
        });
        menuParam.add(menuItemFormatDate);

        menuItemCheckFichLog.setText("Fichier log");
        menuItemCheckFichLog.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuItemCheckFichLogStateChanged(evt);
            }
        });
        menuParam.add(menuItemCheckFichLog);

        menuItemCheckDateHeure.setSelected(true);
        menuItemCheckDateHeure.setText("Affichage date-heure courante");
        menuItemCheckDateHeure.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuItemCheckDateHeureStateChanged(evt);
            }
        });
        menuParam.add(menuItemCheckDateHeure);

        menuBar.add(menuParam);

        menuAPropos.setText("A propos");

        menuItemAuteur.setText("Auteur");
        menuItemAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAuteurActionPerformed(evt);
            }
        });
        menuAPropos.add(menuItemAuteur);

        menuItemAide.setText("Aide");
        menuItemAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAideActionPerformed(evt);
            }
        });
        menuAPropos.add(menuItemAide);

        menuBar.add(menuAPropos);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkRequeteEnAtt)
                                .addGap(38, 38, 38)
                                .addComponent(buttonLire)
                                .addGap(28, 28, 28)
                                .addComponent(textBoxLecture))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonChoisir)
                                .addGap(12, 12, 12)
                                .addComponent(textBoxChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEnvChoix)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonDemarServ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHeure, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(textBoxConfChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonEnvConf))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scrollPanelBateaux, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonBateauAmar)
                                .addGap(220, 220, 220))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonArretServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(206, 206, 206)))))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(buttonDemarServ))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelHeure)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkRequeteEnAtt)
                    .addComponent(buttonLire)
                    .addComponent(textBoxLecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(buttonChoisir)
                    .addComponent(textBoxChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEnvChoix)
                    .addComponent(textBoxConfChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEnvConf))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPanelBateaux, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBateauAmar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonArretServeur)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setUtilisateur(String utilisateur)
    {
        _utilisateur = utilisateur;
    }
    
    public void setTitre()
    {
        if(isConnected())
        {    
            this.setTitle("Capitainerie d'Inpres-Harbour : " + getUtilisateur());
        }
        else
        {
            this.setTitle("Capitainerie d'Inpres-Harbour"); 
        }    
    }
    
    public void setAmarrages(DefaultListModel amarrage)
    {
        _amarrage = amarrage;
    }
    
    public void setInfoBateauEntrant(Bateau infoBateauEntrant)
    {
        _infoBateauEntrant = infoBateauEntrant;
    }
    
    public void setInfoDate(String infoDate)
    {
        _infoDate = infoDate;
    }
    
    public void setEnableAll(boolean choice)
    {
        setEnableMenu(choice);
        setEnableButton(choice);
        setEnableTextBox(choice);
    }
    
    public void setEnableMenu(boolean choice)
    {
        menuAmarrages.setEnabled(choice);
        menuBateaux.setEnabled(choice);
        menuPersonnel.setEnabled(choice);
        menuParam.setEnabled(choice);
    }
        
    public void setEnableButton(boolean choice)
    {
        buttonArretServeur.setEnabled(choice);
        buttonBateauAmar.setEnabled(choice);
        buttonChoisir.setEnabled(choice);
        buttonDemarServ.setEnabled(choice);
        buttonEnvChoix.setEnabled(choice);
        buttonEnvConf.setEnabled(choice);
        buttonLire.setEnabled(choice);
    }
        
    public void setEnableTextBox(boolean choice)
    {
        textBoxChoix.setEnabled(choice);
        textBoxConfChoix.setEnabled(choice);
        textBoxLecture.setEnabled(choice);
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
    
    public Bateau getInfoBateauEntrant()
    {
        return _infoBateauEntrant;
    }
    
    public String getInfoDate()
    {
        return _infoDate;
    }
    
    public DefaultListModel getAmarrages()
    {
        return _amarrage;
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
        
        System.out.println("Creation de la boite dialogue de LOGIN - dans FenApp\n");
        
        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à lieu d'avoir de connecion et déconnexion intempestives*/
        DialogLoginCapitainerie login = new DialogLoginCapitainerie(this, true);
        login.setVisible(true);
        
        if(login.getLoginValide())
        {
            setUtilisateur(login.getUtilisateur());
            setTitre();
            setEnableAll(true);
        }
        else
        {
            setEnableAll(false);
        }
        
        this.setVisible(true);
        login.dispose();
    }
    
    private void afficheErr(String msg)
    {
        System.out.println("Creation de la boite de dialogue ERREUR - dans FenApp\n");
        
        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à beaucoup d'erreurs à gérer*/
        DialogErreur d = new DialogErreur(this, true, msg); 
        d.setLocationRelativeTo(null);
        d.setVisible(true);         
        d.dispose();    
    }
    
    private void formatageDate(int date, int heure, Locale fuseau)
    {
        System.out.println("Creation de la DATE - dans FenApp\n");
        
        Date maintenant = new Date();
        setInfoDate(DateFormat.getDateTimeInstance(date, heure, fuseau).format(maintenant));
        labelHeure.setText(getInfoDate());
    }
    
    private void InitList()
    {
        System.out.println("Creation et initialisation de la liste de marins DEFAULTLISTMODEL - dans FenApp\n");
        
        setAmarrages(new DefaultListModel());
       
       listeBateaux.setModel(getAmarrages());
    }
    
    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonDemarServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDemarServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDemarServActionPerformed

    private void buttonLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLireActionPerformed

    private void buttonChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoisirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonChoisirActionPerformed

    private void buttonEnvChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvChoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEnvChoixActionPerformed

    private void buttonEnvConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEnvConfActionPerformed

    private void buttonBateauAmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBateauAmarActionPerformed
        if(textBoxLecture.getText().length() > 0 && textBoxChoix.getText().length() > 0)
        {
            System.out.println("Creation d'un objet BATEAU + EQUIPAGE - dans FenApp\n");
            
            setInfoBateauEntrant(new Bateau(textBoxLecture.getText(), "UK.jpg", 15, Combustible.kérosène, false, new Equipage()));
            
            System.out.println("Creation de la boite de dialogue INFO BATEAU ENTRANT - dans FenApp\n");
            
            DialogInfoBateauEntrant d = new DialogInfoBateauEntrant(this, true, getInfoBateauEntrant());           
            d.setEmplacemet(textBoxChoix.getText());
            d.setVisible(true);
            
             getAmarrages().addElement(getInfoBateauEntrant());
        }
        else
        {
            afficheErr("Les champs ne sont pas remplis");
        }
        
    }//GEN-LAST:event_buttonBateauAmarActionPerformed

    private void buttonArretServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArretServeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonArretServeurActionPerformed

    /**************************/
    /*                        */
    /*       ITEMS MENU       */
    /*                        */
    /**************************/
    
    private void menuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoginActionPerformed
        if(isConnected())
        {
            afficheErr("Vous êtes déjà connecté !");
        }
        else
        {
            fctLogin();
        }
    }//GEN-LAST:event_menuItemLoginActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        setUtilisateur(null);
        setTitre();
        setEnableAll(false);
    }//GEN-LAST:event_menuItemLogoutActionPerformed

    private void menuItemNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNouveauActionPerformed
        if(isConnected())
        {  
            System.out.println("Creation de la boite de dialogue NOUV LOGIN - dans FenApp\n");
            
            /*Je ne garde pas une référence de la fenêtre en global, car il n'y à beaucoup d'ajout à gérer*/
            DialogNouvLogin d = new DialogNouvLogin(this, true); 
            d.setLocationRelativeTo(null);
            d.setVisible(true);         
            d.dispose();
        }
        else
        {
            afficheErr("Vous n'êtes pas connecté !");
        }
    }//GEN-LAST:event_menuItemNouveauActionPerformed

    private void menuItemPlaisanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPlaisanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemPlaisanceActionPerformed

    private void menuItemPecheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPecheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemPecheActionPerformed

    private void menuItemListeCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListeCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemListeCompActionPerformed

    private void menuItemRechBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRechBateauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemRechBateauActionPerformed

    private void menuItemEquipBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEquipBateauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemEquipBateauActionPerformed

    private void menuItemRechMarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRechMarinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemRechMarinActionPerformed

    private void menuItemFormatDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFormatDateActionPerformed
        
        System.out.println("Creation de la boite de dialogue FORMAT DATE - dans FenApp\n");
        
        /*Je ne garde pas une référence de la fenêtre en global*/
        DialogFormatDate d = new DialogFormatDate(this, true); 
        d.setVisible(true);  
            
        if(d.getValidation())
        {
            formatageDate(d.getFormatDate(), d.getFormatHeure(), d.getFuseauHoraire());
        }

        d.dispose();
    }//GEN-LAST:event_menuItemFormatDateActionPerformed

    private void menuItemCheckFichLogStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuItemCheckFichLogStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemCheckFichLogStateChanged

    private void menuItemCheckDateHeureStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuItemCheckDateHeureStateChanged
        if(menuItemCheckDateHeure.isSelected())
        {
            labelHeure.setVisible(true);
        }
        else
        {
            labelHeure.setVisible(false);
        }
    }//GEN-LAST:event_menuItemCheckDateHeureStateChanged

    private void menuItemAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAuteurActionPerformed
        
        System.out.println("Creation de la boite de dialogue AUTEUR - dans FenApp\n");
        
        /*Je ne garde pas une référence de la fenêtre en global*/
        DialogAuteur d = new DialogAuteur(this, true); 
        d.setVisible(true);         
        d.dispose();
    }//GEN-LAST:event_menuItemAuteurActionPerformed

    private void menuItemAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAideActionPerformed
        
        System.out.println("Creation de la boite de dialogue AIDE - dans FenApp\n");
        
        /*Je ne garde pas une référence de la fenêtre en global*/
        DialogAide d = new DialogAide(this, true); 
        d.setVisible(true);         
        d.dispose();
    }//GEN-LAST:event_menuItemAideActionPerformed



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
            java.util.logging.Logger.getLogger(FenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new FenApp().setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonArretServeur;
    private javax.swing.JButton buttonBateauAmar;
    private javax.swing.JButton buttonChoisir;
    private javax.swing.JButton buttonDemarServ;
    private javax.swing.JButton buttonEnvChoix;
    private javax.swing.JButton buttonEnvConf;
    private javax.swing.JButton buttonLire;
    private javax.swing.JCheckBox checkRequeteEnAtt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelHeure;
    private javax.swing.JList listeBateaux;
    private javax.swing.JMenu menuAPropos;
    private javax.swing.JMenu menuAmarrages;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBateaux;
    private javax.swing.JMenuItem menuItemAide;
    private javax.swing.JMenuItem menuItemAuteur;
    private javax.swing.JCheckBoxMenuItem menuItemCheckDateHeure;
    private javax.swing.JCheckBoxMenuItem menuItemCheckFichLog;
    private javax.swing.JMenuItem menuItemEquipBateau;
    private javax.swing.JMenuItem menuItemFormatDate;
    private javax.swing.JMenuItem menuItemListeComp;
    private javax.swing.JMenuItem menuItemLogin;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemNouveau;
    private javax.swing.JMenuItem menuItemPeche;
    private javax.swing.JMenuItem menuItemPlaisance;
    private javax.swing.JMenuItem menuItemRechBateau;
    private javax.swing.JMenuItem menuItemRechMarin;
    private javax.swing.JMenu menuParam;
    private javax.swing.JMenu menuPersonnel;
    private javax.swing.JMenu menuUtil;
    private javax.swing.JScrollPane scrollPanelBateaux;
    private javax.swing.JTextField textBoxChoix;
    private javax.swing.JTextField textBoxConfChoix;
    private javax.swing.JTextField textBoxLecture;
    // End of variables declaration//GEN-END:variables
}
