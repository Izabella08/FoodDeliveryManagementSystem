package dataLayer;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.Order;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DeliverySerializator implements Serializable {

    public void serializationFunction(HashMap<Order,Collection<BaseProduct>> orders){
        File file;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            file = new File("delivery.ser");
            fileOutputStream = new FileOutputStream("delivery.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(orders);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Order, Collection<BaseProduct>> deserializationFunction(){
        HashMap<Order,Collection<BaseProduct>> orderCollectionHashMap= new HashMap<>();
        File file = new File("delivery.ser");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if(file.exists()){
            try {
                fileInputStream = new FileInputStream("delivery.ser");
                objectInputStream = new ObjectInputStream(fileInputStream);
                orderCollectionHashMap = (HashMap<Order,Collection<BaseProduct>>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return orderCollectionHashMap;
    }


}