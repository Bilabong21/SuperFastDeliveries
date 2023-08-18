
package superfastdeliveries;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import za.ac.tut.delivery.Delivery;

/**
 *
 * @author USER
 */
public class SuperFastDeliveries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
          String[] deliveryInfo = {"2019:1:12.34", "2020:1:34.44", "2020:1:35.19", "2020:2:9.47", 
				   "2019:2:7.37", "2020:1:62.44", "2020:2:145.12", "2019:2:25.93", 
				   "2019:1:56.83", "2020:1:81.29", "2019:2:42.33", "2019:2:22.98",
				   "2020:1:35.23", "2019:1:44.44", "2019:2:108.54", "2020:2:92.11", 
				   "2019:2:21.21", "2020:1:101.23", "2020:1:3.55", "2019:1:64.22", 
				   "2019:2:76.36", "2020:2:64.39", "2019:1:17.04", "2020:1:7.59"};
          
          ArrayList<Delivery> delivery = new ArrayList<Delivery>();
          Random ran = new Random();
          
          for (int i = 0; i < deliveryInfo.length; i++) 
          {
             String[] Tokens = deliveryInfo[i].split(":");
             int year = Integer.parseInt(Tokens[0]);
             int number = ran.nextInt(10000)+ 1;
             int code = Integer.parseInt(Tokens[2]);
             double weight = Double.parseDouble(Tokens[3]);
             Delivery del = new Delivery(year,number,code,weight);
             delivery.add(del);
             
          }
          
          //String results = lightest(delivery);
          //JOptionPane.showMessageDialog(null, results);
          int year =0;
          double fee = averageFee(delivery,year);
          JOptionPane.showMessageDialog(null, fee);
    }
  public static String lightest(ArrayList<Delivery> delivery)
    {
          String light = null;
          double max = Double.MAX_VALUE;
         
          for (int i = 0; i < delivery.size(); i++)
          {
             
               if(delivery.get(i).getWeight() < max)
                 {
                    max = delivery.get(i).getWeight();
                    light= delivery.get(i).getDeliveryNumber();
                 }
          }
          
          return light;
         
    }
    public static double averageFee(ArrayList<Delivery> delivery,int year)
    {
        double average =0.0;
         
         for (int i = 0; i < delivery.size(); i++) 
         {
            average = delivery.get(i).getFee() * year;
         }
 
        
        
        return average;
    }
    
}
