package BurgerBase;

import java.util.ArrayList;

public class Burger {

    private String bun;

    private String meat;

    private String cheese;

    private int numberOfAdditions = 0;

    private int price;

    private ArrayList<Additions> toppings = new ArrayList<Additions>();

    public void removeTopping(Additions topping) {
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).getName() == topping.getName()) {
                Additions thisTopping = toppings.get(i);
                System.out.println("Topping " + thisTopping.getName() + " is removed");
                this.price -= thisTopping.getPrice();
                this.numberOfAdditions -= 1;
                toppings.remove(i);
                break;
            }
        }
    }

    public void addTopping(Additions topping) {
        boolean doIAddThisTopping = true;

        if (this.getNumberOfAdditions() == 4){
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

    public Burger(String bun, String meat, String cheese) {
        this.bun = bun;
        this.meat = meat;
        this.cheese = cheese;
        this.setPrice(6);
    }

    public void allTheDetailsOfTheBurger(){

        System.out.println("The Bun is " + this.getBun() + ", meat is " + this.getMeat() + ", and the cheese is " + this.getCheese() + "." );
        System.out.println("The toppings on the burger are: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(toppings.get(i).getName());
        }
        System.out.println("And the total price is "+ this.getPrice() + "!");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price += price ;
    }

    public String getBun() {
        return bun;
    }

    public String getMeat() {
        return meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setNumberOfAdditions(int numberOfAdditions) {
        this.numberOfAdditions = numberOfAdditions;
    }

    public int getNumberOfAdditions() {
        return numberOfAdditions;
    }

    public ArrayList<Additions> getToppings() {
        return toppings;
    }

    public static void main(String[] args) {
        Burger classicBurger = new Burger("White", "Angus", "Cheddar");

        Additions Tomatoes = new Additions(1, "Tomatoes");

        Additions Pickles = new Additions(1, "Pickles");

        Additions Onions = new Additions(1, "Onions");

        Additions Lettuce = new Additions(1, "Lettuce");

        Additions Mayonnaise = new Additions(0, "Mayonnaise");

        Additions Mushrooms = new Additions(1, "Mushrooms");

        classicBurger.addTopping(Tomatoes);

        classicBurger.addTopping(Onions);

        classicBurger.addTopping(Mayonnaise);

        classicBurger.addTopping(Lettuce);

        classicBurger.addTopping(Pickles);

        classicBurger.removeTopping(Onions);

        classicBurger.allTheDetailsOfTheBurger();

    }


    //    public void setTomatoes() {
//       if(!this.tomatoes) {
//           this.setPrice(1);
//           this.tomatoes = true;
//           this.numberOfAdditions += 1;
//
//       } else {
//           this.setPrice(-1);
//           this.tomatoes = false;
//           this.numberOfAdditions -= 1;
//       }
//    }

}
