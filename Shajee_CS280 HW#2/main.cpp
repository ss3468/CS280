#include <fstream>
#include <iostream>
#include <string>

using std::cout;
using std::endl;
using std::ifstream;
using std::ios;
using std::ofstream;
using std::string;
string line;
int i;
bool A(void);
bool I(void);
bool E(void);
bool P(void);
bool O(void);
bool L(void);
bool U(void);
bool C(void);
bool D(void);
bool A(){
      if(I()){
         if(line[i]=='='){
            i++;
            if(E()){
               return true;
            }
         }
         return false;
      }
      return false;
   }
bool E(){
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
bool O(){
      if(i < line.length()&&(line[i]=='+'||line[i]=='-'||line[i]=='/')){
         i++;
         return true;
      }
      else if(i < line.length()&&line[i]=='*'){
         i++;
         if(i < line.length()&&line[i]=='*'){
            i++;
            return true;
         }
         return true;
      }
      return false;
   }
bool P(){
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
               if(i < line.length()&&line[i]=='('){
                  i++;
                  if(E()){
                     if(i < line.length()&&line[i]==')'){
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
bool U()
        {
        	if (i<line.length()&&(line[i] == '+' || line[i] == '-' || line[i] == '!')) 
        	{
            ++i;
        		return true;
        		}
        	return false;
        	}
bool I(){
      if(C()){
         if(I()&&i<line.length()){
            return true;
         }
         return true;
      }
      return false;
   }
bool C(){
      if(i<line.length()&&(line[i]>='a'&&line[i]<='z')){
         ++i;
         return true;
      }
      return false;
   }
bool L(){
      if(D()){
         if(L()&&i<line.length()){
            return true;
         }
         return true;
      }
      return false;
   }
bool D(){
      if(i<line.length()&&(line[i]>='0'&&line[i]<='9')){
         ++i;
         return true;
      }
      return false;
   }
int main(void) {

    ifstream fin("input.txt");
    ofstream fout("output.txt", ios::out|ios::app);


    while (fin >> line) {
       i=0;
       if(A()&&line[i] == '\0'){
         fout<<"The string \""<<line<<"\" is in the language."<<endl;
       }
       else{
         fout<<"The string \""<<line<<"\" is not in the language."<<endl;
       }
    }
    fout.close();
    fin.close();

    return 0;
}