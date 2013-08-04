package com.lby.main;
/*
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Median_of_Two_Sorted_Arrays {
	 public double findMedianSortedArrays(int A[], int B[]) {
		   int len1 = A.length,len2 = B.length;
		   if(len1==0 && len2==0){
			   return -1;
		   }
		   if(len1==0){
			   return B[(0+len2-1)/2];
		   }
		   if(len2==0){
			   return A[(0+len1-1)/2];
		   }
		   double ans = findMedianSortedArrays(A,0,len1-1,len1,B,0,len2-1,len2);
		   if(ans != -1){
			   return ans;
		   }
		   return findMedianSortedArrays(B,0,len2-1,len2,A,0,len1-1,len1);
	    }
	 public double findMedianSortedArrays(int A[],int l,int r,int lenA, int B[],int l1,int r1,int lenB) {
		 if(l>r){
			 return -1;
		 }
		  int mid = (l+r)/2,s_mid= (lenA+lenB)/2;
		  int a_mid = s_mid - mid-1;
		  if(a_mid==0 && A[mid]<=B[0]){
			  return A[mid];
		  }else if(a_mid==0 && A[mid]>B[0]){
			  r = mid - 1;
			  return findMedianSortedArrays(A,l,r,lenA,B,l1,r1,lenB); 
		  }
		  if(a_mid==lenB && A[mid]>=B[a_mid-1]){
			  return A[mid];
		  }else if(a_mid==lenB && A[mid]<B[a_mid-1]){
			  l = mid+1;
			  return findMedianSortedArrays(A,l,r,lenA,B,l1,r1,lenB); 
			  
		  }
		  a_mid--;
		  if(A[mid]>=B[a_mid] && A[mid]<=B[a_mid+1]){
			  return A[mid];
		  }else if(A[mid] < B[a_mid]){
			  l = mid+1;
			  return findMedianSortedArrays(A,l,r,lenA,B,l1,r1,lenB); 
		  }else{
			  r = mid - 1;
			  return findMedianSortedArrays(A,l,r,lenA,B,l1,r1,lenB); 
		  }
	 }
	 public static void main(String[]ars){
		 int[]a1 = {1},a2={2,3,4,5,6};
		 new Median_of_Two_Sorted_Arrays().findMedianSortedArrays(a1,a2);
	 }
}
