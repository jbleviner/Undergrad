import sys
import os

# Python 3 example program.
# Use the default "Python 3" compiler environment in jGRASP
# to run this file.
def main():
   print('test_python3.py\n')
   
   for var,val in os.environ.items():
      print(var + '=' + val)
      
   print 
   for i in range(5):
      print('Enter line %d:' % (i),)
      line = input()
      print('Line %d: %s\n' % (i, line))
      
   print('Done - exit value will be 81')
   sys.exit(81)
   
if __name__=='__main__':
   main()
