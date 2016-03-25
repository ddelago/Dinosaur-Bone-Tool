package buyer; /**
 * Daniel Delago    1/28/2016
 * Seller Program
 */
import Datastore.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Buyer {                                        //Buyer Class

    Scanner input;
    ArrayList<Coordinate> coordList;
    ArrayList<Bone> boneList;
    ArrayList<BuyerUser> buyerList;
    LoadFile file;
    LoadFile buyerFile;

    public Buyer(){

        input = new Scanner(System.in);
        coordList = new ArrayList();
        boneList = new ArrayList();
        buyerList = new ArrayList<>();
        file = new LoadFile("./src/Datastore/text.csv");
        buyerFile = new LoadFile("./src/Datastore/buyers.csv");

    }
    public void menu(){                                    //Bone Buyer Menu
        int choice;
        Boolean running = true;
        while(running) {
            System.out.println("Bone Buyer Menu:");
            System.out.println("1. Load Map\n2. Display Map\n3. Buy a Bone\n4. Save Files\n5. Load Files\n6. Buyer\n7. Scramble\n8. Quit");
            choice = input.nextInt();
            if (choice < 1 || choice > 7) {
                System.out.println("That is not a valid input.\n");
                continue;
            }

            switch (choice){
                case 1:
                    loadMap();break;
                case 2:
                    displayMap();break;
                case 3:
                    buyBone();break;
                case 4:
                    try {
                        saveFile();
                        saveBuyer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    boneList=file.loadBones();
                    for(Bone b : boneList) {
                        System.out.println(b.toString());
                    }

                    buyerList = buyerFile.loadBuyers();
                    for(BuyerUser buyerUser : buyerList){
                        System.out.println(buyerUser);
                    }
                    break;
                case 6:
                    userMenu();
                    break;
                case 7:
                    scramble();
                    break;
                case 8:
                    running = false;
                    break;
            }
        }
    }

    public void loadMap(){                                                  //Loads the map from map.txt

        File mapFile = new File("./src/Datastore/Map.txt");

        try{
            Scanner fileIn = new Scanner(mapFile);
            while(fileIn.hasNext()){
                String tempLine = fileIn.nextLine();
                String coordData[] = tempLine.split(",");
                Coordinate newCoord = new Coordinate(coordData);
                //loadMap(coordData);
                coordList.add(newCoord);
            }
            fileIn.close();
        }
        catch (IOException e){
            System.out.println("File not Found");
        }

        System.out.println("Map Loaded\n");
    }

    public void displayMap(){                                               //Displays the map and populates with bones.
        try {
            updateMap();
            int sum=0;
            for(int i=0; i<20;i++){
                for(int j=0;j<60;j++){
                    Coordinate tempCoord = coordList.get(sum);
                    int[] coordVals = tempCoord.getVals();
                    if(coordVals[3]==0)
                        System.out.print("$");
                    else if(coordVals[3]==1)
                        System.out.print("X");
                    else if(coordVals[2]==0)
                        System.out.print(".");
                    else if(coordVals[2]==1)
                        System.out.print("*");
                    sum+=1;
                }
                if(i==9)
                    System.out.print("<-Equator");
                System.out.println("");
            }
            System.out.println("              Prime Meridian ^");
        }
        catch(Exception e){
            System.out.println("Please Load a Map First.\n");
        }
        System.out.println("");

    }

    public void buyBone(){                                              //A shop menu for purchasing a bone
        int selection;
        String selection2;
        System.out.println("----------------------------------------------------");
        System.out.println("|ID|          Bones for Sale           |   Price   |");
        System.out.println("----------------------------------------------------");
        for(Bone b : boneList) {
            System.out.printf("|%2d|%-35s|$%-10.2f|%n",b.getID(),b.getName(),b.getPrice());
        }
        System.out.println("----------------------------------------------------");
        System.out.print("Select a bone to purchase by entering it's ID or -1 to quit: ");
        selection = input.nextInt();
        if(selection == -1)
            return;
        System.out.print("Are you sure you wish to purchase this bone?\nEnter Yes or No:");
        selection2 = input.next();
        if(selection2.compareTo("No")==0)
            buyBone();
        for(Bone b : boneList) {
            if(b.getID() == selection){
                System.out.println("You have just purchased a " + b.getName() + "!\n");
                b.setAvailable(false);
                break;
            }
        }
    }

    public void updateMap(){
        for(int i=0;i<coordList.size();i++){
            Coordinate tempCoord = coordList.get(i);
            int[] coordVals = tempCoord.getVals();

            for(int j=0; j < boneList.size(); j++){
                Bone tempBone = boneList.get(j);
                Coordinate boneCoord = tempBone.getCoordinate();

                if(boneCoord.getRowIndex()==coordVals[0] && boneCoord.getCollIndex()==coordVals[1]){ //If there is a bone at this coordinate

                    if(tempBone.isAvailable())
                        tempCoord.available = 1;
                    else if(!tempBone.isAvailable())
                        tempCoord.available = 0;

                    coordList.set(j,tempCoord);
                }
                else{
                    tempCoord.available = -1;
                    coordList.set(j,tempCoord);
                }
            }
        }
    }
    public void scramble(){
        for(int i=0;i<boneList.size();i++){
            Bone curBone = boneList.get(i);
            Coordinate cur = curBone.getCoordinate();

            int curX = (int)(Math.random()*59); //0-59
            int curY = (int)(Math.random()*19); //0-19
            cur.rowIndex = curX;
            cur.collIndex = curY;
            for(int j=0;j<coordList.size();j++){
                if(coordList.get(j).landOrWaterMap==1){
                    if(cur.rowIndex==coordList.get(j).rowIndex && cur.collIndex==coordList.get(j).collIndex)
                        break;   //if on land
                    else if(j==1194){                                              //if bone not on land, get new values and restart loop
                        curX = (int)(Math.random()*59); //0-59
                        curY = (int)(Math.random()*19); //0-19
                        cur.rowIndex = curX;
                        cur.collIndex = curY;
                        System.out.print(curX + " ");
                        System.out.println(curY);
                        j=0;
                    }
                }
            }

        }
        for(int i=0;i<buyerList.size();i++){
            BuyerUser curSeller = buyerList.get(i);
            Coordinate cur = curSeller.getCoordinate();
            double curX = (Math.random()*180); //0-180
            double curY = (Math.random()*90); //0-90
            cur.setLongitude(curX);
            cur.setLatitude(curY);
        }
    }
    public void saveFile() throws IOException {                       //Saves the bone list to a file
        FileWriter outFile = new FileWriter("./src/Datastore/text.csv", false);
        BufferedWriter outStream = new BufferedWriter(outFile);
        for (int k = 0; k < boneList.size(); k++)
            try {
                String line = boneList.get(k).toString();


                outStream.write(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
        outStream.close();
        System.out.println("Data saved.\n");
    }

    public void saveBuyer() throws IOException {                       //Saves the bone list to a file
        FileWriter outFile = new FileWriter("./src/Datastore/buyers.csv", false);
        BufferedWriter outStream = new BufferedWriter(outFile);
        for (int k = 0; k < buyerList.size(); k++)
            try {
                String line = buyerList.get(k).toString();


                outStream.write(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
        outStream.close();
        System.out.println("Data saved.\n");
    }

    /**
     * Menu function for creating, updating, or remove a Seller.
     */
    private void userMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nWould you like to:\n1.Set up a new user.\n2.Update a user.\n3.Remove a user.\n4.Quit to main menu");
            choice = input.nextInt();
            if (choice == 1) {
                /*Bone newBone = new Bone();
                newBone.create();
                boneList.add(newBone);*/
                setupUser();
            }

            if (choice == 2) {
                updateUser();
            }
            if (choice == 3) {
                removeUser();
            }
        }
    }

    /**
     * Based on the current ArrayList of users, the user can type in a
     * matching name that is displayed from the table, and this will
     * remove the user from the ArrayList.
     */
    private void removeUser() {
        String name;
        int i;
        System.out.println("--------------------------------------------------------");
        System.out.println("|    Name       |    Longitude    |     Latitude       |");
        System.out.println("--------------------------------------------------------");
        for (BuyerUser user : buyerList) {
            System.out.printf("|%-15s|%-17.2f|%-20.2f|%n", user.getName(), user.getCoordinate().getLongitude(), user.getCoordinate().getLatitude());
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Enter the sellers name to remove them: ");
        name = input.next();
        for (i = 0; i < buyerList.size(); i++) {
            BuyerUser temp = buyerList.get(i);
            if (!Objects.equals(temp.getName(), name))
                continue;
            else {
                buyerList.remove(i);
            }

        }
    }


    /**
     * Updates list of Sellers, the user types in a name which
     * has already been previously set by using setupUser().
     * The user then can rename the user,
     * give a new longitude, and new latitude.
     */
    private void updateUser() {
        String name;
        int i;
        System.out.println("--------------------------------------------------------");
        System.out.println("|    Name       |    Longitude    |     Latitude       |");
        System.out.println("--------------------------------------------------------");
        for (BuyerUser user : buyerList) {
            System.out.printf("|%-15s|%-17.2f|%-20.2f|%n", user.getName(), user.getCoordinate().getLongitude(), user.getCoordinate().getLatitude());
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Select a user by entering their name: ");
        name = input.next();
        for (i = 0; i < buyerList.size(); i++) {
            BuyerUser temp = buyerList.get(i);
            if (!Objects.equals(temp.getName(), name))
                continue;
            else {
                System.out.print("Please enter a new name for the seller:");
                String newName = input.next();
                temp.setName(newName);
                System.out.print("Please enter a new longitude for the seller:");
                Double newLong = input.nextDouble();
                temp.setLongitude(newLong);
                System.out.print("Please enter a new latitude for the seller:");
                Double newLat = input.nextDouble();
                temp.setLatitude(newLat);
            }
        }
    }

    /**
     * Creates an object of SellerUser, and adds it to an ArrayList called userList.
     */
    private void setupUser() {
        String name;
        double x;
        double y;
        try {
            System.out.print("Please enter your name, longitude, and latitude:");
            name = input.next();
            x = input.nextDouble();
            y = input.nextDouble();
            BuyerUser user = new BuyerUser(x,y,name);

            buyerList.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String args[]){
        Buyer Daniel = new Buyer();
        Daniel.menu();
    }
}
