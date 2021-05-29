import java.util.ArrayList;
import java.util.Scanner;

public class CustomerPanel {
    public static void main(String args[])
    {
        FileHandle file = new FileHandle();
        FileHandle.load(file);
        Scanner sc = new Scanner(System.in);
        String st;
        user customer = new user();
        boolean menu = true;
        //customer = user.idMap.get("armin");

 while (true)
 {

        while(menu)
        {
     try
     {
            System.out.println("login / signup");
            FileHandle.save(file);

        st = sc.next();

        if(st.equals("signup"))
        {
            String newId = sc.next();
            String newPass = sc.next();

            user.signup(newId, newPass);
            customer = user.idMap.get(newId);
            menu = false;
            break;
        }

        else if(st.equals("login"))
        {
            String userId = sc.next();
            String userPass = sc.next();

            if(user.login(userId, userPass))
            {
                customer = user.idMap.get(userId);
                menu = false;
                break;
            }
        }
            FileHandle.save(file);

     }
     catch (Exception e)
     {
         System.out.println("error");
     }
        }


        while (!menu)
        {
            try {

            FileHandle.save(file);
        st = sc.next();

            if (st.equals("ls"))
            {
                st = sc.next();

                if(st.equals("-r"))
                {
                    list.show("-r");
                }
                else if (st.equals("-i"))
                {
                    list.show("-i");
                }
                else if (st.equals("-n"))
                {
                    list.show("-n");
                }
            }

        else if(st.equals("order"))
        {
            st = sc.next();

            if(st.equals("-d"))
            {
                int orderId = sc.nextInt();

                order.delete(orderId);
            }
            else
            {
                int goodId = Integer.parseInt(st);
                sc.next();
                int count = sc.nextInt();
                sc.next();

                order.add(goodId, count, customer);
            }
        }

        else if(st.equals("logout"))
        {
            menu = true;
            break;
        }
            FileHandle.save(file);
        }
            catch (Exception e)
            {
                System.out.println("input mismatch");
            }
            }
 }


 }




}



