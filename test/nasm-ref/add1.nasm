%include	'io.asm'

section	.bss
sinput:	resb	255	;reserve a 255 byte space in memory for the users input string

section	.text
global _start
_start:
	call	main	;
	mov	ebx,	0	;
	mov	eax,	1	;
	int 0x80	;
main :	push	ebp	;
	mov	ebp,	esp	;
	sub	esp,	0	;
	mov	eax,	3	;
	add	eax,	10	;
	mov	eax,	eax	;
	call	iprintLF	;
	add	esp,	0	;
	pop	ebp	;
	ret	;
