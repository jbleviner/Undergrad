
.model small
.386
.stack 100h
.data
   startprompt  db "test.asm",0dh,0ah,0dh,0ah,'$'
   prompt       db "Enter line X: $"
   response     db 0dh,0ah,"Line X: $"
   buffer       db 200 dup('0'),'$' ;input buffer
   nl           db 0dh,0ah,'$'                       
   endprompt    db "Done - exit value will be 12",0ah,'$'

.code
.startup

   mov dx, offset startprompt
   mov ah, 09h
   int 21h

   mov bl, '0'
L1:   mov prompt[11], bl
      mov response[7], bl

      mov dx, offset prompt
      mov ah, 09h
      int 21h

      mov dx, offset buffer
      mov buffer, 200
      mov ah, 0ah
      int 21h

      mov dx, offset response
      mov ah, 09h
      int 21h

      mov dl, buffer[1]
      mov dh, 0
      mov di, dx
      add di, 2
      mov buffer[di], 0dh
      inc di
      mov buffer[di], 0ah
      inc di
      mov buffer[di], 0dh
      inc di
      mov buffer[di], 0ah
      inc di
      mov buffer[di], '$'

      mov dx, offset buffer
      add dx, 2
      mov ah, 09h
      int 21h

      inc bl
      cmp bl, '5'
      jnz L1

   mov dx, offset endprompt
   mov ah, 09h
   int 21h

   mov ax, 12

.exit

end

