
public class Warehouse {
    private String name;
    private String fruit;
    private int maxCapacity;

    public Warehouse(String name, String fruit, int maxCapacity) {
        this.name = name;
        this.fruit = fruit;
        this.maxCapacity = maxCapacity;
    }
    /*
       public void addFruit(String fruitType) {
        if (fruit.size() < maxCapacity) {
            fruit.add(fruitType);
            System.out.println("Added " + fruitType + " to " + name);
        } else {
            System.out.println(name + " is full. Cannot add more " + fruitType);
        }
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    
}
