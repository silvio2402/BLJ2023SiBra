#include <stdio.h>
#include <stdlib.h>

#define NUM_MARKS 5

int main(int argc, char **argv)
{

    printf("-----------------------\n");
    printf("Average Mark Calculator\n");
    printf("-----------------------\n");

    /*
     * TODO - Read as many marks as defined in NUM_MARKS.
     *      - Save read marks in an array of length NUM_MARKS.
     */

    unsigned int marks[NUM_MARKS];
    for (unsigned int i = 0; i < NUM_MARKS; i++)
    {
        fflush(stdin);
        printf("Enter a mark: ");
        scanf("%d", &marks[i]);
    }

    printf("-----------------------\n");

    /*
     * TODO - Calculate and store the sum of all marks.
     */

    unsigned int sum = 0;

    for (unsigned int i = 0; i < NUM_MARKS; i++)
    {
        sum += marks[i];
    }

    /*
     * TODO - Calculate and print the average mark.
     */

    double avg = (double)sum / NUM_MARKS;
    printf("Your average grade is: %g", avg);

    /*
     * TODO - Extra tasks, implement only after completing all previous TODOs.
     *      - Round the calculated average to 2 decimal places (output only).
     *      - While inputting, only allow values between 1.0 and 6.0.
     *      - For every mark, input a weight and calculate the average accordingly.
     *      - Allow for the manipulation of individual marks, using the index.
     */

    return (EXIT_SUCCESS);
}
