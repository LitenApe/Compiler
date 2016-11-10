        .globl  main                    
main:
        call    prog$easter_1           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$easter_1:
        enter   $32,$1                  # Start of easter
.L0003:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0004                  
        jmp     .L0003                  
.L0004:
                                        # End while-statement
        leave                           # End of easter
        ret                             
