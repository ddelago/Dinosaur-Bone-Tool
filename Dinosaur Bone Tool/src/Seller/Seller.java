package Seller;
/**
 * Daniel Delago    1/28/2016
 * Seller Program
 */

import Datastore.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Seller {

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
        file = new LoadFile("text.csv");
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

    public void loadContinents(){                                       //Loads and prepares the continents
        Continents Africa = new Continents("Africa.txt");               contList.add(Africa);
        Continents Antarctica = new Continents("Antarctica.txt");       contList.add(Antarctica);
        Continents Asia = new Continents("Asia.txt");                   contList.add(Asia);
        Continents Australia = new Continents("Australia.txt");         contList.add(Australia);
        Continents Europe = new Continents("Europe.txt");               contList.add(Europe);
        Continents NorthAmerica = new Continents("NorthAmerica.txt");   contList.add(NorthAmerica);
        Continents SouthAmerica = new Continents("SouthAmerica.txt");   contList.add(SouthAmerica);

    }
    public void loadMap(){                                              //Load the map from map.txt

        File mapFile = new File("Map.txt");

        try{
            Scanner fileIn = new Scanner(mapFile);
            while(fileIn.hasNext()){
                String tempLine = fileIn.nextLine();
                String coordData[] = tempLine.split(",");
                Coordinate newCoord = new Coordinate(coordData);
                coordList.add(newCoord);
            }
            fileIn.close();
        }
        catch (IOException e){
            System.out.println("File not Found");
        }

        System.out.println("Map Loaded\n");
    }


    public void handleBone(){                                           //Handle a bone according to user input
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

    private void create() {
        try {
            Bone bone;
            boolean match = false;
            String temp = "";
            System.out.print("Enter the values of the dinosaur on a single line: (Name, price, longitude, latitude)\n");
            String dinosaurName = input.next();
            float price = input.nextFloat();
            float longitude = input.nextFloat();
            float lat = input.nextFloat();

            // Regex split, and lower case
            if (dinosaurName.equals(dinosaurName)){
                dinosaurName = dinosaurName.toLowerCase();
            }


            for (int i = 0; i < specificBones.length; i++) {
                if (dinosaurName.equals(specificBones[i])){
                    match = true;
                }
            }

            if (match){
                switch (dinosaurName){
                    case("amargasaurus"):
                        bone = new Amargasaurus(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0,"");
                        boneList.add(bone);
                        break;
                    case("dakosaurus"):
                        Dakosaurus dakosaurus = new Dakosaurus(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ",true,"");
                        dakosaurus.getMethodOfPropulsion();
                        dakosaurus.isSaltWater();
                        boneList.add(dakosaurus);
                        break;
                    case("giganotosaurus"):
                        bone = new Giganotosaurus(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0);
                        boneList.add(bone);
                        break;
                    case("hylaeosaurus"):
                        bone = new Hylaeosaurus(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0,0,0);
                        boneList.add(bone);
                        break;
                    case("pteranodon"):
                        bone = new Pteranodon(dinosaurName,0,20,price,0,0,0,0,lat,longitude," ", " ", " ", 0, 0, false, 0);
                        boneList.add(bone);
                        break;
                    case("pterodactyl"):
                        bone = new Pterodactyl(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0,false);
                        boneList.add(bone);
                        break;
                    case("pterosaur"):
                        bone = new Pterosaur(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0,"red");
                        boneList.add(bone);
                        break;
                    case("shastasaurus"):
                        Shastasaurus shastasaurus = new Shastasaurus(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ",false,"");
                        //shastasaurus.getMethodOfPropulsion();
                        //shastasaurus.isSaltWater();
                        Shastasaurus.getNumberOfTeeth();
                        boneList.add(shastasaurus);
                        break;
                    case("spinosaurus"):
                        bone = new Spinosaurus(dinosaurName,0,0,price,0,0,0,0,lat,longitude,"Good"," "," ",0,0,0);
                        boneList.add(bone);
                        break;
                    case("triceratops"):
                        bone = new Triceratops(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0,0);
                        boneList.add(bone);
                        break;
                    case("tyrannosaurusrex"):
                        bone = new TyrannosaurusRex(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0,0);
                        boneList.add(bone);
                        break;
                    case("velociraptor"):
                        bone = new Velociraptor(dinosaurName, 0, 0, price,0,0,0,0,lat,longitude," "," "," ", 0,0, "");
                        boneList.add(bone);
                        break;
                    default:
                        System.out.print("Please enter a correct bone");
                }
            }

            /*if (dinosaurName.equals("Spinosaurus")){

            }*/

        }catch (Exception e){
            System.out.format("You broke it.");
        }
    }

    public void displayMap(){                                       //Displays the map containing the Bone for sale
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

    public void integrateBonesWithMap(){                            //Finds what coordinate contains a bone
        for(int i=0; i < boneList.size(); i++){
            Bone tempBone = boneList.get(i);
            for(int k=0;k<coordList.size();k++){
                Coordinate tempCoord = coordList.get(k);
                int[] coordVals = tempCoord.getVals();
                if(tempBone.getMapX()==coordVals[0] && tempBone.getMapY()==coordVals[1]){
                    if(tempBone.isAvailable() == true)
                        tempCoord.available = 1;
                    else if(tempBone.isAvailable() == false)
                        tempCoord.available = 0;
                    coordList.set(k,tempCoord);
                }
            }
        }
    }

    public void saveFile() throws IOException {                 //Saves file to text.csv
        FileWriter outFile = new FileWriter("text.csv", false);
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


        public static void main(String[] args){                 //Main
        Seller Daniel = new Seller();
        Daniel.menu();
    }
}
