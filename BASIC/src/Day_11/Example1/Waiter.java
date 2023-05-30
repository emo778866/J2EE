package Day_11.Example1;

// DIRECTOR
public class Waiter {

    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder _pizzaBuilder) {
        pizzaBuilder = _pizzaBuilder;
    }

    public void constructPizza() {

        pizzaBuilder.createNewPizzaProduct();

        pizzaBuilder.buildDough();

        pizzaBuilder.buildSauce();

        pizzaBuilder.buildTopping();

    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

}
