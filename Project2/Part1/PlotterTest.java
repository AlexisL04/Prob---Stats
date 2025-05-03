package Project2.Part1;

public class PlotterTest 
{
    
    public static void main(String[] args) 
    {
        Plotter plotter = new Plotter();
        
        try 
        {
            String fileName = plotter.convertToCSV();
            System.out.println("File written to: " + fileName);
        } 
        catch (Exception e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
