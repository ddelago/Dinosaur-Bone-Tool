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
 * The Continents class is the class that defines the continent attribute for every bone,user, and map.
 *
 * Data Members:
 * boolean [][]continent;
 * String contName;
 * int priceIncrease;
 * Coordinate coordinate;
 * ArrayList<Continents> contList;
 *
 * Functions:
 * +public Continents(String contName)
 *  Takes a String and assigns the continent object's contName attribute to this string.
 *  Takes the continent file and assigns boolean values into continent depending on the values in the file.
 *
 * +public Continents returnContinents(Coordinate location)
 *  Takes in a Coordinate object and returns what continent this object is on
 *
 * +public boolean onContinent(Coordinate location)
 *  Takes a Coordinate and returns true of false if it is located on the current continent.
 *
 * +public float price()
 *  Assign a specific price to the attribute priceIncrease depending on what continent the object is.
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
