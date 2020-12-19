/*
************************************************************************
************************************************************************
This code depicts the BRUTE-FORCE PASSWORD CRACKING 

Instructions for input:

#1 Enter the option for the contents of password:
        ->Numbers Only                       : Press 1
        ->Lowercase Only                     : Press 2
        ->Lowercase and Numbers              : Press 3

#2 Enter the size of your pasword (recomended size 5 or less)

#3 Enter the irreversible hash of password

***********************************************************************
***********************************************************************
*/



import java.io.*;

public class PasswordCracker {
    static String table = "abcdefghijklmnopqrstuvwxyz0123456789";
    
    

    //static int t = table.length();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Enter number of testCases:");
        // int testCases = Integer.parseInt(br.readLine().trim());
        

        // while(testCases-->0){
        
        System.out.println("Your Password contain:"
        +"\n#Numbers only                       : Press 1"
        +"\n#Lowercase only                     : Press 2"
        +"\n#Lowercase and Numbers              : Press 3");
        //+"\n#Lowercase , Uppercase and Numbers  : Press 4");
        int inp = Integer.parseInt(br.readLine());
        if(inp==1) table = "0123456789";
        else if(inp==2) table = "abcdefghijklmnopqrstuvwxyz";
        else if(inp==3) table = "abcdefghijklmnopqrstuvwxyz0123456789";
        //else if(inp==4) table = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890123456789";
        else
        {
           System.out.println("Please enter the input properly!");  
           System.exit(0);
        }


        System.out.println("Enter your password size :");
        int passSize = Integer.parseInt(br.readLine());
        System.out.println("Enter your password hash :");
        String passwordHash = br.readLine();
        System.out.println("Now wait for 5-7 sec, your's just a normal computer not a super computer and this is brute force");

        PasswordCrack(passwordHash,"",passSize);
        }
    //}
    
    public static void PasswordCrack(String pass, String prefix, int passLen)
    {
        String crackedPass = "Your Password is : ";

        if(passLen==0)
        {
            String hashed = hashIt(prefix,getSalt(prefix));
            
            if(pass.equals(hashed))
             {  crackedPass += prefix;
                System.out.println();
                System.out.println("**********************************");
                System.out.println("**********************************");
                System.out.println("   "+crackedPass+"   ");
                System.out.println("**********************************");
                System.out.println("**********************************");
                System.out.println();

                System.exit(0);
             }
             else
             { 
                 return;
             }

        }
        
    
        for(int i = 0; i< table.length();i++)
        {
           
                String newPrefix = prefix + table.charAt(i);
                PasswordCrack(pass, newPrefix,passLen-1);
                //System.out.println(newPrefix);

            
        }
        

    }

    static String hashIt(String pass,String salt)
    {
        String hashPass="";
        hashPass="$hi$"+"&"+"$"+salt;

        return hashPass;
    }

    public static String getSalt(String pass)
    {
        String salt ="";
        for(int i = 0; i<= 10; i++ )
        {
            // if(i<pass.length()){
            // char ch = pass.charAt(i);
            // salt += (char)(ch+1);
            
            // }
            // else{
            //     salt += (char)(33+i+1);
                    
            // }

            if(i%2==0)
            { if(i<pass.length())
                {
                    salt += (char)(pass.charAt(i)+1) + (char)(pass.charAt(i)) + (char)(pass.charAt(i)-1);
                }
            else
            {
                salt += (char)(33+i-1) + (char)(33+i) + (char)(33+i+1);
            }

            }
            else
            { if(i<pass.length())
                {
                    salt += (char)(pass.charAt(i)-1) + (char)(pass.charAt(i)) + (char)(pass.charAt(i)+1);
                }
            else
            {
                salt += (char)(33+i+1) + (char)(33+i) + (char)(33+i-1);
            }

            }
        }

        return salt;

    }
}