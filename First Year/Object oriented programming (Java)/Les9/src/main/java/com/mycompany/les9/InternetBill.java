
package com.mycompany.les9;

public class InternetBill extends Bill{
    
    private String name, pack;
    private boolean discount;
    private int tariff;

    public InternetBill(String name, String pack, boolean discount, int tariff, String billNumber) {
        super(billNumber);
        this.name = name;
        this.pack = pack;
        this.discount = discount;
        this.tariff = tariff;
    }
    
    @Override
    public double calc(){
        double price;
        
        if(pack.toLowerCase().contains("fast")){
            price = tariff * 1000;
        }
        else
        {
            price = tariff * 500;
        }
        
        if(discount)
        {
            price = price * 0.80;
        }
        
        return price;
    }
    
    @Override
    public boolean checkBill(){
        if(getBillNumber().length() != 10)
        {
            return false;
        }
        
        if(!getBillNumber().startsWith("160"))
        {
            return false;
        }
        
        for(int i = 2; i < getBillNumber().length(); i++)
        {
            if(!Character.isDigit(getBillNumber().charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    
    @Override
    public  String toString()
    {
        return "Internet bill" + getBillNumber() + " " + this.name + " " + this.pack + " " + discount;
    }
}
