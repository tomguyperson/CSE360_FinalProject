/*
Class that implements read and write functionality for .csv files that house the data.
*/

import java.util.*;
import java.io.*;

public class FileReadWrite
{
    private String[] categories = {"ID", "Last Name", "First Name", "Vaccine Type", "Vaccination Date", "Vaccine Location"};

    public void write(ArrayList<Holder> data, String filePath)
    {
        try
        {
            File csvFile = new File(filePath);
            FileWriter csvWriter = new FileWriter(csvFile);

            csvWriter.write(categories[0]);
            csvWriter.write(",");
            csvWriter.write(categories[1]);
            csvWriter.write(",");
            csvWriter.write(categories[2]);
            csvWriter.write(",");
            csvWriter.write(categories[3]);
            csvWriter.write(",");
            csvWriter.write(categories[4]);
            csvWriter.write(",");
            csvWriter.write(categories[5]);

            // converts each row of data in the data arraylist to a string and writes it to the file
            for (int i = 0; i < data.size(); i++)
            {
                csvWriter.write("\n");
                csvWriter.write(data.get(i).stringConvert());
            }

            csvWriter.flush();
            csvWriter.close();
        }
        // catches any file writing errors
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public ArrayList<Holder> read(String filePath)
    {
        ArrayList<Holder> data = new ArrayList<Holder>();

        try 
        {
            File csvFile = new File(filePath);

            if (csvFile.isFile())
            {
                BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
                String row = "";
                csvReader.readLine();
                while ((row = csvReader.readLine()) != null)
                {
                    // splits each row by commas into a one dimensional array and then adds it to the data set
                    String[] rowData = row.split(",");
                    Holder newData = new Holder(Integer.parseInt(rowData[0]), rowData[1], rowData[2], rowData[3], rowData[4], rowData[5]);
                    data.add(newData);
                }

                csvReader.close();
            }
        }
        // catches any file reading errors
        catch(IOException e)
        {
            System.out.println(e);
        }

        return data;
    }
}