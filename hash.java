import java.security.MessageDigest;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.util.Arrays;


class hash
{
   public static byte[] md5(String s)
   {

      byte[] AoB;

      AoB = new byte[16];
      
      try {	   
         return MessageDigest.getInstance("MD5").digest(s.getBytes());
      }
      catch (NoSuchAlgorithmException NSAE) {
	System.out.println("Error in md5() - ");
	return AoB;
      }
      
   }
      
   public static String makeNiceStr(byte[] AoB) 
   {
      char[] AoC;
      AoC = new char[AoB.length];
      int i;
      int myInt;
      char c;
      String niceAoC;
      niceAoC = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

   
      for (i=0; i < AoB.length; i++)
      {
         myInt = AoB[i];
         myInt = myInt & 31;
         c = niceAoC.charAt(myInt);
         AoC[i] = c;
      }
      return(String.valueOf(AoC));
   }
   

   public static void main(String[] args)
   {

      System.out.println("Hash for 'Hello'");

      byte[] hashAoB;

      hashAoB = md5("Hello");

      System.out.println(Arrays.toString(hashAoB));

      System.out.println("Using makeNiceStr(): " + makeNiceStr(hashAoB));
   
      // hash a bunch of names

      System.out.println("Delaware Pennsylvania California Texas...");
      System.out.println(makeNiceStr(md5("Delaware Pennsylvania California Texas...")));

      System.out.println("Ecuador Japan Bhutan Paraguay");
      System.out.println(makeNiceStr(md5("Ecuador Japan Bhutan Paraguay")));

      System.out.println("Russia Romania");
      System.out.println(makeNiceStr(md5("Russia Romania")));

      System.out.println("Turkmenistan Denmark");
      System.out.println(makeNiceStr(md5("Turkmenistan Denmark")));

      System.out.println("Tajikistan Jamaica");
      System.out.println(makeNiceStr(md5("Tajikistan Jamaica")));

      System.out.println("Panama Djibouti Nepal");
      System.out.println(makeNiceStr(md5("Panama Djibouti Nepal")));

      System.out.println("Bolivia Srilanka Singapore");
      System.out.println(makeNiceStr(md5("Bolivia Srilanka Singapore")));


      // Generate an array of random Bytes

      try {	
         FileWriter  writer      = new FileWriter("arrs.dat");
	 PrintWriter printWriter = new PrintWriter(writer);
           
         byte[] rb;
         rb = new byte[30];
         int rblen = 0;  // length of the random string
      
         Random generator = new Random();

         for (int i=0; i < 10000; i++)
         {
           for (int j=0; j < 2; j++)
           {
               generator.nextBytes(rb);
	       rblen = generator.nextInt(20);
               printWriter.print(makeNiceStr(rb).substring(0, 10+rblen));
               printWriter.print(" , ");
           }
           generator.nextBytes(rb);
           rblen = generator.nextInt(20);
           printWriter.println(makeNiceStr(rb).substring(0, 10+rblen));
         }

         printWriter.close();
     
      }
      catch (IOException IOE) {
	 System.out.println("Error in Filewriter for arrs.dat");
      }	 

      System.out.println();System.out.println("wrote arrs.dat"); System.out.println();

   }
}

