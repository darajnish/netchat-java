package chat;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rajnish
 */
public class ChatServer
{
    private static Server server;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
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
            String name = javax.swing.JOptionPane.showInputDialog(null, "Enter the server's name:", "Input", JOptionPane.QUESTION_MESSAGE);
            String sport = javax.swing.JOptionPane.showInputDialog("Enter a port number:");
            if(((name!=null)||(!name.isEmpty()))&&((sport!=null)||(!sport.isEmpty())))
            {
                server = new Server(name, Integer.parseInt(sport));
            }
            else if(((name!=null)||(!name.isEmpty()))&&((sport==null)||(sport.isEmpty())))
            {
                server = new Server(name, 6789);
            }
            else if(((name==null)||(name.isEmpty()))&&((sport!=null)||(!sport.isEmpty())))
            {
                server = new Server("Server", Integer.parseInt(sport));
            }
            else
            {
                server = new Server("Server", 6789);
            }
            
        }
        catch(HeadlessException | NumberFormatException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e);
            server = new Server("Server", 6789);
        }
    }
}
