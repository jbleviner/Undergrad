
#include <stdio.h>

int main(int argc, char *argv[], char *envp[]) {
   int i;
   char buffer[201]; 

   //setvbuf(stdout, NULL, _IONBF, 0);

   printf("test.cpp\n\n");
   printf("environment:\n");
   for(i = 0; envp[i]; i++)
      printf("%s\n", envp[i]);
   printf("\n");
   for(i = 0; i < 5; i++) {
      printf("Enter line %d: ", i);
      fgets(buffer, 200, stdin);
      printf("Line %d: %s\n", i, buffer);
   }
   printf("Done - exit value will be 81\n");

   return 81;
}
