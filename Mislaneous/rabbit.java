class FreshJuice {
    enum FreshJuiceSize{ SMALL, MEDIUM, LARGE }
    FreshJuiceSize size;
   }
   public class rabbit {
    public static void main(String args[]){
    FreshJuice juice = new FreshJuice();
    juice.size = FreshJuice.FreshJuiceSize.SMALL ;
    System.out.println("Size: " + juice.size);
    }
   }
