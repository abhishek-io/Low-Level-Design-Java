//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza(true);
        pizza.addExtraCheese();
        pizza.takeAway();
        pizza.getBill();

        DeluxPizza deluxPizza = new DeluxPizza(true);
        deluxPizza.getBill();
    }
}