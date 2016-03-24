package Seller;
/**
 * Daniel Delago    1/28/2016
 * Seller Program
 */

import Datastore.*;
import com.sun.deploy.util.ArrayUtil;
import sun.tools.java.ScannerInputReader;

import java.io.*;
import java.util.*;


public class Seller {

    String dinosaurName;
    String other;
    Scanner input;
    ArrayList<Coordinate> coordList;
    ArrayList<Bone> boneList;
    ArrayList<Continents> contList;
    String shopName = "DK's Dino Shop";
    LoadFile file;
    String[] specificBones = {"amargasaurus","dakosaurus","giganotosaurus","hylaeosaurus","pteranodon","pterodactyl","pterosaur","shastasaurus","spinosaurus","triceratops","tyrannosaurusrex","velociraptor"};

    public Seller(){                                       //Constructor for Seller Class

        input = new Scanner(System.in);
        coordList = new ArrayList();
        boneList = new ArrayList();
        contList = new ArrayList();
        file = new LoadFile("./src/Datastore/text.csv");

        loadContinents();
    }
    public void menu(){                                     //Seller Menu
        int choice;
        Boolean running = true;
        while(running) {
            System.out.println("Bone Seller Menu:");
            System.out.println("1. Load Map\n2. Handle a bone\n3. Display Map\n4. Save Files\n5. Load Files\n6. Create Shop Name\n7. Seller\n8. Quit");
            choice = input.nextInt();
            if (choice < 1 || choice > 8) {
                System.out.println("That is not a valid input.\n");
                continue;
            }

            switch (choice){                                 //switch on user input
                case 1:
                    loadMap();break;
                case 2:
                    handleBone();break;
                case 3:
                    displayMap();break;
                case 4:
                    try {
                        saveFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    boneList=file.loadBones();
                    for(Bone b : boneList) {
                        System.out.println(b);
                    }
                    break;
                case 6:
                    System.out.print("Enter your shop name: ");         //Enter new shop name
                    shopName = input.next();
                    break;
                case 7:
                    setupUser();
                    break;
                case 8:
                    running = false;
                    break;
            }
        }
    }

    private void setupUser() {
        String name;
        int x;
        int y;
        Coordinate mapX = null;
        Coordinate mapY = null;
        SellerUser user;

        try{
            name = input.next();
            x = input.nextInt();
            y = input.nextInt();
            //SellerUser user = new SellerUser(;
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Makes objects of text files, which are added to an array list, and then the function
     * reads the file from the array list in Continents.java
     */
    public void loadContinents(){
        try {
            Continents Africa = new Continents("./src/Datastore/Africa.txt");
            contList.add(Africa);
            Continents Antarctica = new Continents("./src/Datastore/Antarctica.txt");
            contList.add(Antarctica);
            Continents Asia = new Continents("./src/Datastore/Asia.txt");
            contList.add(Asia);
            Continents Australia = new Continents("./src/Datastore/Australia.txt");
            contList.add(Australia);
            Continents Europe = new Continents("./src/Datastore/Europe.txt");
            contList.add(Europe);
            Continents NorthAmerica = new Continents("./src/Datastore/NorthAmerica.txt");
            contList.add(NorthAmerica);
            Continents SouthAmerica = new Continents("./src/Datastore/SouthAmerica.txt");
            contList.add(SouthAmerica);

            Continents.contList = this.contList;
        }catch (Error e){
            e.printStackTrace();
        }
    }

    /**
     * Loads a text file named map.txt
     */
    public void loadMap(){

        File mapFile = new File("./src/Datastore/Map.txt");

        try{
            Scanner fileIn = new Scanner(mapFile);
            while(fileIn.hasNext()){
                String tempLine = fileIn.nextLine();
                String coordData[] = tempLine.split(",");
                Coordinate newCoord = new Coordinate(coordData);
                //newCooloadMap(coordData);
                coordList.add(newCoord);
            }
            fileIn.close();
        }
        catch (IOException e){
            System.out.println("File not Found");
        }

        System.out.println("Map Loaded\n");
    }

    /**
     * Menu function for choosing create,
     * update, or removing a single bone.
     * Each bone currently loaded will be
     * displayed in a text table with its
     * ID, name, and price.
     */
    public void handleBone(){
        int choice=0;
        while(choice != 4){
            System.out.println("\nWould you like to:\n1.Create a bone\n2.Update a bone\n3.Remove a bone\n4.Quit to main menu");
            choice = input.nextInt();

            if(choice == 1){
                /*Bone newBone = new Bone();
                newBone.create();
                boneList.add(newBone);*/
                create();
            }

            if(choice == 2){
                int id,i;
                System.out.println("----------------------------------------------------");
                System.out.println("|ID|          Bones for Sale           |   Price   |");
                System.out.println("----------------------------------------------------");
                for(Bone b : boneList) {
                    System.out.printf("|%2d|%-35s|$%-10.2f|%n",b.getID(),b.getName(),b.getPrice());
                }
                System.out.println("----------------------------------------------------");
                System.out.print("Select a bone to update by entering it's ID or enter -1 to quit: ");
                id = input.nextInt();
                for(i=0;i<boneList.size();i++) {
                    Bone temp = boneList.get(i);
                    if(temp.getID() != id)
                        continue;
                    for(int k=0;k<coordList.size();k++){
                        Coordinate tempCoord = coordList.get(k);
                        //int[] coordVals = Coordinate.getVals(tempCoord);
                        int[] coordVals = tempCoord.getVals();
                        if(temp.getMapX()==coordVals[0] && temp.getMapY()==coordVals[1]){
                            tempCoord.available=-1;
                        }
                    }
                    temp.newLat();
                    temp.newLong();
                    temp.newPrice();
                    break;
                }
            }

            if(choice == 3){
                int id;
                System.out.println("----------------------------------------------------");
                System.out.println("|ID|          Bones for Sale           |   Price   |");
                System.out.println("----------------------------------------------------");
                for(Bone b : boneList) {
                    System.out.printf("|%2d|%-35s|$%-10.2f|%n",b.getID(),b.getName(),b.getPrice());
                }
                System.out.println("----------------------------------------------------");
                System.out.print("Select a bone to remove by entering it's ID or enter -1 to quit: ");
                id = input.nextInt();
                for(Bone b : boneList) {
                    if(b.getID() != id)
                        continue;
                    for(int k=0;k<coordList.size();k++){
                        Coordinate tempCoord = coordList.get(k);
                        //int[] coordVals = Coordinate.getVals(tempCoord);
                        int[] coordVals = tempCoord.getVals();
                        if(b.getMapX()==coordVals[0] && b.getMapY()==coordVals[1]){
                            tempCoord.available=-1;
                        }
                    }
                    boneList.remove(b);
                    break;
                }
            }
        }
    }

    /**
     * Function executed from handleBone() that takes a single
     * line of input (name, price, longitude, latitude,) and
     * creates a Bone object based off of input.
     *
     * TODO: Side effect: If you do not put a comma on the last value, an error will occur.
     */

    private void create() {
        try {
            boolean match = false;
            float price;
            double longitude;
            double lat;
            System.out.print("Enter the values of the dinosaur on a single line: (Name, price, longitude, latitude)\n");
            Scanner createScanner = new Scanner(System.in);
            String[] array = new String[4];
            createScanner.useDelimiter(",");


            try {
                for (int i = 0; i < array.length;i++) {
                    {
                        array[i] = createScanner.next();
                    }

                }
            }catch (Error e){
                System.out.print("Wrong format");
            }
            dinosaurName = array[0].replaceAll("\\s","").toLowerCase();
            price = Float.parseFloat(array[1]);
            longitude = Double.parseDouble(array[2]);
            lat = Double.parseDouble(array[3]);

            for (String specificBone : specificBones)
                if (dinosaurName.equals(specificBone)) {
                    match = true;
                }

            if (match){
                switch (dinosaurName){
                    case("amargasaurus"):
                        Amargasaurus amargasaurus = new Amargasaurus(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,"");
                        String code = amargasaurus.getDownloadCode();
                        amargasaurus.setDownloadCode(code);
                        boneList.add(amargasaurus);
                        break;

                    case("dakosaurus"):
                        Dakosaurus dakosaurus = new Dakosaurus(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,true,"feet");
                        boneList.add(dakosaurus);
                        break;
                    case("giganotosaurus"):
                        Giganotosaurus giganotosaurus = new Giganotosaurus(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0);
                        boneList.add(giganotosaurus);
                        break;
                    case("hylaeosaurus"):
                        Hylaeosaurus hylaeosaurus = new Hylaeosaurus(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,0,0);
                        boneList.add(hylaeosaurus);
                        break;
                    case("pteranodon"):
                        Pteranodon pteranodon = new Pteranodon(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,true,0,"yes");
                        boneList.add(pteranodon);
                        break;
                    case("pterodactyl"):
                        Pterodactyl pterodactyl = new Pterodactyl(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,true);
                        boneList.add(pterodactyl);
                        break;
                    case("pterosaur"):
                        Pterosaur pterosaur = new Pterosaur(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,"Red");
                        boneList.add(pterosaur);
                        break;
                    case("shastasaurus"):
                        Shastasaurus shastasaurus = new Shastasaurus(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,true,"feet");
                        int teeth = Shastasaurus.getNumberOfTeeth();
                        Shastasaurus.setNumberOfTeeth(teeth);
                        boneList.add(shastasaurus);
                        break;
                    case("spinosaurus"):
                        Spinosaurus spinosaurus = new Spinosaurus(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,0);
                        boneList.add(spinosaurus);
                        break;
                    case("triceratops"):
                        Triceratops triceratops = new Triceratops(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Kolten",dinosaurName,0,0,0);
                        boneList.add(triceratops);
                        break;
                    case("tyrannosaurusrex"):
                        TyrannosaurusRex tyrannosaurusRex = new TyrannosaurusRex(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,0);
                        boneList.add(tyrannosaurusRex);
                        break;
                    case("velociraptor"):
                        Velociraptor velociraptor = new Velociraptor(true,0,0,price,0,0,0,0,lat,longitude,"new","USA","Daniel",dinosaurName,0,0,"large");
                        boneList.add(velociraptor);
                        break;

                    default:
                        System.out.print("Please enter a correct bone");
                }
            }

            /*if (dinosaurName.equals("Spinosaurus")){

            }*/

        }catch (Exception e){
            System.out.format("You broke it.");
            e.printStackTrace();
        }
    }
    /**
     * Function from seller menu that displays the loaded map.txt file
     * and the Bone objects that are for sale, if any.
     */
    public void displayMap(){
        try {
            for(Bone b : boneList) {
                System.out.println(b.toString());
            }
            int centerTitle = (60-shopName.length())/2;
            System.out.printf("%"+centerTitle+"s%s%n"," ", shopName);
            integrateBonesWithMap();
            int sum=0;
            for(int i=0; i<20;i++){
                for(int j=0;j<60;j++){
                    Coordinate tempCoord = coordList.get(sum);
                    //int[] coordVals = Coordinate.getVals(tempCoord);
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

    /**
     * Function that takes the array list of bones, uses a getter to get the Coordinate object
     * from the Bone model, gets the position of the Coordinate object, sets the values to 1 or 0
     */
    public void integrateBonesWithMap(){                            //Finds what coordinate contains a bone
        for(int i=0; i < boneList.size(); i++){
            Bone tempBone = boneList.get(i);
            Coordinate boneCoord = tempBone.getCoordinate();

            for(int k=0;k<coordList.size();k++){
                Coordinate tempCoord = coordList.get(k);
                int[] coordVals = tempCoord.getVals();

                if(boneCoord.getRowIndex()==coordVals[0] && boneCoord.getCollIndex()==coordVals[1]){

                    if(tempBone.isAvailable())
                        tempCoord.available = 1;
                    else if(!tempBone.isAvailable())
                        tempCoord.available = 0;

                    coordList.set(k,tempCoord);
                }
            }
        }
    }

    /**
     * Function that writes the boneList array list to the original file
     */
    public void saveFile() throws IOException {                 //Saves file to text.csv
        FileWriter outFile = new FileWriter("./src/Datastore/text.csv", false);
        BufferedWriter outStream = new BufferedWriter(outFile);
        for (int k = 0; k < boneList.size(); k++)
            try {
                String line = boneList.get(k).toString();


                outStream.write(line);

            } catch (IOException e) {
                System.out.println("Skipped");
                e.printStackTrace();
            }
        outStream.close();
        System.out.println("Data saved.\n");
    }

    /**
     * Static main function, goes to the menu function
     */
        public static void main(String[] args){
        Seller Daniel = new Seller();
        Daniel.menu();
    }
}
