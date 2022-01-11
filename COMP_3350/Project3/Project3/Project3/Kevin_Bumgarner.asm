; Author: Kevin Bumgarner
; Course: COMP 3350 - 001, Organization and Assembly Language
; Creation Date: 10/14/21
; Revisions: 5
; Help: reviewed Dr. Li's lectures and pdf for this project.

; Program Description: A program that will read a value from an array, 
;	and then place this value in another array with the location shifted by a certain amount. 
;	The array may be of any length from 2 to 100

; ***NOTE: When using hex numbers put an 'h' behind the number or else the computer will throw a non-digit build error

.386
.model flat, stdcall
.stack 4096
ExitProcess PROTO, dwExitCode:DWORD 

.data
	;Declare Variables Here......................................................
	
	; Create a DWORD variable with the label ‘shift’
	shift dword 3
	;Create a BYTE array with the label ‘input’
	input byte 5,0Ah,2,6,0Ch,9,4
	;Create a BYTE array with the label ‘output’
	output byte LENGTHOF input DUP (?)

.code
main PROC
	; Write Code Here............................................................

	; Set the values of the EAX, EBX, ECX, and EDX to 0
	xor eax, eax	; resets EAX to 0
	xor ebx, ebx	; resets EBX to 0
	xor ecx, ecx 	; resets ECX to 0
	xor edx, edx 	; resets EDX to 0

	; LOOP 1: Move the elements from input[(length of input - shift)....length of input] into the output array. 
	;	The length of output should be the size of value of shift after this first loop. 
	;	esi and edi are index registers. esi means 'starting index' and edi means 'destination index'. They are useful for this program.
	mov ecx, shift
	mov esi, LENGTHOF input
	mov edi, 0
	sub esi, shift
	L1:  
		mov al, input[esi]
		mov output[edi], al
		inc esi
		inc edi
	loop L1

	; Clear registers in preparation for second loop just to be safe. We do not want any lose ends.
    xor eax, eax	; resets EAX to 0
	xor ebx, ebx	; resets EBX to 0
	xor ecx, ecx 	; resets ECX to 0
	xor edx, edx 	; resets EDX to 0

	; LOOP 2: Move the elements in input[1....(input - shift)] into the remaining indexes in output. 
	;	edi holds the current index of output so it does not need to be set to 0.
	mov ecx, LENGTHOf input
	sub ecx, shift
	mov esi, 0
	L2:
		mov al, input[esi]
		mov output[edi], al
		inc esi
		inc edi
	loop L2

	INVOKE ExitProcess, 0
main ENDP
	;Additional Procedures Here..................................................
END main