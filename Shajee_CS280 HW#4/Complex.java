import java.util.*;
public class Complex{
   double real;
   double imag;
   public Complex() {

        this(0.0,0.0);
    }
    public Complex(double real) {

        this(real, 0.0);
    }
    public Complex(double real, double imag) {

        this.real = real;
        this.imag = imag;
    }
    public Complex add(Complex o) {

        return new Complex(real + o.real , imag + o.imag);
    }
	
	public Complex add(double o){
		return new Complex(real+o,imag);
	}
   public String div(Complex o) {
			double num =(real*o.real)+((-1)*(imag*((-1)*(o.imag))));
			double num1 =(real*((-1)*(o.imag))+(imag*o.real));
			
			double den =(o.real*o.real);
			double den1 =(o.imag*((-1)*(o.imag)))*(-1);
				
			den=den+den1;
				
        return new Complex((num/den),(num1/den)).toString();
        }
   public String div(double o){
        return new Complex(real/o,imag/o).toString();
	}

    public Complex mul(Complex o) {
        return new Complex((real*o.real)+((-1)*(imag*o.imag)),(real*o.imag)+(imag*o.real) );
    }
	
	public Complex mul(double o){
		return new Complex((real*o),(imag*o)); 
	}

    public Complex sub(Complex o) {

        return new Complex(real - o.real , imag - o.imag);
    }
	public Complex sub(double o){
		return new Complex(real-o,imag);
	}
    public boolean isDoubleInt(double d)
    {
      return Math.abs(Math.floor(d) - d) == (double)0;
    }

    public String toString() {
       if(isDoubleInt(this.real)==true&&isDoubleInt(this.imag)==true){
         if (this.imag < 0) {
	          
			   return "("+(int)real + "" + (int)imag + "j)";
	     
		   } else { 
		    
			   return "("+(int)real + "+" + (int)imag + "j)";
		   }
       }
       else{
         if(isDoubleInt(this.real)==true&&isDoubleInt(this.imag)==false){
            if (this.imag < 0) {
	          
			         return "("+(int)real + "" + imag + "j)";
	     
		         } else { 
		    
			         return "("+(int)real + "+" + imag + "j)";
		         }
         }
         else{
            if(isDoubleInt(this.real)==false&&isDoubleInt(this.imag)==true){
               if (this.imag < 0) {
	          
			         return "("+real + "" + (int)imag + "j)";
	     
		         } else { 
		    
			         return "("+real + "+" + (int)imag + "j)";
		         }
            }
            else{
               if (this.imag < 0) {
	          
			         return "("+real + "" + imag + "j)";
	     
		         } else { 
		    
			         return "("+real + "+" + imag + "j)";
		         }
            }
         }
       }
	 }
}