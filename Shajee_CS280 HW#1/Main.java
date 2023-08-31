import java.util.*;
public class Main{
   int h[][];
   int path=1;
   public Main(int N){
      h=new int[N][N];
      for(int i=0;i<N;i++){
         for(int j=0;j<N;j++){
            h[i][j]=0;
         }
      }
   }
   public boolean isSafe(int x, int y,int N){
      return (x>=0&&x<N)&&(y>=0&&y<N);
   }
   public boolean findPath(int row, int column, int index, int N) {
		if (h[row][column] != 0) {
			return false;
		}
		h[row][column] = path++;
		if (index == N * N - 1) {
			return true;
		}
		if (isSafe(row + 2, column + 1, N)
				&& findPath(row + 2, column + 1, index + 1, N)) {
			return true;
		}
		if (isSafe(row + 1, column + 2, N)
				&& findPath(row + 1, column + 2, index + 1, N)) {
			return true;
		}
		if (isSafe(row - 1, column + 2, N)
				&& findPath(row - 1, column + 2, index + 1, N)) {
			return true;
		}
		if (isSafe(row - 2, column + 1, N)
				&& findPath(row - 2, column + 1, index + 1, N)) {
			return true;
		}
		if (isSafe(row - 2, column - 1, N)
				&& findPath(row - 2, column - 1, index + 1, N)) {
			return true;
		}
		if (isSafe(row - 1, column - 2, N)
				&& findPath(row - 1, column - 2, index + 1, N)) {
			return true;
		}
		if (isSafe(row + 1, column - 2, N)
				&& findPath(row + 1, column - 2, index + 1, N)) {
			return true;
		}
		if (isSafe(row + 2, column - 1, N)
				&& findPath(row + 2, column - 1, index + 1, N)) {
			return true;
		}
		h[row][column] = 0;
		path--;
		return false;

	}
   public void generatePath(){
      if(findPath(0,0,0,h.length)){
         printH();
      }
      else{
         System.out.println("path not found");
      }
   }
   public void printH(){
      for(int i=0;i<h.length;i++){
         for(int j=0;j<h.length;j++){
            if(h[i][j]<10){
               System.out.print(" "+h[i][j]+" ");
            }
            else{
               System.out.print(h[i][j]+" ");
            }
         }
         System.out.println();
      }
   }
   public static void main(String [] args){
      Main tem=new Main(8);
      tem.generatePath();
   }
}