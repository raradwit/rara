/*Program to find number of chocolates that we can get from n numbers of choclates if we get one chocolate bonus in evry three chocolates plastic*/
#include<stdio.h>
#include<conio.h>
int get_recur(int choc);
int main()
{
	int choc,res;
	printf("Enter the number of chocolates you have: ");
	scanf("%d",&choc);
	res=choc+get_recur(choc);
    printf("You can eat %d chocolates altogether.",res);
    getch();
	return 0;
}
int get_recur(int choc)
{
	if(choc<3)
	{
		return 0;
	}
	else
	{
		return(1+get_recur(choc-2));
	}
}

