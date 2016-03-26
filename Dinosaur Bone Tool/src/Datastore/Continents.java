package Datastore;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Continents.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Coordinate class is the class that defines the Coordinate attribute for every bone, user, and map.
 *
 * Data Members:
 * int rowindex, collIndex, landOrWaterMap, available;
 * double longitude, latitude;
 *
 * Functions:
 * +public Coordinate(String newCoordData [])
 *  Takes a String array and assigns the attributes rowIndex, collIndex, and landOrWaterMap to these values.
 *
 * +public Coordinate(double longitude, double latitude)
 *  Takes two doubles and assign the Coordinates longitude and latitude attributes to these values.
 *  It then converts the values to int x and y and assigns the Coordinates rowIndex and collIndex attributes to these values.
 *
 * +public int[] getVals()
 *  Returns an array of the Coordinate objects rowIndex, collIndex, landOrwaterMap, and available attributes.
 *
 * +public int longToX(double longitude)
 *  Converts a longitude value to a x map index and returns it.
 *
 * +public int latToX(double latitude)
 *  Converts a latitude value to a y map index and returns it.
 * public int getRowIndex()
 *
 * public void setRowIndex(int rowIndex)
 * Setter, sets row index of Coordinate object
 *
 * public int getCollIndex()
 * Getter, gets Column Index of Coordinate object
 *
 * public void setCollIndex(int collIndex)
 * Setter, sets the Column index of Coordinate object
 *
 * public int getLandOrWaterMap()
 * Getter, gets weather Coordinate object is on land or water, 1 or 0
 *
 * public void setLandOrWaterMap(int landOrWaterMap)
 * Setter, sets int of weather Coordinate is on land or water, with a 1 or 0.
 *
 * public int getAvailable()
 * Getter, gets integer value
 *
 * public void setAvailable(int available)
 * Setter, sets integer value of weather
 *
 * public double getLongitude()
 * Getter, get Longitude attribute of Coordinate object
 *
 * public void setLongitude(double longitude)
 * Setter, sets Longitude attribute of Coordinate object, takes a parameter
 * of type double
 *
 * public double getLatitude()
 * Getter, gets Latitude attribute of Coordinate object
 *
 * public void setLatitude(double latitude)
 * Setter, sets Latitude attribute of Coordinate object, takes a parameter
 * of type double
 *
 */


public class Continents {
    public boolean [][] continent = new boolean[20][60];
    public String contName;
    public int priceIncrease;
    public Coordinate coordinate;
    public static ArrayList<Continents> contList;

    public Continents(String contName){

        this.contName=contName.substring(16,(contName.length()-4));      //Name of the continent
        price();

        try{
            Scanner fileIn = new Scanner(new File(contName));
            for(int i=0;i<20;i++){                  //For every row
                String row = fileIn.nextLine();     //Take in that entire row
                for(int j=0;j<60;j++){              //And check every index
                    if(row.charAt(j)=='1')          //For land
                        continent[i][j]=true;
                    else                            //Or water
                        continent[i][j]=false;
                }
            }
            fileIn.close();
        }
        catch(Exception e){
            System.out.println("File Error");       //No user input so there should be no error
        }
    }

    public Continents(){
    }

    public Continents returnContinents(Coordinate location){         //Find out what continents its in and return it
        int i=0;
        while(contList.get(i).onContinent(location)==false){          //Loop through contList until onContinent returns true
            i++;
            if(i==7)
                break;
        }
        if(i==7){
            Continents Water = new Continents();
            return Water;
        }
        return contList.get(i);
    }

    public boolean onContinent(Coordinate location){            //Outside of this class have each continent loop through
                                                                //Every Bone. Bones should have Coordinate Attribute now                                                 //Add loop tp check which continents its in and return that cintirnenc
        if(continent[location.collIndex][location.rowIndex]==true)
            return true;
        return false;
    }

    public float price(){

        if (this.contName.equals("Africa"))
            priceIncrease=3000;
        else if (this.contName.equals("Antarctica"))
            priceIncrease=100000;
        else if (this.contName.equals("Asia"))
            priceIncrease=4000;
        else if (this.contName.equals("Australia"))
            priceIncrease=5000;
        else if (this.contName.equals("Europe"))
            priceIncrease=1000;
        else if (this.contName.equals("NorthAmerica"))
            priceIncrease=1000;
        else if (this.contName.equals("SouthAmerica"))
            priceIncrease=3000;
        return priceIncrease;
    }
}
