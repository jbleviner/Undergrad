import sys
import os

# Python 2 example program.
# Select the "Python 2" compiler environment in jGRASP
# to run this file.
def main():
   print ('test_python2.py\n')
   
   for var,val in os.environ.items():
      print (var + '=' + val)
      
   print 
   for i in xrange(5):
      print ('Enter line %d:' % (i)),
      line = raw_input()
      print ('Line %d: %s\n' % (i, line))
      
   print ('Done - exit value will be 81')
   sys.exit(81)
   
if __name__=='__main__':
   main()
