import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import java.util.*;

public class PieChart extends ApplicationFrame {

    private static ArrayList<String> countries;
    private static ArrayList<Integer> number;

    //constructor to initialize values
    public PieChart(String title, ArrayList<String> countries, ArrayList<Integer> number) {
        super(title);

        //initialize variables to be used in creating chart
        this.countries = countries;
        this.number = number;
        setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset() {
        //create new data set using data input
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i = 0; i < number.size(); i++)
        {
            //set values from input
            dataset.setValue(countries.get(i), number.get(i));
        }

        //return so other methods can use data set
        return dataset;
    }

    //method creates a chart
    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Number of Doses Administered Per Location", // chart title
                dataset, // data
                true, // include legend
                true, false);

        return chart; //return the chart
    }

    //returns the chart as a JPanel so it can be added to the main JFrame
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
}