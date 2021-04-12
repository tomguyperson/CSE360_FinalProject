public class Main
{
    public static void main(String[] args) 
    {
        FileReadWrite fileW = new FileReadWrite();
        fileW.write(fileW.read("TeamProjectRandomData - 50People.csv"), "temp.csv");
        System.out.println("Completed");
    }  
}