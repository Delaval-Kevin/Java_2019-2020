/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;

import add.*;
import amarrages.Quai;
import java.util.Date;
import add.DialogLogin;
import java.util.Timer;
import add.DialogErreur;
import java.util.Locale;
import java.util.Vector;
import amarrages.Ponton;
import beans.ThreadBean;
import vehicules.Bateau;
import beans.DepartEvent;
import amarrages.Amarrage;
import beans.ReponseEvent;
import java.io.IOException;
import java.util.TimerTask;
import java.io.EOFException;
import beans.DepartListener;
import java.text.DateFormat;
import java.util.Enumeration;
import beans.ReponseListener;
import vehicules.BateauPeche;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import vehicules.BateauPlaisance;
import java.io.ObjectOutputStream;
import network.NetworkBasicServer;
import javax.swing.DefaultListModel;
import java.io.FileNotFoundException;
import amarrages.OddPontoonException;
import vehicules.MoyenDeTransportSurEau;



public class Applic_Capitainerie extends javax.swing.JFrame implements ReponseListener
{
    // <editor-fold defaultstate="collapsed" desc="Variables membres">
    
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private FichierLog _log;
    private String _utilisateur;
    private Parametres _parametres;
    private NetworkBasicServer _serveur;
    
    private Vector _departListeners;
    private Vector<Amarrage> _amarrage;
    private DefaultListModel _bateauEntrant;
    
    private String _infoDate;
    private Bateau _bateauSortant;
    private Bateau _infoBateauEntrant;
    
    private Timer _timer;
    private Locale _fuseau;
    private int _formatDate;
    private int _formatHeure;
    
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public Applic_Capitainerie() 
    {
        initComponents();
        /* récupère le fichier des paramètres */
        setParam(new Parametres());
        
        /* récupère le fichier log */
        setLog(new FichierLog(getParam().searchParam("capitainerieLog")));
        
        fctLogin();
        
        formatageDate(Integer.parseInt(getParam().searchParam("formatDate")), Integer.parseInt(getParam().searchParam("formatHeure")), getParam().stringToLocale(getParam().searchParam("fuseauHoraire")));
        InitTimer();
        InitList();
        
        setDepartListeners(new Vector());
        
        if(LoadAmarrage() == 0)
        {
            InitAmarrage();
        }
        
        LoadEntree();
    }

    //</editor-fold>
    
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        buttonConnexion = new javax.swing.JButton();
        textBoxDepart = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        labelDepart = new javax.swing.JLabel();
        buttonChoixBateau = new javax.swing.JButton();
        buttonSignalDepart = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textBoxRepPhare = new javax.swing.JTextField();
        buttonRAZ = new javax.swing.JButton();
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
        menuItemFichLog = new javax.swing.JMenuItem();
        menuItemCheckDateHeure = new javax.swing.JCheckBoxMenuItem();
        menuAPropos = new javax.swing.JMenu();
        menuItemAuteur = new javax.swing.JMenuItem();
        menuItemAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour");
        setResizable(false);

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

        textBoxLecture.setEditable(false);
        textBoxLecture.setBackground(new java.awt.Color(0, 255, 102));
        textBoxLecture.setForeground(new java.awt.Color(0, 0, 0));
        textBoxLecture.setText("??");

        textBoxChoix.setEditable(false);
        textBoxChoix.setText("??");

        textBoxConfChoix.setEditable(false);
        textBoxConfChoix.setText("???");

        jLabel2.setText("Bateaux en entrée");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capitainerie/voilier.jpeg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/capitainerie/peche1.jpg"))); // NOI18N

        labelHeure.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelHeure.setToolTipText("");

        scrollPanelBateaux.setViewportView(listeBateaux);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Départ des bateaux");

        buttonConnexion.setText("Connexion");
        buttonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnexionActionPerformed(evt);
            }
        });

        textBoxDepart.setEditable(false);

        jLabel6.setText("Bateau en partance :");

        labelDepart.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        buttonChoixBateau.setText("Choisir bateau");
        buttonChoixBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoixBateauActionPerformed(evt);
            }
        });

        buttonSignalDepart.setText("Signaler départ");
        buttonSignalDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignalDepartActionPerformed(evt);
            }
        });

        jLabel7.setText("Réponse du phare :");

        textBoxRepPhare.setEditable(false);

        buttonRAZ.setText("RAZ");
        buttonRAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRAZActionPerformed(evt);
            }
        });

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

        menuItemFichLog.setText("Fichier log");
        menuItemFichLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFichLogActionPerformed(evt);
            }
        });
        menuParam.add(menuItemFichLog);

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

        menuItemAuteur.setText("Auteurs");
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(buttonDemarServ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHeure, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(scrollPanelBateaux, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonBateauAmar)
                                                .addGap(176, 176, 176))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonArretServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(162, 162, 162))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(buttonEnvChoix)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textBoxConfChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonEnvConf))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonChoisir)
                                        .addGap(12, 12, 12)
                                        .addComponent(textBoxChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(checkRequeteEnAtt)
                                        .addGap(38, 38, 38)
                                        .addComponent(buttonLire)
                                        .addGap(28, 28, 28)
                                        .addComponent(textBoxLecture)))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(192, 192, 192)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDepart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSignalDepart, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonConnexion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonRAZ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(textBoxRepPhare)
                            .addComponent(textBoxDepart)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonChoixBateau)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jLabel5))
                        .addGap(140, 140, 140))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buttonDemarServ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(labelHeure)
                        .addGap(62, 62, 62)))
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
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(labelDepart)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(buttonChoixBateau))
                .addGap(18, 18, 18)
                .addComponent(textBoxDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSignalDepart)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(textBoxRepPhare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRAZ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonConnexion)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setUtilisateur(String utilisateur)
    {
        _utilisateur = utilisateur;
    }
    
    public void setServeur(NetworkBasicServer serveur)
    {
        _serveur = serveur;
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
    
    public void setAmarrages(Vector<Amarrage> amarrage)
    {
        _amarrage = amarrage;
    }
    
    public void setListeBateauEntrant(DefaultListModel bateauEntrant)
    {
        _bateauEntrant = bateauEntrant;
    }
    
    public void setInfoBateauEntrant(Bateau infoBateauEntrant)
    {
        _infoBateauEntrant = infoBateauEntrant;
    }
    
    public void setBateauSortant(Bateau bateauSortant)
    {
        _bateauSortant = bateauSortant;
    }
    
    public void setInfoDate(String infoDate)
    {
        _infoDate = infoDate;
    }
    
    public void setTimer(Timer timer)
    {
        _timer = timer;
    }
    
    public void setFuseaau(Locale fuseau)
    {
        _fuseau = fuseau;
    }

    public void setFormatHeure(int formatHeure)
    {
        _formatHeure = formatHeure;
    }
    
    public void setFormatDate(int formatDate)
    {
        _formatDate = formatDate;
    }
    
    public void setLog(FichierLog log)
    {
        _log = log;
    }

    public void setParam(Parametres param)
    {
        _parametres = param;
    }
    
    public void setDepartListeners(Vector departListeners)
    {
        _departListeners = departListeners;
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
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public String getUtilisateur()
    {
        return _utilisateur;
    }
    
    public NetworkBasicServer getServeur()
    {
        return _serveur;
    }
    
    public Bateau getInfoBateauEntrant()
    {
        return _infoBateauEntrant;
    }
    
    public Bateau getBateauSortant()
    {
        return _bateauSortant;
    }
    
    public String getInfoDate()
    {
        return _infoDate;
    }
    
    public Vector<Amarrage> getAmarrages()
    {
        return _amarrage;
    }
    
    public DefaultListModel getListeBateauEntrant()
    {
        return _bateauEntrant;
    }
  
    public Timer getTimer()
    {
        return _timer;
    }
    
    public Locale getFuseaau()
    {
        return _fuseau;
    }

    public int getFormatHeure()
    {
        return _formatHeure;
    }
    
    public int getFormatDate()
    {
       return _formatDate;
    }
    
    public FichierLog getLog()
    {
        return _log;
    }
    
    public Parametres getParam()
    {
        return _parametres;
    }
    
    public Vector getDepartListeners()
    {
        return _departListeners;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methodes">
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    private void InitList()
    {
        getLog().ecritLigne("Applic_Capitainerie", "Creation et initialisation de la liste de marins DEFAULTLISTMODEL");
        
        setListeBateauEntrant(new DefaultListModel());
        listeBateaux.setModel(getListeBateauEntrant());
    }
    
    private void InitAmarrage()
    {
        Vector<Amarrage> ams = new Vector<Amarrage>();
        try
        {
            ams.addElement(new Ponton(12));
            ams.addElement(new Ponton(18));
            ams.addElement(new Ponton(12));
            ams.addElement(new Quai(6));
            ams.addElement(new Quai(5));   
        }
        catch(OddPontoonException e)
        {
            afficheErr(e.getMessage());
        }
        setAmarrages(ams);
    }
    
    
    
    // permet de charger l'état du port lors du démarrage
    private int LoadAmarrage()
    {
        String rep = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        
        try
        {
            FileInputStream file = new FileInputStream(rep+sep+getParam().searchParam("fichierAmarrage"));
            ObjectInputStream ois = new ObjectInputStream(file);
            
            setAmarrages((Vector <Amarrage>) ois.readObject());
            return 1; 
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            getLog().ecritLigne("Applic_Capitainerie", "Attention, fichier port.dat n'est pas trouvé");      
        }
        catch(IOException iOException)
        {    
            getLog().ecritLigne("Applic_Capitainerie", "Erreur : " + iOException.getMessage());
        }
        catch(ClassNotFoundException classNotFoundException)
        {
           getLog().ecritLigne("Applic_Capitainerie", "Erreur classes non trouvée");
        }
        
        return 0;
    }
    
    // permet de sauvegarder l'état du port
    
    
    public void SaveAmarrage()
    {
        String rep = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        
        try
        {     
            FileOutputStream file = new FileOutputStream(rep+sep+getParam().searchParam("fichierAmarrage"));
            ObjectOutputStream oos = new ObjectOutputStream(file);
            
            oos.writeObject(getAmarrages());
        }
        catch(IOException iOException)
        {
            getLog().ecritLigne("Applic_Capitainerie", "iOException : "+iOException.getMessage());
        }
    }
    
    public void SaveEntree()
    {
        String rep = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        
        DefaultListModel dlm = (DefaultListModel) listeBateaux.getModel();
        
        try
        {     
            FileOutputStream file = new FileOutputStream(rep+sep+getParam().searchParam("fichierEntreeAmarrage"));
            ObjectOutputStream oos = new ObjectOutputStream(file);
            
            DefaultListModel elems = (DefaultListModel) listeBateaux.getModel();
            
            Enumeration enu = elems.elements();
                
            while(enu.hasMoreElements())
            {
                oos.writeObject(enu.nextElement());
            }    
        }
        catch(IOException iOException)
        {
            getLog().ecritLigne("Applic_Capitainerie", "iOException : "+iOException.getMessage());
        }
    }
    
    private int LoadEntree()
    {
        String rep = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        
        try
        {
            FileInputStream file = new FileInputStream(rep+sep+getParam().searchParam("fichierEntreeAmarrage"));
            ObjectInputStream ois = new ObjectInputStream(file);
            
            DefaultListModel elems = getListeBateauEntrant();
                
            try
            {
                while(true)
                {
                    elems.addElement(ois.readObject());
                }
            }
            catch(EOFException e)
            {
                listeBateaux.setModel(elems);
            }
            return 1; 
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            getLog().ecritLigne("Applic_Capitainerie", "Attention, fichier port.dat n'est pas trouvé");      
        }
        catch(IOException iOException)
        {    
            getLog().ecritLigne("Applic_Capitainerie", "Erreur : " + iOException.getMessage());
        }
        catch(ClassNotFoundException classNotFoundException)
        {
           getLog().ecritLigne("Applic_Capitainerie", "Erreur classes non trouvée");
        }
        return 0;
    }
    
    public boolean isConnected()
    {
        if(getUtilisateur() == null)
        {
            return false;
        }
        return true;
    }
    
    //crée le thread qui fera l'affichage de l'heure toutes les secondes
    private void InitTimer()
    {
        setTimer(new Timer());
        TimerTask task = new TimerTask()
        {
            @Override
            public
            void run()
            {
                afficheHeure();
            }
        };
        getTimer().schedule(task,0, 1*1000);
    }
    
    private void fctLogin()
    {
        this.setVisible(false);
        
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite dialogue de LOGIN");

        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à lieu d'avoir de connecion et déconnexion intempestives*/
        DialogLogin login = new DialogLogin(this, true);
        login.setVisible(true);
        
        if(login.getLoginValide())
        {
            setUtilisateur(login.getUtilisateur());
            setTitre();
            setEnableAll(true);
            getLog().ecritLigne("Applic_Capitainerie", "Connexion de : "+getUtilisateur());
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
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue ERREUR");
        
        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à beaucoup d'erreurs à gérer*/
        DialogErreur d = new DialogErreur(this, true, msg); 
        d.setLocationRelativeTo(null);
        d.setVisible(true);         
        d.dispose();    
    }
    
    private void formatageDate(int date, int heure, Locale fuseau)
    {
        getLog().ecritLigne("Applic_Capitainerie", "Formatage de la DATE");

        setFormatDate(date);
        setFormatHeure(heure);
        setFuseaau(fuseau);
        afficheHeure();
    }
    
    private void afficheHeure()
    {   
        Date maintenant = new Date();
        setInfoDate(DateFormat.getDateTimeInstance(getFormatDate(), getFormatHeure(), getFuseaau()).format(maintenant));
        labelHeure.setText(getInfoDate());
    }
    
    private String getAmarrageBateau(Bateau bateau)
    {
        Enumeration enu = _amarrage.elements();
        
        int iAm = 0;
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(am instanceof Ponton)
            {
                for(int i = 1; i <= 2; i++)
                {
                    MoyenDeTransportSurEau[] mte = ((Ponton) am).getListe(i);
                    
                    for(int j = 0; j < mte.length; j++)
                    {
                        if(bateau == mte[j])
                        {
                            return "P" + iAm + i + "*" + j;
                        }
                    }
                }   
            }
            else if(am instanceof Quai)
            {
                MoyenDeTransportSurEau[] mte = ((Quai) am).getListe();

                for(int j = 0; j < mte.length; j++)
                {
                    if(bateau == mte[j])
                    {
                        return "Q" + iAm + "0" + "*" + j;
                    }
                }
            }    
        }
        return "???*?";
    }
    
    public void notifyDepartDetected()
    {
        getLog().ecritLigne("Applic_Capitainerie", "notifyDepartDetected");
        DepartEvent e = new DepartEvent(this); //On génère l'événement
        e.setDepart(getBateauSortant().getNom());
        
        getLog().ecritLigne("Applic_Capitainerie", "envoie d'un DepartEvent");
        int n = getDepartListeners().size();
        for(int i = 0 ; i < n ; i++)
        {
            DepartListener obj = (DepartListener) getDepartListeners().elementAt(i);
            obj.DepartDetected(e);
        }
    }
    
    public void addDepartListener(DepartListener dl)
    {
        getLog().ecritLigne("Applic_Capitainerie", "addDepartListener");
        if(!getDepartListeners().contains(dl))
        {
            getDepartListeners().addElement(dl);
        }
    }
    
    public void removeBoatListener(DepartListener dl)
    {
        getLog().ecritLigne("Applic_Capitainerie", "removeBoatListener");
        if(getDepartListeners().contains(dl))
        {
            getDepartListeners().removeElement(dl);
        }        
    }
    
    @Override
    public void ReponseDetected(ReponseEvent e) 
    {
        textBoxRepPhare.setText(e.getReponse());
        labelDepart.setText("Le dernier bateau est parti le : "+getInfoDate());
        
        getLog().ecritLigne("Applic_Capitainerie", "Bateau parti");
        
        Bateau bateau = getBateauSortant();
        
        Enumeration enu = _amarrage.elements();
        
        int iAm = 0;
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(am instanceof Ponton)
            {
                for(int i = 1; i <= 2; i++)
                {
                    MoyenDeTransportSurEau[] mte = ((Ponton) am).getListe(i);
                    
                    for(int j = 0; j < mte.length; j++)
                    {
                        if(bateau == mte[j])
                        {
                            mte[j] = null;
                        }
                    } 
                }
            }
            else if(am instanceof Quai)
            {
                MoyenDeTransportSurEau[] mte = ((Quai) am).getListe();

                for(int j = 0; j < mte.length; j++)
                {
                    if(bateau == mte[j])
                    {
                        mte[j] = null;
                    }
                }
            }    
        }
        SaveAmarrage();
        setBateauSortant(null);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Boutons 1">
    
    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonDemarServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDemarServActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Démarrage du serveur");
        
        setServeur(new NetworkBasicServer(Integer.parseInt(getParam().searchParam("portEcoute1")),checkRequeteEnAtt));
        buttonDemarServ.setEnabled(false);
    }//GEN-LAST:event_buttonDemarServActionPerformed

    private void buttonLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLireActionPerformed
        
        if(checkRequeteEnAtt.isSelected())
        {
            getLog().ecritLigne("Applic_Capitainerie", "Lecture d'un message");
            
            String[] infos = getServeur().getMessage().split("/");
            
            switch (infos[0])
            {
                case "1":
                    if(infos[1].compareTo("Peche") == 0)
                    {
                        setInfoBateauEntrant(new BateauPeche());
                    }
                    else if(infos[1].compareTo("Plaisance") == 0)
                    {
                        setInfoBateauEntrant(new BateauPlaisance());
                    }
                    else
                    {
                        getLog().ecritLigne("Applic_Capitainerie", "Erreur, bateau de type '"+infos[1]+"' reçu !?");
                    }
                    getLog().ecritLigne("Applic_Capitainerie", "type '"+ getInfoBateauEntrant().getClass());
                    getInfoBateauEntrant().setPavillon(infos[2]);
                    getInfoBateauEntrant().setNom(infos[3]);
                    getInfoBateauEntrant().setLongueur(Integer.parseInt(infos[4]));
                    textBoxLecture.setText(getInfoBateauEntrant().getNom()+" / "+getInfoBateauEntrant().getLongueur()+" m");
                    break;
                    
                case "2":
                    textBoxLecture.setText(infos[1]);
                    textBoxConfChoix.setText(getInfoBateauEntrant().getNom()+" --> "+textBoxChoix.getText());
                    break;
            }
        }
    }//GEN-LAST:event_buttonLireActionPerformed

    private void buttonChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoisirActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de DIALOGPLACESDISPO");
        
        DialogPlacesDispo pd = new DialogPlacesDispo(this, true, getAmarrages(), getInfoBateauEntrant());
        pd.setVisible(true);
        textBoxChoix.setText(pd.getChoixFinal());
    }//GEN-LAST:event_buttonChoisirActionPerformed

    private void buttonEnvChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvChoixActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Envoie du choix d'amarrage");
        
        getServeur().sendMessage(textBoxChoix.getText());
    }//GEN-LAST:event_buttonEnvChoixActionPerformed

    private void buttonEnvConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvConfActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Envoie confirmation du choix d'amarrage");
        getListeBateauEntrant().addElement(getInfoBateauEntrant());
        getServeur().sendMessage(textBoxConfChoix.getText());
        
        String emplacement = textBoxChoix.getText();
        int index = Integer.parseInt(String.valueOf(emplacement.charAt(1)));
        int slot_in = Integer.parseInt(String.valueOf(emplacement.charAt(4)));

        if(getInfoBateauEntrant() instanceof BateauPlaisance)
        {
            int slot = Integer.parseInt(String.valueOf(emplacement.charAt(2)));

            Ponton ponton = (Ponton) getAmarrages().elementAt(index-1);
            ponton.addMoyenDeTransportSurEau(getInfoBateauEntrant(), slot, slot_in-1);
        }
        else if(getInfoBateauEntrant() instanceof BateauPeche)
        {  
            Quai quai = (Quai) getAmarrages().elementAt(index-1);
            quai.addMoyenDeTransportSurEau(getInfoBateauEntrant(), slot_in-1);      
        }
        SaveAmarrage();
        SaveEntree();
        
    }//GEN-LAST:event_buttonEnvConfActionPerformed

    private void buttonBateauAmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBateauAmarActionPerformed
        if(textBoxLecture.getText().length() > 0 && textBoxChoix.getText().length() > 0)
        {                        
            getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue INFO BATEAU ENTRANT");
            setInfoBateauEntrant((Bateau) ((DefaultListModel) listeBateaux.getModel()).getElementAt(0));
            DialogInfoBateauEntrant d = new DialogInfoBateauEntrant(this, true, getInfoBateauEntrant());
            
            d.setEmplacemet(getAmarrageBateau(getInfoBateauEntrant()));
            d.setVisible(true);
            
            if(d._confirme)
            {
                ((DefaultListModel) listeBateaux.getModel()).removeElementAt(0);
                SaveEntree();
            }
        }
        else
        {
            afficheErr("Les champs ne sont pas remplis");
        }
    }//GEN-LAST:event_buttonBateauAmarActionPerformed

    private void buttonArretServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonArretServeurActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Arret du serveur");
       
        buttonDemarServ.setEnabled(true);
        getServeur().setEndReceiving();
    }//GEN-LAST:event_buttonArretServeurActionPerformed

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Menu Items">
    
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
            getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue NOUV LOGIN");
            
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
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue BATEAUX DE PLAISANCE");
      
        DialogPlacesDispo dpd = new DialogPlacesDispo(this, true, getAmarrages(), new BateauPlaisance());
        dpd.setVisible(true);  
    }//GEN-LAST:event_menuItemPlaisanceActionPerformed

    private void menuItemPecheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPecheActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue BATEAUX DE PECHE");         
       
        DialogPlacesDispo dpd = new DialogPlacesDispo(this, true, getAmarrages(), new BateauPeche());
        dpd.setVisible(true);
    }//GEN-LAST:event_menuItemPecheActionPerformed

    private void menuItemListeCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListeCompActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue LISTE BATEAUX");
        
        DialogListeCompleteBateaux d = new DialogListeCompleteBateaux(this, true, getAmarrages(), 0);
        d.setVisible(true);
    }//GEN-LAST:event_menuItemListeCompActionPerformed

    private void menuItemRechBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRechBateauActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue RECHERCHE BATEAUX");
        
        DialogListeCompleteBateaux d = new DialogListeCompleteBateaux(this, true, getAmarrages(), 1);
        d.setVisible(true);
    }//GEN-LAST:event_menuItemRechBateauActionPerformed

    private void menuItemEquipBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEquipBateauActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue EQUIPAGE BATEAU");
       
        DialogPersonnelBateau dpb = new DialogPersonnelBateau(this, true, getAmarrages(), false);
        dpb.setVisible(true);
    }//GEN-LAST:event_menuItemEquipBateauActionPerformed

    private void menuItemRechMarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRechMarinActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue RECHERCHE MARIN");
       
        DialogPersonnelBateau dpb = new DialogPersonnelBateau(this, true, getAmarrages(), true);
        dpb.setVisible(true);
    }//GEN-LAST:event_menuItemRechMarinActionPerformed

    private void menuItemFormatDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFormatDateActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue FORMAT DATE");
        
        /*Je ne garde pas une référence de la fenêtre en global*/
        DialogFormatDate d = new DialogFormatDate(this, true); 
        d.setVisible(true);  
            
        if(d.getValidation())
        {
            formatageDate(d.getFormatDate(), d.getFormatHeure(), d.getFuseauHoraire());
            getParam().ChangeProperty("formatDate", Integer.toString(d.getFormatDate()));
            getParam().ChangeProperty("formatHeure", Integer.toString(d.getFormatHeure()));
            getParam().ChangeProperty("fuseauHoraire", getParam().localeToString(d.getFuseauHoraire()));
        }
        d.dispose();
    }//GEN-LAST:event_menuItemFormatDateActionPerformed

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
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue AUTEURS");
        
        /*Je ne garde pas une référence de la fenêtre en global*/
        DialogAuteur d = new DialogAuteur(this, true); 
        d.setVisible(true);         
        d.dispose();
    }//GEN-LAST:event_menuItemAuteurActionPerformed

    private void menuItemAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAideActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue AIDE");
        
        /*Je ne garde pas une référence de la fenêtre en global*/
        DialogAide d = new DialogAide(this, true); 
        d.setVisible(true);         
        d.dispose();
    }//GEN-LAST:event_menuItemAideActionPerformed

    private void menuItemFichLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFichLogActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue FICHIER LOG");
          
        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à beaucoup d'ajout à gérer*/
        DialogFichierLog d = new DialogFichierLog(this, true, getParam()); 
        d.setLocationRelativeTo(null);
        d.setVisible(true);      
        d.dispose();    
    }//GEN-LAST:event_menuItemFichLogActionPerformed

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Boutons 2">
    
    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnexionActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation du thread pour les départs");

        //Creation du thread qui va ce connecté au serveur      
        ThreadBean thread = new ThreadBean(Integer.parseInt(getParam().searchParam("portEcoute2")), this);
        thread.init();
        
        thread.addReponseListener(this);
        
        thread.start();
        
        buttonConnexion.setEnabled(false);
    }//GEN-LAST:event_buttonConnexionActionPerformed

    private void buttonSignalDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSignalDepartActionPerformed
        notifyDepartDetected();
    }//GEN-LAST:event_buttonSignalDepartActionPerformed

    private void buttonChoixBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoixBateauActionPerformed
        getLog().ecritLigne("Applic_Capitainerie", "Creation de la boite de dialogue LISTE BATEAUX");
        
        DialogListeCompleteBateaux d = new DialogListeCompleteBateaux(this, true, getAmarrages(), 2);
        d.setVisible(true);
        
        setBateauSortant(d.getBateau());
        
        textBoxDepart.setText(getBateauSortant().getNom()+" à quitté sont emplacement");
    }//GEN-LAST:event_buttonChoixBateauActionPerformed

    private void buttonRAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRAZActionPerformed
        textBoxDepart.setText("");
        textBoxRepPhare.setText("");
    }//GEN-LAST:event_buttonRAZActionPerformed

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Main">
    
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
            java.util.logging.Logger.getLogger(Applic_Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Applic_Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Applic_Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Applic_Capitainerie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Applic_Capitainerie().setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonArretServeur;
    private javax.swing.JButton buttonBateauAmar;
    private javax.swing.JButton buttonChoisir;
    private javax.swing.JButton buttonChoixBateau;
    private javax.swing.JButton buttonConnexion;
    private javax.swing.JButton buttonDemarServ;
    private javax.swing.JButton buttonEnvChoix;
    private javax.swing.JButton buttonEnvConf;
    private javax.swing.JButton buttonLire;
    private javax.swing.JButton buttonRAZ;
    private javax.swing.JButton buttonSignalDepart;
    private javax.swing.JCheckBox checkRequeteEnAtt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelDepart;
    private javax.swing.JLabel labelHeure;
    private javax.swing.JList listeBateaux;
    private javax.swing.JMenu menuAPropos;
    private javax.swing.JMenu menuAmarrages;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBateaux;
    private javax.swing.JMenuItem menuItemAide;
    private javax.swing.JMenuItem menuItemAuteur;
    private javax.swing.JCheckBoxMenuItem menuItemCheckDateHeure;
    private javax.swing.JMenuItem menuItemEquipBateau;
    private javax.swing.JMenuItem menuItemFichLog;
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
    private javax.swing.JTextField textBoxDepart;
    private javax.swing.JTextField textBoxLecture;
    private javax.swing.JTextField textBoxRepPhare;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
