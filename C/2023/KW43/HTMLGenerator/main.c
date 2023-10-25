#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char HTML_BEGIN[] = "<!DOCTYPE html>\n"
                          "<html>\n"
                          "  <head>\n"
                          "    <title>HTML Generator</title>\n"
                          "    <style>\n";
const char HTML_STYLE[] = "      table {\n"
                          "        border-collapse: collapse;\n"
                          "      }\n"
                          "      td {\n"
                          "        border: 1px solid black;\n"
                          "        padding: 5px;\n"
                          "      }\n";
const char HTML_END_STYLE[] = "    </style>\n"
                              "  </head>\n"
                              "  <body>\n";
const char HELLO_WORLD[] = "    <h1>Hello World!</h1>\n";
const char TABLE_BEGIN[] = "    <table>\n";
const char TABLE_ROW_BEGIN[] = "      <tr>\n";
const char TABLE_DATA_BEGIN[] = "        <td>";
const char SAMPLE_TEXT[] = "Sample Text";
const char TABLE_DATA_END[] = "</td>\n";
const char TABLE_ROW_END[] = "      </tr>\n";
const char TABLE_END[] = "    </table>\n";
const char HTML_END[] = "  </body>\n"
                        "</html>";

int main(int argc, char **argv)
{
    const unsigned int rows;
    printf("Enter the number of rows: ");
    scanf("%d", &rows);

    const unsigned int cols;
    printf("Enter the number of columns: ");
    scanf("%d", &cols);

    unsigned int size = (sizeof(HTML_BEGIN) + sizeof(HTML_END) + sizeof(HTML_STYLE) + sizeof(HTML_END_STYLE) + sizeof(HELLO_WORLD) + sizeof(TABLE_BEGIN) + sizeof(TABLE_END) + (sizeof(TABLE_ROW_BEGIN) + sizeof(TABLE_ROW_END)) * rows + (sizeof(TABLE_DATA_BEGIN) + sizeof(TABLE_DATA_END) + sizeof(SAMPLE_TEXT)) * (rows * cols)) / sizeof(char);
    char *outStr = (char *)malloc(size * sizeof(char));
    if (outStr == NULL)
    {
        printf("Error allocating memory");
        return EXIT_FAILURE;
    }
    memset(outStr, 0, size * sizeof(char));

    strcat(outStr, HTML_BEGIN);
    strcat(outStr, HTML_STYLE);
    strcat(outStr, HTML_END_STYLE);
    strcat(outStr, HELLO_WORLD);
    strcat(outStr, TABLE_BEGIN);

    for (unsigned int row = 0; row < rows; row++)
    {
        strcat(outStr, TABLE_ROW_BEGIN);
        for (unsigned int data = 0; data < cols; data++)
        {
            strcat(outStr, TABLE_DATA_BEGIN);
            strcat(outStr, SAMPLE_TEXT);
            strcat(outStr, TABLE_DATA_END);
        }
        strcat(outStr, TABLE_ROW_END);
    }

    strcat(outStr, TABLE_END);
    strcat(outStr, HTML_END);

    FILE *fp = fopen("index.html", "w");
    if (fp == NULL)
    {
        printf("Error opening the file");
        return EXIT_FAILURE;
    }
    fprintf(fp, "%s", outStr);
    fclose(fp);

    free(outStr);

    printf("Successfully created index.html");

    return EXIT_SUCCESS;
}
