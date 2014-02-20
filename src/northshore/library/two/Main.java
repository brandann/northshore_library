/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author brandan
 */
public class Main {
        public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Windows".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Driver driver = new Driver();
        if(args.length > 0){
            if(args[0].equals("Manage-2")){
                JFrame frame = new SearchLibrary(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setTitle(driver.SEARCH_FORM_TITLE);
                frame.setMaximumSize(null); 
            }
            else if(args[0].equals("search")){
                JFrame frame = new SearchLibrary(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setTitle(driver.SEARCH_FORM_TITLE);
                frame.setMaximumSize(null); 
            }
            else if(args[0].equals("-s")){
                String list = "";
                for (int i = 1; i < args.length; i++)
                {
                    System.out.println(args[i]);
                    list += " " + args[i];
                }
                Searchable s = new Searchable(list);
            }
            else if(args[0].equals("-i")){
                String list = "";
                for (int i = 1; i < args.length; i++)
                {
                    System.out.println(args[i]);
                    list += " " + args[i];
                }
                Import i = new Import();
            }
        }
        else{
                JFrame frame = new SearchLibrary(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setTitle(driver.SEARCH_FORM_TITLE);
                frame.setMaximumSize(null); 
        }
        
    }
}
