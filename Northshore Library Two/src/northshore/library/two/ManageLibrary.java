/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author brandan
 */
public class ManageLibrary extends JFrame{

    public ManageLibrary() throws ClassNotFoundException, IOException{
        setLayout(new BorderLayout());
        setSize(FRAME_WIDTH, (FRAME_HEIGHT + FRAME_HEIGHT/2) );
        setBackground(Color.WHITE);
        initComponents();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(new Point((screenSize.width  - FRAME_WIDTH)  / 2,
                              (screenSize.height - (FRAME_HEIGHT + FRAME_HEIGHT/2)) / 2));
        try {
            URL url = this.getClass().getResource(driver.ICON);
            Image img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            setIconImage(icon.getImage());
        }
        catch(Exception e){System.out.println(e);}
    }
    
    private void initComponents() throws ClassNotFoundException, IOException{
        database = new Database();
        editing = false;
        selectedTagsArrayList = new ArrayList<>();
        currentDetail = database.getFirst();
        initMenu();
        initTitle();
        initButtons();
        initPicture();
        initInformation();
        setEntry();
        viewEnabled();
    }

    private void initMenu(){
        lastDetailMade = null;
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuHelp = new JMenu();
        menuSearchSwitch = new JMenuItem();
        menuHelpitem = new JMenuItem();
        menuNew = new JMenuItem();
        menuChangeLog = new JMenuItem();
        menuClose = new JMenuItem();
        
        menuFile.setText("File");
        menuHelp.setText("Help");
        menuSearchSwitch.setText("Open Search");
        menuNew.setText("New Entry");
        menuHelpitem.setText("Help");
        menuChangeLog.setText("Change Log");
        menuClose.setText("Exit");
        
        menuFile.add(menuSearchSwitch);
        menuFile.add(menuNew);
        menuFile.add(menuClose);
        
        menuHelp.add(menuHelpitem);
        menuHelp.add(menuChangeLog);
        
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        
        setJMenuBar(menuBar);
        menuNew.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetForm();
            editEnabled();
            loadPrevious();
            removeButton.setEnabled(false);
        }});
        menuSearchSwitch.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            
            
        }});
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
        menuClose.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            System.exit(0);
        }});
    }
    
    private void initTitle(){
        titlePanel = new JPanel();
        titleLabel = new JLabel("Northshore Library Manager");
        
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
        firstButton = new JButton();
        previousButton = new JButton();
        nextButton = new JButton();
        lastButton = new JButton();
        lookupEntryTextField = new JTextField();
        
        firstButton.setText("First Entry");
        previousButton.setText("<< Previous");
        nextButton.setText("Next >>");
        lastButton.setText("Last Entry");
        
        firstButton.setPreferredSize(new Dimension(150,25));
        previousButton.setPreferredSize(new Dimension(150,25));
        lookupEntryTextField.setPreferredSize(new Dimension(100,25));
        nextButton.setPreferredSize(new Dimension(150,25));
        lastButton.setPreferredSize(new Dimension(150,25));
        
        lookupEntryTextField.setHorizontalAlignment(JTextField.CENTER);
        lookupEntryTextField.setFont(new Font("", Font.BOLD, 12));
        lookupEntryTextField.setForeground(driver.colorColor);
        
        firstButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetForm();
            currentDetail = database.getFirst();
            setEntry();
        }});
        previousButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetForm();
            currentDetail = database.getPrevious();
            setEntry();
        }});
        lookupEntryTextField.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(!lookupEntryTextField.getText().isEmpty()){
                if(currentDetail.getEntry() != Integer.valueOf(lookupEntryTextField.getText())){
                    int index = Integer.valueOf(lookupEntryTextField.getText());
                    resetForm();
                    currentDetail = database.get(index);
                    setEntry();
                }
            }
        }});
        nextButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetForm();
            currentDetail = database.getNext();
            setEntry();
        }});
        lastButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetForm();
            currentDetail = database.getLast();
            setEntry();
        }});
        lookupEntryTextField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){
                for(char c = ' '; c <= '/'; c++)
                    lookupEntryTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
                for(char c = ':'; c <= '~'; c++)
                    lookupEntryTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
            }
            public void keyReleased(KeyEvent e){}
        });
        
        buttonPanel.add(firstButton);
        buttonPanel.add(previousButton);
        buttonPanel.add(lookupEntryTextField);
        buttonPanel.add(nextButton);
        buttonPanel.add(lastButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    private void initPicture(){
        leftPanel = new JPanel();
        imageLabel = new JLabel();
        imageLabel.setBackground(Color.BLACK);
        imageLabel.setForeground(Color.BLACK);
        leftPanel.add(imageLabel);
        add(leftPanel, BorderLayout.WEST);
    }
    
    private void initInformation(){
        rightPanel = new JPanel(new BorderLayout());
        rightTopPanel = new JPanel(new GridLayout(12,1));
        rightCenterPanel = new JPanel();
        rightBottomPanel = new JPanel();
        
        //date
        datePanel = new JPanel();
        dateLabel = new JLabel("Date: ");
        dateInfoLabel = new JLabel("20130723");
        dateLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        dateInfoLabel.setPreferredSize(new Dimension(400,COMPONENT_HEIGHT));
        datePanel.add(dateLabel);
        datePanel.add(dateInfoLabel);
        rightTopPanel.add(datePanel);
        
        //Entry
        entryPanel = new JPanel();
        entryLabel = new JLabel("Entry: ");
        entryInfoLabel = new JLabel("37");
        entryLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        entryInfoLabel.setPreferredSize(new Dimension(400,COMPONENT_HEIGHT));
        entryPanel.add(entryLabel);
        entryPanel.add(entryInfoLabel);
        rightTopPanel.add(entryPanel);
        
        //Picture
        picPanel = new JPanel();
        picLabel = new JLabel("Image:");
        picLocation = new JLabel("");
        picButton = new JButton("Load Image");
        picLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        picLocation.setPreferredSize(new Dimension(300,COMPONENT_HEIGHT));
        picButton.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        
        picPanel.add(picLabel);
        picPanel.add(picLocation);
        picPanel.add(picButton);
        rightTopPanel.add(picPanel);
        picButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(lastPath));
            final FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("PNG Image (*.png)", "png");
            chooser.addChoosableFileFilter(pngFilter);
            chooser.setFileFilter(pngFilter);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(chooser.getSelectedFile().getName().toUpperCase());
                if(chooser.getSelectedFile().getName().toUpperCase().contains(".JPG") || chooser.getSelectedFile().getName().toUpperCase().contains(".PNG")){
                    picLocation.setText(chooser.getSelectedFile().getPath());
                    lastPath = chooser.getSelectedFile().getParent();
                    imageLabel.setIcon(getIcon(picLocation.getText()));
                    picLocation.setToolTipText(picLocation.getText());
                }
                else{
                    errorBox("Image file must be .jpg or .png format", "File Format Error");
                }
            }
        }});
        
        //PDF
        pdfPanel = new JPanel();
        pdfLabel = new JLabel("PDF:");
        pdfLocation = new JLabel("");
        pdfButton = new JButton("Load PDF");
        pdfLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        pdfLocation.setPreferredSize(new Dimension(300,COMPONENT_HEIGHT));
        pdfButton.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        
        pdfPanel.add(pdfLabel);
        pdfPanel.add(pdfLocation);
        pdfPanel.add(pdfButton);
        rightTopPanel.add(pdfPanel);
        pdfButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(lastPath));
            final FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF document (*.pdf)", "pdf");
            chooser.addChoosableFileFilter(pdfFilter);
            chooser.setFileFilter(pdfFilter);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(chooser.getSelectedFile().getName().toUpperCase());
                if(chooser.getSelectedFile().getName().toUpperCase().contains(".PDF")){
                    pdfLocation.setText(chooser.getSelectedFile().getPath());
                    lastPath = chooser.getSelectedFile().getParent();
                    pdfLocation.setToolTipText(pdfLocation.getText());
                }
                else{
                    errorBox("PDF file must be .pdf format", "File Format Error");
                }
            }
        }});
        
        //DWG
        dwgPanel = new JPanel();
        dwgLabel = new JLabel("DWG:");
        dwgLocation = new JLabel("");
        dwgButton = new JButton("Load DWG");
        dwgLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        dwgLocation.setPreferredSize(new Dimension(300,COMPONENT_HEIGHT));
        dwgButton.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        
        dwgPanel.add(dwgLabel);
        dwgPanel.add(dwgLocation);
        dwgPanel.add(dwgButton);
        rightTopPanel.add(dwgPanel);
        dwgButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(lastPath));
            final FileNameExtensionFilter dwgFilter = new FileNameExtensionFilter("Autocad Drawing (*.dwg)", "dwg");
            chooser.addChoosableFileFilter(dwgFilter);
            chooser.setFileFilter(dwgFilter);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(chooser.getSelectedFile().getName().toUpperCase());
                if(chooser.getSelectedFile().getName().toUpperCase().contains(".DWG")){
                    dwgLocation.setText(chooser.getSelectedFile().getPath());
                    lastPath = chooser.getSelectedFile().getParent();
                    dwgLocation.setToolTipText(dwgLocation.getText());
                }
                else{
                    errorBox("AutoCAD file must be .dwg format", "File Format Error");
                }
            }
        }});
        
        //company
        companyPanel = new JPanel();
        companyLabel = new JLabel("Company:");
        companyComboBox = new JComboBox(driver.companyStringArray);
        companyBufferLabel = new JLabel("");
        companyLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        companyComboBox.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        companyBufferLabel.setPreferredSize(new Dimension(250,COMPONENT_HEIGHT));
        companyPanel.add(companyLabel);
        companyPanel.add(companyComboBox);
        companyPanel.add(companyBufferLabel);
        rightTopPanel.add(companyPanel);
        companyComboBox.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(companyComboBox.getSelectedIndex() == 2)
                jobNumberTextField.setText("0000");
        }});
        
        //Job Name Information
        jobNamePanel = new JPanel();
        jobNameLabel = new JLabel("Job Name:");
        jobNameTextField = new JTextField("");
        jobNameLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        jobNameTextField.setPreferredSize(new Dimension(400,COMPONENT_HEIGHT));
        jobNameTextField.setToolTipText("Job Name: Match JobFile, Omit Contractor/Customer");
        jobNamePanel.add(jobNameLabel);
        jobNamePanel.add(jobNameTextField);
        rightTopPanel.add(jobNamePanel);
        jobNameTextField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){
                for(char c = '$'; c <= '$'; c++)
                    jobNameTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
            }
            public void keyReleased(KeyEvent e){}
        });

        //Job Number Information
        jobNumberPanel = new JPanel();
        jobNumberLabel = new JLabel("Job Number:");
        jobNumberTextField = new JTextField("");
        jobNumberBufferLabel = new JLabel("");
        jobNumberLoadInformationButton = new JButton("Load Information");
        jobNumberLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        jobNumberTextField.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        jobNumberBufferLabel.setPreferredSize(new Dimension(95,COMPONENT_HEIGHT));
        jobNumberLoadInformationButton.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        jobNumberPanel.add(jobNumberLabel);
        jobNumberPanel.add(jobNumberTextField);
        jobNumberPanel.add(jobNumberBufferLabel);
        jobNumberPanel.add(jobNumberLoadInformationButton);
        rightTopPanel.add(jobNumberPanel);
        jobNumberTextField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){
                for(char c = '$'; c <= '$'; c++)
                    jobNumberTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
            }
            public void keyReleased(KeyEvent e){}
        });
        jobNumberLoadInformationButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
                if(companyComboBox.getSelectedIndex() == 1){
                        chooser.setCurrentDirectory(new File("P:\\NorthClad\\Job file - NORTHCLAD"));
                    }
                else{
                        chooser.setCurrentDirectory(new File("P:\\Job File"));
                    }
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    String path = chooser.getSelectedFile().getPath();
                    if(path.toUpperCase().contains("J:\\") ||  path.toUpperCase().contains("\\JOB FILE\\")){
                        companyComboBox.setSelectedIndex(0);
                    }
                    else if(path.toUpperCase().contains("N:\\") || path.toUpperCase().contains("NORTHCLAD")){
                        companyComboBox.setSelectedIndex(1);
                    }
                    else{
                        companyComboBox.setSelectedIndex(2);
                    }
                    String pathName = chooser.getSelectedFile().getName();
                    System.out.println(pathName);
                    
                    if(companyComboBox.getSelectedIndex() == 0){
                        jobNameTextField.setText(pathName.substring(0, pathName.indexOf("-")));
                        jobNumberTextField.setText(pathName.substring(pathName.indexOf("(") + 1));
                    }
                    else if(companyComboBox.getSelectedIndex() == 1){
                        if(jobNameTextField.getText().contains("-")){
                            jobNameTextField.setText(pathName.substring(0, pathName.indexOf("-")));
                        }
                        else{
                            jobNameTextField.setText(pathName.substring(0, pathName.indexOf("NC")));
                        }
                        jobNumberTextField.setText(pathName.substring(pathName.indexOf("NC")));
                    }
                    else{
                        jobNameTextField.setText(pathName);
                        jobNumberTextField.setText("0000");
                    }
                    
                    String getNumber = jobNumberTextField.getText();
                    String newGetNumber = "";
                    for(char c : getNumber.toCharArray()){
                        if(String.valueOf(c).equals(")") || String.valueOf(c).equals("(")){
                            
                        }
                        else{
                            newGetNumber += String.valueOf(c);
                        }
                    }
                    newGetNumber = newGetNumber.trim();
                    jobNumberTextField.setText(newGetNumber.toUpperCase());
                    
                    String getJobName = jobNameTextField.getText();
                    String newJobName = "";
                    for(char c : getJobName.toCharArray()){
                        if(String.valueOf(c).equals(")") || String.valueOf(c).equals("(")){
                            
                        }
                        else{
                            newJobName += String.valueOf(c);
                        }
                    }
                    newJobName = newJobName.trim();
                    jobNameTextField.setText(newJobName.toUpperCase());
                }
        }});
        
        //Detail Description Information
        detailDescriptionPanel = new JPanel();
        detailDescriptionLabel = new JLabel("Detail Description:");
        detailDescriptionTextField = new JTextField("");
        detailDescriptionLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        detailDescriptionTextField.setPreferredSize(new Dimension(400,COMPONENT_HEIGHT));
        detailDescriptionPanel.add(detailDescriptionLabel);
        detailDescriptionPanel.add(detailDescriptionTextField);
        rightTopPanel.add(detailDescriptionPanel);
        detailDescriptionTextField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){
                for(char c = '$'; c <= '$'; c++)
                    detailDescriptionTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
            }
            public void keyReleased(KeyEvent e){}
        });
        
        
        //New Tag
        newTagPanel = new JPanel();
        newTagLabel = new JLabel("Create New Tag:");
        newTagTextField = new JTextField("");
        newTagComboBox = new JComboBox(driver.getSystemsArray());
        newTagButton = new JButton("Save");
        newTagLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        newTagTextField.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        newTagComboBox.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        newTagButton.setPreferredSize(new Dimension(150, COMPONENT_HEIGHT));
        newTagPanel.add(newTagLabel);
        newTagPanel.add(newTagTextField);
        newTagPanel.add(newTagComboBox);
        newTagPanel.add(newTagButton);
        rightTopPanel.add(newTagPanel);
        newTagButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            String newTag = newTagTextField.getText().toUpperCase();
            String category = String.valueOf(newTagComboBox.getSelectedItem());
            if(newTag.length() > 0){
                if(!driver.tagExist(newTag, category)){
                    driver.createTag(newTag, category);
                    addTag(newTag);
                    systemComboBox.setSelectedIndex(systemComboBox.getSelectedIndex());
                    newTagTextField.setText("");
                }
                else{
                    errorBox("Tag Alreay Exists", "Duplicate Tag");
                }
            }
        }});
        newTagTextField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){
                for(char c = '$'; c <= '$'; c++)
                    newTagTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
            }
            public void keyReleased(KeyEvent e){}
        });
        
        //Note
        notePanel = new JPanel();
        noteLabel = new JLabel("Add Note:");
        noteTextField = new JTextField("");
        noteButton = new JButton("Add");
        noteLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        noteTextField.setPreferredSize(new Dimension(250,COMPONENT_HEIGHT));
        noteButton.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        notePanel.add(noteLabel);
        notePanel.add(noteTextField);
        notePanel.add(noteButton);
        rightTopPanel.add(notePanel);
        noteButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(!noteTextField.getText().isEmpty()){
                addTag(noteTextField.getText().toUpperCase());
                noteTextField.setText("");
            }
        }});
        noteTextField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent e){}
            public void keyPressed(KeyEvent e){
                for(char c = '$'; c <= '$'; c++)
                    noteTextField.getInputMap().put(KeyStroke.getKeyStroke(c),"none");
            }
            public void keyReleased(KeyEvent e){}
        });
        noteTextField.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(!noteTextField.getText().isEmpty()){
                addTag(noteTextField.getText().toUpperCase());
                noteTextField.setText("");
            }
        }});
        
        //Tag Label
        tagLabelPanel = new JPanel();
        tagLibraryLabel = new JLabel("Tag Library");
        tagBuffer1Label = new JLabel("");
        tagBuffer2Label = new JLabel("");
        tagSelectedLibrary = new JLabel("Selected Tags");
        tagLibraryLabel.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        tagBuffer1Label.setPreferredSize(new Dimension(143,COMPONENT_HEIGHT));
        tagSelectedLibrary.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        tagBuffer2Label.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        tagLabelPanel.add(tagLibraryLabel);
        tagLabelPanel.add(tagBuffer1Label);
        tagLabelPanel.add(tagSelectedLibrary);
        tagLabelPanel.add(tagBuffer2Label);
        //rightTopPanel.add(tagLabelPanel);
        
        //Tag Info 1
        taginfo1Panel = new JPanel();
        //taginfo1Label = new JLabel("System:");
        systemComboBox = new JComboBox(driver.SystemsStringArray);
        taginfoBuffer2Label = new JLabel("");
        clearTagButton = new JButton("Clear Tags");
        taginfoBuffer3Label = new JLabel("");
        //taginfo1Label.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        systemComboBox.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        taginfoBuffer2Label.setPreferredSize(new Dimension(100,COMPONENT_HEIGHT));
        clearTagButton.setPreferredSize(new Dimension(150,COMPONENT_HEIGHT));
        taginfoBuffer3Label.setPreferredSize(new Dimension(50,COMPONENT_HEIGHT));
        //taginfo1Panel.add(taginfo1Label);
        taginfo1Panel.add(systemComboBox);
        taginfo1Panel.add(taginfoBuffer2Label);
        taginfo1Panel.add(clearTagButton);
        taginfo1Panel.add(taginfoBuffer3Label);
        rightTopPanel.add(taginfo1Panel);
        systemComboBox.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            tagLibraryList.setListData(driver.readTextFile((String) systemComboBox.getSelectedItem() + ".txt", driver.SORT));
        }});
        clearTagButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            selectedTagsArrayList.clear();
            tagSelectedList.setListData(selectedTagsArrayList.toArray());
        }});
        
        //List Box
        listPanel = new JPanel();
        listBuffer1 = new JLabel("");
        tagLibraryList = new JList(driver.readTextFile((String) systemComboBox.getSelectedItem() + ".txt", driver.SORT));
        tagSelectedList = new JList();
        listBuffer3 = new JLabel("");
        scrollSelected = new JScrollPane(tagSelectedList);
        scrollTags = new JScrollPane(tagLibraryList);
        scrollTags.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTags.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollSelected.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSelected.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listBuffer1.setPreferredSize(new Dimension(20,COMPONENT_HEIGHT));
        scrollTags.setPreferredSize(new Dimension(235,300));
        scrollSelected.setPreferredSize(new Dimension(235,300));
        listBuffer3.setPreferredSize(new Dimension(20,COMPONENT_HEIGHT));
        scrollTags.setToolTipText("Tag Library: Double Click Entry To Add.");
        scrollSelected.setToolTipText("Selected Tags: Double Click Entry To Remove.");
        tagLibraryList.setToolTipText("Tag Library: Double Click Entry To Add.");
        tagSelectedList.setToolTipText("Selected Tags: Double Click Entry To Remove.");
        listPanel.add(listBuffer1);
        listPanel.add(scrollTags);
        listPanel.add(scrollSelected);
        listPanel.add(listBuffer3);
        tagLibraryList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2)
                    addTag();
            }
        });
        tagSelectedList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2)
                    removeTag();
            }
        });
        rightCenterPanel.add(listPanel);
        
        controlPanel = new JPanel();
        removeButton = new JButton("Delete Entry");
        resetButton = new JButton("Reset Form");
        editCancelButton = new JButton("Edit");
        saveButton = new JButton("Save Entry");
        removeButton.setPreferredSize(new Dimension(120,COMPONENT_HEIGHT+2));
        resetButton.setPreferredSize(new Dimension(120,COMPONENT_HEIGHT+2));
        editCancelButton.setPreferredSize(new Dimension(120,COMPONENT_HEIGHT+2));
        saveButton.setPreferredSize(new Dimension(120,COMPONENT_HEIGHT+2));
        controlPanel.add(removeButton);
        //controlPanel.add(resetButton);
        controlPanel.add(editCancelButton);
        controlPanel.add(saveButton);
        rightBottomPanel.add(controlPanel);
        removeButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            //driver.FNI();
            int n = JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete this entry? This cannot be undone", "Confirm", JOptionPane.YES_NO_OPTION); //yes == 0, no == 1
            if(n == 0){
                int index = currentDetail.getEntry();
                database.remove(index);
                driver.infoBox("The Database Entry Has Been Removed", "Great!");
                currentDetail = database.get(index);
                setEntry();
                viewEnabled();
            }
        }});
        resetButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            resetForm();
        }});
        editCancelButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(editCancelButton.getText().equals("Edit")){
                editEnabled();
                editCancelButton.setText("Cancel");
            }
            else{
                viewEnabled();
                editCancelButton.setText("Edit");
                if(entryInfoLabel.getText().equals(BLANK_ENTRY)){
                    currentDetail = database.getFirst();
                }
                else{
                    currentDetail = database.getCurrentDetail();
                }
                setEntry();
            }
        }});
        saveButton.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(entryInfoLabel.getText().equals(BLANK_ENTRY)){
                makeNewEntry();
            }
            else{
                appendEntry();
            }
            //viewEnabled();
            //setEntry();
        }});
        rightPanel.add(rightTopPanel, BorderLayout.NORTH);
        rightPanel.add(rightCenterPanel, BorderLayout.CENTER);
        rightPanel.add(rightBottomPanel, BorderLayout.SOUTH);
        
        add(rightPanel, BorderLayout.EAST);
    }
    
    private void makeNewEntry(){
        if(check()){
            Detail newDetail = new Detail();
            newDetail.setPDF(pdfLocation.getText());
            newDetail.setJPG(picLocation.getText());
            newDetail.setDWG(dwgLocation.getText());
            prev_pic = picLocation.getText().substring(picLocation.getText().lastIndexOf("\\"));
            prev_pdf = pdfLocation.getText().substring(pdfLocation.getText().lastIndexOf("\\"));
            prev_dwg = dwgLocation.getText().substring(dwgLocation.getText().lastIndexOf("\\"));
            newDetail.setTags(setTAG());
            newDetail.setCompany(String.valueOf(companyComboBox.getSelectedItem()).toUpperCase() );
            newDetail.setJobName(jobNameTextField.getText().toUpperCase() );
            newDetail.setJobNumber(jobNumberTextField.getText().toUpperCase() );
            newDetail.setJobYear("");
            newDetail.setAddedDate(dateInfoLabel.getText().toUpperCase() );
            newDetail.setDetailDescription(detailDescriptionTextField.getText().toUpperCase() );
            database.add(newDetail);
            currentDetail = database.getCurrentDetail();
            lastDetailMade = currentDetail;
            driver.infoBox("The Database Entry Has Been Created!", "Great!");
            viewEnabled();
            setEntry();
        }
    }
    
    private void appendEntry(){
        if(check()){
            currentDetail.setPDF(pdfLocation.getText());
            currentDetail.setJPG(picLocation.getText());
            currentDetail.setDWG(dwgLocation.getText());
            currentDetail.setTags(setTAG());
            currentDetail.setCompany(String.valueOf(companyComboBox.getSelectedItem()).toUpperCase() );
            currentDetail.setJobName(jobNameTextField.getText().toUpperCase() );
            currentDetail.setJobNumber(jobNumberTextField.getText().toUpperCase() );
            currentDetail.setJobYear("");
            currentDetail.setAddedDate(dateInfoLabel.getText().toUpperCase() );
            currentDetail.setDetailDescription(detailDescriptionTextField.getText().toUpperCase() );
            database.replace(currentDetail);
            //driver.infoBox("The Database Entry Has Been Modified!", "Great!");
            viewEnabled();
            setEntry();
        }
    }

    private String setTAG(){
        String tagsString = ">>";
        for(int i = 0; i < selectedTagsArrayList.size(); i++){
            if(selectedTagsArrayList.get(i).equals(""))
                selectedTagsArrayList.remove(i);
        }
        for(String s : selectedTagsArrayList){
            tagsString += s + ">>";
        }
        return tagsString;
    }
    
    private void addTag(){
        if(!tagLibraryList.isSelectionEmpty()){
            addTag((String) tagLibraryList.getSelectedValue());
        }
    }
    
    private void addTag(String s){
            selectedTagsArrayList.add(s);
            Collections.sort(selectedTagsArrayList);
            for(int i = 0; i < selectedTagsArrayList.size(); i++){
            if(selectedTagsArrayList.get(i).equals(""))
                selectedTagsArrayList.remove(i);
            }
            tagSelectedList.setListData(selectedTagsArrayList.toArray());
    }
    
    private void removeTag(){
        if(selectedTagsArrayList.size() > 0){
            int index = tagSelectedList.getSelectedIndex();
            if(tagSelectedList.getSelectedIndex() > -1){
                noteTextField.setText(selectedTagsArrayList.get(index));
                selectedTagsArrayList.remove(index);
                tagSelectedList.setListData(selectedTagsArrayList.toArray());
            }
            if(selectedTagsArrayList.size() == 0){
                index = -1;
            }
            else if(selectedTagsArrayList.size() <= index){
                index--;
            }
            tagSelectedList.setSelectedIndex(index);
        }
    }
        
    private void resetForm(){
        try
        {
            File pic = new File("blank.png");
            URL url = pic.toURI().toURL();
            ImageIcon icon = new ImageIcon();
            Image img = ImageIO.read(url);
            Image newImg = img.getScaledInstance(8*SCALE_MULTIPLIER, 11*SCALE_MULTIPLIER, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImg);
            imageLabel.setIcon(icon);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        dateInfoLabel.setText(driver.getDate());
        entryInfoLabel.setText(BLANK_ENTRY);
        picLocation.setText("");
        pdfLocation.setText("");
        dwgLocation.setText("");
        companyComboBox.setSelectedIndex(0);
        jobNameTextField.setText("");
        jobNumberTextField.setText("");
        detailDescriptionTextField.setText("");
        lookupEntryTextField.setText("");
        selectedTagsArrayList.clear();
        tagSelectedList.setListData(selectedTagsArrayList.toArray());
        systemComboBox.setSelectedIndex(0);
    }
    
    private void editEnabled(){
        //Lock Controls
        firstButton.setEnabled(false);
        previousButton.setEnabled(false);
        lookupEntryTextField.setEnabled(false);
        nextButton.setEnabled(false);
        lastButton.setEnabled(false);
        menuNew.setEnabled(false);
        //Unlock Controls
        picButton.setEnabled(true);
        pdfButton.setEnabled(true);
        dwgButton.setEnabled(true);
        companyComboBox.setEnabled(true);
        jobNameTextField.setEnabled(true);
        jobNumberTextField.setEnabled(true);
        jobNumberLoadInformationButton.setEnabled(true);
        detailDescriptionTextField.setEnabled(true);
        newTagTextField.setEnabled(true);
        newTagComboBox.setEnabled(true);
        newTagButton.setEnabled(true);
        noteTextField.setEnabled(true);
        noteButton.setEnabled(true);
        systemComboBox.setEnabled(true);
        clearTagButton.setEnabled(true);
        tagLibraryList.setEnabled(true);
        tagSelectedList.setEnabled(true);
        saveButton.setEnabled(true);
        removeButton.setEnabled(true);
        
        editCancelButton.setText("Cancel");
    }
    
    private void viewEnabled(){
        //Lock Controls
        picButton.setEnabled(false);
        pdfButton.setEnabled(false);
        dwgButton.setEnabled(false);
        companyComboBox.setEnabled(false);
        jobNameTextField.setEnabled(false);
        jobNumberTextField.setEnabled(false);
        jobNumberLoadInformationButton.setEnabled(false);
        detailDescriptionTextField.setEnabled(false);
        newTagTextField.setEnabled(false);
        newTagComboBox.setEnabled(false);
        newTagButton.setEnabled(false);
        noteTextField.setEnabled(false);
        noteButton.setEnabled(false);
        systemComboBox.setEnabled(false);
        clearTagButton.setEnabled(false);
        tagLibraryList.setEnabled(false);
        tagSelectedList.setEnabled(false);
        saveButton.setEnabled(false);
        removeButton.setEnabled(false);
        //Unlock Controls
        firstButton.setEnabled(true);
        previousButton.setEnabled(true);
        lookupEntryTextField.setEnabled(true);
        nextButton.setEnabled(true);
        lastButton.setEnabled(true);
        menuNew.setEnabled(true);
        
        editCancelButton.setText("Edit");
    }
    
    private void loadPrevious(){
        if(lastDetailMade != null){
            int index = 0;
            if(lastDetailMade.getCompany().equals("Northshore")){index = 0;}
            if(lastDetailMade.getCompany().equals("Northclad")){index = 1;}
            if(lastDetailMade.getCompany().equals("Standard")){index = 2;}
            companyComboBox.setSelectedIndex(index);
            jobNameTextField.setText(lastDetailMade.getJobName());
            jobNumberTextField.setText(lastDetailMade.getJobNumber());
            detailDescriptionTextField.setText(lastDetailMade.getDetailDescription());
            String[] tags = lastDetailMade.getTags().split(">>");
            selectedTagsArrayList.clear();
            for(String s : tags)
                selectedTagsArrayList.add(s);
            addTag("");
            Pattern pattern;
            Matcher matcher;
            String prefix = "";
            String suffex = "";
            int number = 0;
            String buffer = "";
            File file;
            
            pattern = Pattern.compile("\\d*\\d");
            
            matcher = pattern.matcher(prev_pic);
            System.out.println(prev_pic);
            
            if(matcher.find()){
                prefix = prev_pic.substring(0, matcher.start());
                number = Integer.parseInt(prev_pic.substring(matcher.start(), matcher.end()));
                suffex = prev_pic.substring(matcher.end(), prev_pic.length());
                number++;
                int matchlength = matcher.end() - matcher.start();
                matchlength = matchlength - String.valueOf(number).length();
                for(int i = 0; i < matchlength; i++)
                    buffer += "0";
                prev_pic = prefix + buffer + number + suffex;
                System.out.println(prev_pic);
                picLocation.setText(lastPath + prev_pic);
                file = new File(picLocation.getText());
                if(!file.exists())
                    picLocation.setText("");
                imageLabel.setIcon(getIcon(picLocation.getText()));
            }
            
            matcher = pattern.matcher(prev_pdf);
            System.out.println(prev_pdf);
            
            buffer = "";
            if(matcher.find()){
                prefix = prev_pdf.substring(0, matcher.start());
                number = Integer.parseInt(prev_pdf.substring(matcher.start(), matcher.end()));
                suffex = prev_pdf.substring(matcher.end(), prev_pdf.length());
                number++;
                int matchlength = matcher.end() - matcher.start();
                matchlength = matchlength - String.valueOf(number).length();
                for(int i = 0; i < matchlength; i++)
                    buffer += "0";
                prev_pdf = prefix + buffer + number + suffex;
                System.out.println(prev_pdf);
                pdfLocation.setText(lastPath + prev_pdf);
                file = new File(pdfLocation.getText());
                if(!file.exists())
                    pdfLocation.setText("");
            }
            
            matcher = pattern.matcher(prev_dwg);
            System.out.println(prev_dwg);
            
            buffer = "";
            if(matcher.find()){
                prefix = prev_dwg.substring(0, matcher.start());
                number = Integer.parseInt(prev_dwg.substring(matcher.start(), matcher.end()));
                suffex = prev_dwg.substring(matcher.end(), prev_dwg.length());
                number++;
                int matchlength = matcher.end() - matcher.start();
                matchlength = matchlength - String.valueOf(number).length();
                for(int i = 0; i < matchlength; i++)
                    buffer += "0";
                prev_dwg = prefix + buffer + number + suffex;
                System.out.println(prev_dwg);
                dwgLocation.setText(lastPath + prev_dwg);
                file = new File(dwgLocation.getText());
                if(!file.exists())
                    dwgLocation.setText("");
            }
            
        }
    }
    
    private ImageIcon getIcon(String path){
        try{
            File pic = new File(path);
            URL url = pic.toURI().toURL();
            ImageIcon icon = new ImageIcon();
            Image img = ImageIO.read(url);
            Image newImg = img.getScaledInstance((int) 8.5*SCALE_MULTIPLIER, 11*SCALE_MULTIPLIER, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImg);
            return icon;
        }
        catch(Exception e){
            System.out.println(e);
            return new ImageIcon();
        }
    }
    
    private void setEntry(){
        imageLabel.setIcon(getIcon(currentDetail.getJPG()));
        dateInfoLabel.setText(currentDetail.getAddedDate());
        entryInfoLabel.setText(String.valueOf(currentDetail.getEntry()));
        picLocation.setText(currentDetail.getJPG());
        pdfLocation.setText(currentDetail.getPDF());
        dwgLocation.setText(currentDetail.getDWG());
        jobNameTextField.setText(currentDetail.getJobName());
        jobNumberTextField.setText(currentDetail.getJobNumber());
        detailDescriptionTextField.setText(currentDetail.getDetailDescription());
        selectedTagsArrayList.clear();
        tagSelectedList.setListData(selectedTagsArrayList.toArray());
        for(String s : currentDetail.getTags().split(">>"))
            addTag(s);
        lookupEntryTextField.setText(String.valueOf(currentDetail.getEntry()));
    }

    private boolean check(){
        File file;
        boolean good = true;
        if(selectedTagsArrayList.size() == 0){
            errorBox("Please enter 1 or more tags to make this entry valid", "Missing Tags");
            return !good;
        }
        if(jobNameTextField.getText().equals("")) {good = false;}
        if(jobNumberTextField.getText().equals("")) {good = false;}
        if(pdfLocation.getText().equals("")) {good = false;}
        if(dwgLocation.getText().equals("")) {good = false;}
        if(picLocation.getText().equals("")) {good = false;}
        if(!good){
           errorBox("Make sure all your information is entered", "Missing Information");
           return good;
        }
        file = new File(pdfLocation.getText());
        if(!file.exists() || !file.canRead()) {
            good = false;
        }
        file = new File(dwgLocation.getText());
        if(!file.exists() || !file.canRead()) {
            good = false;
        }
        file = new File(picLocation.getText());
        if(!file.exists() || !file.canRead()) {
            good = false;
        }
        if(!good){
            errorBox("1 or more of the files you entered cannot be read, check to make sure the file exists and is readable.", "File Error");
            return good;
        }
        return good;
    }
    
    public static void errorBox(String errorMessage, String title){
            JOptionPane.showMessageDialog(null, errorMessage, "Error: " 
                + title, JOptionPane.ERROR_MESSAGE);
        }
    
    private final int COMPONENT_HEIGHT = 23;
    private final int FRAME_HEIGHT = 600;
    private final int FRAME_WIDTH = 1100;
    private final int SCALE_MULTIPLIER = 65;
    private final String BLANK_ENTRY = "--";
    private ArrayList<String> prev_tags;
    private ArrayList<String> selectedTagsArrayList;
    private ArrayList<String> temp_tags;
    private boolean editing;
    private boolean hasPrevious = false;
    private Driver driver = new Driver();
    private Database database;
    private Detail currentDetail;
    private Detail lastDetailMade;
    private JButton clearTagButton;
    private JButton dwgButton;
    private JButton editCancelButton;
    private JButton firstButton;
    private JButton jobNumberLoadInformationButton;
    private JButton lastButton;
    private JButton newTagButton;
    private JButton nextButton;
    private JButton noteButton;
    private JButton pdfButton;
    private JButton picButton;
    private JButton previousButton;
    private JButton removeButton;
    private JButton resetButton;
    private JButton saveButton;
    private JComboBox companyComboBox;
    private JComboBox newTagComboBox;
    private JComboBox systemComboBox;
    private JComboBox tagComboBox;
    private JLabel centerBuffer;
    private JLabel companyBufferLabel;
    private JLabel companyLabel;
    private JLabel dateInfoLabel;
    private JLabel dateLabel;
    private JLabel detailDescriptionBufferLabel;
    private JLabel detailDescriptionLabel;
    private JLabel dwgLabel;
    private JLabel dwgLocation;
    private JLabel entryInfoLabel;
    private JLabel entryLabel;
    private JLabel imageLabel;
    private JLabel jobNameLabel;
    private JLabel jobNumberBufferLabel;
    private JLabel jobNumberLabel;
    private JLabel listBuffer1;
    private JLabel listBuffer2;
    private JLabel listBuffer3;
    private JLabel newTagLabel;
    private JLabel noteLabel;
    private JLabel pdfLabel;
    private JLabel pdfLocation;
    private JLabel picLabel;
    private JLabel picLocation;
    private JLabel tagBuffer1Label;
    private JLabel tagBuffer2Label;
    private JLabel tagBufferLabel;
    private JLabel taginfo1Label;
    private JLabel taginfo2Buffer2Label;
    private JLabel taginfo2Label;
    private JLabel taginfoBuffer2Label;
    private JLabel taginfoBuffer3Label;
    private JLabel tagLibraryLabel;
    private JLabel tagSelectedLibrary;
    private JLabel titleLabel;
    private JList tagLibraryList;
    private JList tagSelectedList;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuBar menuBar;
    private JMenuItem menuBuildSwitch;
    private JMenuItem menuChangeLog;
    private JMenuItem menuClose;
    private JMenuItem menuHelpitem;
    private JMenuItem menuNew;
    private JMenuItem menuSearchSwitch;
    private JPanel buttonPanel;
    private JPanel companyPanel;
    private JPanel controlPanel;
    private JPanel datePanel;
    private JPanel detailDescriptionPanel;
    private JPanel dwgButtonPanel;
    private JPanel dwgLabelPanel;
    private JPanel dwgLocationPanel;
    private JPanel dwgPanel;
    private JPanel entryPanel;
    private JPanel jobNameLabelPanel;
    private JPanel jobNamePanel;
    private JPanel jobNameTextFieldPanel;
    private JPanel jobNumberPanel;
    private JPanel leftPanel;
    private JPanel listPanel;
    private JPanel newTagPanel;
    private JPanel notePanel;
    private JPanel pdfButtonPanel;
    private JPanel pdfLabelPanel;
    private JPanel pdfLocationPanel;
    private JPanel pdfPanel;
    private JPanel picButtonPanel;
    private JPanel picLabelPanel;
    private JPanel picLocationPanel;
    private JPanel picPanel;
    private JPanel picturePanel;
    private JPanel rightBottomPanel;
    private JPanel rightCenterPanel;
    private JPanel rightPanel;
    private JPanel rightTopPanel;
    private JPanel taginfo1Panel;
    private JPanel taginfo2Panel;
    private JPanel tagLabelPanel;
    private JPanel titlePanel;
    private JScrollPane scrollSelected;
    private JScrollPane scrollTags;
    private JTextField detailDescriptionTextField;
    private JTextField jobNameTextField;
    private JTextField jobNumberTextField;
    private JTextField lookupEntryTextField;
    private JTextField newTagTextField;
    private JTextField noteTextField;
    private String prev_pic;
    private String prev_pdf;
    private String prev_dwg;
    private String lastPath = "";

}
