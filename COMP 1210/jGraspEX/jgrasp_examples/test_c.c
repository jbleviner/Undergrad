#include <stdio.h>

int main(int argc, char *argv[], char *envp[]) {
   int i;
   char buffer[201];
   //test
   //setvbuf(stdout, NULL, _IONBF, 0);
   printf("test.c\n\n");
   printf("arguments: %d\n", argc);
   for(i = 0; i < argc; i++)
      printf("%s\n", argv[i]);
   printf("\nenvironment:\n");
   for(i = 0; envp[i]; i++)
      printf("%s\n", envp[i]);
   printf("\n");
   for(i = 0; i < 5; i++) {
      printf("Enter line %d: ", i);
      fgets(buffer, 200, stdin);
      printf("Line %d: %s\n", i, buffer);
   }
   printf("Done - exit value will be 23\n");

   return 23;
}
