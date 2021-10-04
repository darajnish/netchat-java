package chatclient;

import java.awt.HeadlessException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rajnish
 */
public class ChatClient
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Client cl;
        try
        {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        try
        {
            String name = javax.swing.JOptionPane.showInputDialog("Enter the name:");
            String ipadd = javax.swing.JOptionPane.showInputDialog("Enter the ip:");
            String sport = javax.swing.JOptionPane.showInputDialog("Enter the port number:");
            if(((name!=null)||(!name.isEmpty()))&&((sport!=null)||(!sport.isEmpty())))
            {
                cl = new Client(name, ipadd, Integer.parseInt(sport));
            }
            else if(((name!=null)||(!name.isEmpty()))&&((sport==null)||(sport.isEmpty())))
            {
                cl = new Client(name, ipadd, 6789);
            }
            else if(((name==null)||(name.isEmpty()))&&((sport!=null)||(!sport.isEmpty())))
            {
                cl = new Client("client", ipadd, Integer.parseInt(sport));
            }
            else
            {
                cl = new Client("Client", ipadd, 6789);
            }
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e);
            cl = new Client("Client", "", 6789);
        }
    }
}
