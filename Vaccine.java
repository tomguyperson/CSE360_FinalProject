
// Packages to import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.*;
import java.io.*;

public class Vaccine {
    // frame
    JFrame f;
    // Table
    JTable j;
    // Panel for BorderLayout
    JPanel p;
    // JPanel for BoxLayout
    JPanel listPane;
    // Panel for Borderlayout for JTextArea
    JTextPane jtp;
    // Panel for GridLayout
    JPanel g;
    // Labels for 'add' GridLayout
    JLabel id, lname, fname, vtype, vdate, vlocation;
    // TextFields for 'add' GridLayout
    JTextField idf, lnamef, fnamef, vtypef, vdatef, vlocationf;
    // Panel for Add Borderlayout
    JPanel addBorder;
    // File Chooser
    JFileChooser file;
    // Variable for filepath
    String filepath;
    // Panel for Borderlayout for save JTextArea
    JTextPane savejtp;

    FileReadWrite reader = new FileReadWrite();

    ArrayList<Holder> data1 = new ArrayList<Holder>();

    // Constructor
    Vaccine() {
        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("Vaccines");

        // Column Names
        String[] columnNames = { "ID", "Last Name", "First Name", "Vaccine Type", "Vaccine Date", "Vaccine Location" };

        // Initializing the JTable

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        j = new JTable(tableModel);
        j.setBounds(30, 40, 200, 300);
        
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        // Size the JTable so that the Columns are a fixed size and horizontal scroll is allowed.
        j.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        j.getColumnModel().getColumn(0).setPreferredWidth(100);
        j.getColumnModel().getColumn(1).setPreferredWidth(100);
        j.getColumnModel().getColumn(2).setPreferredWidth(100);
        j.getColumnModel().getColumn(3).setPreferredWidth(110);
        j.getColumnModel().getColumn(4).setPreferredWidth(110);
        j.getColumnModel().getColumn(5).setPreferredWidth(110);
        
        // Initializing BorderLayout
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(sp, BorderLayout.CENTER);

        ImageIcon img = new ImageIcon(System.getProperty("user.dir") + "\\lib\\dababy.jpg");
        f.setIconImage(img.getImage());

        // Initializing BoxLayout that goes inside of BorderLayout(WEST)
        listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));
        listPane.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        // Initizalize all the buttons
        JButton about = new JButton("About");
        listPane.add(about);
        listPane.add(Box.createRigidArea(new Dimension(0, 110)));

        JButton load = new JButton("Load");
        listPane.add(load);
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));

        JButton add = new JButton("Add");
        listPane.add(add);
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));

        JButton save = new JButton("Save");
        listPane.add(save);
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));

        JButton visualize = new JButton("Visualize (Pie)");
        listPane.add(visualize);
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));

        JButton visualize2 = new JButton("Visualize (Bar)");
        listPane.add(visualize2);

        // adding BoxLayout to BorderLayout
        p.add(listPane, BorderLayout.WEST);
        // adding BorderLayout to frame
        f.add(p);

        // This is here to be able to remove the center of p BorderLayout
        BorderLayout layout = (BorderLayout) p.getLayout();

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Line below removes p.BorderLayout.Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

                // Initialize JTextPane and style it
                jtp = new JTextPane();
                SimpleAttributeSet set = new SimpleAttributeSet();
                StyleConstants.setBold(set, true);
                jtp.setCharacterAttributes(set, true);
                StyledDocument doc = jtp.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
                jtp.setText("\nTeam 49\n\nJustin Ngov\nTomas Mesquita\nLuke Burger");
                Font font = new Font("Arial", Font.PLAIN, 30);
                jtp.setFont(font);
                jtp.setEditable(false);
                p.add(jtp, BorderLayout.CENTER);
                p.repaint();
                p.revalidate();
            }
        });

        // Initialize GridLayout
        g = new JPanel();
        g.setLayout(new GridLayout(6, 2));
        g.setBorder(new EmptyBorder(new Insets(50, 150, 50, 150)));

        // Initialize Labels
        vdate = new JLabel("Date:");
        id = new JLabel("ID:");
        lname = new JLabel("Last Name:");
        fname = new JLabel("First Name:");
        vtype = new JLabel("Vaccine Type:");
        vlocation = new JLabel("Vaccine Location:");
        // Initialize TextFields
        vdatef = new JTextField();
        idf = new JTextField();
        lnamef = new JTextField();
        fnamef = new JTextField();
        vtypef = new JTextField();
        vlocationf = new JTextField();
        // add labels and textfields to GridLayout
        g.add(vdate);
        g.add(vdatef);
        g.add(id);
        g.add(idf);
        g.add(lname);
        g.add(lnamef);
        g.add(fname);
        g.add(fnamef);
        g.add(vtype);
        g.add(vtypef);
        g.add(vlocation);
        g.add(vlocationf);

        JButton add2 = new JButton("Add");

        // ActionListener for add button inside of the Add panel
        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adds the column titles to the table
                tableModel.addRow(new Object[] { idf.getText(), lnamef.getText(), fnamef.getText(), vtypef.getText(),
                        vdatef.getText(), vlocationf.getText() });
                idf.setText("");
                lnamef.setText("");
                fnamef.setText("");
                vtypef.setText("");
                vdatef.setText("");
                vlocationf.setText("");

                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                p.add(sp, BorderLayout.CENTER);
                p.repaint();
                p.revalidate();
            }
        });

        // ActionListener for add button. 
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear BorderLayout Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

                // Initialize GridLayout
                g = new JPanel();
                g.setLayout(new GridLayout(6, 2));
                g.setBorder(new EmptyBorder(new Insets(50, 150, 50, 150)));

                // Initialize Labels
                vdate = new JLabel("Date:");
                id = new JLabel("ID:");
                lname = new JLabel("Last Name:");
                fname = new JLabel("First Name:");
                vtype = new JLabel("Vaccine Type:");
                vlocation = new JLabel("Vaccine Location:");
                // Initialize TextFields
                vdatef = new JTextField();
                idf = new JTextField();
                lnamef = new JTextField();
                fnamef = new JTextField();
                vtypef = new JTextField();
                vlocationf = new JTextField();
                // add labels and textfields to GridLayout
                g.add(vdate);
                g.add(vdatef);
                g.add(id);
                g.add(idf);
                g.add(lname);
                g.add(lnamef);
                g.add(fname);
                g.add(fnamef);
                g.add(vtype);
                g.add(vtypef);
                g.add(vlocation);
                g.add(vlocationf);

                // add GridLayout to BorderLayout
                addBorder = new JPanel();
                addBorder.setLayout(new BorderLayout());
                addBorder.setBorder(new EmptyBorder(new Insets(0, 30, 100, 30)));
                addBorder.add(g, BorderLayout.CENTER);
                addBorder.add(add2, BorderLayout.SOUTH);

                p.add(addBorder, BorderLayout.CENTER);
                p.repaint();
                p.revalidate();
            }
        });

        // ActionListener for load button.
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear BorderLayout Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

                // File Chooser for Load
                file = new JFileChooser();
                file.setDialogTitle("Please choose filepath for .csv");
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                file.setFileHidingEnabled(false);
                int opened = file.showOpenDialog(null);

                if (opened == JFileChooser.APPROVE_OPTION) {
                    java.io.File f = file.getSelectedFile();
                    filepath = f.getPath();

                    data1 = reader.read(filepath);

                    for (int i = 0; i < data1.size(); i++) {
                        tableModel.addRow(new Object[] { data1.get(i).getID(), data1.get(i).getLastName(),
                        data1.get(i).getFirstName(), data1.get(i).getVaccine(), data1.get(i).getDate(),
                        data1.get(i).getLocation() });
                    }

                    p.add(sp, BorderLayout.CENTER);
                    p.repaint();
                    p.revalidate();
                } else if (opened == JFileChooser.CANCEL_OPTION) {
                    p.add(sp, BorderLayout.CENTER);
                    p.repaint();
                    p.revalidate();
                }

            }
        });

        // ActionListener for save button
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear BorderLayout Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

                // Initialize fileChooser for file selections
                JFileChooser fileChooser = new JFileChooser();
                int opened = fileChooser.showSaveDialog(null);
                if (opened == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    filepath = file.getPath();
                    
                    Object[][] toSave = getTableData(j);
                    ArrayList<Holder> listOfHolders = new ArrayList<Holder>();

                    for (int i = 0; i < toSave.length; i++) {
                        listOfHolders.add(new Holder((int) toSave[i][0], (String) toSave[i][1], (String) toSave[i][2],
                                (String) toSave[i][3], (String) toSave[i][4], (String) toSave[i][5]));
                    }

                    reader.write(listOfHolders, filepath);

                    // Create JTextPane to show that the save was completed 
                    savejtp = new JTextPane();
                    SimpleAttributeSet set = new SimpleAttributeSet();
                    StyleConstants.setBold(set, true);
                    savejtp.setCharacterAttributes(set, true);
                    StyledDocument doc = savejtp.getStyledDocument();
                    SimpleAttributeSet center = new SimpleAttributeSet();
                    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                    doc.setParagraphAttributes(0, doc.getLength(), center, false);
                    savejtp.setText("\n\n\nData Saved to .csv");
                    Font font = new Font("Arial", Font.PLAIN, 30);
                    savejtp.setFont(font);
                    savejtp.setEditable(false);
                    p.add(savejtp, BorderLayout.CENTER);
                    p.repaint();
                    p.revalidate();
                }
                else if (opened == JFileChooser.CANCEL_OPTION) {
                    p.add(sp, BorderLayout.CENTER);
                    p.repaint();
                    p.revalidate();
                }
            }
        });

        // ActionListener for visualize pie button
        visualize.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear BorderLayout Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

                ArrayList<String> countries = new ArrayList<String>();
                ArrayList<Integer> numbers = new ArrayList<Integer>();

                Object[][] toSave = getTableData(j);
                
                // Takes data from the table and then uses that to add to the pie chart
                for (int i = 0; i < toSave.length; i++) {
                    if(countries.contains(toSave[i][5]))
                    {
                        numbers.set(countries.indexOf(toSave[i][5]), numbers.get(countries.indexOf(toSave[i][5])) + 1); //increment count of doses in corresponding country
                    }
                    else
                    {
                        countries.add((String) toSave[i][5]);
                        numbers.add(1);
                    }
                }
                
                new PieChart("Number of Doses Administered Per Location", countries, numbers);

                p.add(PieChart.createDemoPanel(), BorderLayout.CENTER);
                p.repaint();
                p.revalidate();                
            }
        });

        // ActionListener for visualize bar button
        visualize2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear BorderLayout Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

                ArrayList<String> vaccines = new ArrayList<String>();
                ArrayList<Integer> numbers = new ArrayList<Integer>();

                Object[][] toSave = getTableData(j);
                
                // Takes data from the table and then uses that to add to the bar chart
                for (int i = 0; i < toSave.length; i++) {
                    if(vaccines.contains(toSave[i][3]))
                    {
                        numbers.set(vaccines.indexOf(toSave[i][3]), numbers.get(vaccines.indexOf(toSave[i][3])) + 1); //increment count of doses in corresponding country
                    }
                    else
                    {
                        vaccines.add((String) toSave[i][3]);
                        numbers.add(1);
                    }
                }
                
                new BarChart("Number of Doses of Each Vaccine Administered", vaccines, numbers);

                p.add(BarChart.createDemoPanel(), BorderLayout.CENTER);
                p.repaint();
                p.revalidate();   
            }
        });

        // Frame Size
        f.setSize(800, 600);
        // Frame Visible = true
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Driver method
    public static void main(String[] args) {
        new Vaccine();
    }

    // Method to get the data from the table
    public Object[][] getTableData(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0; i < nRow; i++)
            for (int j = 0; j < nCol; j++)
                tableData[i][j] = dtm.getValueAt(i, j);
        return tableData;
    }
}