package com.lby.main;

/*
 * Implement pow(x, n).
 */
public class Pow_x_n {
	public double pow(double x, int n) {
	  boolean neg = false;
	  double ans = 0;
	  if(n<0){
		  neg = true;
		  n = Math.abs(n);
	  }
	  if(n==0){
		  return 1;
	  }
	  if(n==1){
		  if(neg)
		  return 1/x;
		  return x;
	  }
	   double tmp = 0;
	   if(n%2==0){
		   tmp = pow(x,n/2);
		   ans = tmp * tmp;
	   }else{
		   tmp = pow(x,n/2);
		   ans = tmp * tmp * x;
	   }
      if(neg){
    	  ans = 1/ans;
      }
      return ans;
	}
}
