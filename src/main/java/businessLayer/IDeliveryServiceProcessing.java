package businessLayer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface IDeliveryServiceProcessing {

    //ADMIN OPTIONS
    //import products

    /**
     * add new product
     * @param menuItem
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    public void createNewProduct(MenuItem menuItem);

    /**
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     * @param menuItem
     * @param newMenuItem
     */
    public void editProduct(MenuItem menuItem, MenuItem newMenuItem);


    /**
     * generate report 1
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    public void generateReport1(LocalDateTime startHour, LocalDateTime endHour);


    /**
     * generate report 2
     *@pre size-ul Arraylistului de [produse mai mare ca 0
     *@post size-ul Arraylistului de [produse mai mare ca 0
     *@invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    public void generateReport2(Integer nrOrders);


    /**
     * generate report 3
     * @throws IOException
     *@pre size-ul Arraylistului de [produse mai mare ca 0
     *@post size-ul Arraylistului de [produse mai mare ca 0
     *@invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    public void generateReport3(Integer nrOrders,Integer sum);


    /**
     * generate report 4
     * @throws IOException
     *@pre size-ul Arraylistului de [produse mai mare ca 0
     *@post size-ul Arraylistului de [produse mai mare ca 0
     *@invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    public void generateReport4(LocalDateTime date) ;


    //CLIENT OPTIONS
    /**
     * create an order
     * @param order
     * @param productsList
     */
    public void createOrder(Order order, List<BaseProduct> productsList);


}
