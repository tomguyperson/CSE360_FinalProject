
// Packages to import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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

    // Constructor
    Vaccine() {
        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("Vaccines");

        // Data to be displayed in the JTable
        String[][] data = { { "01234", "Ngov", "Justin", "Pfizer", "1/1/2021", "Cardinals Stadium" },
                { "56789", "Mesquita", "Tomas", "Pfizer", "1/1/2021", "Cardinals Stadium" } };

        // Column Names
        String[] columnNames = { "ID", "Last Name", "First Name", "Vaccine Type", "Vaccine Date", "Vaccine Location" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);

        // Initializing BorderLayout
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(sp, BorderLayout.CENTER);

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

        JButton visualize = new JButton("Visualize");
        listPane.add(visualize);

        // adding BoxLayout to BorderLayout
        p.add(listPane, BorderLayout.WEST);
        // adding BorderLayout to frame
        f.add(p);

        // Initialize JTextPane and style it (COMMENTED OUT MOVED TO ONCLICK)
        // jtp = new JTextPane();
        // SimpleAttributeSet set = new SimpleAttributeSet();
        // StyleConstants.setBold(set, true);
        // jtp.setCharacterAttributes(set, true);
        // StyledDocument doc = jtp.getStyledDocument();
        // SimpleAttributeSet center = new SimpleAttributeSet();
        // StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        // doc.setParagraphAttributes(0, doc.getLength(), center, false);
        // jtp.setText("Team 49\n\nJustin Ngov\nTomas Mesquita\nLuke Burger");
        // Font font = new Font("Arial", Font.PLAIN, 30);
        // jtp.setFont(font);
        // jtp.setEditable(false);

        // This is here to be able to remove the center of p BorderLayout
        BorderLayout layout = (BorderLayout) p.getLayout();

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Line below removes p.BorderLayout.Center
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));

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

        // add GridLayout to BorderLayout
        addBorder = new JPanel();
        addBorder.setLayout(new BorderLayout());
        addBorder.setBorder(new EmptyBorder(new Insets(0, 30, 100, 30)));
        addBorder.add(g, BorderLayout.CENTER);
        JButton add2 = new JButton("Add");
        addBorder.add(add2, BorderLayout.SOUTH);

        p.add(addBorder, BorderLayout.CENTER);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                JButton add2 = new JButton("Add");
                addBorder.add(add2, BorderLayout.SOUTH);

                p.add(addBorder, BorderLayout.CENTER);
                p.repaint();
                p.revalidate();
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                
                // File Chooser for Load
                file = new JFileChooser();
                file.setDialogTitle("Please choose filepath for .csv");
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                file.setFileHidingEnabled(false);
                if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    java.io.File f = file.getSelectedFile();
                    filepath = f.getPath();
                    System.err.println(filepath);
                }

                p.add(sp, BorderLayout.CENTER);
                p.repaint();
                p.revalidate();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                
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
}