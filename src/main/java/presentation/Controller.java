package presentation;

import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Controller {

    public static DeliveryService deliveryService;

    public JTable createOrdersTable(Map<Order, List<MenuItem>> ordersList) {
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        Vector<Object> header = new Vector<Object>();
        header.add("Order id");
        header.add("Date");
        header.add("Command");
        model.setColumnIdentifiers(header);
        for(Order o: deliveryService.orderArrayList) {
            int k=0;
            Vector<Object> dataTable = new Vector<Object>();
            dataTable.add((o.hashCode()));
            dataTable.add((o.getDate()));
            List <MenuItem> menu=ordersList.get(o);
            String s="";
            for(MenuItem m:menu) {
                if(k==0) {
                    s=m.getTitle();
                    k++;
                }else {
                    s=s+","+m.getTitle();
                    k++;
                }
            }
            dataTable.add(s);
            model.addRow(dataTable);
            table.setModel(model);
        }
        return table;
    }


}
