/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 20/05/2020             */
/***********************************************************/

package capitainerie;

import amarrages.Quai;
import amarrages.Ponton;
import java.util.Vector;
import vehicules.Bateau;
import amarrages.Amarrage;
import java.util.Enumeration;
import vehicules.MoyenDeTransportSurEau;
import javax.swing.table.DefaultTableModel;


public class DialogListeCompleteBateaux extends javax.swing.JDialog 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/

    private Vector _amarrage;
    
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public DialogListeCompleteBateaux(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public DialogListeCompleteBateaux(java.awt.Frame parent, boolean modal, Vector amarrages, boolean recherche) 
    {
        this(parent, modal);
        _amarrage = amarrages;
        InitTable();
        if(!recherche){
            PanelSearch.setVisible(false);
        }
    }
    
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    private void InitTable()
    {   
        Enumeration enu = _amarrage.elements();
        
        int iAm = 0;
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(am instanceof Ponton)
            {
                AddPonton((Ponton) am, iAm);
            }
            else if( am instanceof Quai)
            {
                AddQuai((Quai) am, iAm);
            }    
        }
    }
    
    public void AddPonton(Ponton ponton, int iAm)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeBateaux.getModel();
        
        for(int i = 1; i <= 2; i++)
        { 
            MoyenDeTransportSurEau[] mte = ponton.getListe(i);
            for(int j = 0; j < mte.length; j++)
            {
                Bateau bp = (Bateau) mte[j];
                if(bp != null)
                {
                    ligne = new Vector();

                    ligne.add(bp.getNom());
                    ligne.add(bp.getPortAttache());
                    ligne.add(bp.getTonnage());
                    ligne.add(bp.getPavillon());
                    ligne.add(bp.getLongueur() + "m");
                    ligne.add("P" + iAm +ponton.getIdentifiant()+"*"+i);
                    
                    dtm.addRow(ligne);     
                }                
            } 
        }
    }
    
    public void AddPonton(Ponton ponton, int iAm, boolean search)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeBateaux.getModel();
              
        for(int i = 1; i <= 2; i++)
        {
            MoyenDeTransportSurEau[] mte = ponton.getListe(i);
            for(int j = 0; j < mte.length; j++)
            {
                Bateau bp = (Bateau) mte[j];
                if(bp != null && bp.getNom().contains(SearchTextBox.getText()))
                {
                    ligne = new Vector();

                    ligne.add(bp.getNom());
                    ligne.add(bp.getPortAttache());
                    ligne.add(bp.getTonnage());
                    ligne.add(bp.getPavillon());
                    ligne.add(bp.getLongueur() + "m");
                    ligne.add("P" + iAm +ponton.getIdentifiant()+"*"+i);
                    
                    dtm.addRow(ligne);     
                }             
            } 
        }
    }
    
    public void AddQuai(Quai quai, int iAm)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeBateaux.getModel();
        
        MoyenDeTransportSurEau[] mte = quai.getListe();
        for(int j = 0; j < mte.length; j++)
        {        
            Bateau bp = (Bateau) mte[j];
            if(bp != null)
            {
                ligne = new Vector();

                ligne.add(bp.getNom());
                ligne.add(bp.getPortAttache());
                ligne.add(bp.getTonnage());
                ligne.add(bp.getPavillon());
                ligne.add(bp.getLongueur() + "m");
                ligne.add("Q" + iAm +quai.getIdentifiant()+"*"+j);

                dtm.addRow(ligne);     
            }            
        }
    }

    
    public void AddQuai(Quai quai, int iAm, boolean search)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel) this.TableListeBateaux.getModel();
        

        MoyenDeTransportSurEau[] mte = quai.getListe();
        for(int j = 0; j < mte.length; j++)
        {
            Bateau bp = (Bateau) mte[j];
            if(bp != null && bp.getNom().contains(SearchTextBox.getText()))
            {
                ligne = new Vector();

                ligne.add(bp.getNom());
                ligne.add(bp.getPortAttache());
                ligne.add(bp.getTonnage());
                ligne.add(bp.getPavillon());
                ligne.add(bp.getLongueur() + "m");
                ligne.add("Q" + iAm +quai.getIdentifiant()+"*"+j);

                dtm.addRow(ligne);     
            }          
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PanelSearch = new javax.swing.JPanel();
        SearchButton = new javax.swing.JButton();
        SearchTextBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableListeBateaux = new javax.swing.JTable();
        LabelTitle = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour :  Liste des bateaux");

        SearchButton.setText("Chercher");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Rechercher par nom");

        javax.swing.GroupLayout PanelSearchLayout = new javax.swing.GroupLayout(PanelSearch);
        PanelSearch.setLayout(PanelSearchLayout);
        PanelSearchLayout.setHorizontalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSearchLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelSearchLayout.createSequentialGroup()
                        .addComponent(SearchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSearchLayout.setVerticalGroup(
            PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSearchLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton)
                    .addComponent(SearchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        TableListeBateaux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Port d'attache", "Tonnage", "Pavillion", "Longueur", "Amarrage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableListeBateaux);

        LabelTitle.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        LabelTitle.setText("Liste des bateaux");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(PanelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(LabelTitle)
                .addContainerGap(348, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(LabelTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) this.TableListeBateaux.getModel();
        while(dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        Enumeration enu = _amarrage.elements();
        
        
        int iAm = 0;
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(am instanceof Ponton)
            {
                AddPonton((Ponton) am, iAm, true);
            }
            else if( am instanceof Quai)
            {
                AddQuai((Quai) am, iAm, true);
            }    
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(DialogListeCompleteBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogListeCompleteBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogListeCompleteBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogListeCompleteBateaux.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogListeCompleteBateaux dialog = new DialogListeCompleteBateaux(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JPanel PanelSearch;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextBox;
    private javax.swing.JTable TableListeBateaux;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
