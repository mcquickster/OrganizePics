import java.util.ArrayList;
public class OrganizePics{
    public Photos familyPics;
    public OrganizePics(){
        familyPics = new Photos("C:/Users/Luke/Desktop/x/");
    }
    public static void main(String[] args) {
        OrganizePics organization = new OrganizePics();
        ArrayList<String> destinations = new ArrayList<>();
        //change the year here when needed
        int year = 2022;
        //You have to make the year folders by yourself, ex: Toshiba/2022 Pics
        //toshiba
        destinations.add("L:/Toshiba/" + year + " Pics/");
        //backup
        destinations.add("G:/" + year + " Pics/");
        //buffalo
       destinations.add("F:/" + year + " Pics/");
       Photos.makeFolders(destinations);
       organization.familyPics.sortByMonth(organization.familyPics.getFilePaths(), organization.familyPics.getFileNames(), destinations, year);
        
    }
}