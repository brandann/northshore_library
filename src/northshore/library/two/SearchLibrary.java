/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author brandan
 */
public class SearchLibrary extends JFrame{
    private JPanel bufferPanel1;
    private JPanel jobPanel1;
    private JLabel jobLabel;
    private JTextField jobTextField;
    private JLabel jobBuffer1;
    private JPanel jobPanel2;
    private JLabel jobBuffer2;
    private JComboBox jobComboBox;
    private JButton jobButton;
    private JPanel numberPanel;
    private JLabel numberLabel;
    private JTextField numberTextField;
    private JLabel numberBuffer1;
    private JPanel numberPanel2;
    private JLabel numberBuffer21;
    private JComboBox numberComboBox;
    private JButton numberButton;
    private JPanel bufferPanel2;
    private boolean manage;
    

    
    public SearchLibrary(boolean manage) throws ClassNotFoundException, IOException{
        this.manage = manage;
        if(this.manage)
            System.out.println("Manage = true");
        setLayout(new BorderLayout());
        setSize(FRAME_WIDTH, (FRAME_HEIGHT + FRAME_HEIGHT/2) );
        setBackground(Color.WHITE);
        initComponents();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(new Point((screenSize.width  - FRAME_WIDTH)  / 2,
                              (screenSize.height - (FRAME_HEIGHT + FRAME_HEIGHT/2)) / 2));
        try {
            URL url = this.getClass().getResource(driver.ICON);
            //System.out.println(buildDriver.ICON);
            //System.out.println(url);
            Image img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            setIconImage(icon.getImage());
        }
        catch(Exception e){System.out.println(e);}
    }
    
    private void initComponents() throws ClassNotFoundException, IOException{
        listArrayList = new ArrayList<String>();
        databaseMatch = new ArrayList<Detail>();
        cardPanel = new JPanel();
        cardPanel.setLayout(card);
        database = new Database();
        matches = database.getDatabase();
        databaseArray = database.getDatabase();
        
        initMenu();
        initTitle();
        initButtons();
        initSearchByTags();
        initSearchByKeyword();
        initSearchByJob();
        
        matchLabel.setText("Database Size: " + database.getItems());
        
        cardPanel.add(searchByTagPanel, SEARCH_BY_TAGS );
        cardPanel.add(searchByKeywordPanel, SEARCH_BY_KEYWORDS );
        cardPanel.add(searchByJobPanel, SEARCH_BY_JOB );
        add(cardPanel, BorderLayout.CENTER);
        card.show(cardPanel, SEARCH_BY_KEYWORDS);
        currentCard = SEARCH_BY_KEYWORDS;
        searchButton.setVisible(true);
    }
    
    private void initMenu(){
        menuBar = new JMenuBar();
        
        menuFile = new JMenu();
        menuSearchByKeyword = new JMenuItem();
        menuSearchByTag = new JMenuItem();
        menuSearchByJob = new JMenuItem();
        menuStandards = new JMenuItem();
        menuEditSwitch = new JMenuItem();
        menuClose = new JMenuItem();
        menuFile.setText("File");
        menuSearchByKeyword.setText("Search Detail By Keywords");
        menuSearchByTag.setText("Search By Detail Tags");
        menuSearchByJob.setText("Search By Job Information");
        menuStandards.setText("Standards Lookup");
        menuEditSwitch.setText("Open Manager");
        menuClose.setText("Exit");
        menuFile.add(menuSearchByKeyword);
        menuFile.add(menuSearchByTag);
        menuFile.add(menuSearchByJob);
        menuFile.add(menuStandards);
        if(manage)
            menuFile.add(menuEditSwitch);
        menuFile.add(menuClose);
        menuSearchByKeyword.addActionListener(new java.awt.event.ActionListener() {public void actionPerformed(java.awt.event.ActionEvent evt) {
                card.show(cardPanel, SEARCH_BY_KEYWORDS);
                currentCard = SEARCH_BY_KEYWORDS;
                searchButton.setVisible(true);
                //driver.FNI();
            }
        });
        menuSearchByTag.addActionListener(new java.awt.event.ActionListener() {public void actionPerformed(java.awt.event.ActionEvent evt) {
                card.show(cardPanel, SEARCH_BY_TAGS);
                currentCard = SEARCH_BY_TAGS;
                searchButton.setVisible(true);
            }
        });
        menuSearchByJob.addActionListener(new java.awt.event.ActionListener() {public void actionPerformed(java.awt.event.ActionEvent evt) {
                card.show(cardPanel, SEARCH_BY_JOB);
                currentCard = SEARCH_BY_JOB;
                searchButton.setVisible(false);
                //driver.FNI();
            }
        });
        menuStandards.addActionListener(new java.awt.event.ActionListener() {public void actionPerformed(java.awt.event.ActionEvent evt) {
                //card.show(standardsPanel, SEARCH_BY_STANDARDS);
                //currentCard = SEARCH_BY_STANDARDS;
                //searchButton.setVisible(false);
                driver.FNI();
            }
        });
        menuEditSwitch.addActionListener(new java.awt.event.ActionListener() {public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFrame frame;
                try {
                    frame = new ManageLibrary();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    //frame.setResizable(false);
                    frame.setTitle(driver.EDIT_FORM_TITLE);
                    frame.setMaximumSize(null); 
                    setVisible(false);
                    dispose();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SearchLibrary.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SearchLibrary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuClose.addActionListener(new java.awt.event.ActionListener() {public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        
        menuHelp = new JMenu();
        menuHelpitem = new JMenuItem();
        menuChangeLog = new JMenuItem();
        menuHelp.setText("Help");
        menuHelpitem.setText("Help");
        menuChangeLog.setText("Change Log");
        menuHelp.add(menuHelpitem);
        menuHelp.add(menuChangeLog);
        menuHelpitem.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            try{
                Desktop d = Desktop.getDesktop();
                d.open(new File("Help.html"));
            }
            catch(Exception e){}
        }});
        menuChangeLog.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            try{
                Desktop d = Desktop.getDesktop();
                d.open(new File("changelog.html"));
            }
            catch(Exception e){}
        }});
        
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);
    }
    
    private void initTitle(){
        titlePanel = new JPanel();
        titleLabel = new JLabel("Northshore Library Search");
        
        titleLabel.setFont(new Font("", Font.BOLD, 29));
        titleLabel.setForeground(driver.colorColor);
        
        titleLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2)
                    driver.brandanMessage();
            }
        });
        
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
    }
    
    private void initButtons(){
        buttonPanel = new JPanel();
        searchButton = new JButton("Search!"); 
        matchLabel = new JLabel(matches.length + " Matches");
        searchButton.setPreferredSize(new Dimension(150,25));
        matchLabel.setPreferredSize(new Dimension(150,25));
        buttonPanel.add(searchButton);
        buttonPanel.add(matchLabel);
        searchButton.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent evt) {
            displaySearch();
        }});
        
        add(buttonPanel, BorderLayout.SOUTH);
        matchLabel.setFont(new Font("", Font.BOLD, 13));
        matchLabel.setForeground(driver.colorColor);
    }
    
    private void displaySearch(){
        String text = "";
        if(currentCard.equals(SEARCH_BY_TAGS)){
                
        }
        else if(currentCard.equals(SEARCH_BY_KEYWORDS)){
            text = searchTextField.getText().toUpperCase();
            if(text.contains(",")){
                String[] texts = text.split(",");
                for(int i = 0; i < texts.length; i++)
                    texts[i] = texts[i].trim();
                matches = new Search().SearchEverything(texts, database.getDatabase(), driver.EXCLUSIVE);
            }
            else{
                matches = new Search().SearchEverything(text, database.getDatabase());
            }
        }

        if(matches.length > 0 && matches.length < MAX_SEARCH_RESULTS){
            Random r = new Random();
            HtmlOut h = new HtmlOut(matches, r.nextLong() + ".html");
            matches = database.getDatabase();
        }
        else if(text.equals("$")){
            int n = JOptionPane.showConfirmDialog(null, "Are you sure you would like to display ALL entries? This could take awhile", "Confirm", JOptionPane.YES_NO_OPTION); //yes == 0, no == 1
            if(n == 0){
                Random r = new Random();
                HtmlOut h = new HtmlOut(matches, r.nextLong() + ".html");
                matches = database.getDatabase();
            }
        }
        else if(matches.length <= 0){
            driver.infoBox("No Matches Found, Please Revise Your Search Criteria", "No Matches");
        }
        else if(matches.length >= MAX_SEARCH_RESULTS){
            driver.infoBox(matches.length + " Matches Found, Please Narrow Down Your Search Criteria To Under " + MAX_SEARCH_RESULTS, "Too Many Matches");
        }
    }

    private void initSearchByTags(){
        searchByTagPanel = new JPanel(new BorderLayout());
        
        comboPanel = new JPanel();
        listPanel = new JPanel();
        removeButtonPanel = new JPanel();
        
        systemsComboBox = new JComboBox(driver.SystemsStringArray);
        tagsComboBox = new JComboBox(driver.readTextFile(driver.SystemsStringArray[0] + ".txt", driver.SORT));
        
        addTagButton = new JButton("Add Tag To Search List");
        removeButton = new JButton("Remove Tag");
        clearButton = new JButton("Clear Tags");
        
        systemsComboBox.setPreferredSize(new Dimension(125,25));
        tagsComboBox.setPreferredSize(new Dimension(250,25));
        addTagButton.setPreferredSize(new Dimension(150,25));
        removeButton.setPreferredSize(new Dimension(150,25));
        clearButton.setPreferredSize(new Dimension(150,25));
        
        systemsLabel = new JLabel("Selected System For Relevent Tags");
        tagsLabel = new JLabel("Select Tags To Search For");
        
        list = new JList(listArrayList.toArray());
        scrollTags = new JScrollPane(list);
        
        scrollTags.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTags.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTags.setPreferredSize(new Dimension(400,200));
        comboPanel.add(systemsComboBox);
        comboPanel.add(tagsComboBox);
        //comboPanel.add(addTagButton);
        listPanel.add(scrollTags);
        removeButtonPanel.add(clearButton);
        removeButtonPanel.add(removeButton);
        
        searchByTagPanel.add(comboPanel, BorderLayout.NORTH);
        searchByTagPanel.add(listPanel, BorderLayout.CENTER);
        searchByTagPanel.add(removeButtonPanel, BorderLayout.SOUTH);
        
        clearButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listArrayList.clear();
                list.setListData(listArrayList.toArray());
                search();
        }});
        removeButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(listArrayList.size() > 0){
                    int index = list.getSelectedIndex();
                    if(list.getSelectedIndex() > -1){
                        listArrayList.remove(index);
                        list.setListData(listArrayList.toArray());
                    }
                    if(listArrayList.size() == 0){
                        index = -1;
                    }
                    else if(listArrayList.size() <= index){
                        index--;
                    }
                    list.setSelectedIndex(index);
                }
                search();
        }});
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    if(listArrayList.size() > 0){
                        int index = list.getSelectedIndex();
                        if(list.getSelectedIndex() > -1){
                            listArrayList.remove(index);
                            list.setListData(listArrayList.toArray());
                        }
                        if(listArrayList.size() == 0){
                            index = -1;
                        }
                        else if(listArrayList.size() <= index){
                            index--;
                        }
                        list.setSelectedIndex(index);
                    }
                    search();
                }
            }
        });
        systemsComboBox.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagsComboBox.removeAllItems();
                String[] newTags = driver.readTextFile((String) systemsComboBox.getSelectedItem() + ".txt", driver.SORT);
                for(int i = 0; i < newTags.length; i++){
                    tagsComboBox.setModel(new JComboBox<>(newTags).getModel());
                }
        }});
        tagsComboBox.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String newTag = "";
                newTag = (String) tagsComboBox.getSelectedItem();
                if(newTag != null){
                    listArrayList.add(newTag.toUpperCase());
                    search();
                }
                
        }});
        addTagButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String newTag = "";
                newTag = (String) tagsComboBox.getSelectedItem();
                listArrayList.add(newTag.toUpperCase());
                search();
        }});  
    }
    
    private void initSearchByKeyword(){
        searchByKeywordPanel = new JPanel();
        searchTextField = new JTextField();
        searchLabel = new JLabel("Type Any Keyword To Search For:");
        searchTextField.setPreferredSize(new Dimension(200,20));
        searchLabel.setPreferredSize(new Dimension(180,300));
        searchTextField.setToolTipText("Seperate Search Terms With A Comma");
        searchByKeywordPanel.add(searchLabel);
        searchByKeywordPanel.add(searchTextField);
        searchTextField.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent evt) {
            displaySearch();
        }});
    }
    
    private void initSearchByJob(){
        searchByJobPanel = new JPanel(new GridLayout(6,1));
        
        bufferPanel1 = new JPanel();
        searchByJobPanel.add(bufferPanel1);
        
        jobPanel1 = new JPanel();
        jobLabel = new JLabel("Job Name:");
        jobTextField = new JTextField();
        jobBuffer1 = new JLabel("");
        jobLabel.setPreferredSize(new Dimension(100,25));
        jobTextField.setPreferredSize(new Dimension(200,25));
        jobBuffer1.setPreferredSize(new Dimension(150,25));
        jobPanel1.add(jobLabel);
        jobPanel1.add(jobTextField);
        jobPanel1.add(jobBuffer1);
        searchByJobPanel.add(jobPanel1);
        
        ArrayList<String> namel = new ArrayList<>();
        for(Detail e : database.getDatabase())
            if(e != null)
                namel.add(e.getJobName());
        Collections.sort(namel);
        namel = driver.removeDuplicates(namel);
        String[] names = new String[namel.size()];
        names = namel.toArray(names);
        
        jobPanel2 = new JPanel();
        jobBuffer2 = new JLabel("");
        jobComboBox = new JComboBox(names);
        jobButton = new JButton("Search");
        jobBuffer2.setPreferredSize(new Dimension(100,25));
        jobComboBox.setPreferredSize(new Dimension(200,25));
        jobButton.setPreferredSize(new Dimension(150,25));
        jobPanel2.add(jobBuffer2);
        jobPanel2.add(jobComboBox);
        jobPanel2.add(jobButton);
        searchByJobPanel.add(jobPanel2);
        jobButton.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchJobName();
        }});
        jobTextField.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchJobName();
        }});
        
        numberPanel = new JPanel();
        numberLabel = new JLabel("Job Number:");
        numberTextField = new JTextField();
        numberBuffer1 = new JLabel("");
        numberLabel.setPreferredSize(new Dimension(100,25));
        numberTextField.setPreferredSize(new Dimension(200,25));
        numberBuffer1.setPreferredSize(new Dimension(150,25));
        numberPanel.add(numberLabel);
        numberPanel.add(numberTextField);
        numberPanel.add(numberBuffer1);
        searchByJobPanel.add(numberPanel);
        
        ArrayList<String> numl = new ArrayList<>();
        for(Detail e : database.getDatabase())
            if(e != null)
                numl.add(e.getJobNumber());
        Collections.sort(numl);
        numl = driver.removeDuplicates(numl);
        String[] nums = new String[numl.size()];
        nums = numl.toArray(names);
        
        numberPanel2 = new JPanel();
        numberBuffer21 = new JLabel("");
        numberComboBox = new JComboBox(nums);
        numberButton = new JButton("Search");
        numberBuffer21.setPreferredSize(new Dimension(100,25));
        numberComboBox.setPreferredSize(new Dimension(200,25));
        numberButton.setPreferredSize(new Dimension(150,25));
        numberPanel2.add(numberBuffer21);
        numberPanel2.add(numberComboBox);
        numberPanel2.add(numberButton);
        searchByJobPanel.add(numberPanel2);
        numberButton.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchJobNumber();
        }});
        numberTextField.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchJobNumber();
        }});
        
        bufferPanel2 = new JPanel();
        searchByJobPanel.add(bufferPanel2);
    }
    
    private void searchJobName(){
        matches = database.getDatabase();
            if(!jobTextField.getText().isEmpty()){
                matches = new Search().SearchJobName(jobTextField.getText().toUpperCase().trim(), database.getDatabase());
            }
            else {
                matches = new Search().SearchJobName(String.valueOf(jobComboBox.getSelectedItem()), database.getDatabase());
            }
            
            if(matches.length > 0 && matches.length < MAX_SEARCH_RESULTS){
                Random r = new Random();
                HtmlOut h = new HtmlOut(matches, r.nextLong() + ".html");
                matches =  database.getDatabase();
            }
    }
    
    private void searchJobNumber(){
        matches = database.getDatabase();
            if(!numberTextField.getText().isEmpty()){
                matches = new Search().SearchJobNumber(numberTextField.getText().toUpperCase().trim(), database.getDatabase());
            }
            else {
                matches = new Search().SearchJobNumber(String.valueOf(numberComboBox.getSelectedItem()), database.getDatabase());
            }
            
            if(matches.length > 0 && matches.length < MAX_SEARCH_RESULTS){
                Random r = new Random();
                HtmlOut h = new HtmlOut(matches, r.nextLong() + ".html");
                matches =  database.getDatabase();
            }
    }
    
    private void search(){
        list.setListData(listArrayList.toArray());
        matches = new Search().SearchTag(listArrayList, database.getDatabase(), driver.EXCLUSIVE);
        String label = " Matches";
        if(matches.length == 1)
            label = " Match";
        else if(matches.length == 0)
            label = label + " :(";            
        matchLabel.setText(matches.length + label);
        if(listArrayList.size() == 0)
            matchLabel.setText("Database Size: " + database.getItems());
        if(matches.length > MAX_SEARCH_RESULTS)
            matchLabel.setText("Too many Matches!");
        
    }
    
    private void exit(int exitCommand){
        if(exitCommand == EXIT_PROGRAM){
            System.exit(EXIT_PROGRAM);
        }
        else if(exitCommand == EXIT_FRAME){
            setVisible(false);
            dispose();
        }
        
    }

    public static void errorBox(String errorMessage, String title){
        JOptionPane.showMessageDialog(null, errorMessage, "Error: " 
                + title, JOptionPane.ERROR_MESSAGE);
    }
    
    CardLayout card= new CardLayout();
    private ArrayList<Detail> databaseMatch;
    private ArrayList<String> listArrayList;
    private Driver driver = new Driver();
    private Database database;
    private Detail[] databaseArray;
    private Detail[] matches;
    private final int EXIT_FRAME = 1;
    private final int EXIT_PROGRAM = 0;
    private final int FRAME_HEIGHT = 300;
    private final int FRAME_WIDTH = 500;
    private final int MAX_SEARCH_RESULTS = 300;
    private final String SEARCH_BY_JOB = "searchByJob";
    private final String SEARCH_BY_KEYWORDS = "searchByKeywords";
    private final String SEARCH_BY_STANDARDS = "searchByStandards";
    private final String SEARCH_BY_TAGS = "searchByTags";
    private JButton addTagButton;
    private JButton clearButton;
    private JButton exitButton;
    private JButton removeButton;
    private JButton searchButton;
    private JComboBox searchPrefComboBox;
    private JComboBox systemsComboBox;
    private JComboBox tagsComboBox;
    private JLabel matchLabel;
    private JLabel searchLabel;
    private JLabel systemsLabel;
    private JLabel tagsLabel;
    private JLabel titleLabel;
    private JList list;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuBar menuBar;
    private JMenuItem menuChangeLog;
    private JMenuItem menuClose;
    private JMenuItem menuEditSwitch;
    private JMenuItem menuHelpitem;
    private JMenuItem menuSearchByJob;
    private JMenuItem menuSearchByKeyword;
    private JMenuItem menuSearchByTag;
    private JMenuItem menuStandards;
    private JPanel buttonPanel;
    private JPanel cardPanel;
    private JPanel comboPanel;
    private JPanel listButtonPanel;
    private JPanel listPanel;
    private JPanel removeButtonPanel;
    private JPanel searchByJobPanel;
    private JPanel searchByKeywordPanel;
    private JPanel searchByTagPanel;
    private JPanel tagButtonPanel;
    private JPanel titlePanel;
    private JScrollPane scrollTags;
    private JTextField searchTextField;
    private String currentCard = SEARCH_BY_TAGS;
    private boolean addBlock = false;
    
}
