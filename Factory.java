

public class Factory {
    private String name;
    private char size;
    private Warehouse[] warehouses;
    private int warehouseCount;

    public Factory(String name, char size) {
        this.name = name;
        this.size = Character.toUpperCase(size);
        this.warehouses = new Warehouse[getSizeMultiplier(size)];
        this.warehouseCount = 0;
    }

    /*
    public boolean addWarehouse(String name, String fruit, int maxCapacity) {
    if (warehouseCount < getSizeMultiplier()) {
    if (!warehouseNameExists(name)) {
    if (warehouses[warehouseCount] == null) {
    warehouses[warehouseCount] = new Warehouse(name, maxCapacity);
    }
    warehouses[warehouseCount].addFruit(fruit); // Assuming you have an addFruit method in the Warehouse class
    warehouseCount++;
    return true;
    } else {
    System.out.println("Warehouse name already exists in this factory.");
    }
    } else {
    System.out.println("Maximum number of warehouses reached for this factory.");
    }
    return false;

    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize(char size) {
        return getSizeMultiplier(size);
    }
    public char getSizechar() {
        return size;
    }
    public void setSize(char size) {
        this.size = Character.toUpperCase(size);
    }

    public Warehouse[] getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Warehouse[] warehouses) {
        this.warehouses = warehouses;
    }

    public int getWarehouseCount() {
        return warehouseCount;
    }

    public void setWarehouseCount(int warehouseCount) {
        this.warehouseCount = warehouseCount;
    }

    public boolean createWarehouse(String name, String fruit, int maxCapacity, char size) {
        if (warehouseCount < getSizeMultiplier(size)) {
            if (!warehouseNameExists(name)) {
                Warehouse warehouse = new Warehouse(name, fruit, maxCapacity);
                warehouses[warehouseCount] = warehouse;
                warehouseCount++;
                //System.out.println("executed here inside loop"+warehouseCount);
                //return true;
            } else {
                System.out.println("Warehouse name already exists in this factory.");
            }
        } else {
            System.out.println("Maximum number of warehouses reached for this factory.");
        }
        return false;
    }

    private int getSizeMultiplier(char size) {
        switch (size) {
            case 'S':
                return 1;
            case 'M':
                return 2;
            case 'L':
                return 3;
            default:
                return 0;
        }
    }

    private boolean warehouseNameExists(String name) {
        for (int i = 0; i < warehouseCount; i++) {
            if (warehouses[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public String getAllWarehouse () {
        String warehouseList = "";
        for (int i = 0; i < warehouseCount; i++) {
            if (!warehouses[i].getName().equals("")) {
                System.out.println("Warehouse " + warehouses[i].getName() +
                " has fruit " + warehouses[i].getFruit() +
                " and max capacity " + warehouses[i].getMaxCapacity() + " tonnes"+"\n");
            }
        }
        return warehouseList;
    }

    public String getFruitWarehouse (String fruit)
    {
        String fruitlist = "";
        for (int i=0; i<warehouseCount; i++) //creates a list of warehouses with specific fruit
        {
            if(warehouses[i].getFruit().equalsIgnoreCase(fruit))
                fruitlist += warehouses[i].getName()+", Factory: "+getName()+"\n";
        }
        return fruitlist;
    }

    public int totalApple() {
        String fruit = "";
        int capacityToUse = 0;
        for (int i = 0; i < warehouseCount; i++) {
            if (warehouses[i].getFruit().equals("apple"))
            {
                capacityToUse = warehouses[i].getMaxCapacity();
            }
        }
        return capacityToUse;
    }

    public int totalOrange() {
        String fruit = "";
        int capacityToUse = 0;
        for (int i = 0; i < warehouseCount; i++) {
            if (warehouses[i].getFruit().equals("orange"))
            {
                capacityToUse = warehouses[i].getMaxCapacity();
            }
        }
        return capacityToUse;
    }

    public int totalPear() {
        String fruit = "";
        int capacityToUse = 0;
        for (int i = 0; i < warehouseCount; i++) {
            if (warehouses[i].getFruit().equals("pear"))
            {
                capacityToUse = warehouses[i].getMaxCapacity();
            }
        }
        return capacityToUse;
    }
}
