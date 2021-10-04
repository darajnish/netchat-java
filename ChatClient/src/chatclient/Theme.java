package chatclient;

import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Rajnish
 * @version 1.0
 */
public class Theme
{
    public final static int PLATFORM = 0;
    public final static int METAL = 1;
    public final static int NIMBUS = 2;
    public final static int MOTIF = 3;
    
    //<editor-fold defaultstate="collapsed" desc="(Constructor) nothing">
    private Theme()
    {
        //nothing.
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="(static) to set from the given themes">
    public static void setTheme(int theme)
    {
        Theme.setRecognisedTheme(theme);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="(static) main method to set theme (String)">
    public static void setTheme(String classname)
    {
        try
        {
            javax.swing.UIManager.setLookAndFeel(classname);
        }
        catch(Exception e)
        {
            warnUser("Unable to set the desired theme!");
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="(static) main method to set theme (LookAndFeel)">
    public static void setTheme(LookAndFeel lookAndFeel)
    {
        try
        {
            javax.swing.UIManager.setLookAndFeel(lookAndFeel);
        }
        catch(Exception e)
        {
            warnUser("Unable to set the desired theme!");
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="(static) set Installed themes by recognising">
    private static void setRecognisedTheme(int theme)
    {
        switch(theme)
        {
            case Theme.PLATFORM : setTheme(javax.swing.UIManager.getSystemLookAndFeelClassName());
            break;
            case Theme.METAL    : setTheme("javax.swing.plaf.metal.MetalLookAndFeel");
            break;
            case Theme.NIMBUS   : setTheme("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            break;
            case Theme.MOTIF    : setTheme("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            break;
            default : setTheme(javax.swing.UIManager.getSystemLookAndFeelClassName());
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="(static) set theme through xml file">
    public static void setTheme(URL themeFile)
    {
        try
        {
            SynthLookAndFeel synthlaf = new javax.swing.plaf.synth.SynthLookAndFeel();
            synthlaf.load(themeFile);
            setTheme(synthlaf);
        }
        catch(IOException e)
        {
            warnUser("Unable to find the theme xml file!");
        }
        catch(Exception e)
        {
            warnUser("Unable to apply the theme!\n"+e);
        }
    }
    //</editor-fold>
    
    private static void warnUser(String msg)
    {
        javax.swing.JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    } 
}
