package Mobile_Phone;


public class ContactDailer {

    static Mobilephone mob=new Mobilephone();
    static boolean flag=true;
    public static void main(String[] args) {
        System.out.println("\n\t\t\t\t\t\t\t\t\t--> CONTACT DAILER APPLICATION <-- \n\t\t\t\t\t\t\t\t\t            by: Kavin");

        while(flag){
            optionmenu();
            System.out.println("Enter Corresponding Number to use the Dailer");
            if(mob.sc.hasNextInt()){
                int switchval=mob.sc.nextInt();
                mob.sc.nextLine();
                switchvalue(switchval);
            }else {
                System.out.println("Enter the Number within range [1-6]");
                mob.sc.nextLine();
                continue;
            }

        }
        mob.sc.close();


    }

    public static void switchvalue(int num){
        switch(num){
            case 1:
                mob.PrintcontactDetails();
                break;
            case 2:
                System.out.println("Enter the Contact Name :\r");
                String name=mob.sc.nextLine();
                if(mob.contact_name.contains(name)){
                    System.out.println("Contact already exist");
                    break;
                }
                System.out.println("Enter the Contact Number :\r");
                long numval = mob.sc.nextLong();
                if(mob.contact_number.contains(numval)){
                    System.out.println("Number already assigned with another contact");
                    break;
                }
                else{
                    mob.sc.nextLine();
                    mob.setcontact(name, numval);
                    System.out.println("Contact added to your List...");
                }

                break;
            case 3:
                System.out.println("Enter a Contact Detail...\n A.Contact Name \n B.Contact Number");
                String val=mob.sc.nextLine();
                switch (val.toLowerCase()){
                    case "a":
                        System.out.println("Enter the Contact Name :\r");
                        String vname=mob.sc.nextLine();
                        if(mob.contact_name.contains(vname)){
                            long cnnum=mob.getcontactnumber(vname);
                            System.out.println(" Contact Name :"+mob.getcontactname(cnnum)+"  Contact Number :"+cnnum);
                            break;
                        }else{
                            System.out.println("No Match Found in List...");
                        }

                        break;
                    case "b":
                        System.out.println("Enter the Contact Number :\r");
                        long vnum=mob.sc.nextLong();
                        mob.sc.nextLine();
                        if (mob.contact_number.contains(vnum)){
                            String cnname=mob.getcontactname(vnum);
                            System.out.println("Contact Name :"+cnname+" Contact Number :"+mob.getcontactnumber(cnname));
                            break;
                        }else{
                            System.out.println("No Match Found in List...");
                        }

                        break;
                }
                break;

            case 4:
                System.out.println("Enter the Contact Detail in List to Proceed>>>");
                System.out.println("Enter the Contact Name: \r");
                String valname=mob.sc.nextLine();
                System.out.println("Enter the Contact Number :\r");
                long number=mob.sc.nextLong();
                mob.sc.nextLine();
                mob.updatecontact(valname,number);
                break;
            case 5:
                mob.deletecontact();
                break;
            case 6:
                flag=false;
                break;
            default:
                System.out.println("Wrong Option...>Enter within range<");
                break;


        }
    }






    public static void optionmenu(){
        System.out.println("\n||________________________||");
        System.out.println("   1. LIST OF CONTACTS");
        System.out.println("   2. CREATE NEW CONTACT");
        System.out.println("   3. FIND IN CONTACTS");
        System.out.println("   4. UPDATE CONTACT");
        System.out.println("   5. DELETE CONTACT");
        System.out.println("   6. EXIT THE APPLICATION");
        System.out.println("||________________________||");

    }



}
