package Datastore;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by daniel on 3/22/16.
 */
public class Continents {
    public boolean [][] continent = new boolean[20][60];
    public String contName;

    public Continents(String contString){
        //this.contName=contName.substring(0,(contName.length()-4));
        for(int i=0;i<20;i++){
            for(int j=0;j<60;j++){              //And check every index
                if(contString.charAt(i+j)=='1')          //For land
                    continent[i][j]=true;
                else                            //Or water
                    continent[i][j]=false;
            }
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
