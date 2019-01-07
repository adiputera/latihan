import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the aOrB function below.
     */
    static void aOrB(int k, String a, String b, String c) {
        /*
         * Write your code here.
         */
        String abin = hexToBin(a);
        String bbin = hexToBin(b);
        String cbin = hexToBin(c);
        
        char[] ar1 = abin.toCharArray();
        char[] ar2 = bbin.toCharArray();
        char[] ar3 = cbin.toCharArray();
        int maxLength = ar1.length;
        if(maxLength < ar2.length){
            maxLength = ar2.length;
        }
        if(maxLength < ar3.length){
            maxLength = ar3.length;
        }
        char[] ara = new char[maxLength];
        char[] arb = new char[maxLength];
        char[] arc = new char[maxLength];
        if(ar1.length < maxLength){
            for (int i = 0; i < maxLength - ar1.length; i++) {
                ara[i] = '0';
            }
        }
        System.arraycopy(ar1, 0, ara, maxLength - ar1.length, ar1.length);
        if(ar2.length < maxLength){
            for (int i = 0; i < maxLength - ar2.length; i++) {
                arb[i] = '0';
            }
        }
        System.arraycopy(ar2, 0, arb, maxLength - ar2.length, ar2.length);
        if(ar3.length < maxLength){
            for (int i = 0; i < maxLength - ar3.length; i++) {
                arc[i] = '0';
            }
        }
        System.arraycopy(ar3, 0, arc, maxLength - ar3.length, ar3.length);
        int batas = 0;
        for(int i = 0; i < maxLength; i++){
            if(arc[i] == '0'){
                if(ara[i]=='0' && arb[i]=='0'){
                    
                }else if(ara[i]=='1' && arb[i]=='1'){
                    ara[i]='0';
                    arb[i]='0';
                    batas+=2;
                }else if(ara[i]=='1' && arb[i]=='0'){
                    ara[i]='0';
                    batas+=1;
                }else{
                    arb[i]='0';
                    batas+=1;
                }
            }else{
                if(ara[i]=='1' || arb[i]=='1'){
                    
                }else {
                    arb[i]='1';
                    batas+=1;
                }
            }
        }
        /*if(batas<k){
            boolean g = true;
            while(g){
                for(int i = 0; i < maxLength; i++){
                    
                }
            }
        }*/
        String bina = new String(ara);
        String binb = new String(arb);
        BigInteger deca = new BigInteger(bina, 2);
        BigInteger decb = new BigInteger(binb, 2);
        String hexa = deca.toString(16).toUpperCase();
        String hexb = decb.toString(16).toUpperCase();
        if(batas > k){
            System.out.println("-1");
        }else{
            System.out.println(hexa);
            System.out.println(hexb);
        }
    }
    
    static String hexToBin(String s) {
        String preBin = new BigInteger(s, 16).toString(2);
        Integer length = preBin.length();
        if (length < 8) {
            for (int i = 0; i < 8 - length; i++) {
                preBin = "0" + preBin;
            }
        }
        return preBin;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int k = Integer.parseInt(scanner.nextLine().trim());

            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String c = scanner.nextLine();

            aOrB(k, a, b, c);
        }
    }
}

