package Optativa.Java.String.src;

public class Funciones {
    
    public static void QuitaCaracteres (String str1, String str2){
        
       String out1 = "";
       String out2 = "";
       int min = Math.min(str1.length(), str2.length());


        for (int i = 0; i < min; i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                out1 += str1.charAt(i);
            }
            if(str2.charAt(i) != str1.charAt(i)){
                out2 += str2.charAt(i);
            }
        }
        System.out.println("str1: "+str1+" out1: "+out1);
        System.out.println("str2: "+str2+" out2: "+out2);

    }

}
