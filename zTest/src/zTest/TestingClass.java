package zTest;

import java.util.Arrays;

public class TestingClass {
   
    public String printArray(int arr[], int k)
    {
        String s = "NO";
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.println(i);
                if (i == k) {
                    return "YES";
                    //break;
                }
            }
        }
            return "NO";
    }
    
    private static void palindromeMethod(String str, String str2) {
    	
    	if (str2.length() == 0) {
    		System.out.println(str);
    	}
    	for (int i = 0; i < str2.length(); i++) {
				palindromeMethod(str+str2.charAt(i), str2.substring(0, i)+str2.substring(i+1, str2.length()));
		}
	}
 
    // Driver program to test above functions
    public static void main(String[] args)
    {
        float ff= 10.9999f; //7 decimal points
        double dd = ff; // 15 decimal points
        //float ff1 = dd; // this cannot be done
        
        String s1 = "Hello";
        int arr1[] = new int[5];
        //arr1 = 0;
        System.out.println(arr1[4]);
        method1(s1);
        System.out.println(s1);
        TestingClass rotate = new TestingClass();
        
        System.out.println(tryTesting());
        
        String sortVal = "bottle";
        sortVal = sortValue(sortVal);
        System.out.println(sortVal);
        
        palindromeMethod("", "ABC");
        
    }
    private static String sortValue(String s) {
        final int cc;//this can not be done at instance level
        cc= 800;
        System.out.println(cc);
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    
    public static void method1(String s) {
        s = "hi";
    }
    
    public static int tryTesting() {
        try {
            int i = 10/0;
            System.out.println("I am still working");
            return 0;
        } catch (Exception e) {
            System.out.println("In Catch block");
            return 1;
        } finally {
            return 2;
        }
    }
}
 