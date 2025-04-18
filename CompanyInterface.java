import java.util.*;
import java.io.*;
public class CompanyInterface
{
    private int factoryCount = 0; //number of factory used
    private int factoryCountExternal=0; //number of factory from file
    private Factory[] factory;
    private final int factoryMax = 5; //max number of facories
    public int i=0;
    private void run()
    {
        Scanner scanner = new Scanner(System.in);
        factory = new Factory[factoryMax]; // creates array
        for (int i = 0; i < factoryMax; i++) 
        {
            factory[i] = new Factory("DefaultFactory" + i, 'M');
        }
        while(true){
            menu();
        }
    }

    
    public static void main(String[] args) 
    {       
        CompanyInterface ci = new CompanyInterface();
        ci.run();
    }

    private void menu()
    {
        Scanner scanner = new Scanner(System.in);
        // displays menu with options for the user to choose from
        System.out.println("Menu");
        System.out.println(" 1. Create Factory");
        System.out.println(" 2. Delete Factory");
        System.out.println(" 3. List factory size and Warehouse fruits");
        System.out.println(" 4. List Warehouse and Capacity");
        System.out.println(" 5. List Warehouses by Fruit Type");
        System.out.println(" 6. See juice production");
        System.out.println(" 7. Load from File");
        System.out.println(" 8. Output to File");
        System.out.println(" 9. Exit");
        System.out.println("Enter Selection: ");
        int menuSelection = scanner.nextInt(); // select from menu
        // switch statement executes case based on user selection
        switch(menuSelection)
        {
            case 1 : createFactory(); menu(); break;
            case 2 : deleteFactory(); menu(); break;
            case 3 : listFactoryandWarehouse(); menu(); break; 
            case 4 : listWarehousesInFactory(); menu(); break;
            case 5 : listWarehousesWithFruitType(); menu(); break; //UPDATED CODE
            case 6 : analyzeJuiceProduction(); menu(); break; //updated for loop at start and in breakdown section
            case 7 : loadFromFile(); menu(); break;
            case 8 : saveToFile(); menu(); break;
            case 9 : System.out.println("Exiting program..."); System.exit(0); break; //exit
            default : System.out.println("Invalid Input, try again"); menu(); 
        }
    }
    
    /*public Factory createFactory2(String name, String size, int capacity){
        //factory[factoryCountExternal];
        return Factory;
    }*/
    public void createFactory()
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Factory Management Program");
            System.out.println("1. Create a New Factory");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            //Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            // Consume the newline character

            switch (choice) {
                case 1:
                    if (factoryCount < factoryMax) {
                        //Scanner scanner= new Scanner(System.in);
                        System.out.println("Creating a new factory...");
                        // Prompts user for factory details
                        System.out.print("Enter the factory name: ");
                        scanner.nextLine(); // Consume newline left over
                        String factoryName = scanner.nextLine();
                        char factorySize = 'A';
                        boolean validSize = false;

                        // Uses a loop to repeatedly prompt for the size until a valid option is chosen
                        do {
                            System.out.print("Enter the factory size (S, M, or L): ");
                            String sizeInput = scanner.nextLine();
                            if (sizeInput.equalsIgnoreCase("S")) {
                                factorySize = 'S';
                                validSize = true;
                            } else if (sizeInput.equalsIgnoreCase("M")) {
                                factorySize = 'M';
                                validSize = true;
                            } else if (sizeInput.equalsIgnoreCase("L")) {
                                factorySize = 'L';
                                validSize = true;
                            } else {
                                System.out.println("Invalid size option. Please enter 'S', 'M', or 'L' (case-insensitive).");
                            }
                        } while (!validSize);

                        // Checks if a factory with the same name and size already exists
                        boolean factoryExists = false;
                        for (int i = 0; i < factoryCount; i++) {
                            if (factory[i].getName().equalsIgnoreCase(factoryName) 
                            /*&&
                              factory[i].getSize() == factorySize*/) {
                                factoryExists = true;
                                break;
                            }
                        }

                        if (factoryExists) {
                            System.out.println("Error: Factory with the same name and size already exists.");
                        } 
                        else {
                            // Creates a new factory and add it to the array
                            factory[factoryCount] = new Factory(factoryName, factorySize);

                            // Prompt user for warehouse details
                            for (int i = 1; i <= factory[factoryCount].getSize(factorySize); i++) {
                                System.out.println("Enter details for Warehouse " + i);
                                System.out.print("Name: ");
                                String warehouseName = scanner.nextLine();

                                String fruitType;
                                boolean validFruit = false;

                                // Uses a loop to repeatedly prompt for the fruit type until a valid option is chosen
                                do {
                                    System.out.print("Fruit type (Apple, Orange, or Pear): ");
                                    fruitType = scanner.nextLine();
                                    if (fruitType.equalsIgnoreCase("Apple") || fruitType.equalsIgnoreCase("Orange") || fruitType.equalsIgnoreCase("Pear")) {
                                        validFruit = true;
                                    } else {
                                        System.out.println("Invalid fruit type. Please enter 'Apple', 'Orange', or 'Pear' (case-insensitive).");
                                    }
                                } while (!validFruit);

                                int maxCapacity;
                                boolean validCapacity = false;

                                // Uses a loop to repeatedly ask for the capacity until a positive integer is provided
                                do {
                                    System.out.print("Maximum capacity (positive integer): ");
                                    maxCapacity = scanner.nextInt();
                                    scanner.nextLine(); // Consume the newline character
                                    if (maxCapacity > 0) {
                                        validCapacity = true;
                                    } else {
                                        System.out.println("Invalid capacity. Please enter a positive integer.");
                                    }
                                } while (!validCapacity);
                                //System.out.println("works upto here 1");

                                // Check if the warehouse name is unique within the factory
                                boolean warehouseExists = false;
                                for (Warehouse warehouse : factory[factoryCount].getWarehouses()) {
                                    if (warehouse != null) {
                                        if (warehouse.getName().equalsIgnoreCase(warehouseName)) {
                                            warehouseExists = true;
                                            break;
                                        }
                                    }
                                }
                                  //System.out.println("works upto here 2");
                                if (warehouseExists) {
                                    System.out.println("Error: Warehouse with the same name already exists in this factory.");
                                    i--; // Asks for details again
                                } else {
                                    // Adds the warehouse to the factory
                                    factory[factoryCount].createWarehouse(warehouseName, fruitType, maxCapacity, factorySize);
                                }
                            }

                            factoryCount++;
                            System.out.println("Factory created successfully.");
                        }
                    } else {
                        System.out.println("Error: Maximum number of factory (5) reached.");
                    }
                    break;
                case 2:
                    System.out.println("Exiting the program.");
                    menu();
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    
    }

    public void deleteFactory()
    {
        System.out.print("Enter the name of the factory to delete: ");
        Scanner scanner = new Scanner(System.in);
        String factoryName = scanner.nextLine();
        int foundIndex = -1; // Initializes with an invalid index

        // Searchsf for the factory with the specified name
        for (int i = 0; i < factoryCount; i++) {
            if (factory[i] != null && factory[i].getName().equalsIgnoreCase(factoryName)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            // Factory found
            for (int i = foundIndex; i < factoryCount - 1; i++) {
                factory[i] = factory[i + 1];
            }

            // Clears the last factory since it's been moved
            factory[factoryCount - 1] = null;

            factoryCount--; // Decrement the factory count
            System.out.println("Factory '" + factoryName + "' has been deleted.");
        } else {
            System.out.println("Factory '" + factoryName + "' not found.");
        }
    }

    public void listFactoryandWarehouse()
    {
		//import Warehouse;
        if (factoryCount == 0) {
            System.out.println("No factory to list.");
        } else {
            for (int i = 0; i < factoryCount; i++) {
                Factory targetfactory = factory[i];
                System.out.println("Factory " + targetfactory.getName() + " has size " + targetfactory.getSizechar());

                Warehouse[] warehouses = targetfactory.getWarehouses();
                for (Warehouse warehouse : warehouses) {
                    System.out.println("Warehouse " + warehouse.getName() + " has fruit " + warehouse.getFruit());
                }
            }
        }
    }
    public void listWarehousesInFactory()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the factory whose warehouse to list: ");
        String factoryName = scanner.nextLine();
        int factoryNum = findFactoryByName(factoryName);

        if (factoryNum == 100) {
            System.out.println("Factory '" + factoryName + "' not found.");
        } else {
            String warehouses = factory[factoryNum].getAllWarehouse();

            if (warehouses.equals("")) {
                System.out.println("No warehouses in the factory.");
            } else {
                System.out.println(warehouses);
            }
        }

    }

    public int findFactoryByName(String factoryName) {
        int factoryNum = 0;
        for (int i = 0; i < factoryCount; i++) {
            if (factory[i].getName().equalsIgnoreCase(factoryName)) {
                factoryNum = i;
                return factoryNum;
            }
        }
        return 100; // Factory not found
    }

    public void listWarehousesWithFruitType() 
    {
        Scanner scanner = new Scanner(System.in);
        if (factoryCount != 0) {
            System.out.print("Enter the name of the fruit: ");
            String fruitType = scanner.nextLine().toLowerCase();
            while (!fruitType.equals("pear") && !fruitType.equals("apple") && !fruitType.equals("orange")) //checks if input is valid
            {
                System.out.println("Invalid Input.");
                System.out.print("Enter the name of the fruit: ");
                fruitType = scanner.nextLine().toLowerCase();
            }
            String fruitList = "";
            for (int i = 0; i < factoryCount; i++) { // builds list of warehouses with specific fruit
                fruitList += factory[i].getFruitWarehouse(fruitType);
            }

            if (fruitList.equals("")) {
                System.out.println("No warehouses with that fruit.");
            }
            else {
                System.out.println("Warehouses storing "+fruitType+":");
                System.out.println(fruitList);
            }
        }
        else 
            System.out.println("There are no factories to check from");
    }

    public void analyzeJuiceProduction() {
        int totalApple = 0;
        int totalOrange = 0;
        int totalPear = 0;

        System.out.println("Juice Production Analysis:");
        System.out.println("Total juice production:");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < factoryCount; i++) {
            totalApple += factory[i].totalApple();
            totalOrange += factory[i].totalOrange();
            totalPear += factory[i].totalPear();
        }

        // Calculates and display juice production
        int appleJuice = totalApple / 3;
        int orangeJuice = totalOrange / 3;
        int pearJuice = totalPear / 3;
        int leftoverApple = totalApple % 3;
        int leftoverOrange = totalOrange % 3;
        int leftoverPear = totalPear % 3;

        if (appleJuice > 0) {
            System.out.println(appleJuice + " tonnes of Apple, Orange and Pear juice");
        }
        if (orangeJuice > 0) {
            System.out.println(orangeJuice + " tonnes of Apple, Orange and Pear juice");
        }
        if (pearJuice > 0) {
            System.out.println(pearJuice + " tonnes of Apple, Orange and Pear juice");
        }
        if (leftoverApple > 0 || leftoverOrange > 0 || leftoverPear > 0) {
            System.out.println("Remaining simple juices:");
            if (leftoverApple > 0) {
                System.out.println(leftoverApple + " tonnes of Apple juice");
            }
            if (leftoverOrange > 0) {
                System.out.println(leftoverOrange + " tonnes of Orange juice");
            }
            if (leftoverPear > 0) {
                System.out.println(leftoverPear + " tonnes of Pear juice");
            }
        }

        System.out.println("---------------------------------------------------------");

        System.out.println("Breakdown by factory:");
        System.out.println("---------------------------------------------------------");
        
        int factoryApple = 0;
        int factoryOrange = 0;
        int factoryPear = 0;
        for (int i = 0; i < factoryCount; i++) {
            factoryApple += factory[i].totalApple();
            factoryOrange += factory[i].totalOrange();
            factoryPear += factory[i].totalPear();

            int factoryAppleJuice = factoryApple / 3;
            int factoryOrangeJuice = factoryOrange / 3;
            int factoryPearJuice = factoryPear / 3;
            int factoryLeftoverApple = factoryApple % 3;
            int factoryLeftoverOrange = factoryOrange % 3;
            int factoryLeftoverPear = factoryPear % 3;
            
            System.out.println("Factory " + factory[i].getName() + ":");
            if (factoryAppleJuice > 0) {
                System.out.println(factoryAppleJuice + " tonnes of Apple, Orange and Pear juice");
            }
            if (factoryOrangeJuice > 0) {
                System.out.println(factoryOrangeJuice + " tonnes of Apple, Orange and Pear juice");
            }
            if (factoryPearJuice > 0) {
                System.out.println(factoryPearJuice + " tonnes of Apple, Orange and Pear juice");
            }
            if (factoryLeftoverApple > 0 || factoryLeftoverOrange > 0 || factoryLeftoverPear > 0) {
                System.out.println("Remaining simple juices:");
                if (factoryLeftoverApple > 0) {
                    System.out.println(factoryLeftoverApple + " tonnes of Apple juice");
                }
                if (factoryLeftoverOrange > 0) {
                    System.out.println(factoryLeftoverOrange + " tonnes of Orange juice");
                }
                if (factoryLeftoverPear > 0) {
                    System.out.println(factoryLeftoverPear + " tonnes of Pear juice");
                }
            }
        }
    }


    public void loadFromFile() 
    {
        System.out.println("Inside LoadFromFile");
        String fileName = "ReginaCollection.txt"; // name of input file
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("Factory")) {
                    String name = scanner.nextLine().replace("Name ", "");
                    String size = scanner.nextLine().replace("Size ", "");
                    int maxCapacity;
                    //Factory factory = createFactory2(name, size, maxCapacity);
                    System.out.println("The size is: " + size);
                    String nextLine = scanner.nextLine();
                    while (!nextLine.equals("Warehouses")) {
                        nextLine = scanner.nextLine();
                    }

                    while (scanner.hasNextLine()) {
                        nextLine = scanner.nextLine();
                        if (nextLine.equals("Factory")) {
                            break;
                        }
                        if (nextLine.equals("Name")) {
                            String whName = scanner.nextLine().replace("Name ", "");
                            String fruit = scanner.nextLine().replace("Fruit ", "");
                            maxCapacity = Integer.parseInt(scanner.nextLine().replace("MaxCapacity ", ""));
                            //factory.createWarehouse(whName, fruit, maxCapacity,size);
                        }
                    }
                    
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    public void saveToFile() 
    {
        System.out.print("Enter the name of the output file: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int i = 0; i < factoryCount; i++) {
                // Factory factory = factory[i];
                writer.println("Factory");
                writer.println("Name " + factory[i].getName());
                writer.println("Size " + factory[i].getSizechar());

                writer.println("Warehouses");
                Warehouse[] warehouses = factory[i].getWarehouses();
                for (Warehouse warehouse : warehouses) {
                    writer.println("Name " + warehouse.getName());
                    writer.println("Fruit " + warehouse.getFruit());
                    writer.println("MaxCapacity " + warehouse.getMaxCapacity());
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file.");
        }
    }

}

