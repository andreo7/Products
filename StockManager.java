import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        for(int i = 0; i<stock.size(); i++){
            if(stock.get(i).getID() == item.getID()){
               System.out.println("El prducto con este ID ya existe"); 
            }
        }
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        boolean existe = false;
        int i = 0;
        while(i<stock.size() && !existe){
            if(id == stock.get(i).getID()){
                existe = true;
                stock.get(i).increaseQuantity(amount);
            }
            i++;
        }
    }
        
    
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        boolean existe = false;
        int i = 0;
        while(i<stock.size() && !existe){ 
            if(id == stock.get(i).getID()){
                existe = true;
                return stock.get(i);
            }
            i++;
        } 
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        boolean existe = false;
        int i = 0;
        while(i<stock.size() && !existe){
            if(id == stock.get(i).getID()){
                existe = true;
                return stock.get(i).getQuantity();
            }
            i++;
        }
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product: stock){
            System.out.println(product);
        }
    }
    
    public void printProducts(int amount){
       for(Product product: stock){
            if(product.getQuantity() < amount)
                System.out.println(product);
        } 
    }
    
    public Product findProduct(String name){
        boolean existe = false;
        int i = 0;
        while(i<stock.size() && !existe){
            if(stock.get(i).getName().equals(name)){
                existe = true;
                return stock.get(i);
            }
            i++;
        }
        return null;
    }
}
