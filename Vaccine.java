
// Packages to import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
    // JTextArea for About
    JTextArea jta;
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

    // Constructor
    Vaccine() {
        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("Vaccnines");

        // Data to be displayed in the JTable
        String[][] data = { { "01234", "Ngov", "Justin", "Pfizer" }, { "56789", "Mesquita", "Tomas", "Pfizer" } };

        // Column Names
        String[] columnNames = { "ID", "Last Name", "First Name", "Vaccine Type" };

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

        // LOOK INTO CARDS AND IMPLEMENT CARDLAYOUT TO BE ABLE TO SWAP PANELS

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.setVisible(false);
                jtp = new JTextPane();
                SimpleAttributeSet set = new SimpleAttributeSet();
                StyleConstants.setBold(set, true);
                jtp.setCharacterAttributes(set, true);
                StyledDocument doc = jtp.getStyledDocument();
                SimpleAttributeSet center = new SimpleAttributeSet();
                StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                doc.setParagraphAttributes(0, doc.getLength(), center, false);
                jtp.setText("Team 49\n\nJustin Ngov\nTomas Mesquita\nLuke Burger");
                Font font = new Font("Arial", Font.PLAIN, 30);
                jtp.setFont(font);
                jtp.setEditable(false);
                p.add(jtp, BorderLayout.CENTER);
                jtp.setVisible(true);
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
                addBorder.setVisible(false);
                jtp.setVisible(false);
                sp.setVisible(false);
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
                jtp.setVisible(false);
                sp.setVisible(false);
                addBorder.setVisible(true);
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtp.setVisible(false);
                addBorder.setVisible(false);
                sp.setVisible(false);
                p.add(sp, BorderLayout.CENTER);
                jtp.setVisible(false);
                addBorder.setVisible(false);
                sp.setVisible(true);
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