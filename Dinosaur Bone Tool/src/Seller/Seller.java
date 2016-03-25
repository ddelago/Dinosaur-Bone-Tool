package Seller;
/**
 * Daniel Delago    1/28/2016
 * Seller Program
 */

import Datastore.*;
import buyer.BuyerUser;
import java.io.*;
import java.util.*;


public class Seller {

    String dinosaurName;
    String other;
    Scanner input;
    ArrayList<Coordinate> coordList;
    ArrayList<Bone> boneList;
    ArrayList<Continents> contList;
    ArrayList<SellerUser> userList;
    String shopName = "DK's Dino Shop";
    LoadFile file;
    LoadFile sellerUserFile;
    String[] specificBones = {"amargasaurus", "dakosaurus", "giganotosaurus", "hylaeosaurus", "pteranodon", "pterodactyl", "pterosaur", "shastasaurus", "spinosaurus", "triceratops", "tyrannosaurusrex", "velociraptor"};

    public Seller() {                                       //Constructor for Seller Class

        input = new Scanner(System.in);
        coordList = new ArrayList();
        boneList = new ArrayList();
        contList = new ArrayList();
        userList = new ArrayList();
        file = new LoadFile("./src/Datastore/text.csv");
        sellerUserFile = new LoadFile("./src/Datastore/seller.csv");

        loadContinents();
    }
    /**
     * Parent/Driver menu function for the entire program.
     */
    public void menu() {                                     //Seller Menu
        int choice;
        Boolean running = true;
        while (running) {
            System.out.println("Bone Seller Menu:");
            System.out.println("1. Load Map\n2. Handle a bone\n3. Display Map\n4. Save Files\n5. Load Files\n6. Create Shop Name\n7. Seller\n8. Scramble\n9. Distance\n10. Quit");
            choice = input.nextInt();
            if (choice < 1 || choice > 10) {
                System.out.println("That is not a valid input.\n");
                continue;
            }

            switch (choice) {                                 //switch on user input
                case 1:
                    loadMap();
                    break;
                case 2:
                    handleBone();
                    break;
                case 3:
                    displayMap();
                    break;
                case 4:
                    try {
                        saveFile();
                        saveUsers();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    boneList = file.loadBones();
                    for (Bone b : boneList) {
                        System.out.println(b);
                    }

                    userList = sellerUserFile.loadSellers();
                    for (SellerUser seller : userList){
                        System.out.println(seller);
                    }
                    break;
                case 6:
                    System.out.print("Enter your shop name: ");         //Enter new shop name
                    shopName = input.next();
                    break;
                case 7:
                    userMenu();
                    break;
                case 8:
                    scramble();
                    break;
                case 9:
                    double dist = distance();
                    System.out.printf("Distance between users is %.2f miles.%n%n", dist);
                    break;
                case 10:
                    running = false;
                    break;
            }
        }
    }

    /**
     * Menu function for creating, updating, or remove a Seller.
     */
    private void userMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nWould you like to:\n1.Set up a new user.\n2.Update a user.\n3.Remove a user.\n4.Quit to main menu");
            choice = input.nextInt();
            if (choice == 1) {
                /*Bone newBone = new Bone();
                newBone.create();
                boneList.add(newBone);*/
                setupUser();
            }

            if (choice == 2) {
                updateUser();
            }
            if (choice == 3) {
                removeUser();
            }
        }
    }

    /**
     * Based on the current ArrayList of users, the user can type in a
     * matching name that is displayed from the table, and this will
     * remove the user from the ArrayList.
     */
    private void removeUser() {
        String name;
        int i;
        System.out.println("--------------------------------------------------------");
        System.out.println("|    Name       |    Longitude    |     Latitude       |");
        System.out.println("--------------------------------------------------------");
        for (SellerUser user : userList) {
            System.out.printf("|%-15s|%-17.2f|%-20.2f|%n", user.getName(), user.getCoordinate().getLongitude(), user.getCoordinate().getLatitude());
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Enter the sellers name to remove them: ");
        name = input.next();
        for (i = 0; i < userList.size(); i++) {
            SellerUser temp = userList.get(i);
            if (!Objects.equals(temp.getName(), name))
                continue;
            else {
                userList.remove(i);
            }

        }
    }


    /**
     * Updates list of Sellers, the user types in a name which
     * has already been previously set by using setupUser().
     * The user then can rename the user,
     * give a new longitude, and new latitude.
     */
    private void updateUser() {
        String name;
        int i;
        System.out.println("--------------------------------------------------------");
        System.out.println("|    Name       |    Longitude    |     Latitude       |");
        System.out.println("--------------------------------------------------------");
        for (SellerUser user : userList) {
            System.out.printf("|%-15s|%-17.2f|%-20.2f|%n", user.getName(), user.getCoordinate().getLongitude(), user.getCoordinate().getLatitude());
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Select a user by entering their name: ");
        name = input.next();
        for (i = 0; i < userList.size(); i++) {
            SellerUser temp = userList.get(i);
            if (!Objects.equals(temp.getName(), name)){
                return;
            }
            else {
                System.out.print("Please enter a new name for the seller:");
                String newName = input.next();
                temp.setName(newName);
                System.out.print("Please enter a new longitude for the seller:");
                Double newLong = input.nextDouble();
                temp.setLongitude(newLong);
                System.out.print("Please enter a new latitude for the seller:");
                Double newLat = input.nextDouble();
                temp.setLatitude(newLat);
            }
        }
    }

    /**
     * Creates an object of SellerUser, and adds it to an ArrayList called userList.
     */
    private void setupUser() {
        String name;
        double x;
        double y;
        try {
            System.out.print("Please enter your name, longitude, and latitude:");
            name = input.next();
            x = input.nextDouble();
            y = input.nextDouble();
            SellerUser user = new SellerUser(x,y,name);

            userList.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Makes objects of text files, which are added to an array list, and then the function
     * reads the file from the array list in Continents.java
     */
    public void loadContinents() {
        try {
            Continents Africa = new Continents("./src/Datastore/Africa.txt");
            contList.add(Africa);
            Continents Antarctica = new Continents("./src/Datastore/Antarctica.txt");
            contList.add(Antarctica);
            Continents Asia = new Continents("./src/Datastore/Asia.txt");
            contList.add(Asia);
            Continents Australia = new Continents("./src/Datastore/Australia.txt");
            contList.add(Australia);
            Continents Europe = new Continents("./src/Datastore/Europe.txt");
            contList.add(Europe);
            Continents NorthAmerica = new Continents("./src/Datastore/NorthAmerica.txt");
            contList.add(NorthAmerica);
            Continents SouthAmerica = new Continents("./src/Datastore/SouthAmerica.txt");
            contList.add(SouthAmerica);

            Continents.contList = this.contList;
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a text file named map.txt
     */
    public void loadMap() {

        File mapFile = new File("./src/Datastore/Map.txt");

        try {
            Scanner fileIn = new Scanner(mapFile);
            while (fileIn.hasNext()) {
                String tempLine = fileIn.nextLine();
                String coordData[] = tempLine.split(",");
                Coordinate newCoord = new Coordinate(coordData);
                //newCooloadMap(coordData);
                coordList.add(newCoord);
            }
            fileIn.close();
        } catch (IOException e) {
            System.out.println("File not Found");
        }

        System.out.println("Map Loaded\n");
    }

    /**
     * Menu function for choosing create,
     * update, or removing a single bone.
     * Each bone currently loaded will be
     * displayed in a text table with its
     * ID, name, and price.
     */
    public void handleBone() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\nWould you like to:\n1.Create a bone\n2.Update a bone\n3.Remove a bone\n4.Quit to main menu");
            choice = input.nextInt();

            if (choice == 1) {
                /*Bone newBone = new Bone();
                newBone.create();
                boneList.add(newBone);*/
                create();
            }

            if (choice == 2) {
                int id, i;
                System.out.println("----------------------------------------------------");
                System.out.println("|ID|          Bones for Sale           |   Price   |");
                System.out.println("----------------------------------------------------");
                for (Bone b : boneList) {
                    System.out.printf("|%2d|%-35s|$%-10.2f|%n", b.getID(), b.getName(), b.getPrice());
                }
                System.out.println("----------------------------------------------------");
                System.out.print("Select a bone to update by entering it's ID or enter -1 to quit: ");
                id = input.nextInt();
                for (i = 0; i < boneList.size(); i++) {
                    Bone temp = boneList.get(i);
                    if (temp.getID() != id)
                        continue;
                    for (int k = 0; k < coordList.size(); k++) {
                        Coordinate tempCoord = coordList.get(k);
                        //int[] coordVals = Coordinate.getVals(tempCoord);
                        int[] coordVals = tempCoord.getVals();
                        if (temp.getMapX() == coordVals[0] && temp.getMapY() == coordVals[1]) {
                            tempCoord.available = -1;
                        }
                    }
                    temp.newLat();
                    temp.newLong();
                    temp.newPrice();
                    break;
                }
            }

            if (choice == 3) {
                int id;
                System.out.println("----------------------------------------------------");
                System.out.println("|ID|          Bones for Sale           |   Price   |");
                System.out.println("----------------------------------------------------");
                for (Bone b : boneList) {
                    System.out.printf("|%2d|%-35s|$%-10.2f|%n", b.getID(), b.getName(), b.getPrice());
                }
                System.out.println("----------------------------------------------------");
                System.out.print("Select a bone to remove by entering it's ID or enter -1 to quit: ");
                id = input.nextInt();
                for (Bone b : boneList) {
                    if (b.getID() != id)
                        continue;
                    for (int k = 0; k < coordList.size(); k++) {
                        Coordinate tempCoord = coordList.get(k);
                        //int[] coordVals = Coordinate.getVals(tempCoord);
                        int[] coordVals = tempCoord.getVals();
                        if (b.getMapX() == coordVals[0] && b.getMapY() == coordVals[1]) {
                            tempCoord.available = -1;
                        }
                    }
                    boneList.remove(b);
                    break;
                }
            }
        }
    }

    /**
     * Function executed from handleBone() that takes a single
     * line of input (name, price, longitude, latitude,) and
     * creates a Bone object based off of input.
     * <p/>
     * TODO: Side effect: If you do not put a comma on the last value, an error will occur.
     */

    private void create() {
        try {
            boolean match = false;
            float price;
            double longitude;
            double lat;
            System.out.print("Enter the values of the dinosaur on a single line: (Name, price, longitude, latitude)\n");
            Scanner createScanner = new Scanner(System.in);
            String[] array = new String[4];
            createScanner.useDelimiter(",");


            try {
                for (int i = 0; i < array.length; i++) {
                    {
                        array[i] = createScanner.next();
                    }

                }
            } catch (Error e) {
                System.out.print("Wrong format");
            }
            dinosaurName = array[0].replaceAll("\\s", "").toLowerCase();
            price = Float.parseFloat(array[1]);
            longitude = Double.parseDouble(array[2]);
            lat = Double.parseDouble(array[3]);

            for (String specificBone : specificBones)
                if (dinosaurName.equals(specificBone)) {
                    match = true;
                }

            if (match) {
                switch (dinosaurName) {
                    case ("amargasaurus"):
                        Amargasaurus amargasaurus = new Amargasaurus(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, "");
                        String code = amargasaurus.getDownloadCode();
                        amargasaurus.setDownloadCode(code);
                        boneList.add(amargasaurus);
                        break;

                    case ("dakosaurus"):
                        Dakosaurus dakosaurus = new Dakosaurus(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, true, "feet");
                        boneList.add(dakosaurus);
                        break;
                    case ("giganotosaurus"):
                        Giganotosaurus giganotosaurus = new Giganotosaurus(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0);
                        boneList.add(giganotosaurus);
                        break;
                    case ("hylaeosaurus"):
                        Hylaeosaurus hylaeosaurus = new Hylaeosaurus(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, 0, 0);
                        boneList.add(hylaeosaurus);
                        break;
                    case ("pteranodon"):
                        Pteranodon pteranodon = new Pteranodon(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, true, 0, "yes");
                        boneList.add(pteranodon);
                        break;
                    case ("pterodactyl"):
                        Pterodactyl pterodactyl = new Pterodactyl(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, true);
                        boneList.add(pterodactyl);
                        break;
                    case ("pterosaur"):
                        Pterosaur pterosaur = new Pterosaur(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, "Red");
                        boneList.add(pterosaur);
                        break;
                    case ("shastasaurus"):
                        Shastasaurus shastasaurus = new Shastasaurus(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, true, "feet");
                        int teeth = Shastasaurus.getNumberOfTeeth();
                        Shastasaurus.setNumberOfTeeth(teeth);
                        boneList.add(shastasaurus);
                        break;
                    case ("spinosaurus"):
                        Spinosaurus spinosaurus = new Spinosaurus(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, 0);
                        boneList.add(spinosaurus);
                        break;
                    case ("triceratops"):
                        Triceratops triceratops = new Triceratops(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Kolten", dinosaurName, 0, 0, 0);
                        boneList.add(triceratops);
                        break;
                    case ("tyrannosaurusrex"):
                        TyrannosaurusRex tyrannosaurusRex = new TyrannosaurusRex(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, 0);
                        boneList.add(tyrannosaurusRex);
                        break;
                    case ("velociraptor"):
                        Velociraptor velociraptor = new Velociraptor(true, 0, 0, price, 0, 0, 0, 0, lat, longitude, "new", "USA", "Daniel", dinosaurName, 0, 0, "large");
                        boneList.add(velociraptor);
                        break;

                    default:
                        System.out.print("Please enter a correct bone");
                }
            }

            /*if (dinosaurName.equals("Spinosaurus")){

            }*/

        } catch (Exception e) {
            System.out.format("You broke it.");
            e.printStackTrace();
        }
    }

    /**
     * Function from seller menu that displays the loaded map.txt file
     * and the Bone objects that are for sale, if any.
     */
    public void displayMap() {
        try {
            for (Bone b : boneList) {
                System.out.println(b.toString());
            }
            int centerTitle = (60 - shopName.length()) / 2;
            System.out.printf("%" + centerTitle + "s%s%n", " ", shopName);
            updateMap();
            int sum = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 60; j++) {
                    Coordinate tempCoord = coordList.get(sum);
                    int[] coordVals = tempCoord.getVals();
                    if (coordVals[3] == 0)
                        System.out.print("$");
                    else if (coordVals[3] == 1)
                        System.out.print("X");
                    else if (coordVals[2] == 0)
                        System.out.print(".");
                    else if (coordVals[2] == 1)
                        System.out.print("*");
                    sum += 1;
                }
                if (i == 9)
                    System.out.print("<-Equator");
                System.out.println("");
            }
            System.out.println("              Prime Meridian ^");
        } catch (Exception e) {
            System.out.println("Please Load a Map First.\n");
        }
        System.out.println("");

    }

    /**
     * Function that takes the array list of bones, uses a getter to get the Coordinate object
     * from the Bone model, gets the position of the Coordinate object, sets the values to 1 or 0
     */

    public void updateMap(){
        for(int i=0;i<coordList.size();i++){
            Coordinate tempCoord = coordList.get(i);
            int[] coordVals = tempCoord.getVals();

            for(int j=0; j < boneList.size(); j++){
                Bone tempBone = boneList.get(j);
                Coordinate boneCoord = tempBone.getCoordinate();

                if(boneCoord.getRowIndex()==coordVals[0] && boneCoord.getCollIndex()==coordVals[1]){ //If there is a bone at this coordinate

                    if(tempBone.isAvailable()){
                        tempCoord.available = 1;
                        coordList.set(j,tempCoord);
                        break;
                    }
                    else if(!tempBone.isAvailable()){
                        tempCoord.available = 0;
                        coordList.set(j,tempCoord);
                        break;
                    }
                }
                else{
                    tempCoord.available = -1;
                    coordList.set(j,tempCoord);
                }
            }
        }
    }

    public void scramble(){
        for(int i=0;i<boneList.size();i++){
            Bone curBone = boneList.get(i);
            Coordinate cur = curBone.getCoordinate();

            int curX = (int)(Math.random()*59); //0-59
            int curY = (int)(Math.random()*19); //0-19
            cur.rowIndex = curX;
            cur.collIndex = curY;
            for(int j=0;j<coordList.size();j++){
                if(coordList.get(j).landOrWaterMap==1){
                    if(cur.rowIndex==coordList.get(j).rowIndex && cur.collIndex==coordList.get(j).collIndex)
                        break;   //if on land
                    else if(j==1194){                                              //if bone not on land, get new values and restart loop
                        curX = (int)(Math.random()*59); //0-59
                        curY = (int)(Math.random()*19); //0-19
                        cur.rowIndex = curX;
                        cur.collIndex = curY;
                        j=0;
                    }
                }
            }
        }
        for(int i=0;i<userList.size();i++){
            SellerUser curSeller = userList.get(i);
            Coordinate cur = curSeller.getCoordinate();
            double curX = (Math.random()*180); //0-180
            double curY = (Math.random()*90); //0-90
            cur.setLongitude(curX);
            cur.setLatitude(curY);
        }
    }

    public double[] userCoord(){
        String name1;
        SellerUser seller;
        double long1, long2, lat1, lat2;
        double[] coords = new double[4];
        System.out.println("--------------------------------------------------------");
        System.out.println("|    Name       |    Longitude    |     Latitude       |");
        System.out.println("--------------------------------------------------------");
        for (SellerUser user : userList) {
            System.out.printf("|%-15s|%-17.2f|%-20.2f|%n", user.getName(), user.getCoordinate().getLongitude(), user.getCoordinate().getLatitude());
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Select a seller by entering their name: ");
        name1 = input.next();
        for (int i = 0; i < userList.size(); i++) {
            SellerUser temp = userList.get(i);
            if (!Objects.equals(temp.getName(), name1))
                continue;
            else {
                seller=temp;
                long1=seller.getCoordinate().getLongitude();
                lat1=seller.getCoordinate().getLatitude();
                coords[0]=long1;
                coords[2]=lat1;
            }
        }

        LoadFile buyerFile = new LoadFile("./src/Datastore/buyers.csv");
        ArrayList<BuyerUser> buyerList = buyerFile.loadBuyers();
        String name2;
        BuyerUser buyer;
        System.out.println("--------------------------------------------------------");
        System.out.println("|    Name       |    Longitude    |     Latitude       |");
        System.out.println("--------------------------------------------------------");
        for (BuyerUser user : buyerList) {
            System.out.printf("|%-15s|%-17.2f|%-20.2f|%n", user.getName(), user.getCoordinate().getLongitude(), user.getCoordinate().getLatitude());
        }
        System.out.println("--------------------------------------------------------");
        System.out.print("Select a buyer by entering their name: ");
        name2 = input.next();
        for (int i = 0; i < buyerList.size(); i++) {
            BuyerUser temp = buyerList.get(i);
            if (!Objects.equals(temp.getName(), name2))
                continue;
            else {
                buyer=temp;
                long2=buyer.getCoordinate().getLongitude();
                lat2=buyer.getCoordinate().getLatitude();
                coords[1]=long2;
                coords[3]=lat2;
            }
        }
        return coords;
    }

    public double distance(){
        double[] coords = userCoord();
        double long1=coords[0];                         //Variables used in Vincenty Formula
        double lat1=coords[2];
        double long2=coords[1];
        double lat2=coords[3];
        double a = 6378137;
        double f = 1/298.257;
        double b = (1-f)*a;
        double U1 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat1)));
        double U2 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat2)));
        double L = Math.toRadians(long2 - long1);
        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);
        double cosSqAlpha;
        double sinSigma;
        double sinAlpha;
        double cos2SigmaM;
        double cosSigma;
        double sigma;
        double lambda = L;
        double lambdaP;
        double C;
        double uSq;
        double A;
        double B;
        double deltaSigma;
        double s;
        double iterLimit = 100;


        //*****Using the Vincenty GPS formula based off the following sources:*****//
        //https://en.wikipedia.org/wiki/Vincenty%27s_formulae
        //http://www.kosherjava.com/zmanim/docs/api/src-html/net/sourceforge/zmanim/util/GeoLocationUtils.html
        //https://github.com/janantala/GPS-distance/blob/master/java/Distance.java
        do
        {
            double sinLambda = Math.sin(lambda);
            double cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt((cosU2 * sinLambda)*(cosU2 * sinLambda)+(cosU1 * sinU2 - sinU1 * cosU2 * cosLambda)*(cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;

            C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
            lambdaP = lambda;
            lambda = L + (1 - C) * f * sinAlpha*(sigma + C * sinSigma*(cos2SigmaM + C * cosSigma*(-1 + 2 * cos2SigmaM * cos2SigmaM)));

        } while (Math.abs(lambda - lambdaP) > (Math.pow(10,-12)) && --iterLimit > 0);

        uSq = cosSqAlpha * (a * a - b * b) / (b * b);
        A = 1 + uSq / 16384*(4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        deltaSigma =B * sinSigma*(cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) - B / 6 * cos2SigmaM* (-3 + 4 * sinSigma * sinSigma)* (-3 + 4 * cos2SigmaM * cos2SigmaM)));
        s = b * A * (sigma - deltaSigma);

        return s * 0.00062137;              //Convert to miles
    }

    /**
     * Function that writes the boneList array list to the original file
     */
    public void saveFile() throws IOException {                 //Saves file to text.csv
        FileWriter outFile = new FileWriter("./src/Datastore/text.csv", false);
        BufferedWriter outStream = new BufferedWriter(outFile);
        for (int k = 0; k < boneList.size(); k++)
            try {
                String line = boneList.get(k).toString();


                outStream.write(line);

            } catch (IOException e) {
                System.out.println("Skipped");
                e.printStackTrace();
            }
        outStream.close();
        System.out.println("Data saved.\n");
    }

    public void saveUsers() throws IOException{
        FileWriter outFile = new FileWriter("./src/Datastore/seller.csv", false);
        BufferedWriter outStream = new BufferedWriter(outFile);
        for (int k = 0; k < userList.size(); k++)
            try {
                String line = userList.get(k).toString();


                outStream.write(line);

            } catch (IOException e) {
                System.out.println("Skipped");
                e.printStackTrace();
            }
        outStream.close();
        System.out.println("Users saved.\n");
    }

    /**
     * Static main function, goes to the menu function
     */
    public static void main(String[] args) {
        Seller Daniel = new Seller();
        Daniel.menu();
    }
}

