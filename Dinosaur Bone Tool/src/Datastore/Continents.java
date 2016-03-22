package Datastore;

import java.io.File;
import java.util.Scanner;

/**
 * Created by daniel on 3/22/16.
 */
public class Continents {
    public boolean [][] continent;
    public String contName;
    public Continents(String contName){

        this.contName=contName.substring(0,(contName.length()-4));
        File contFile = new File(contName);

        try{
            Scanner fileIn = new Scanner(contFile);
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
            System.out.println("File Error"); //No user input so there should be no error
        }
    }

    public boolean onContinent(Coordinate location){            //Outside of this class have each continent loop through
                                                                //Every Bone. Bones should have Coordinate Attribute now
        if(continent[location.rowIndex][location.collIndex]==true){
            //Add price Increase Function

            return true;
        }

        else
            return false;
    }
}
