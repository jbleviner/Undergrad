
CHARACTER*200 LINE

PRINT '(A)', 'test.for'
PRINT '(A)', ''

DO 10 I = 1, 5
   PRINT '(A, I1, A $)', 'Enter line ', I, ': '
   READ '(A)', LINE
   PRINT '(A, I1, A, A)', 'line ', I, ': ', LINE
   PRINT '(A)', ''
10 CONTINUE

END