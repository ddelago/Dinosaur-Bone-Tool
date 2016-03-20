/**
 * Created by daniel on 2/5/16.
 */
public class Coordinate {                                       //Coordinate class for the map points

    int longitudeMap, latitudeMap, landOrWaterMap, available=-1;
    double longitudeGlobe, latitudeGlobe;

    public void loadMap(String newCoordData []){                //Parses data from map.txt
        longitudeMap = Integer.parseInt(newCoordData[0]);
        latitudeMap = Integer.parseInt(newCoordData[1]);
        landOrWaterMap = Integer.parseInt(newCoordData[2]);
    }

    public static int[] getVals(Coordinate temp){               //Returns the values from a certain coordinate
        int[] coord = {temp.longitudeMap, temp.latitudeMap, temp.landOrWaterMap, temp.available };
        return coord;
    }

    public static int longToX(double longitude){                //Converts longitude to x matrix points
        int mapX;
        longitude /= 6;
        if(longitude >= 0)
            longitude +=29;
        else if (longitude < 0)
            longitude = 30+longitude;
        mapX = (int)Math.round(longitude);
        return mapX;
    }

    public static int latToY(double latitude){                  //Converts latitude to y matrix points
        int mapY;
        latitude /= 9;
        if(latitude > 0){
            latitude *= -1;
            latitude +=10;
        }
        else if (latitude <= 0)
            latitude = 9 + Math.abs(latitude);
        mapY = (int)Math.round(latitude);
        return mapY;
    }

    /*public void setAvailable(int available){
        this.available = available;
    }*/
}