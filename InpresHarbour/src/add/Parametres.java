/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package add;

import java.io.*;
import java.text.DateFormat;
import java.util.*;


public class Parametres 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Properties _parametres;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public Parametres()
    {
        setParametres(new Properties());
        Load();
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setParametres(Properties parametres)
    {
        _parametres = parametres;
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public Properties getParametres()
    {
        return _parametres;
    }
     
    public String getFileName()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        
        return rep+sep+"config.properties";
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
            getParametres().store(output,null);
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
            getParametres().load(input);
        } 
        catch(IOException io) 
        {
            ConfigDeBase();
            System.out.println("Un probleme est survenu lors du chargement du fichier : "+io.getMessage());
        }
    }
    
    public String searchParam(String param)
    {
        return getParametres().getProperty(param);
    }
    
    public boolean DoesParamExist(String param)
    {
        return getParametres().containsKey(param);
    }
    
    public boolean AddProperty(String param, String value)
    {
        if(!DoesParamExist(param))
        {
            getParametres().setProperty(param, value);
            Save();
            return true;
        }
        else
            return false;
    } 
    
    public boolean ChangeProperty(String param, String value)
    {
        if(DoesParamExist(param))
        {
            getParametres().setProperty(param, value);
            Save();
            return true;
        }
        else
            return false;
    }
    
    public String localeToString(Locale l) 
    {
        return l.getLanguage() + "_" + l.getCountry();
    }

    public Locale stringToLocale(String s) 
    {
        StringTokenizer tempStringTokenizer = new StringTokenizer(s,",");
        String l = "FR";
        String c = "fr";
        if(tempStringTokenizer.hasMoreTokens())
            l = tempStringTokenizer.nextElement().toString();
        if(tempStringTokenizer.hasMoreTokens())
            c = tempStringTokenizer.nextElement().toString();

        return new Locale(l,c);
    }

    public void ConfigDeBase()
    {
            AddProperty("fichierProperties", "logins.properties");
            AddProperty("fichierAmarrage", "port.dat");
            AddProperty("capitainerieLog", "capitainerie.log");
            AddProperty("phareLog", "phare.log");
            AddProperty("fichierEntreeAmarrage", "entree.dat");
            AddProperty("portEcoute1", "50000");
            AddProperty("portEcoute2", "50005");
            AddProperty("nombreRef1", "7");
            AddProperty("nombreRef2", "17");
            AddProperty("tempsSommeil", "1000");
            AddProperty("formatHeure", Integer.toString(DateFormat.MEDIUM));
            AddProperty("formatDate", Integer.toString(DateFormat.MEDIUM));
            AddProperty("fuseauHoraire", localeToString(Locale.FRANCE));
            
            Save();
    }
}