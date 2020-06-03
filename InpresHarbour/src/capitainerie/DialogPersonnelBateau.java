/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package capitainerie;

import amarrages.Amarrage;
import amarrages.Ponton;
import amarrages.Quai;
import humain.Marin;
import java.awt.Frame;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import vehicules.Bateau;


public class DialogPersonnelBateau extends javax.swing.JDialog 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    public Vector<Amarrage> _amarrages;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public DialogPersonnelBateau(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public DialogPersonnelBateau(Frame parent, boolean modal, Vector<Amarrage> amarrage, boolean search){
        this(parent, modal);
        setAmarrage(amarrage);
        InitTable();
        if(!search){
            SearchPanel.setVisible(false);
        }
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public Vector getAmarrages()
    {
        return _amarrages;
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/

    public void setAmarrage(Vector<Amarrage> amarrages)
    {
        _amarrages = amarrages;
    }
        
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    private void InitTable()
    {
        
        Enumeration enu = getAmarrages().elements();
        
        int iAm = 0;
        while(enu.hasMoreElements()){
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(am instanceof Ponton){
                AddPersonnelPonton((Ponton) am, iAm);
            }else if( am instanceof Quai){
                AddPersonnelQuai((Quai) am, iAm);
            }    
        }
    }
    
    public void AddPersonnelPonton(Ponton ponton, int iAm)
    {
    
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeMarin.getModel();
        Marin capitaine;
        Marin second;
        Marin marin;
        Bateau b;
        Vector ligne;
        
        
        for(int i = 1; i <= 2; i++)
        {
            for(int j = 0; j < ponton.getListe(i).length; j++)
            {
                b = (Bateau) ponton.getListe(i)[j];
                ligne = new Vector();
                if(b != null)
                {
                    // capitaine
                    if(b.getEquipage().getCapitaine() != null)
                    {
                        capitaine = b.getEquipage().getCapitaine();
                        ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                        ligne.addElement(b.getNom());
                        ligne.addElement(capitaine);
                        dtm.addRow(ligne);
                    }


                    // second
                    ligne = new Vector();
                    if(b.getEquipage().getSecond() != null)
                    {
                        second = b.getEquipage().getSecond();
                        if(b.getEquipage().getCapitaine() == null)
                        {
                            ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                            ligne.addElement(b.getNom());
                        }
                        else
                        {
                            ligne.addElement("");
                            ligne.addElement("");
                        }

                        ligne.addElement(second);
                        dtm.addRow(ligne);
                    }

                    int taille  = b.getEquipage().getMarins().size();

                    for(int k = 0; k < taille; k++)
                    {
                        ligne = new Vector();
                        // marin
                        marin = b.getEquipage().getMarins().elementAt(k);

                        if(b.getEquipage().getCapitaine() == null && b.getEquipage().getCapitaine() == null)
                        {
                            ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                            ligne.addElement(b.getNom());
                        }
                        else
                        {
                            ligne.addElement("");
                            ligne.addElement("");
                        }

                        ligne.addElement(marin);
                        dtm.addRow(ligne);
                    }
                           
                    ligne = new Vector();
                    if(b.getEquipage().getCapitaine() != null || b.getEquipage().getSecond() != null || !b.getEquipage().getMarins().isEmpty())
                    {
                        ligne.addElement("");
                        ligne.addElement("");
                        ligne.addElement("");
                        dtm.addRow(ligne);
                    }
                }
            }
        }    
    }
    
    
    public void AddPersonnelPonton(Ponton ponton, int iAm, boolean search)
    {
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeMarin.getModel();
        Marin capitaine;
        Marin second;
        Marin marin;
        Bateau b;
        Vector ligne;
        
        String toSearch = SearchTextBox.getText();
        
        for(int i = 1; i <= 2; i++)
        {
            for(int j = 0; j < ponton.getListe(i).length; j++)
            {
                b = (Bateau) ponton.getListe(i)[j];
                ligne = new Vector();
                if(b != null)
                {
                    // capitaine
                    if(b.getEquipage().getCapitaine() != null)
                    {
                        capitaine = b.getEquipage().getCapitaine();
                        if(capitaine.getNom().contains(toSearch) || capitaine.getPrenom().contains(toSearch))
                        {
                            ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                            ligne.addElement(b.getNom());
                            ligne.addElement(capitaine);
                            dtm.addRow(ligne);
                        }
                    }

                    // second
                    ligne = new Vector();
                    if(b.getEquipage().getSecond() != null)
                    {
                        second = b.getEquipage().getSecond();
                        
                        if(second.getNom().contains(toSearch) || second.getPrenom().contains(toSearch))
                        {
                            ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                            ligne.addElement(b.getNom());
                            ligne.addElement(second);
                            dtm.addRow(ligne);
                        }
                    }


                    int taille  = b.getEquipage().getMarins().size();

                    for(int k = 0; k < taille; k++)
                    {
                        ligne = new Vector();
                        // marin
                        marin = b.getEquipage().getMarins().elementAt(k);
                        if(marin.getNom().contains(toSearch) || marin.getPrenom().contains(toSearch))
                        {
                            ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                            ligne.addElement(b.getNom());
                            ligne.addElement(marin);
                            dtm.addRow(ligne);
                        }
                    } 
                }
            }
        }
    }
    
    
    public void AddPersonnelQuai(Quai quai, int iAm)
    {
    
        DefaultTableModel dtm = (DefaultTableModel) TableListeMarin.getModel();
        Marin capitaine;
        Marin second;
        Marin marin;
        Bateau b;
        Vector ligne;

        for(int j = 0; j < quai.getListe().length; j++)
        {
            b = (Bateau) quai.getListe()[j];
            ligne = new Vector();

            // capitaine
            if(b != null)
            {    
                if(b.getEquipage().getCapitaine() == null)
                {
                    capitaine = b.getEquipage().getCapitaine();
                    ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                    ligne.addElement(b.getNom());
                    ligne.addElement(capitaine);
                    dtm.addRow(ligne);
                }

                ligne = new Vector();
                // second
                if(b.getEquipage().getSecond()== null)
                {
                    second = b.getEquipage().getSecond();

                    if(b.getEquipage().getCapitaine() == null)
                    {
                        ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                        ligne.addElement(b.getNom());
                    }
                    else
                    {
                        ligne.addElement("");
                        ligne.addElement("");
                    }

                    ligne.addElement(second);
                    dtm.addRow(ligne);
                }

                int taille  = b.getEquipage().getMarins().size();

                for(int k = 0; k < taille; k++)
                {
                    ligne = new Vector();
                    // marin
                    marin = b.getEquipage().getMarins().elementAt(k);

                    if(b.getEquipage().getCapitaine() == null && b.getEquipage().getCapitaine() == null)
                    {
                        ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                        ligne.addElement(b.getNom());
                    }
                    else
                    {
                        ligne.addElement("");
                        ligne.addElement("");
                    }

                    ligne.addElement(marin);
                    dtm.addRow(ligne);
                }
            }
        }  
    }
    
    
    public void AddPersonnelQuai(Quai quai, int iAm, boolean search)
    {
        DefaultTableModel dtm = (DefaultTableModel) TableListeMarin.getModel();
        Marin capitaine;
        Marin second;
        Marin marin;
        Bateau b;
        Vector ligne;
        
        String toSearch = SearchTextBox.getText();

        for(int j = 0; j < quai.getListe().length; j++)
        {
            b = (Bateau) quai.getListe()[j];
            ligne = new Vector();

            // capitaine
            if(b != null)
            {
                if(b.getEquipage().getCapitaine() != null && (b.getEquipage().getCapitaine().getNom().contains(toSearch) || b.getEquipage().getCapitaine().getPrenom().contains(toSearch)))
                {
                    capitaine = b.getEquipage().getCapitaine();
                    ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                    ligne.addElement(b.getNom());
                    ligne.addElement(capitaine);
                    dtm.addRow(ligne);
                }

                ligne = new Vector();
                // second
                if(b.getEquipage().getSecond() != null && (b.getEquipage().getSecond().getNom().contains(toSearch) || b.getEquipage().getSecond().getPrenom().contains(toSearch)))
                {
                    second = b.getEquipage().getSecond();

                    ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                    ligne.addElement(b.getNom());

                    ligne.addElement(second);
                    dtm.addRow(ligne);
                }


                int taille  = b.getEquipage().getMarins().size();

                for(int k = 0; k < taille; k++)
                {
                    ligne = new Vector();
                    // marin
                    marin = b.getEquipage().getMarins().elementAt(k);
                    if(marin.getNom().contains(toSearch) || marin.getPrenom().contains(toSearch))
                    {
                        ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                        ligne.addElement(b.getNom());
                        ligne.addElement(marin);
                        dtm.addRow(ligne);
                    }
                }
            }
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableListeMarin = new javax.swing.JTable();
        SearchPanel = new javax.swing.JPanel();
        SearchButton = new javax.swing.JButton();
        SearchTextBox = new javax.swing.JTextField();
        SearchLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableListeMarin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amarrage", "Nom bateau", "Marin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableListeMarin.setToolTipText("");
        jScrollPane2.setViewportView(TableListeMarin);

        SearchButton.setText("Rechercher");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchLabel.setText("Rechercher par nom/prenom");

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchLabel)
                    .addGroup(SearchPanelLayout.createSequentialGroup()
                        .addComponent(SearchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton)))
                .addGap(198, 198, 198))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(SearchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton)
                    .addComponent(SearchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel2.setText("Rechercher un marin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*         BOUTONS        */
    /*                        */
    /**************************/
    
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeMarin.getModel();
        while(dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        Enumeration enu = _amarrages.elements();
        
        
        int iAm = 0;
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(am instanceof Ponton)
            {
                AddPersonnelPonton((Ponton) am, iAm, true);
            }
            else if( am instanceof Quai)
            {
                AddPersonnelQuai((Quai) am, iAm, true);
            }    
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DialogPersonnelBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogPersonnelBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogPersonnelBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogPersonnelBateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogPersonnelBateau dialog = new DialogPersonnelBateau(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTextField SearchTextBox;
    private javax.swing.JTable TableListeMarin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
