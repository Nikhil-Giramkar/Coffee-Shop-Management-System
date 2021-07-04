import java.io.*;
import java.util.*;
import java.lang.*;

public class Coffee_Shop{

int count_of_products = 0;
static double turnover_today=0.0;
static int bill_no = 0;


BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

HashMap<Integer,String>prod_name = new HashMap<>();

HashMap<Double,Double>prod_price = new HashMap<>();

HashMap<Integer,Double>bill_today = new HashMap<>();






//-------------------------------MAIN FUNCTION-------------------------

public static void main(String args[])throws IOException
{

Coffee_Shop obj = new Coffee_Shop();
obj.interFace();
}



//------------------------------------CONSTRUCTOR------------------------------------
Coffee_Shop(){

prod_name.put(1,"Dalogna Coffee");
count_of_products++;
prod_name.put(2,"Irish Coffee");
count_of_products++;
prod_name.put(3,"White Coffee");
count_of_products++;
prod_name.put(4,"Capuccino");
count_of_products++;
prod_name.put(5,"Cold Coffee");
count_of_products++;


prod_price.put(1.1,50.0);
prod_price.put(1.2,75.0);
prod_price.put(1.3,100.0); 

prod_price.put(2.1,125.0);
prod_price.put(2.2,150.0);
prod_price.put(2.3,175.0);

prod_price.put(3.1,200.0);
prod_price.put(3.2,225.0);
prod_price.put(3.3,250.0);

prod_price.put(4.1,275.0);
prod_price.put(4.2,300.0);
prod_price.put(4.3,325.0);

prod_price.put(5.1,350.0);
prod_price.put(5.2,375.0);
prod_price.put(5.3,400.0);

}
//----------------------------------------------------------------------------------







//--------------------------------------ADD PRODUCT----------------------------------------------
public void add_product()throws IOException{

System.out.println("Enter the name of product to ba added in the menu \n");
String name = br.readLine();
count_of_products++;
System.out.println("Enter the UID no. for the product \n");
int uid = Integer.parseInt(br.readLine());

prod_name.put(uid,name);

System.out.println("Enter the price for Small size \n");
double price1 = Double.parseDouble(br.readLine());

System.out.println("Enter the price for Medium size \n");
double price2 = Double.parseDouble(br.readLine());

System.out.println("Enter the price for Large size \n");
double price3 = Double.parseDouble(br.readLine());

prod_price.put(uid+0.1,price1);
prod_price.put(uid+0.2,price2);
prod_price.put(uid+0.3,price3);

System.out.println("New product has been added successfully \n \n");

}
//---------------------------------------------------------------------------------










//----------------------------------------DELETE PRODUCT-------------------------------------

public void delete_product()throws IOException{

System.out.println("Enter the name of product to be deleted \n");
String name = br.readLine();

int uid_no =0;

for(Map.Entry<Integer,String>hm : prod_name.entrySet())
{
if(hm.getValue().equalsIgnoreCase(name))
{
uid_no = hm.getKey();
break;
}
}
if(uid_no == 0)
System.out.println("No such product found!!!");
else
{
String prduct_removed = (String)prod_name.remove(uid_no);
count_of_products--;
double price1 = prod_price.remove(uid_no+0.1);
double price2 = prod_price.remove(uid_no+0.2);
double price3 = prod_price.remove(uid_no+0.3);

System.out.println("Item has been removed successfully....\n");
}
}
//---------------------------------------------------------------












//----------------------------------------------------------------

public void change_price()throws IOException
{
int uid;
for(Map.Entry<Integer,String>disp : prod_name.entrySet())
{
System.out.println(disp.getKey()+"        "+disp.getValue()+"\n");
}

System.out.println("Enter the UID of the product");
uid = Integer.parseInt(br.readLine());

if(prod_name.containsKey(uid))
{

//********************Display the sub_uid with prices for S M L********************

System.out.println("1)"+" Small    -    Rs."+prod_price.get(uid+0.1)+"\n");
System.out.println("2)"+" Medium   -    Rs."+prod_price.get(uid+0.2)+"\n");
System.out.println("3)"+" Large    -    Rs."+prod_price.get(uid+0.3)+"\n");


System.out.println("Enter the Sub UID \n");
double sub_uid = Double.parseDouble(br.readLine());

if(prod_price.containsKey(uid+(0.1*sub_uid)))
{
System.out.println("Enter the new Price \n");
double new_price = Double.parseDouble(br.readLine());

prod_price.put(uid+(0.1*sub_uid),new_price);
System.out.println("Price changed Successfully \n");
}
}
}
//--------------------------------------------------------------









//----------TURNOVER CALCULATOR---------------

public double turnover_today(){

double sum = 0.0;
for(Map.Entry<Integer,Double> trans : bill_today.entrySet())
{
sum = sum + trans.getValue();
}
return sum;
}
//------------------------------------------------------------










//-----------BILL CALCULATOR--------------------------

public double bill_calculator(double total_bill)
{
double sum=0.0;
double gst = 0.18;

sum = total_bill + (total_bill*0.18);


return sum; 
}
//--------------------------------------------------------










//------------------------------InterFace--------------

public void interFace()throws IOException{

int shop_open;
do{

//*********Shop open******
int mode;
System.out.println("Enter the Mode \n 1. Customer Interface \n 2. Manager's Settings ");
mode = Integer.parseInt(br.readLine());

switch(mode)
{

case 1 :                      //  CUSTOMER INTERFACE


int new_cust;
do{
//********New Customer**********
double bill = 0.0;
int uid=0;
int types_of_coffee=0;
System.out.println("New Customer......\n");
HashMap<Integer,String>choice_name = new HashMap<>();
HashMap<Integer,Double>choice_price = new HashMap<>();
HashMap<Integer,Integer>choice_qty = new HashMap<>();
HashMap<Integer,Double>choice_bill = new HashMap<>();
int choice_count = 0;

//********************Display menu with uid and name********************

for(Map.Entry<Integer,String>disp : prod_name.entrySet())
{
System.out.println(disp.getKey()+"        "+disp.getValue()+"\n");
}

System.out.println("How many types of coffee you wish to order \n");
types_of_coffee = Integer.parseInt(br.readLine());


for(int i=0;i<types_of_coffee;i++)
{

//**********New item*************
System.out.println("Enter the UID \n");
uid = Integer.parseInt(br.readLine());

if(prod_name.containsKey(uid))
{
choice_count++;
String nameOfProduct = prod_name.get(uid);
choice_name.put(choice_count,nameOfProduct);

//********************Display the sub_uid with prices for S M L********************

System.out.println("1)"+" Small    -    Rs."+prod_price.get(uid+0.1)+"\n");
System.out.println("2)"+" Medium   -    Rs."+prod_price.get(uid+0.2)+"\n");
System.out.println("3)"+" Large    -    Rs."+prod_price.get(uid+0.3)+"\n");


System.out.println("Enter the Sub UID \n");
double sub_uid = Double.parseDouble(br.readLine());

if(prod_price.containsKey(uid+(0.1*sub_uid)))
{

System.out.println("Enter the quantity \n");
int qty = Integer.parseInt(br.readLine());
double price = prod_price.get(uid+(0.1*sub_uid));

choice_price.put(choice_count,price); 

choice_qty.put(choice_count,qty); 

choice_bill.put(choice_count,price); 

bill = (price * qty);
choice_bill.put(choice_count,bill);




System.out.println("Coffee added to cart successfully \n");
}
else
{System.out.println("Invalid sub-uid \n");}

}
else
{System.out.println("Invaid UID \n");}
}

double total_bill = 0.0;

for(Map.Entry<Integer,Double> x : choice_bill.entrySet())
{
total_bill = total_bill+x.getValue();
}


bill_no++;
bill_today.put(bill_no,total_bill);

double final_bill = bill_calculator(total_bill);



//******************** print bill********************


for(int i=1;i<=choice_count;i++)
{
System.out.println("Sr.no. "+i+"  "+choice_name.get(i));
System.out.println("Price      -     Rs."+choice_price.get(i));
System.out.println("Quantity   -        "+choice_qty.get(i));
System.out.println("Amount     -     Rs."+choice_bill.get(i)+"\n");
}
System.out.println("Total Bill   -   Rs."+total_bill);
System.out.println("GST          -       18% ");
System.out.println("Final Bill   -   Rs."+final_bill);

//************************************************************

System.out.println("New customer? 1,0  \n");
new_cust = Integer.parseInt(br.readLine());

}while(new_cust==1);

break; //case 1 end

//###################################################################################################################################


case 2:                                     //MANAGER SETTING

System.out.println("Which setting do you wish to make \n ");
int leave;

do
{
System.out.println("1. Add Item \n 2. Delete Item \n 3. Change price of an item \n 4. Today's Turnover ");
int setting_no = Integer.parseInt(br.readLine());

switch(setting_no)
{
case 1 :
add_product();
break;

case 2:
delete_product();
break;

case 3:
change_price();
break;

case 4:
System.out.println("Today's Turnover = Rs."+turnover_today()+"\n");
break;

default:
System.out.println("Incorrect Input\n");
}

System.out.println("Do you wish to leave the Manager's Settings\n 1 for Yes \n 0 for No");
leave = Integer.parseInt(br.readLine());
}while(leave==0);



break; //case 2 end


default: 
System.out.println("Invalid input \n ");

}//switch case



System.out.println("Do you wish to close the shop? \n 0 for Yes \n 1 for No \n");


shop_open = Integer.parseInt(br.readLine());

if(shop_open == 0)
System.out.println("See you Tomorrow 🤑️ \n");
}while(shop_open==1);




}//main end



}//class end
