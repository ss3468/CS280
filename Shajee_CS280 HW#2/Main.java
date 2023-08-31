import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
   public static String line;
   public static int i;
   public static boolean A(){
      if(I()){
         if(line.charAt(i)=='='){
            i++;
            if(E()){
               return true;
            }
         }
         return false;
      }
      return false;
   }
   public static boolean E(){
      if(P()){
         if(O()){
            if(P()){
               return true;
            }
            return false;
         }
         return true;
      }
      return false;
   }
   public static boolean O(){
      if(i < line.length()&&(line.charAt(i)=='+'||line.charAt(i)=='-'||line.charAt(i)=='/')){
         i++;
         return true;
      }
      else if(i < line.length()&&line.charAt(i)=='*'){
         i++;
         if(i < line.length()&&line.charAt(i)=='*'){
            i++;
            return true;
         }
         return true;
      }
      return false;
   }
   public static boolean P(){
      if(I()){
         return true;
      }
      else{
         if(L()){
            return true;
         }
         else{
            if(U()){
               if(I()){
                  return true;
               }
               else{
                  if(L()){
                     return true;
                  }
                  else{
                     return false;
                  }
               }
            }
            else{
               if(i < line.length()&&line.charAt(i)=='('){
                  i++;
                  if(E()){
                     if(i < line.length()&&line.charAt(i)==')'){
                        i++;
                        return true;
                     }
                  }
                  return false;
               }
               return false;
            }
         }
      }
   }
   public static boolean U()
        {
        	if (i<line.length()&&(line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '!')) 
        	{
            ++i;
        		return true;
        		}
        	return false;
        	}
   public static boolean I(){
      if(C()){
         if(I()){
            return true;
         }
         return true;
      }
      return false;
   }
   public static boolean C(){
      if(i<line.length()&&(line.charAt(i)>='a'&&line.charAt(i)<='z')){
         ++i;
         return true;
      }
      return false;
   }
   public static boolean L(){
      if(D()){
         if(L()){
            return true;
         }
         return true;
      }
      return false;
   }
   public static boolean D(){
      if(i<line.length()&&(line.charAt(i)>='0'&&line.charAt(i)<='9')){
         ++i;
         return true;
      }
      return false;
   }
   public static void main(String [] args){
        File in = new File("input.txt");
        File out = new File("output.txt");

        try (Scanner scan = new Scanner(in);
             PrintWriter pw = new PrintWriter(new FileWriter(out, true))) {

            while (scan.hasNextLine()) {
                line=scan.nextLine();
                i=0;
                if(A() && i==line.length()){
                  pw.println("The string \""+line+"\" is in the language.");
                }
                else{
                  pw.println("The string \""+line+"\" is not in the language.");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

   }
}