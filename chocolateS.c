#include<stdio.h>
int getChoc(int num);
int main()
{
	int res,choc;
	printf("Enter the number of chocolate: ");
	scanf("%d",&choc);
	res=choc+getChoc(choc);
	printf("The total number of chocolates is %d",res);
}
int getChoc(int num)
{
	if(num<3)
		return(0);
	else
		return(1+getChoc(num-2));
}
