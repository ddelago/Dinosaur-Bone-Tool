package Datastore;

import java.util.Random;

/**
 * Amargasaurus.java
 * Daniel Delago
 * Kolten Sturgill
 * 1001060927
 * 1001089599
 *
 * The Amargasaurus class is the class that defines the Amargasaurus dinosaur bone model
 *
 * Data Members:
 * double downloadCode
 *
 * Functions:
 * +public Amargasaurus()
 *  Takes 15 parameters and assigns to bone object.
 *
 * +public String getDownloadCode()
 *  Returns data member downloadCode
 *
 * +public void setDownloadCode(String downloadCode)
 *  Takes a string to set's Amargasaurus downloadCode data member to this string.
 *
 * +private String randomDownloadCode()
 *  Generates a random String of 16 characters and returns it using the StringBuilder library by WhiteFang34, modified for this program.
 *  http://stackoverflow.com/questions/5683327/how-to-generate-a-random-string-of-20-characters
 */

public class Amargasaurus extends LandHerbivore {
    String downloadCode = randomDownloadCode();

    public Amargasaurus(boolean isAvailable, int age, int id, float price, float length, float width, float height, float weight, double latitude, double longitude, String condition, String origin, String prospector, String name, double speed, double gait, String downloadCode) {
        super(isAvailable, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, name, speed, gait);
        this.downloadCode = downloadCode;
    }

    public String getDownloadCode() {
        return downloadCode;
    }

    public void setDownloadCode(String downloadCode) {
        this.downloadCode = downloadCode;
    }

    private String randomDownloadCode(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 16; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        setDownloadCode(sb.toString());
        return sb.toString();
    }
}
