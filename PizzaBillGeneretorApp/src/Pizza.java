public class Pizza {
    private int price;
    private boolean veg;

    private int vegBasePrice = 300;
    private int nonvegBasePrice = 400;
    private int extraCheesePrice = 100;
    private int extraToppingsPrice = 150;
    private int takeAwayBagPrice = 20;


    public Pizza(boolean veg) {
        this.veg = veg;
        if(this.veg)
            this.price = this.vegBasePrice;
        else
            this.price = this.nonvegBasePrice;
    }

    public void addExtraCheese(){
        this.price += extraCheesePrice;
        System.out.println("Extra cheese added, total price: "+ this.price);
    }

    public void addExtraToppings(){
        this.price += extraToppingsPrice;
        System.out.println("Extra toppings added, total price: "+this.price);
    }

    public void takeAway(){
        this.price += takeAwayBagPrice;
        System.out.println("Take away bag added, total price: "+this.price);
    }

    public void getBill(){
        System.out.println("Total bill: "+this.price);
    }
}
