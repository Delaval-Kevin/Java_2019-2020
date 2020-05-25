/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 *
 * @author collloi
 */
public class DialogPersonnelBateau extends javax.swing.JDialog {

    /**
     * Creates new form DialogPersonnelBateau
     */
    
    public Vector<Amarrage> _amarrages;
    
    public DialogPersonnelBateau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
    }
    
    public DialogPersonnelBateau(Frame parent, boolean modal, Vector<Amarrage> amarrage){
        this(parent, modal);
        setAmarrage(amarrage);
        InitTable();
    }

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
        
        for(int i = 0; i < 2; i++){
        
            for(int j = 0; j < ponton.getListe(i).length; j++){
            
                b = (Bateau) ponton.getListe(i)[j];
                ligne = new Vector();
                
                // capitaine
                if(b.getEquipage().getCapitaine() == null){
                    capitaine = b.getEquipage().getCapitaine();
                    ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                    ligne.addElement(b.getNom());
                    ligne.addElement(capitaine);
                    dtm.addRow(ligne);
                }
                
                
                // second
                ligne = new Vector();
                if(b.getEquipage().getSecond()== null){
                    second = b.getEquipage().getSecond();
                    if(b.getEquipage().getCapitaine() == null){
                        ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                        ligne.addElement(b.getNom());
                    }else{
                        ligne.addElement("");
                        ligne.addElement("");
                    }
                    
                    ligne.addElement(second);
                    dtm.addRow(ligne);
                }
                
                
                int taille  = b.getEquipage().getMarins().size();
                
                for(int k = 0; k < taille; k++){
                
                    
                    ligne = new Vector();
                    // marin
                    marin = b.getEquipage().getMarins().elementAt(k);

                    if(b.getEquipage().getCapitaine() == null && b.getEquipage().getCapitaine() == null){
                        ligne.addElement("P" + iAm +ponton.getIdentifiant()+"*"+i);
                        ligne.addElement(b.getNom());
                    }else{
                        ligne.addElement("");
                        ligne.addElement("");
                    }

                    ligne.addElement(marin);
                    dtm.addRow(ligne);
                    
                }
                
            }
            
        }
        
    }
    
    public void AddPersonnelQuai(Quai quai, int iAm){
    
        DefaultTableModel dtm = (DefaultTableModel) TableListeMarin.getModel();
        Marin capitaine;
        Marin second;
        Marin marin;
        Bateau b;
        Vector ligne;
        

        for(int j = 0; j < quai.getListe().length; j++){

            b = (Bateau) quai.getListe()[j];
            ligne = new Vector();

            // capitaine
            if(b.getEquipage().getCapitaine() == null){
                capitaine = b.getEquipage().getCapitaine();
                ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                ligne.addElement(b.getNom());
                ligne.addElement(capitaine);
                dtm.addRow(ligne);
            }


            ligne = new Vector();
            // second
            if(b.getEquipage().getSecond()== null){
                second = b.getEquipage().getSecond();

                if(b.getEquipage().getCapitaine() == null){
                    ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                    ligne.addElement(b.getNom());
                }else{
                    ligne.addElement("");
                    ligne.addElement("");
                }

                ligne.addElement(second);
                dtm.addRow(ligne);
            }


            int taille  = b.getEquipage().getMarins().size();

            for(int k = 0; k < taille; k++){


                ligne = new Vector();
                // marin
                marin = b.getEquipage().getMarins().elementAt(k);

                if(b.getEquipage().getCapitaine() == null && b.getEquipage().getCapitaine() == null){
                    ligne.addElement("Q" + iAm +quai.getIdentifiant()+"*"+j);
                    ligne.addElement(b.getNom());
                }else{
                    ligne.addElement("");
                    ligne.addElement("");
                }

                ligne.addElement(marin);
                dtm.addRow(ligne);

            }

        }

        
    }
    
    public void setAmarrage(Vector<Amarrage> amarrages){
        _amarrages = amarrages;
    }
    
    public Vector getAmarrages(){
        return _amarrages;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableListeMarin = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JTable TableListeMarin;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
