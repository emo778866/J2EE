package Day_11.Example1;

// abstract BUILDER A.K.A BUILDER
abstract class PizzaBuilder {

    protected Pizza pizza;

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();

    public abstract void buildSauce();

    public abstract void buildTopping();

    public Pizza getPizza() {
        return pizza;
    }

}
