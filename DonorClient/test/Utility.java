public class Utility {
    @Deprecated
    public static void printLine(){
        System.out.println("-----------------------");
    }
    public static void printLine(char ch){
        for(int i=1;i<=40;i++){
            System.out.print(ch);
        }
        System.out.println();
    }    
}
