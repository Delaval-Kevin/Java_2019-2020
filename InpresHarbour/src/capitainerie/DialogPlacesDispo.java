/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package capitainerie;

import amarrages.Amarrage;
import amarrages.Ponton;
import amarrages.Quai;
import java.awt.Frame;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import vehicules.Bateau;
import vehicules.MoyenDeTransportSurEau;

public class DialogPlacesDispo extends javax.swing.JDialog 
{

    
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/ 
    
    private String _choixEmp;
    private String _choixAmarrage;
    private String _choixFinal;
    
    private Vector<Amarrage> _amarrage;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public DialogPlacesDispo(Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public DialogPlacesDispo(Frame parent, boolean modal, Vector<Amarrage> amarrage)
    {
        this(parent, modal);
        setAmarrage(amarrage);
        InitTable();
    }
   
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public Vector<Amarrage> getAmarrage() 
    {
        return _amarrage;
    }
    
    public String getChoixFinal() 
    {
        return _choixFinal;
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    private void setAmarrage(Vector<Amarrage> _amarrage) 
    {
        this._amarrage = _amarrage;
    }
    
    public void setChoixFinal(String _choixFinal) 
    {
        this._choixFinal = _choixFinal;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    private void InitTable()
    {       
        String type = "PLAISANCE";
        
        if(type.compareTo("PLAISANCE") == 0){
            ListAmarrageTable.getColumnModel().getColumn(0).setHeaderValue("Pontons");
        }else if(type.compareTo("PECHE") == 0){
            ListAmarrageTable.getColumnModel().getColumn(0).setHeaderValue("Quais");
        }
        
        Enumeration enu = _amarrage.elements();
        
        int iAm = 0;
        while(enu.hasMoreElements()){
            Amarrage am = (Amarrage) enu.nextElement();
            iAm++;
            
            if(type.compareTo("PLAISANCE") == 0 && am instanceof Ponton){
                AddPonton((Ponton) am, iAm);
            }else if(type.compareTo("PECHE") == 0 && am instanceof Quai){
                AddQuai((Quai) am, iAm);
            }    
        }
    }
    
    public void AddPonton(Ponton ponton, int iAm)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel) this.ListAmarrageTable.getModel();
        
        
        for(int i = 1; i <= 2; i++){
            
            MoyenDeTransportSurEau[] mte = ponton.getListe(i);
            for(int j = 0; j < mte.length; j++){
                Bateau bp = (Bateau) mte[j];
                ligne = new Vector();
                
                if(j == 0){
                    ligne.add("P" + iAm +ponton.getIdentifiant()+i);
                }else{
                    ligne.add("");
                }
                
                ligne.add(j+1);
                
                if(bp != null){
                    ligne.add(bp.getNom());
                    ligne.add(bp.getPortAttache());
                }else{
                    ligne.add("");
                    ligne.add("");
                }
                dtm.addRow(ligne);               
            } 
        }
    }
    
    public void AddQuai(Quai quai, int iAm)
    {
        Vector ligne;
        DefaultTableModel dtm = (DefaultTableModel) this.ListAmarrageTable.getModel();
        

        MoyenDeTransportSurEau[] mte = quai.getListe();
        for(int j = 0; j < mte.length; j++){
            Bateau bp = (Bateau) mte[j];
            ligne = new Vector();

            if(j == 0){
                ligne.add("Q" + iAm + quai.getIdentifiant()+j);
            }else{
                ligne.add("");
            }

            ligne.add(j+1);

            if(bp != null){
                ligne.add(bp.getNom());
                ligne.add(bp.getPortAttache());
            }else{
                ligne.add("");
                ligne.add("");
            }
            dtm.addRow(ligne);
        } 
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageAmarage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListAmarrageTable = new javax.swing.JTable();
        ButtonChoisir = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        EmplacementLabel = new javax.swing.JLabel();
        EmplacementContentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        ImageAmarage.setText("jLabel1");

        ListAmarrageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ponton", "Emplacement", "Bateau", "Port d'attache"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListAmarrageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListAmarrageTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListAmarrageTable);

        ButtonChoisir.setText("Choisir");
        ButtonChoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChoisirActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Annuler");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        EmplacementLabel.setText("Emplacement :");

        EmplacementContentLabel.setText("???");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(ImageAmarage)
                .addGap(184, 184, 184)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonChoisir)
                    .addComponent(EmplacementLabel))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmplacementContentLabel)
                    .addComponent(ButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmplacementLabel)
                    .addComponent(EmplacementContentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonChoisir)
                        .addComponent(ButtonCancel))
                    .addComponent(ImageAmarage))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void ListAmarrageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListAmarrageTableMouseClicked
        // TODO add your handling code here:
        int ligne = ListAmarrageTable.getSelectedRow();
        int indexEmp = (int) ListAmarrageTable.getValueAt(ligne,1);
        String nomBateau = (String) ListAmarrageTable.getValueAt(ligne, 3);
        
        String amarrage = (String) ListAmarrageTable.getValueAt(ligne - (indexEmp-1), 0);
        String amLocal = amarrage + "*" + indexEmp;
        
        _choixEmp = Integer.toString(indexEmp);
        
        _choixAmarrage = amarrage;
        
        setChoixFinal(amLocal);
        
        EmplacementContentLabel.setText(amLocal);
        
        if(nomBateau.compareTo("") == 0)
        {
            ButtonChoisir.setEnabled(true);
        }
        else
        {
            ButtonChoisir.setEnabled(true);
        }
    }//GEN-LAST:event_ListAmarrageTableMouseClicked

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChoisirActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_ButtonChoisirActionPerformed


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
            java.util.logging.Logger.getLogger(DialogPlacesDispo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogPlacesDispo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogPlacesDispo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogPlacesDispo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                DialogPlacesDispo dialog = new DialogPlacesDispo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonChoisir;
    private javax.swing.JLabel EmplacementContentLabel;
    private javax.swing.JLabel EmplacementLabel;
    private javax.swing.JLabel ImageAmarage;
    private javax.swing.JTable ListAmarrageTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
  
}
