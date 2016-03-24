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
    LoadFile file;

    public Buyer(){

        input = new Scanner(System.in);
        coordList = new ArrayList();
        boneList = new ArrayList();
        file = new LoadFile("./src/Datastore/text.csv");
    }
    public void menu(){                                    //Bone Buyer Menu
        int choice;
        Boolean running = true;
        while(running) {
            System.out.println("Bone Buyer Menu:");
            System.out.println("1. Load Map\n2. Display Map\n3. Buy a Bone\n4. Save Files\n5. Load Files\n6. Quit");
            choice = input.nextInt();
            if (choice < 1 || choice > 6) {
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    boneList=file.loadBones();
                    for(Bone b : boneList) {
                        System.out.println(b.toString());
                    }
                    break;
                case 6:
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


    public static void main(String args[]){
        Buyer Daniel = new Buyer();
        Daniel.menu();
    }
}
