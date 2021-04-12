import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.*;
import javax.swing.JPanel;

public class BarChart extends ApplicationFrame {

   private static ArrayList<String> vaccines;
   private static ArrayList<Integer> number;

   public BarChart(String chartTitle, ArrayList<String> vaccines, ArrayList<Integer> number) {
      super("no");
      this.vaccines = vaccines;
      this.number = number;
   }

   private static JFreeChart createChart(DefaultCategoryDataset dataset) {
      JFreeChart chart = ChartFactory.createBarChart("Number of Doses of Each Vaccine Administered", "Vaccine", "Number of Doses", createDataset(),
            PlotOrientation.VERTICAL, false, true, false);

      return chart;
  }

   private static DefaultCategoryDataset createDataset() {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();

      for(int i = 0; i < number.size(); i++)
      {
         dataset.addValue(number.get(i), "Vaccine", vaccines.get(i));
      }

      return dataset;
   }

   public static JPanel createDemoPanel() {
      JFreeChart chart = createChart(createDataset());
      return new ChartPanel(chart);
   }   
}