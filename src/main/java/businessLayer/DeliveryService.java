package businessLayer;

import dataLayer.DeliverySerializator;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    private static final long serialVersionUID = 1L;

    public HashSet<MenuItem> menuItemHashSet;
    public HashMap<Order, Collection<BaseProduct>> orderCollectionHashMap = new HashMap<Order, Collection<BaseProduct>>();
    public Map<Order, List<BaseProduct>> orderListHashMap = new HashMap<>();
    public List<Order> orderArrayList = new ArrayList<Order>();
    public DeliverySerializator deliverySerializator = new DeliverySerializator();

    @Override
    /**
     * metoda care adauga un nou produs de tip MenuItem la meniu
     */
    public void createNewProduct(MenuItem menuItem) {
        this.menuItemHashSet.add(menuItem);
    }

    @Override
    public void editProduct(MenuItem menuItem, MenuItem newMenuItem) {
        newMenuItem = menuItem;
    }

    /**
     * Metoda de invariant
     * @return
     */
    public boolean invariant()
    {
        if(this.orderCollectionHashMap.size()>0) {
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public void generateReport1(LocalDateTime startHour, LocalDateTime endHour) {
        assert this.menuItemHashSet.size()>0;
        int  h1= startHour.getHour();
        int h2= endHour.getHour();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("report1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write("Comenzi cuprinse intre ora "+ startHour.getHour()+" si ora"+ endHour.getHour()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderCollectionHashMap = deliverySerializator.deserializationFunction();
        List <Order> dateOrders= orderCollectionHashMap.keySet().stream().filter(e->e.getDate().getHour()>=h1 && e.getDate().getHour()<=h2).collect(Collectors.toList());
        List<BaseProduct> product = new ArrayList<BaseProduct>();
        for(Order o: dateOrders){
            product.addAll(orderCollectionHashMap.get(o));
        }
        for(BaseProduct p: product){
            try {
                fileWriter.write(p.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuItemHashSet.size()>0;
        assert invariant();
    }

    @Override
    public void generateReport2(Integer nrTimesOrdered) {
        assert this.menuItemHashSet.size()>0;
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter("report2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write("Produse ce au fost cumparate mai mult de"+ nrTimesOrdered +"ori:\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<MenuItem> menuItemList;
        menuItemList = menuItemHashSet.stream().filter(e->e.getNrOfAppInOrders()>= nrTimesOrdered).collect(Collectors.toList());
        FileWriter finalFw = fileWriter;
        menuItemList.stream().forEach(e->{
            try{
                finalFw.write("Produsul "+e.getTitle()+" a fost cumparat de "+ nrTimesOrdered +" ori\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuItemHashSet.size()>0;
        assert invariant();
    }

    @Override
    public void generateReport3(Integer nrOrders,Integer sum) {
        assert this.menuItemHashSet.size()>0;
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter("report3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Client> clients = new ArrayList<Client>();
        FileWriter fileWriter1 = fileWriter;
        clients.stream().distinct().forEach(e->{
            try{
                fileWriter1.write("Clientul "+ e.getId() + " are mai mult de "+nrOrders+"\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuItemHashSet.size()>0;
        assert invariant();
    }

    @Override
    public void generateReport4(LocalDateTime date) {
        assert this.menuItemHashSet.size()>0;
        FileWriter fw= null;
        try {
            fw = new FileWriter("report4.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write("Produse ce au fost cumparate in data de"+date+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter finalFw = fw;
        menuItemHashSet.stream().forEach(items->{
            orderCollectionHashMap.keySet().stream().forEach(orders->{
                orderCollectionHashMap.get(orders).stream().forEach(e->
                {
                    if(orders.getDate().getDayOfMonth()==date.getDayOfMonth())
                    {
                        try {
                            finalFw.write("Produsul:"+e.getTitle());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
            });
        });
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuItemHashSet.size()>0;
        assert invariant();
    }

    /**
     * Metoda care verifica daca avem o comanda goala(fara produse)
     * @return
     */
    public boolean noItems() {
        for(Order order : orderArrayList) {
            List<BaseProduct> itemsList;
            itemsList = this.orderListHashMap.get(order);
            if(itemsList.size() != 0) {
                return true;
            }
        }
        return false;
    }


    public DeliveryService(){
        orderCollectionHashMap = deliverySerializator.deserializationFunction();
    }

    @Override
    public void createOrder(Order order, List<BaseProduct> productsList) {
        assert order != null;
        if (noItems() == false) {
            String prod;
            prod = "";
            int i = 0;
            orderArrayList.add(order);
            orderCollectionHashMap.put(order, productsList);
            deliverySerializator.serializationFunction(orderCollectionHashMap);
            for (MenuItem item : productsList) {
                if (i != 0) {
                    prod = prod + "," + item.getTitle();
                } else {
                    prod = item.getTitle();
                    i++;
                }
            }
            setChanged();
        }
    }

    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(null, "Notification!");
    }

}
