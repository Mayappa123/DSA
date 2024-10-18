public class Jagged_array {

    public static void main(String[] args) {

        int maya [][]= new int[3][];

        maya[0]=  new int[3];
        maya[1]=  new int[4];

        int counter=0;
        for ( int i=0; i<maya.length; i++){
            for ( int j=0; i<maya[i].length; j++){
                maya[i][j]=counter++;
            }
        }

        for ( int i=0; i<maya.length; i++){
            System.out.println();
            for ( int j=0; i<maya[i].length; j++){
                System.out.println(maya[i][j]+" ");
            }
        }




    }
    
}
