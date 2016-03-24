package Datastore;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by daniel on 3/22/16.
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
