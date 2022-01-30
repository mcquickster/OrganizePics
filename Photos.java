import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
public class Photos {
    public String path;
    public Photos(String photoPath){
        path = photoPath;
    }
    public ArrayList<String> getFilePaths(){
      String[] pathnames;
      File f = new File(path);
      pathnames = f.list();
      ArrayList<String> filePaths = new ArrayList<String>();
      for (String pathname : pathnames) {
      filePaths.add(path + pathname);
  }
  return filePaths;
}
      public ArrayList<String> getFileNames(){
        String[] pathnames;
        File f = new File(path);
        pathnames = f.list();
        ArrayList<String> fileNames = new ArrayList<String>();
        for (String pathname : pathnames) {
        fileNames.add(pathname);
    }
    return fileNames;
}
public void sortByMonth(ArrayList<String> paths, ArrayList<String> fileNames, ArrayList<String> destinations, int currentYear){
  for(String folderPath : destinations){
  String fileName = "";
  int x = paths.size();
  System.out.println("***There are " + x + " items in the folder.");
  int i = 0;
  for(String photo:paths){
      fileName = fileNames.get(i);
      i++;
      String date = getDate(photo); 
      int year = Integer.parseInt(date.substring(6,10));
      String month = date.substring(0,2);
      File from = new File(photo);
      File to = new File(photo);
      System.out.println(currentYear);
      System.out.println(photo);
      if (year == currentYear){
      switch(month){
          case "01":
          to = new File( folderPath + "January/" + fileName);
          System.out.println("January");
          break;
          case "02":
          to = new File( folderPath + "February/" + fileName);
          System.out.println("February");
          break;
          case "03":
          to = new File( folderPath + "March/" + fileName);
          System.out.println("March");
          break;
          case "04":
          to = new File( folderPath + "April/" + fileName);
          System.out.println("April");
          break;
          case "05":
          to = new File( folderPath + "May/" + fileName);
          System.out.println("May");
          break;
          case "06":
          to = new File( folderPath + "June/" + fileName);
          System.out.println("June");
          break;
          case "07":
          to = new File( folderPath + "July/" + fileName);
          System.out.println("July");
          break;
          case "08":
          to = new File( folderPath + "August/" + fileName);
          System.out.println("August");
          break;
          case "09":
          to = new File( folderPath + "September/" + fileName);
          System.out.println("September");
          break;
          case "10":
          to = new File( folderPath + "October/" + fileName);
          System.out.println("October");
          break;
          case "11":
          to = new File( folderPath + "November/" + fileName);
          System.out.println("November");
          break;
          case "12":
          to = new File( folderPath + "December/" + fileName);
          System.out.println("December");
          break;
          default: 
          to = new File( folderPath);
          System.out.println("error wrong date");
      }
     // System.out.println(to.toPath());
      try {
          Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
          System.out.println("File copied successfully.");
      }
      catch (IOException ex) {
          ex.printStackTrace();
      }
   } else{
      System.out.println("There are some old files that weren't moved. \n Please run the program again with a different year to finish transfering all of the files. \n The year to look at is " + year);
   }
  }}
}
   public static void makeFolders(ArrayList<String> destinations){
     for(String folderPath : destinations){
    File January = new File(folderPath + "January");
    January.mkdir();
    File February = new File(folderPath + "February");
    February.mkdir();
    File March = new File(folderPath + "March");
    March.mkdir();
    File April = new File(folderPath + "April");
    April.mkdir();
    File May = new File(folderPath + "May");
    May.mkdir();
    File June = new File(folderPath + "June");
    June.mkdir();
    File July = new File(folderPath + "July");
    July.mkdir();
    File August = new File(folderPath + "August");
    August.mkdir();
    File September = new File(folderPath + "September");
    September.mkdir();
    File October = new File(folderPath + "October");
    October.mkdir();
    File November = new File(folderPath + "November");
    November.mkdir();
    File December = new File(folderPath + "December");
    December.mkdir();
     }
}
    public static String getDate(String path){
        File file =  new File(path);
        //This part sets the date to 12/31/1969 and ruins my whole program
        //update: sdf isn't the problem, it goes to the default date because last modifyed returns 0 for some reason
           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
           String date = sdf.format(file.lastModified());
           System.out.println(date);
        return date;
    }

}
