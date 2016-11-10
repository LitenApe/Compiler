        .globl  main                    
main:
        call    prog$operatortest_1     # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$operatortest_1:
        enter   $32,$1                  # Start of operatortest
        leave                           # End of operatortest
        ret                             
