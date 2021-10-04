/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclient;

import java.awt.FileDialog;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URISyntaxException;
import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;

/**
 *
 * @author Rajnish
 */
public class Client extends javax.swing.JFrame
{
    private java.net.Socket connection;
    private java.io.ObjectOutputStream output;
    private ObjectInputStream input;
    private String name = "Client";
    private String ip;
    private int port;
    private String message;
    /**
     * Creates new form Client
     */
    public Client(String sname, String ipadd, int port)
    {
        this.name = sname;
        this.ip = ipadd;
        this.port = port;
        initComponents();
        this.setSize(500, 300);
        this.setVisible(true);
        start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendpane = new javax.swing.JPanel();
        progress = new javax.swing.JProgressBar();
        scrollpane = new javax.swing.JScrollPane();
        printPane = new javax.swing.JEditorPane();
        inputpanel = new javax.swing.JPanel();
        msglabel = new javax.swing.JLabel();
        messagebox = new javax.swing.JTextField();
        sendbutton = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        savebutton = new javax.swing.JButton();
        this.setLocation(500, 500);
        this.setIconImage(new javax.swing.ImageIcon(this.getClass().getResource("/resources/icon.jpg")).getImage());
        menubar = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        exitmenuitem = new javax.swing.JMenuItem();
        themeMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Chat");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        sendpane.setLayout(new java.awt.BorderLayout());

        progress.setToolTipText("sending.....");
        sendpane.add(progress, java.awt.BorderLayout.SOUTH);

        printPane.setEditable(false);
        printPane.setContentType("text/html"); // NOI18N
        printPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printPaneMouseClicked(evt);
            }
        });
        printPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                printPaneHyperlinkUpdate(evt);
            }
        });
        scrollpane.setViewportView(printPane);

        sendpane.add(scrollpane, java.awt.BorderLayout.CENTER);

        getContentPane().add(sendpane, java.awt.BorderLayout.CENTER);

        inputpanel.setLayout(new java.awt.BorderLayout());

        msglabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        msglabel.setText("Message :");
        msglabel.setToolTipText("");
        inputpanel.add(msglabel, java.awt.BorderLayout.WEST);

        messagebox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        messagebox.setToolTipText("Enter the message here.");
        messagebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageboxActionPerformed(evt);
            }
        });
        inputpanel.add(messagebox, java.awt.BorderLayout.CENTER);

        sendbutton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        sendbutton.setText("Send");
        sendbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbuttonActionPerformed(evt);
            }
        });
        inputpanel.add(sendbutton, java.awt.BorderLayout.EAST);

        jToolBar1.setRollover(true);

        savebutton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        savebutton.setText("Save Chat");
        savebutton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        savebutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });
        jToolBar1.add(savebutton);

        inputpanel.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(inputpanel, java.awt.BorderLayout.PAGE_START);

        filemenu.setText("File");

        exitmenuitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitmenuitem.setText("Exit");
        exitmenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitmenuitemActionPerformed(evt);
            }
        });
        filemenu.add(exitmenuitem);

        menubar.add(filemenu);

        themeMenu.setText("Themes");

        jMenuItem2.setText("System");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem2);

        jMenuItem3.setText("Metal(Java)");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem3);

        jMenuItem5.setText("Nimbus");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem5);

        jMenuItem4.setText("Motif/CDE");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem4);

        menubar.add(themeMenu);

        jMenu1.setText("Help");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menubar.add(jMenu1);

        setJMenuBar(menubar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitmenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitmenuitemActionPerformed

        System.exit(0);
    }//GEN-LAST:event_exitmenuitemActionPerformed

    private void messageboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageboxActionPerformed

        progress(true);
        sendMessage(evt.getActionCommand());
        messagebox.setText("");
        progress(false);
    }//GEN-LAST:event_messageboxActionPerformed

    private void sendbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendbuttonActionPerformed

        progress(true);
        sendMessage(messagebox.getText());
        messagebox.setText("");
        progress(false);
    }//GEN-LAST:event_sendbuttonActionPerformed

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
        save();
    }//GEN-LAST:event_savebuttonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        About dialog = new About(this, false);
        dialog.setIconImage(this.getIconImage());
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.PLATFORM);
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.METAL);
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.NIMBUS);
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.MOTIF);
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void printPaneHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_printPaneHyperlinkUpdate
        // TODO add your handling code here:
        try
        {
            java.awt.Desktop.getDesktop().browse(evt.getURL().toURI());
        }
        catch(URISyntaxException | IOException e)
        {
            warnUser("Unable to open the URL\n"+String.valueOf(evt.getURL()));
        }
    }//GEN-LAST:event_printPaneHyperlinkUpdate

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void printPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printPaneMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==3)
        {
            JPopupMenu menu = getPrintPanePopupMenu();
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_printPaneMouseClicked
 
    private void progress(boolean con)
    {
        progress.setIndeterminate(con);
    }
    private JPopupMenu getPrintPanePopupMenu()
    {
        JPopupMenu pmenu = new JPopupMenu();
        pmenu.add(new AbstractAction("Clear")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                printPane.setText("");
            }
        });
        pmenu.add(new AbstractAction("Save")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                save();
            }
        });
        return pmenu;
    }
    private void save()
    {
        FileDialog fd = new java.awt.FileDialog(this, "Save chat as", FileDialog.SAVE);
        fd.setDirectory(System.getProperty("user.dir"));
        fd.setVisible(true);
        try
        {
            FileWriter save = new java.io.FileWriter(fd.getFile());
            String data = printPane.getText();
            save.write(data);
            save.close();
        }
        catch(IOException ex)
        {
            warnUser("Unable to save the chat!");
        }
    }
    
    private void start()
    {
        try
        {
            progress(true);
            connectToServer();
            setupStreams();
            progress(false);
            whileChatting();
        }
        catch(EOFException eofe)
        {
            showMessage("Client terminated connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCrap();
        }
    }
    
    private void connectToServer() throws IOException
    {
        showMessage("Attempting connection ");
        connection= new Socket(InetAddress.getByName(ip),port);
        progress.setIndeterminate(true);
        showMessage("Connected to "+connection.getInetAddress().getHostName());
    }
    
    private void setupStreams()throws IOException
    {
        output= new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input=new ObjectInputStream(connection.getInputStream());
        showMessage("Streams are now good to go...");
    }
    
    private void whileChatting()throws IOException
    {
        messagebox.setEditable(true);
        progress.setIndeterminate(false);
        do
        {
            try
            {
                message= (String) input.readObject();
                showMessage(message);
            }
            catch(ClassNotFoundException e)
            {
                showMessage("I dont know what user send");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        while(!message.equals("CLIENT - END"));
    }
    
    private void sendMessage(String msg)
    {
        try
        {
            output.writeObject(name+" : "+msg);
            output.flush();
            showMessage(name+" : "+msg);
        }
        catch(Exception e)
        {
            printPane.setText("Unable to send message");
        }
    }
    
    private void showMessage(final String msg)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                append(msg+"\n");
            }
        });
    }
    
    private void append(String s)
    {
        try
        {
            Document doc = printPane.getDocument();
            if(s==null||s.equals("")) return;
            Reader r = new StringReader(s);
            EditorKit kit = printPane.getEditorKit();
            kit.read(r, doc, doc.getLength());
        }
        catch(Exception e)
        {
            warnUser("Unable to display on chat board!\n"+e);
        }
    }
    
    private void closeCrap()
    {
        showMessage("Closing crap down!");
        warnUser("Closing crap!");
        messagebox.setEditable(false);
        try
        {
            output.close();
            input.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void warnUser(String msg)
    {
        javax.swing.JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitmenuitem;
    private javax.swing.JMenu filemenu;
    private javax.swing.JPanel inputpanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JTextField messagebox;
    private javax.swing.JLabel msglabel;
    private javax.swing.JEditorPane printPane;
    private javax.swing.JProgressBar progress;
    private javax.swing.JButton savebutton;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JButton sendbutton;
    private javax.swing.JPanel sendpane;
    private javax.swing.JMenu themeMenu;
    // End of variables declaration//GEN-END:variables

}
