package presentation;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ClientView extends JFrame{

    JButton backButton;
    JButton viewProducts;
    JButton searchProduct;
    JButton createOrder;
    JLabel productTitle;
    JTextField titleText;
    JLabel rating;
    JTextField ratingText;
    JLabel calories;
    JTextField caloriesText;
    JLabel protein;
    JTextField proteinText;
    JLabel fat;
    JTextField fatText;
    JLabel sodium;
    JTextField sodiumText;
    JLabel price;
    JTextField priceText;
    BaseProduct productBaseProduct;
    DefaultTableModel defaultTableModel;
    JTable jTable;
    DeliveryService deliveryService;
    JComboBox comboBox;
    List<BaseProduct> items;

    public ClientView(){
        this.setSize(1350, 750);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(2, 200, 220));

        JLabel title = new JLabel("CLIENT");
        title.setBounds(450, 5, 300, 70);
        title.setForeground(new Color(0, 0, 0));
        title.setBackground(new Color(2, 200, 220));
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setVisible(true);
        this.add(title);


        searchProduct = new JButton("Search product");
        searchProduct.setBounds(20,400,250,50);
        searchProduct.setBackground(new Color(0, 0, 0));
        searchProduct.setFont(new Font("Arial",Font.BOLD,25));
        searchProduct.setForeground(Color.WHITE);
        searchProduct.setFocusable(false);
        searchProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==searchProduct){
                    if(comboBox.getSelectedItem().equals("Title"))
                    {
                        for (BaseProduct baseProduct:titleSearch(titleText.getText())) {
                            System.out.println(baseProduct.toString());
                        }
                    }
                    else
                    {
                        if(comboBox.getSelectedItem().equals("Rating"))
                        {
                            for (BaseProduct baseProduct:ratingSearch(Float.parseFloat(ratingText.getText().toString()))) {
                                System.out.println(baseProduct.toString());
                            }
                        }
                        else
                        {
                            if(comboBox.getSelectedItem().equals("Calories"))
                            {
                                for (BaseProduct baseProduct:caloriesSearch(Integer.parseInt(caloriesText.getText().toString()))) {
                                    System.out.println(baseProduct.toString());
                                }
                            }
                            else
                            {
                                if(comboBox.getSelectedItem().equals("Protein"))
                                {
                                    for (BaseProduct baseProduct:proteinsSearch(Integer.parseInt(proteinText.getText().toString()))) {
                                        System.out.println(baseProduct.toString());
                                    }
                                }
                                else
                                {
                                    if(comboBox.getSelectedItem().equals("Fat"))
                                    {
                                        for (BaseProduct baseProduct:fatSearch(Integer.parseInt(fatText.getText().toString()))) {
                                            System.out.println(baseProduct.toString());
                                        }
                                    }
                                    else
                                    {
                                        if(comboBox.getSelectedItem().equals("Sodium"))
                                        {
                                            for (BaseProduct baseProduct:sodiumSearch(Integer.parseInt(sodiumText.getText().toString()))) {
                                                System.out.println(baseProduct.toString());
                                            }
                                        }
                                        else
                                        {
                                            if(comboBox.getSelectedItem().equals("Price"))
                                            {
                                                for (BaseProduct baseProduct:priceSearch(Integer.parseInt(priceText.getText().toString()))) {
                                                    System.out.println(baseProduct.toString());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        this.add(searchProduct);

        createOrder = new JButton("Create order");
        createOrder.setBounds(20,470,250,50);
        createOrder.setBackground(new Color(0, 0, 0));
        createOrder.setFont(new Font("Arial",Font.BOLD,25));
        createOrder.setForeground(Color.WHITE);
        createOrder.setFocusable(false);
        createOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==createOrder){
                    int[] rows;
                    rows = jTable.getSelectedRows();
                    List<MenuItem> menuItems;
                    menuItems = new ArrayList<>();
                    for (int i = 0; i < rows.length; i++)
                    {
                        BaseProduct baseProductSelected = items.get(jTable.convertRowIndexToModel(rows[i]));
                        menuItems.add(baseProductSelected);
                    }
                    Order o=new Order(menuItems);
                    o.setClientId(1);
                    o.setDate( LocalDateTime.now());
                    deliveryService = new DeliveryService();
                    deliveryService.addObserver((Observer)new EmployeeView("A new Order has been made!!"));
                    deliveryService.createOrder(o, items);
                    System.out.println(o.toString() +"\nClient ordered: " + menuItems.toString());
                }
            }
        });
        this.add(createOrder);

        backButton=new JButton("Back");
        backButton.setBounds(1100,10,150,30);
        backButton.setBackground(new Color(0, 0,0));
        backButton.setFont(new Font("Aerial", Font.BOLD,20));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==backButton)
                {
                    dispose();
                    MainFrame v=new MainFrame();
                }
            }
        });
        this.add(backButton);

        productTitle =new JLabel("Title:");
        productTitle.setBounds(20,80,100,40);
        productTitle.setFont(new Font("Aerial",Font.BOLD,25));
        productTitle.setForeground(Color.BLACK);
        this.add(productTitle);
        titleText=new JTextField();
        titleText.setBounds(140,90,170,25);
        this.add(titleText);

        rating=new JLabel("Rating:");
        rating.setBounds(20,120,100,40);
        rating.setFont(new Font("Aerial",Font.BOLD,25));
        rating.setForeground(Color.BLACK);
        this.add(rating);
        ratingText=new JTextField();
        ratingText.setBounds(140,130,170,25);
        this.add(ratingText);

        calories=new JLabel("Calories:");
        calories.setBounds(20,150,110,70);
        calories.setFont(new Font("Aerial",Font.BOLD,20));
        calories.setForeground(Color.BLACK);
        this.add(calories);
        caloriesText=new JTextField();
        caloriesText.setBounds(140,170,170,25);
        this.add(caloriesText);

        protein=new JLabel("Protein:");
        protein.setBounds(20,200,100,40);
        protein.setFont(new Font("Aerial",Font.BOLD,25));
        protein.setForeground(Color.BLACK);
        this.add(protein);
        proteinText=new JTextField();
        proteinText.setBounds(140,210,170,25);
        this.add(proteinText);

        fat=new JLabel("Fat:");
        fat.setBounds(20,240,100,40);
        fat.setFont(new Font("Aerial",Font.BOLD,25));
        fat.setForeground(Color.BLACK);
        this.add(fat);
        fatText=new JTextField();
        fatText.setBounds(140,250,170,25);
        this.add(fatText);

        sodium=new JLabel("Sodium:");
        sodium.setBounds(20,280,100,40);
        sodium.setFont(new Font("Aerial",Font.BOLD,25));
        sodium.setForeground(Color.BLACK);
        this.add(sodium);
        sodiumText=new JTextField();
        sodiumText.setBounds(140,290,170,25);
        this.add(sodiumText);

        price=new JLabel("Price:");
        price.setBounds(20,320,100,40);
        price.setFont(new Font("Aerial",Font.BOLD,25));
        price.setForeground(Color.BLACK);
        this.add(price);
        priceText=new JTextField();
        priceText.setBounds(140,330,170,25);
        this.add(priceText);

        JPanel jPanel=new JPanel();
        jPanel.setBorder(new EtchedBorder());
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBounds(400,100,900,500);
        jPanel.setBackground(Color.WHITE);
        jPanel.setVisible(true);

        productBaseProduct =new BaseProduct();
        items = productBaseProduct.readCsvFile();
        defaultTableModel =new DefaultTableModel();
        defaultTableModel.addColumn("Title");
        defaultTableModel.addColumn("Rating");
        defaultTableModel.addColumn("Calories");
        defaultTableModel.addColumn("Protein");
        defaultTableModel.addColumn("Fat");
        defaultTableModel.addColumn("Sodium");
        defaultTableModel.addColumn("Price");

        List<BaseProduct> baseProductList;
        baseProductList = productBaseProduct.readCsvFile();

        for (BaseProduct bp:baseProductList) {
            String  name = bp.getTitle();
            String  rating = Float.toString(bp.getRating());
            String  calories = Integer.toString(bp.getCalories());
            String protein = Integer.toString(bp.getProtein());
            String fat = Integer.toString(bp.getFat());
            String sodium = Integer.toString(bp.getSodium());
            String price = Integer.toString(bp.getPrice());
            defaultTableModel.addRow(new Object[]{name,rating,calories,protein,fat,sodium,price});
        }

        jTable =new JTable(defaultTableModel);
        jTable.setVisible(true);
        jTable.setBounds(0,0,500,500);
        jTable.setForeground(new Color(0, 0,0));
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable.setColumnSelectionAllowed(false);
        jTable.setRowSelectionAllowed(true);
        jTable.addRowSelectionInterval(1, 100);
        jTable.setFont(new Font("Arial",Font.BOLD,20));
        JScrollPane sp=new JScrollPane(jTable);
        sp.setBounds(0,0,900,500);
        jPanel.add(sp);

        String filters[] = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        comboBox = new JComboBox(filters);
        comboBox.setBounds(20,530,200,40);
        comboBox.setBackground(new Color(0,0,0));
        comboBox.setForeground(Color.WHITE);
        this.add(comboBox);

        this.setVisible(true);
    }

    public List<BaseProduct> titleSearch(String s){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getTitle().toLowerCase().contains(s.toLowerCase())).collect(Collectors.toList());
        return finalList;
    }

    public List<BaseProduct> ratingSearch(float value){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getRating()==value).collect(Collectors.toList());
        return finalList;
    }

    public List<BaseProduct> caloriesSearch(int value){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getCalories()==value).collect(Collectors.toList());
        return finalList;
    }

    public List<BaseProduct> proteinsSearch(int value){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getProtein()==value ).collect(Collectors.toList());
        return finalList;
    }

    public List<BaseProduct> fatSearch(int value){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getFat()==value).collect(Collectors.toList());
        return finalList;
    }

    public List<BaseProduct> sodiumSearch(int value){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getSodium()==value).collect(Collectors.toList());
        return finalList;
    }

    public List<BaseProduct> priceSearch(int value){
        List<BaseProduct> finalList = new ArrayList<>();
        finalList = this.items.stream().filter(e -> e.getPrice()==value).collect(Collectors.toList());
        return finalList;
    }

}
