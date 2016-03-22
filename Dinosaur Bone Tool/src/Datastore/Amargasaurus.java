package Datastore;

import java.util.Random;

/**
 * Kolten Sturgill
 * 1001089599
 * CSE 1325-002
 * 3/20/16.
 */
public class Amargasaurus extends LandHerbivore {
    String downloadCode;

    public Amargasaurus(String name, int age, int id, float price, float length, float width, float height, float weight, float latitude, float longitude, String condition, String origin, String prospector, double speed, double gait, String downloadCode) {
        super(name, age, id, price, length, width, height, weight, latitude, longitude, condition, origin, prospector, speed, gait);
        this.downloadCode = randomDownloadCode();
        System.out.print("Your free download code: " + getDownloadCode().toUpperCase());
    }

    public String getDownloadCode() {
        return downloadCode;
    }

    public void setDownloadCode(String downloadCode) {
        this.downloadCode = downloadCode;
    }

    /**
     *  Generates a random String of 16 characters
     *  using the StringBuilder library by WhiteFang34, modified for this program.
     *  http://stackoverflow.com/questions/5683327/how-to-generate-a-random-string-of-20-characters
     * */
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
