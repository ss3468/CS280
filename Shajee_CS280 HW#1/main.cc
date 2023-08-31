#include<iostream>
#include<stdio.h>
const int N=8;
int h[N][N];
int path=1;
bool isSafe(int x, int y,int N){
    return (x>=0&&x<N)&&(y>=0&&y<N);
}
// determines if coordinates are in plane

bool findPath(int row, int column, int index, int N) {
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
		if (isSafe(row+1, column + 2, N)
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
void printH(){
      for(int i=0;i<N;i++){
         for(int j=0;j<N;j++){
            if(h[i][j]<10){
               std::cout<<" "<<h[i][j]<<" ";
            }
            else{
               std::cout<<h[i][j]<<" ";
            }
         }
         std::cout<<"\n";
      }
   }
void generatePath(){
   if(findPath(0,0,0,N)){
      printH();
    }
    else{
         std::cout<<"path not found";
      }
   }
int main(){
   generatePath();
}