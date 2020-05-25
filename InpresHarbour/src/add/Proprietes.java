/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package add;

import java.io.*;
import java.util.*;



public class Proprietes 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Properties _login;
    private String _fileName;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public Proprietes()
    {
        setLogin(new Properties());
        setFileName("logins.properties");
        Load();
    }
    
    public Proprietes(String fileName)
    {
        setLogin(new Properties());
        setFileName(fileName);
        Load();
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
    
    public void setFileName(String fileName)
    {
        _fileName = fileName;
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
        return _fileName;
    }
     
    public String getFilePath()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        
        return rep+sep;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/
    
    public void Save()
    {
        try(OutputStream output = new FileOutputStream(getFilePath()+getFileName())) 
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
        try(InputStream input = new FileInputStream(getFilePath()+getFileName())) 
        {            
            getLogin().load(input);
        } 
        catch(IOException io) 
        {
            AddUser("DelavalKevin", "1234"); //pour nous inclure
            AddUser("ColletteLoic", "1234"); //dans le fichier
            Save();
            System.out.println("Un probleme est survenu lors du chargement du fichier : "+io.getMessage());
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
