/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;

import capitainerie.Applic_Capitainerie;
import java.util.Vector;
import network.NetworkBasicClient;


public class ThreadBean extends java.lang.Thread implements DepartListener
{
    
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private int _portEcoute;
    private String _message;
    private String _reponse;
    private boolean _enMarche;
    private Vector _reponseListeners;
    private NetworkBasicClient _client;
    
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    public ThreadBean(int portEcoute, Applic_Capitainerie cap)
    {         
        setPortEcoute(portEcoute);
        setMessage(null);
        setReponseListeners(new Vector());
        
        cap.addDepartListener(this);
    }
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/
    
    public boolean isEnMarche()
    {
        return _enMarche;
    }
 
    public String getMessage()
    {
        return _message;
    }
    
    public String getReponse()
    {
        return _reponse;
    }
    
    public int getPortEcoute()
    {
        return _portEcoute;
    }

    public NetworkBasicClient getClient()
    {
        return _client;
    }
    
    public Vector getReponseListeners()
    {
        return _reponseListeners;
    }
    
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/
    
    public void setEnMarche(boolean enMarche)
    {
        _enMarche = enMarche;
    }
    
    public void setMessage(String message)
    {
        _message = message;
    }
    
    public void setReponse(String reponse)
    {
        _reponse = reponse;
    }
    
    public void setPortEcoute(int portEcoute)
    {
        _portEcoute = portEcoute;
    }
    
    public void setClient(NetworkBasicClient client)
    {
        _client = client;
    }
    
    public void setReponseListeners(Vector reponseListeners)
    {
        _reponseListeners = reponseListeners;
    }
    
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/

    public void init()
    {
        setEnMarche(true);
    }
    
    public void run()      
    {
        if(isEnMarche())
        {
            setClient(new NetworkBasicClient("localhost", getPortEcoute()));
            
            while(true) 
            { 
                System.out.println(getMessage());
                if(getMessage() != null)
                {
                    setReponse(getClient().sendString(getMessage()));
                    
                    notifyReponseDetected();
                    
                    setMessage(null);
                }
          
                try 
                {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) 
                {
                    System.out.println("Erreur de thread interrompu : " + e.getMessage()); 
                }  
            }       
        }
    } 
    
    @Override
    public void DepartDetected(DepartEvent e) 
    {
        setMessage(e.getDepart());       
    }
    
    public void notifyReponseDetected()
    {
        ReponseEvent e = new ReponseEvent(this); //On génère l'événement
        e.setReponse("Le bateau "+getReponse()+" est bien parti");

        
        int n = getReponseListeners().size();
        for(int i = 0 ; i < n ; i++)
        {
            ReponseListener obj = (ReponseListener) getReponseListeners().elementAt(i);
            obj.ReponseDetected(e);
        }
    }
    
    public void addReponseListener(ReponseListener rl)
    {
        if(!getReponseListeners().contains(rl))
        {
            getReponseListeners().addElement(rl);
        }
    }
    
    public void removeReponseListener(ReponseListener rl)
    {
        if(getReponseListeners().contains(rl))
        {
            getReponseListeners().removeElement(rl);
        }        
    }
}