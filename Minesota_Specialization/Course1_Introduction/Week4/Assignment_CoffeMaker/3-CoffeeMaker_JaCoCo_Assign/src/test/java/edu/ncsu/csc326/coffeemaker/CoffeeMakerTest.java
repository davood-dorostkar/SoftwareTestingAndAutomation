package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Inventory inventory;

    private Recipe recipe0;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;

    @Before
    public void setUp() throws Exception {
        coffeeMaker = new CoffeeMaker();
        inventory = new Inventory();


        recipe0 = new Recipe();
        recipe0.setName("Coffee");
        recipe0.setAmtChocolate("0");
        recipe0.setAmtCoffee("3");
        recipe0.setAmtMilk("1");
        recipe0.setAmtSugar("1");
        recipe0.setPrice("50");

        recipe1 = new Recipe();
        recipe1.setName("Mocha");
        recipe1.setAmtChocolate("20");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("75");

        recipe2 = new Recipe();
        recipe2.setName("Latte");
        recipe2.setAmtChocolate("0");
        recipe2.setAmtCoffee("3");
        recipe2.setAmtMilk("3");
        recipe2.setAmtSugar("1");
        recipe2.setPrice("100");

        recipe3 = new Recipe();
        recipe3.setName("Lavazza");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtCoffee("3");
        recipe3.setAmtMilk("3");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("100");

        recipe4 = new Recipe();
        recipe4.setName("Chibo");
        recipe4.setAmtChocolate("0");
        recipe4.setAmtCoffee("3");
        recipe4.setAmtMilk("3");
        recipe4.setAmtSugar("1");
        recipe4.setPrice("100");




    }

    @Test
    public void testAddRecipe() throws RecipeException {
        recipe3 = new Recipe();
        recipe3.setName("Hot Chocolate");
        recipe3.setAmtChocolate("4");
        recipe3.setAmtCoffee("0");
        recipe3.setAmtMilk("1");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("65");

        coffeeMaker.addRecipe(recipe3);
    }

    @Test
    public void testDeleteRecipe1() {
        coffeeMaker.addRecipe(recipe0);
        coffeeMaker.deleteRecipe(0);
        Assert.assertNotSame(recipe0, coffeeMaker.getRecipes()[0]);
        Assert.assertNull(coffeeMaker.getRecipes()[0]);
    }

    @Test
    public void testDeleteRecipeThatIsNull(){
        Assert.assertNull(coffeeMaker.deleteRecipe(4));
    }

    @Test
    public void testEditRecipe() throws RecipeException {
        coffeeMaker.addRecipe((recipe0));
        coffeeMaker.editRecipe(0, recipe1);
        Assert.assertSame(recipe1, coffeeMaker.getRecipes()[0]);


    }

    //--------------------------------------------------
    //testInventoryStart
    //--------------------------------------------------

    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("5", "8", "0", "8");
    }

    //Если пользователь вводит буквенный символ, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException11() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "asdf", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException12() throws InventoryException {
        coffeeMaker.addInventory("asdf", "5", "4", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException13() throws InventoryException {
        coffeeMaker.addInventory("4", "asdf", "4", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException14() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "4", "asdf");
    }

    //Если пользователь выбирает отрицательное или не целое число, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException21() throws InventoryException {
        coffeeMaker.addInventory("4", "-5", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException22() throws InventoryException {
        coffeeMaker.addInventory("-4", "5", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException23() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "-3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException24() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "3", "-3");
    }

    //Если пользователь выбирает отрицательное или не целое число, пользователю будет предложено ввести сумму повторно.
    @Test(expected = InventoryException.class)
    public void testAddInventoryException31() throws InventoryException {
        coffeeMaker.addInventory("4", "5.4", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException32() throws InventoryException {
        coffeeMaker.addInventory("4.0", "5.4", "3", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException33() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "3.6", "3");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException34() throws InventoryException {
        coffeeMaker.addInventory("4", "5", "3", "3.7");
    }
    //--------------------------------------------------
    //testInventoryEnd
    //--------------------------------------------------

    // пользователю будет показан список ингредиентов в кофеварке.
    @Test
    public void testCheckInventory() {
        inventory.setMilk(10);
        inventory.setChocolate(10);
        inventory.setCoffee(10);
        inventory.setSugar(10);
        Assert.assertEquals("Coffee: 10\n" +
                                    "Milk: 10\n" +
                                    "Sugar: 10\n" +
                                    "Chocolate: 10\n" , coffeeMaker.checkInventory());
    }

    //Когда мы делаем кофе, выбираем действующий рецепт и платим больше, чем стоимость кофе. Сдача 25.
    @Test
    public void testMakeCoffee() {
        coffeeMaker.addRecipe(recipe0);
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));

    }

    //Кофеварка проверит, достаточно ли ингредиентов в инвентаре для приготовления выбранного напитка.
    //Если запасов недостаточно для приготовления напитка, отобразится сообщение, деньги пользователя будут возвращены
    @Test
    public void testMakeCoffee1() {
        inventory.setMilk(1);
        inventory.setChocolate(1);
        inventory.setCoffee(1);
        inventory.setSugar(1);

        coffeeMaker.addRecipe(recipe0);
        assertEquals(50, coffeeMaker.makeCoffee(0, 50));

    }

    @Test
    public void testGetRecipes() {
        coffeeMaker.addRecipe(recipe1);
        Recipe[] recipes = new Recipe[3];
        recipes[0] = recipe1;
        Assert.assertArrayEquals(recipes ,coffeeMaker.getRecipes());
    }
}