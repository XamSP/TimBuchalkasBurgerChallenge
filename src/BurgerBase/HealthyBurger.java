package BurgerBase;

public class HealthyBurger extends Burger {

    private int additionsLimit = 6;

    public HealthyBurger(String meat, String cheese) {
        super("Brown Rye Roll", meat, cheese);
    }

    public void addTopping(Additions topping) {
        boolean doIAddThisTopping = true;

        if (this.getNumberOfAdditions() == 6){
            System.out.println("Toppings MAX'd out! " + topping.getName() + " couldn't be added.");
            //System.exit(1);
            doIAddThisTopping = false;
        }

        for (int i = 0; i < this.getToppings().size(); i++) {
            if (this.getToppings().get(i).getName() == topping.getName()) {
                Additions thisTopping = this.getToppings().get(i);
                System.out.println(thisTopping.getName() + " is already added");
                doIAddThisTopping = false;
                break;
            }
        }
        if(doIAddThisTopping) {
            this.setNumberOfAdditions(this.getNumberOfAdditions() + 1);
            this.getToppings().add(topping);
            this.setPrice(topping.getPrice());
            System.out.println(topping.getName() + " was added!");
        }
    }

    public static void main(String[] args) {

        HealthyBurger naturalBurger = new HealthyBurger("Angus", "Cheddar");

        Additions Tomatoes = new Additions(1, "Tomatoes");

        Additions Pickles = new Additions(1, "Pickles");

        Additions Onions = new Additions(1, "Onions");

        Additions Lettuce = new Additions(1, "Lettuce");

        Additions Mayonnaise = new Additions(0, "Mayonnaise");

        Additions Mushrooms = new Additions(1, "Mushrooms");

        naturalBurger.addTopping(Tomatoes);

        naturalBurger.addTopping(Onions);

        naturalBurger.addTopping(Mayonnaise);

        naturalBurger.addTopping(Lettuce);

        naturalBurger.addTopping(Pickles);

        naturalBurger.removeTopping(Onions);

        naturalBurger.allTheDetailsOfTheBurger();

    }

}
