import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.*;

public class PieChart extends ApplicationFrame {

    private static ArrayList<String> countries;
    private static ArrayList<Integer> number;

    public PieChart(String title, ArrayList<String> countries, ArrayList<Integer> number) {
        super(title);

        this.countries = countries;
        this.number = number;
        setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i = 0; i < number.size(); i++)
        {
            dataset.setValue(countries.get(i), number.get(i));
        }

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Number of Doses Administered Per Location", // chart title
                dataset, // data
                true, // include legend
                true, false);

        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
}