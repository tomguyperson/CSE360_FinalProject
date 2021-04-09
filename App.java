import javax.swing.*;
import java.awt.*;

public class App {
    
    public static void main(String[] args) {
        JFrame app = new JFrame();// creating instance of JFrame
        
        GridBagLayout mfw = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        app.setLayout(mfw);

        GridLayout buttGrid = new GridLayout(5, 3, 10, 20);
        JPanel buttons = new JPanel();
        buttons.setLayout(buttGrid);
        buttons.setVisible(true);

        JPanel extra = new JPanel();
        //extra.setBounds(150, 5, 1010, 750);
        extra.setBackground(Color.green);

        JButton about = new JButton("About");// creating instance of JButton
        //about.setBounds(20, 20, 90, 35);// x axis, y axis, width, height
        about.setSize(new Dimension(90, 35));

        JButton load = new JButton("Load");// creating instance of JButton
        //load.setBounds(20, 100, 90, 35);// x axis, y axis, width, height

        JButton add = new JButton("Add");// creating instance of JButton
        //add.setBounds(20, 150, 90, 35);// x axis, y axis, width, height
        

        JButton save = new JButton("Save");// creating instance of JButton
        //save.setBounds(20, 200, 90, 35);// x axis, y axis, width, height

        JButton visualize = new JButton("Visualize");// creating instance of JButton
        //visualize.setBounds(20, 250, 90, 35);// x axis, y axis, width, height
        
        ImageIcon img = new ImageIcon(System.getProperty("user.dir")  + "\\lib\\dababy.jpg");
        app.setIconImage(img.getImage());

        //String[] colNames = {"ID", "Last Name", "First Name", "Vaccine Type"};
        //String[][] data = {};
        
        Object[][] data = {
            {"Kathy", "Smith",
             "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
             "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
             "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
             "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
             "Pool", new Integer(10), new Boolean(false)}
        };

        String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};


        
        JTable info = new JTable(data, columnNames);
        info.setVisible(true);       

        info.setFont(new Font("Serif", Font.PLAIN, 20));
        JScrollPane scrol = new JScrollPane(info);
        scrol.createVerticalScrollBar();
        //scrol.setBounds(info.getBounds());
        info.setFillsViewportHeight(true);
        scrol.setSize(extra.getSize());
        

        
        //info.setSize(new Dimension(500, 500));
        //info.setIntercellSpacing(new Dimension(50, 1));
        //info.setLovation();
        
        
        //extra.add(info);

        extra.add(scrol);

        buttons.add(about);// adding button in JFrame
        buttons.add(load);// adding button in JFrame
        buttons.add(add);// adding button in JFrame
        buttons.add(save);// adding button in JFrame
        buttons.add(visualize);// adding button in JFrame
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        c.ipady = 3;
        c.insets = new Insets(0, 0, 0, 50);
       

        app.add(buttons, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 40;
        c.gridheight = 3;
        c.insets = new Insets(0, 50, 0, 0);
        

        app.add(extra, c);

        app.setSize(900, 600);
        //app.setLayout(null);// using no layout managers
        app.setVisible(true);// making the frame visible
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}