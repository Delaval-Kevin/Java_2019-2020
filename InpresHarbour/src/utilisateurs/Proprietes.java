/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package utilisateurs;
import java.util.*;
import java.io.*;


public class Proprietes 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Properties _login;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public Proprietes()
    {
        setLogin(new Properties());
        Load();
        
        Save();
        //AddUser("DelavalKevin", "1234");
        //AddUser("ColletteLoic", "1234");
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setLogin(Properties login)
    {
        _login = login;
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public Properties getLogin()
    {
        return _login;
    }
     
    public String getFileName()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        
        return rep+sep+"logins.properties";
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    public void Save()
    {
        try(OutputStream output = new FileOutputStream(getFileName())) 
        {            
            getLogin().store(output,null);
        } 
        catch(IOException io) 
        {
            System.out.println("Erreur de sauvegarder "+io.getMessage());
        }
    }
    
    public void Load()
    {
        try(InputStream input = new FileInputStream(getFileName())) 
        {            
            getLogin().load(input);
        } 
        catch(IOException io) 
        {
            System.out.println("chargement de fichier problematique "+io.getMessage());
        }
    }
    
    public boolean TryLogin(String user, String pass) throws LoginException
    {
        if(user.length() < 1 || getLogin().getProperty(user).compareTo(pass) != 0)
        {
            System.out.println("Dans le throw ");
            throw new LoginException("Données non correctes");
        }
        else return true;
    }
    
    public boolean DoesUserExist(String user)
    {
        return getLogin().containsKey(user);
    }
    
    public boolean AddUser(String user, String pwd)
    {
        if(!DoesUserExist(user))
        {
            getLogin().setProperty(user, pwd);
            Save();
            return true;
        }
        else
            return false;
    }
}
