; Program Description:
; Author: Kevin Bumgarner
; Course: COMP 3350 - 001, Organization and Assembly Language
; Creation Date: 09/22/21
; Revisions: 3

.386
.model flat, stdcall
.stack 4096
ExitProcess PROTO, dwExitCode:DWORD 

.data
	; Declare Variables Here
	; Create a BYTE array with the label ‘input’
	input BYTE 1,2,3,4,5,6,7,8
	; Create a BYTE variable with the label ‘shift’
	shift BYTE 2

.code
main PROC
	; Set the values of the EAX, EBX, ECX, and EDX to 0
	xor eax, eax	; resets EAX to 0
	xor ebx, ebx	; resets EBX to 0
	xor ecx, ecx 	; resets ECX to 0
	xor edx, edx 	; resets EDX to 0

	; The first sums should be in high position of the AX register
	mov ah, [input]
	add ah, shift
	; The second sums should be in low position of the AX register
	mov al, [input+1]
	add al, shift
	; The third sums should be in high position of BX register
	mov bh, [input+2]
	add bh, shift
	; The fourth sums should be in low position of BX register
	mov bl, [input+3]
	add bl, shift
	; The fifth sums should be in high position of CX register
	mov ch, [input+4]
	add ch, shift
	; The sixth sums should be in low position of CX register
	mov cl, [input+5]
	add cl, shift
	; The seventh sums should be in high position of the DX register
	mov dh, [input+6]
	add dh, shift
	; The eighth sums should be in low position of the DX register
	mov dl, [input+7]
	add dl, shift

	INVOKE ExitProcess, 0
main ENDP
	; Additional Procedures Here
END main
