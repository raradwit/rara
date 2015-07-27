#include <stdio.h>

int chocolate_from_wrapper(int no_of_wrapper){
	int left, number_of_chocolate;
	if(no_of_wrapper < 3){
	    return 0;
	}
	left = no_of_wrapper % 3;
	number_of_chocolate = (int)no_of_wrapper / 3;
	no_of_wrapper = left + number_of_chocolate;
	return(number_of_chocolate + chocolate_from_wrapper(no_of_wrapper));
}

int main()
{
    int number_of_chocolate, wrapper, total_chocolate_at_last;
	printf("Enter the number of chocolate: ");
	scanf("%d", &number_of_chocolate);
	wrapper = number_of_chocolate;
	total_chocolate_at_last=number_of_chocolate + chocolate_from_wrapper(wrapper);
	printf("You will have %d number of chocolates.", total_chocolate_at_last);
    return 0;
}


