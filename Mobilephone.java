package Mobile_Phone;

import java.util.ArrayList;
import java.util.Scanner;

public class Mobilephone {
    Scanner sc=new Scanner(System.in);
    ArrayList<String> contact_name=new ArrayList<String>();
    ArrayList<Long> contact_number=new ArrayList<Long>();

    public void setcontact(String name,long num){
        if(!contact_name.contains(name)){
            contact_name.add(name);
            contact_number.add(num);
//            int position = contact_name.indexOf(name);
//            contact_number.set(position,num);
        }


    }

    public long getcontactnumber(String name){
        int position=contact_name.indexOf(name);
        return contact_number.get(position);
    }

    public String getcontactname(long number){
        int position=contact_number.indexOf(number);
        return contact_name.get(position);
    }

    public void updatecontact(String name,long number){
        if(contact_name.contains(name)&& contact_number.contains(number)){
            System.out.println("What would u like to update :\r\n1. Contact Name \n2. Contact Number \n3. Both (Contact Name and Number)");
            int num=sc.nextInt();
            sc.nextLine();
            switch (num){
                case 1:
                    int pos=contact_number.indexOf(number);
                    System.out.println("Enter the new Name :\r");
                    String newname=sc.nextLine();
                    if(contact_name.contains(newname)){
                        System.out.println("Contact Name "+newname+" already exist in list");
                        break;
                    }else {
                        contact_name.set(pos, newname);
                        System.out.println("Updated!!");
                    }
                    break;
                case 2:
                    int posnum=contact_name.indexOf(name);
                    System.out.println("Enter the New Number :\r");
                    long newnum=sc.nextLong();
                    sc.nextLine();
                    if(contact_number.contains(newnum)){
                        System.out.println("Contact Number "+newnum+" already exist in list");
                        break;
                    }
                    else {
                        contact_number.set(posnum, newnum);
                        System.out.println("Updated!!");
                    }
                    break;
                case 3:
                    int cnamepos= contact_name.indexOf(name);
                    int cnumpos = contact_number.indexOf(number);
                    if(cnamepos==cnumpos){
                        System.out.println("Enter a New name :\r");
                        String rename=sc.nextLine();
                        System.out.println("Enter a New Number :\r");
                        long renum=sc.nextLong();
                        sc.nextLine();
                        contact_name.set(cnamepos,rename);
                        contact_number.set(cnumpos,renum);
                        System.out.println("Updated!!");
                    }
                    break;
            }
        }else{
            System.out.println("Enter Valid Contact Details...");
        }
    }


    public void deletecontact(){
        System.out.println("What Contact detail do u have ? \n 1. Contact Name \n 2. Contact Number");
        int num=sc.nextInt();
        sc.nextLine();
        switch (num){
            case 1:
                System.out.println("Enter the Contact Name to delete the Contact :\r");
                String name=sc.nextLine();
                if(contact_name.contains(name)){
                    System.out.println("<<< Contact Found >>>");
                    int index=contact_name.indexOf(name);
                    contact_name.remove(index);
                    contact_number.remove(index);
                    System.out.println("Contact Deleted...");


                }
                else {
                    System.out.println("Contact Detail Not Found in List");
                }
                break;

               case 2:
                System.out.println("Enter the Contact Number to delete the Contact :\r ");
                long newnum=sc.nextLong();
                   sc.nextLine();
                if(contact_number.contains(newnum)){
                    System.out.println(">>> Contact Found <<<");
                    int indexnew=contact_number.indexOf(newnum);
                    contact_number.remove(indexnew);
                    contact_name.remove(indexnew);
                    System.out.println("Contact Deleted...");
                }
                else {
                    System.out.println("Contact Detail Not Found in List");
                }
                break;

        }


    }

    public void PrintcontactDetails(){
        System.out.println(">>>Contact Name<<<\t\t\t>>>Contact Number<<<");
        for(int i=0;i<contact_number.size();i++){
            System.out.println("|   "+contact_name.get(i)+"\t\t\t\t\t\t "+contact_number.get(i)+"  |");
        }

    }


}
