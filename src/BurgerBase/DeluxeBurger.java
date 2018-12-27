package BurgerBase;

public class DeluxeBurger extends Burger {

    public DeluxeBurger(String bun, String meat, String cheese) {
        super(bun, meat, cheese);

        super.addTopping(new Additions(2, "Chips"));
        super.addTopping(new Additions(2, "Drink"));
    }

    @Override
    public void addTopping(Additions topping) {
        //nothin
        System.out.println("Can't add topping!");
    }

    @Override
    public void removeTopping(Additions topping) {
        //nothin
        System.out.println("Can't remove topping!");
    }

    public static void main(String[] args) {
        DeluxeBurger xBurger = new DeluxeBurger("Sesame Bun", "Super Angus", "Provolone");

        Additions Pickles = new Additions(1, "Pickles");

        xBurger.addTopping(Pickles);

        xBurger.removeTopping(new Additions(2, "Chips"));

        xBurger.allTheDetailsOfTheBurger();
    }
}
