/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.JFrame;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
/**
 *
 * @author Rajnish
 */
public class Server extends javax.swing.JFrame
{

    private java.net.ServerSocket server;
    private java.net.Socket connection;
    private java.io.ObjectOutputStream output;
    private ObjectInputStream input;
    private String name = "Server";
    private int port;
    /**
     * Creates new form Server
     */
    public Server(String name, int port)
    {
        this.name = name;
        this.port = port;
        this.initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputpanel = new javax.swing.JPanel();
        msglabel = new javax.swing.JLabel();
        messagebox = new javax.swing.JTextField();
        sendbutton = new javax.swing.JButton();
        sendpane = new javax.swing.JPanel();
        progress = new javax.swing.JProgressBar();
        scrollpane = new javax.swing.JScrollPane();
        printPane = new javax.swing.JEditorPane();
        jToolBar1 = new javax.swing.JToolBar();
        savebutton = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        exitmenuitem = new javax.swing.JMenuItem();
        themeMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Chat");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(700, 500));

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

        sendpane.setLayout(new java.awt.BorderLayout());

        progress.setToolTipText("sending.....");
        sendpane.add(progress, java.awt.BorderLayout.SOUTH);

        printPane.setEditable(false);
        printPane.setContentType("text/html"); // NOI18N
        scrollpane.setViewportView(printPane);

        sendpane.add(scrollpane, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        savebutton.setText("Save Chat");
        savebutton.setToolTipText("Save file:");
        savebutton.setFocusable(false);
        savebutton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        savebutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });
        jToolBar1.add(savebutton);

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

        themeMenu.setText("Theme");

        jMenuItem1.setText("System");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem1);

        jMenuItem2.setText("Metal(Java)");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem2);

        jMenuItem3.setText("Nimbus");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem3);

        jMenuItem4.setText("Motif/CDE");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        themeMenu.add(jMenuItem4);

        menubar.add(themeMenu);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sendpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendpane, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
        );

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
        try
        {
            String path = javax.swing.JOptionPane.showInputDialog("Enter a filename for the chat");
            save(path+".txt");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            warnUser("Unable to save!");
        }
    }//GEN-LAST:event_savebuttonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.PLATFORM);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.MOTIF);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.METAL);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Theme.setTheme(Theme.NIMBUS);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
    private void progress(boolean con)
    {
        progress.setIndeterminate(con);
    }
    private void save(String file)
    {
        try
        {
            FileWriter save = new java.io.FileWriter(file);
            String data = printPane.getText();
            save.write(data);
            save.close();
        }catch(Exception e){e.printStackTrace();}
    }
    
    private void start()
    {
        try
        {
            server = new java.net.ServerSocket(port, 100);
            while(true)
            {
                try
                {
                    progress.setIndeterminate(true);
                    waitForConnection();
                    setupStreams();
                    progress.setIndeterminate(false);
                    whileChatting();
                }
                catch(EOFException eofe)
                {
                    showMessage("Server ended connection!");
                }
                finally
                {
                    closeCrap();
                }
            }
        }
        catch(Exception e)
        {
            warnUser(e.getMessage());
        }
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
            warnUser("Unable to send message");
        }
    }
    
    private void warnUser(String msg)
    {
        javax.swing.JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void waitForConnection() throws IOException
    {
        showMessage("Waiting For Someone to connect.....");
        connection = server.accept();
        showMessage("Now Connected "+connection.getInetAddress().getHostName()+"("+connection.getInetAddress().getHostAddress()+")");
    }

    private void setupStreams() throws IOException
    {
        output= new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input=new ObjectInputStream(connection.getInputStream());
        showMessage("Streams are now setup!");
    }

    private void whileChatting() throws IOException
    {
        String message= "Your are now connected";
        sendMessage(message);
        messagebox.setEditable(true);
        do
        {
            try
            {
                message= (String) input.readObject();
                showMessage(message);                               
            }
            catch(ClassNotFoundException cnfe)
            {
                showMessage("I dont know what user send");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        while(!message.equals("SERVER - END"));
    }

    private void closeCrap()
    {
        showMessage("Closing connection....");
        messagebox.setEditable(false);
        try
        {
            output.close();
            input.close();
            connection.close();
        }
        catch(IOException e)
        {
            warnUser(e.getMessage());
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exitmenuitem;
    private javax.swing.JMenu filemenu;
    private javax.swing.JPanel inputpanel;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
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
