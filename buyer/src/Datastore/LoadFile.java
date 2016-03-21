package Datastore;
/**
 * @author KoltenSturgill
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;


public class LoadFile {                                            //Loads a bone file

    Scanner fileContents;
    Formatter formatter;

    public LoadFile(String s){
        try {
            fileContents = new Scanner(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* Right */
    /**
     * Regex Solution for CSV file split
     * with commas by Achintya Jha
     * http://stackoverflow.com/a/15739087/4151253
     * */
    public ArrayList<Bone> loadBones() {                   //Adds the lines of the file as bone objects into a list
        System.out.println("Loading Bone...");
        ArrayList tempBones = new ArrayList();


        //Load entire file line by line
        while(fileContents.hasNextLine()) {
            String line = fileContents.nextLine();
            String[] parsed = line.split(",");
            if(parsed.length == 14) {
                Bone bone = new Bone(parsed);
                tempBones.add(bone);
                //System.out.println(bone.toString());
            }
        }

        return tempBones;
    }



    /* Wrong */


    /*public int load(){

        //Creates a file object

        //File file = new File("text.csv");
        if(file.exists()){
            readFile(file);

            readCount++;

        }

        return readCount;
    }

*//*    public boolean isLoaded(){
        //load();

        if (readCount >= 1){
            System.out.print("File is loaded\n");
            bone.createBone();

        }

        else{
            System.out.print("No files found!\n");
        }

        return false;
    }*//*


    public ArrayList readFile(File fileIn){
        //Reads and prints items in file

        //ArrayList list = new ArrayList();


        try{
            Scanner input = new Scanner(fileIn);
            //input.useDelimiter(",");

            while(input.hasNext()){
                //Bones bone = new Bones(input.nextLine());
                if(input.hasNextInt()){
                    list.add(input.nextInt());
                }

                if(input.hasNextFloat()){
                    list.add(input.nextFloat());
                }

                if(input.hasNext()){
                    list.add(input.next());
                }

            }
            input.close();
            System.out.print("Finished loading...\n");
        }

        catch(IOException ex){
            System.out.printf("%s", "File not found!");
        }

        //System.out.print(list);
        //createBone(list);
        return list;

    }

    public ArrayList getList() {
        //readFile(file);
        return list;
    }*/
}



    

