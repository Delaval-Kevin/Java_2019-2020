/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 20/05/2020             */
/***********************************************************/

package capitainerie;

import add.*;
import java.util.ArrayList;


public class DialogFichierLog extends javax.swing.JDialog 
{

    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Parametres _parametres;
    private FichierLog _logCap;
    private FichierLog _logPhare;
    private ArrayList<String> _text;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public DialogFichierLog(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);

        setParam(new Parametres());
        
        setLogCap(new FichierLog(getParam().searchParam("capitainerieLog")));
        setLogPhare(new FichierLog(getParam().searchParam("phareLog")));
        
        initComponents();
    }
    
    public DialogFichierLog(java.awt.Frame parent, boolean modal, Parametres param) 
    {
        super(parent, modal);
        initComponents();
        
        setParam(param);
        
        setLogCap(new FichierLog(getParam().searchParam("capitainerieLog")));
        setLogPhare(new FichierLog(getParam().searchParam("phareLog")));
        
        CompletArea(getLogCap());
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setLogCap(FichierLog log)
    {
        _logCap = log;
    }
    
    public void setLogPhare(FichierLog log)
    {
        _logPhare = log;
    }
    
    public void setText(ArrayList<String> text)
    {
        _text = text;
    }
    
    public void setParam(Parametres param)
    {
        _parametres = param;
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
 
    public FichierLog getLogCap()
    {
        return _logCap;
    }
    
    public FichierLog getLogPhare()
    {
        return _logPhare;
    }
    
    public ArrayList<String> getText()
    {
        return _text;
    }
 
    public Parametres getParam()
    {
        return _parametres;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/ 

    public void CompletArea(FichierLog log)
    {
        //On vide la zone de texte
        TextArea.setText("");
        
        setText(log.lireFichier());
        
        for(String line : getText())
        {
            TextArea.append(line+"\n");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        radioCapitainerie = new javax.swing.JRadioButton();
        radioPhare = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Capitainerie d'Inpres-Harbour :  Fichier log");
        setPreferredSize(new java.awt.Dimension(800, 450));

        TextArea.setEditable(false);
        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        buttonGroup1.add(radioCapitainerie);
        radioCapitainerie.setSelected(true);
        radioCapitainerie.setText("Capitainerie");
        radioCapitainerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCapitainerieActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioPhare);
        radioPhare.setText("Phare");
        radioPhare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPhareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioCapitainerie)
                        .addGap(18, 18, 18)
                        .addComponent(radioPhare)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCapitainerie)
                    .addComponent(radioPhare))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**************************/
    /*                        */
    /*        BOUTONS         */
    /*                        */
    /**************************/
    
    private void radioCapitainerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCapitainerieActionPerformed
        CompletArea(getLogCap());
    }//GEN-LAST:event_radioCapitainerieActionPerformed

    private void radioPhareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPhareActionPerformed
        CompletArea(getLogPhare());
    }//GEN-LAST:event_radioPhareActionPerformed


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
            java.util.logging.Logger.getLogger(DialogFichierLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogFichierLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogFichierLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogFichierLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFichierLog dialog = new DialogFichierLog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea TextArea;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioCapitainerie;
    private javax.swing.JRadioButton radioPhare;
    // End of variables declaration//GEN-END:variables
}
