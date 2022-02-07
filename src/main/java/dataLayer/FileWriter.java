package dataLayer;

import businessLayer.MenuItem;
import businessLayer.Order;

import java.io.File;
import java.io.IOException;

public class FileWriter {
    public void generateBill(Order order){
        String string;
        string = "";
        int total = 0;
        try{
            File myFile = new File("bill.txt");
            java.io.FileWriter myWriter = new java.io.FileWriter("bill.txt");
            myWriter.write("Bill:\n");
            myWriter.write("Id client: " + order.getClientId() + "\n");
            for (MenuItem menuItem : order.getMenuItems()) {
                string = string + menuItem.getTitle() + " " + menuItem.getPrice() + "\n";
                total = total + menuItem.getPrice();
            }
            myWriter.write(string + "Total :" + total);
            myWriter.close();
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
            else {
                System.out.println("Bill created succesfully!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing the bill!");
            e.printStackTrace();
        }
    }
}
