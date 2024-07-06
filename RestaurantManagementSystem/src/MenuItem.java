public class MenuItem {
    private int id;
    private String name;
    private double price;
    private boolean isVeg;
    private String category;

    // Constructor, getters, setters

    public MenuItem(String name, double price, boolean isVeg, String category) {
        this.name = name;
        this.price = price;
        this.isVeg = isVeg;
        this.category = category;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public boolean IsVeg(){
        return this.isVeg;
    }
    public void setVeg(boolean veg){
        this.isVeg = veg;
    }
    public String getCategory(){
        return this.category;
    }
    public void setCategory(String category){
        this.category = category;
    }
}