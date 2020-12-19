import java.io.*;



public class PasswordHashing {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of testCases:");
        int testCases = Integer.parseInt(br.readLine().trim());
        

        while(testCases-->0){
        System.out.println("Enter your password:");
        String password = br.readLine();
        String hashed = hashIt(password,getSalt(password));

        System.out.println(hashed);
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

        //zigZag(salt,salt.length());
        return salt;

    }

    // public static void zigZag(int arr[], int n) {
    //     int temp;
    //       for(int i = 0; i< n-1; i++)
    //       {
    //           if(i%2==0)
    //           {if(arr[i]>arr[i+1])
    //           {temp = arr[i];
    //           arr[i] = arr[i+1];
    //           arr[i+1] = temp;
    //           }
                  
    //           }
    //           else
    //           {if(arr[i]<arr[i+1])
    //           {temp = arr[i];
    //           arr[i] = arr[i+1];
    //           arr[i+1] = temp;
    //           }
    //           }
    //       }
    //    }
}
