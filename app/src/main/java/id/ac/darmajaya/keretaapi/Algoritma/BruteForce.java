package id.ac.darmajaya.keretaapi.Algoritma;

public class BruteForce {
    public static int BruteForce(String text,String tobematched){
        int length = text.length();//length of the text
        int plength = tobematched.length();//length of the pattern;

        //loop condition
        for(int i=0;i<=length-plength;i++){
            //initialization of j
            int j=0;
            while((j < plength) && (text.charAt(i+j) == tobematched.charAt(j))){
                j++;
            }
            if(j == plength){
                return i;
            }
        }

        return -1;
    }
}
