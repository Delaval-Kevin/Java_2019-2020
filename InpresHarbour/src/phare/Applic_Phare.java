/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package phare;

import add.*;
import beans.*;
import java.util.Timer;
import java.beans.Beans;
import java.util.Locale;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimerTask;
import network.NetworkBasicClient;
import javax.swing.DefaultListModel;
import network.NetworkBasicServer;


public class Applic_Phare extends javax.swing.JFrame 
{
    // <editor-fold defaultstate="collapsed" desc="Variables membres">
    
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Timer _timer;
    private Locale _fuseau;
    private String _tmpNom;
    private FichierLog _log;
    private String _reponse;
    private String _batSort;
    private String _tmpType;
    private int _formatDate;
    private int _formatHeure;
    private BoatBean _beanBoat;
    private String _utilisateur;
    private String _tmpPavillon;
    private String _tmpLongueur;
    private Parametres _parametres;
    private NotifyBean _beanNotify;
    private NetworkBasicClient _client;
    private NetworkBasicServer _serveur;
    private KindOfBoatBean _beanKindOfBoat;
    private DefaultListModel _bateauxEntrant;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public Applic_Phare() 
    {
        initComponents();
        
        /* récupère le fichier des paramètres */
        setParam(new Parametres());
        
        /* récupère le fichier log */
        setLog(new FichierLog(getParam().searchParam("phareLog")));
        
        InitList();
        fctLogin();
        
        formatageDate(Integer.parseInt(getParam().searchParam("formatDate")) , Integer.parseInt(getParam().searchParam("formatHeure")) ,getParam().stringToLocale(getParam().searchParam("fuseauHoraire")));
        InitTimer();
        
        InitBeans();

        /* Si l'utilisateur ne se log pas on ferme la fenetre dans la foulée */
        if(!isConnected())
        {
            System.exit(0);
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    
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
    
    private String getBatSort()
    {
        return _batSort;
    }
    
    public FichierLog getLog()
    {
        return _log;
    }
    
    public Parametres getParam()
    {
        return _parametres;
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
    
    public NetworkBasicServer getServeur()
    {
        return _serveur;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    
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
        _reponse = reponse;
    }
    
    private void setBatSort(String batSort)
    {
        _batSort = batSort;
    }
    
    public void setLog(FichierLog log)
    {
        _log = log;
    }

    public void setParam(Parametres param)
    {
        _parametres = param;
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
    
    public void setServeur(NetworkBasicServer serveur)
    {
        _serveur = serveur;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methodes">
    
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
        
        getLog().ecritLigne("Applic_Phare" , "Creation de la boite dialogue de LOGIN");
        
        /*Je ne garde pas une référence de la fenêtre en global, car il n'y à lieu d'avoir de connecion et déconnexion intempestives*/
        DialogLogin login = new DialogLogin(this, true);
        login.setVisible(true);
        
        if(login.getLoginValide())
        {
            setUtilisateur(login.getUtilisateur());
            setTitre();
            getLog().ecritLigne("Applic_Phare", "LOGIN de "+getUtilisateur());
        }
        
        this.setVisible(true);
        login.dispose();
    }
    
    private void InitList()
    {
        getLog().ecritLigne("Applic_Phare", "Creation et initialisation de la liste de marins DEFAULTLISTMODEL");
        
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
        
        /* maintenant que tout est en place on demarre KindOfBoatBean*/
        getBeanKindOfBoat().run();
    }
    
    private void InitKindOfBoat()
    {
        try 
        {    
            getLog().ecritLigne("Applic_Phare", "Creation de KindOfBoatBean");
            setBeanKindOfBoat((KindOfBoatBean)Beans.instantiate(null, "beans.KindOfBoatBean"));
        } 
        catch(ClassNotFoundException e) 
        {
            getLog().ecritLigne("Applic_Phare", "Classe KindOfBoatBean non trouvée");
            System.exit(0);
        }
        catch(IOException e)
        {
            getLog().ecritLigne("Applic_Phare", "Erreur d'I/O : KindOfBoatBean !!!");
            System.exit(0);
        }
        
        //config du bean
        getBeanKindOfBoat().init();
    }
    
    private void InitBoat()
    {
        try 
        {    
            getLog().ecritLigne("Applic_Phare", "Creation de BoatBean");
            setBeanBoat((BoatBean)Beans.instantiate(null, "beans.BoatBean"));
        } 
        catch(ClassNotFoundException e) 
        {
            getLog().ecritLigne("Applic_Phare", "Classe BoatBean non trouvée");
            System.exit(0);
        }
        catch(IOException e)
        {
            getLog().ecritLigne("Applic_Phare", "Erreur d'I/O : KindOfBoatBean !!!");
            System.exit(0);
        }   
        
    }
    
    private void InitNotify()
    {
        try 
        {    
            getLog().ecritLigne("Applic_Phare", "Creation de NotifyBean");
            setBeanNotify((NotifyBean)Beans.instantiate(null, "beans.NotifyBean"));
        } 
        catch(ClassNotFoundException e) 
        {
            getLog().ecritLigne("Applic_Phare", "Classe NotifyBean non trouvée");
            System.exit(0);
        }
        catch(IOException e)
        {
            getLog().ecritLigne("Applic_Phare", "Erreur d'I/O : KindOfBoatBean !!!");
            System.exit(0);
        }    
        
        //config du bean
        getBeanNotify().setBateauxEntrant(getBateauxEntrant());
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
    
    private void formatageDate(int date, int heure, Locale fuseau)
    {
        setFormatDate(date);
        setFormatHeure(heure);
        setFuseaau(fuseau);
        afficheHeure();
    }
    
    private void afficheHeure()
    {           
        Date maintenant = new Date();
        labelHeure.setText(DateFormat.getDateTimeInstance(getFormatDate(), getFormatHeure(), getFuseaau()).format(maintenant));
    }
    
    //</editor-fold>
     
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
        labelHeure = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        buttonDemarServeur = new javax.swing.JButton();
        checkMessAtt = new javax.swing.JCheckBox();
        buttonLire = new javax.swing.JButton();
        textBoxDepart = new javax.swing.JTextField();
        buttonValidDep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        labelHeure.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Départ des bateaux");

        buttonDemarServeur.setText("Démarrer le serveur");
        buttonDemarServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDemarServeurActionPerformed(evt);
            }
        });

        checkMessAtt.setText("Message en attente :");

        buttonLire.setText("Lire");
        buttonLire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLireActionPerformed(evt);
            }
        });

        textBoxDepart.setEditable(false);

        buttonValidDep.setText("Valider départ");
        buttonValidDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidDepActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonSuivant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonRAZ)
                                    .addComponent(labelHeure, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonDeconexion))))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonConnexion)
                        .addGap(82, 82, 82)
                        .addComponent(labelBatEnAttente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkMessAtt)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLire, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCap)
                                .addGap(18, 18, 18)
                                .addComponent(labelRepCap, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBatIdentif)
                                .addGap(36, 36, 36)
                                .addComponent(textBoxBatIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonDemAutEntree))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(buttonBatEntreRade)
                                .addGap(18, 18, 18)
                                .addComponent(labelBatEntre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDemarServeur))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonValidDep, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textBoxDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(labelHeure)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonConnexion)
                            .addComponent(labelBatEnAttente))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(buttonSuivant))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelImage)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkMessAtt)
                            .addComponent(buttonLire))
                        .addGap(18, 18, 18)
                        .addComponent(textBoxDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonValidDep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonBatEntreRade)
                            .addComponent(buttonDeconexion)
                            .addComponent(labelBatEntre))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonDemarServeur)
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelBatEnAttente.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Boutons">
    
    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void buttonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnexionActionPerformed
        getLog().ecritLigne("Applic_Phare", "Connexion au serveur");
        
        setClient(new NetworkBasicClient("localhost", Integer.parseInt(getParam().searchParam("portEcoute1"))));
        buttonConnexion.setEnabled(false);
    }//GEN-LAST:event_buttonConnexionActionPerformed

    private void buttonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSuivantActionPerformed
        String[] parties = getBateauxEntrant().elementAt(0).toString().split("/");
        setTmpType(parties[0]);
        setTmpPavillon(parties[1]);
        
        getLog().ecritLigne("Applic_Phare", "Creation de la boite de dialogue IDENT BATEAU");
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
        getLog().ecritLigne("Applic_Phare", "Demande autorisation d'entree a la capitainerie");
        
        setReponse(getClient().sendString("1/"+getTmpType()+"/"+getTmpPavillon()+"/"+getTmpNom()+"/"+getTmpLongueur())); 
        labelRepCap.setText(getReponse());
    }//GEN-LAST:event_buttonDemAutEntreeActionPerformed

    private void buttonBatEntreRadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatEntreRadeActionPerformed
        getLog().ecritLigne("Applic_Phare", "Validation d'entree dans la rade");
        
        setReponse(getClient().sendString("2/Bateau "+getTmpNom()+" est bien entre dans la rade"));
        getBateauxEntrant().remove(0); 
        labelBatEntre.setText(getReponse());
    }//GEN-LAST:event_buttonBatEntreRadeActionPerformed

    private void buttonRAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRAZActionPerformed
        getLog().ecritLigne("Applic_Phare", "Remise a zero des champs");
        
        labelBatEntre.setText("??");
        labelRepCap.setText("??");
        textBoxBatIdent.setText("??");
        setReponse("");
        setTmpPavillon("");
        setTmpLongueur("");
        setTmpNom("");
        setTmpType("");
        buttonSuivant.setEnabled(true);
    }//GEN-LAST:event_buttonRAZActionPerformed

    private void buttonDeconexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeconexionActionPerformed
        getLog().ecritLigne("Applic_Phare", "Deconnexion du serveur");
        
        getClient().setEndSending();
        buttonConnexion.setEnabled(true);
    }//GEN-LAST:event_buttonDeconexionActionPerformed

    private void buttonLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLireActionPerformed
        getLog().ecritLigne("Applic_Phare", "Lecture réception message ( départ d'un bateau )");
        
        if(checkMessAtt.isSelected())
        {
            setBatSort(getServeur().getMessage());
            textBoxDepart.setText("Départ du bateau "+getBatSort());
        }
    }//GEN-LAST:event_buttonLireActionPerformed

    private void buttonValidDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidDepActionPerformed
        getLog().ecritLigne("Applic_Phare", "Envoie du message validation départ bateau");
        
        getServeur().sendMessage(getBatSort());
    }//GEN-LAST:event_buttonValidDepActionPerformed

    private void buttonDemarServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDemarServeurActionPerformed
        getLog().ecritLigne("Applic_Phare", "Démarrage du serveur");
        
        setServeur(new NetworkBasicServer(Integer.parseInt(getParam().searchParam("portEcoute2")),checkMessAtt));
        buttonDemarServeur.setEnabled(false);
    }//GEN-LAST:event_buttonDemarServeurActionPerformed

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
    
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
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Applic_Phare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatEntreRade;
    private javax.swing.JButton buttonConnexion;
    private javax.swing.JButton buttonDeconexion;
    private javax.swing.JButton buttonDemAutEntree;
    private javax.swing.JButton buttonDemarServeur;
    private javax.swing.JButton buttonLire;
    private javax.swing.JButton buttonRAZ;
    private javax.swing.JButton buttonSuivant;
    private javax.swing.JButton buttonValidDep;
    private javax.swing.JCheckBox checkMessAtt;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelBatEnAttente;
    private javax.swing.JLabel labelBatEntre;
    private javax.swing.JLabel labelBatIdentif;
    private javax.swing.JLabel labelCap;
    private javax.swing.JLabel labelHeure;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelRepCap;
    private javax.swing.JList listBatEnAttente;
    private javax.swing.JTextField textBoxBatIdent;
    private javax.swing.JTextField textBoxDepart;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
