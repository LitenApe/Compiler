        .globl  main                    # --- program
main:
                                        # --- program
        call    prog$gcd_1              # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
func$gcd_2:
                                        # --- func decl
        enter   $328,$2                 # --- func decl
        cmpl    $0,%eax                 
        je      .L0003                  
.L0003:
        jmp     .L0004                  
.L0004:
        pushl   %eax                    # Push next param. --- func call
        pushl   %eax                    # Push next param. --- func call
        call    gcd_2                   # Call function --- func call
        addl    8,%esp                  # Pop param. --- func call
        movl    -32(%ebp),%eax          # --- func decl
        leave                           # --- func decl
        ret                             # --- func decl
prog$gcd_1:
                                        # --- program
        enter   $32,$1                  # Start of gcd--- program
        pushl   %eax                    # Push next param. --- func call
        pushl   %eax                    # Push next param. --- func call
        call    gcd_2                   # Call function --- func call
        addl    8,%esp                  # Pop param. --- func call
        pushl   %eax                    # Push next param.
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $41,%eax                #   ')'  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ','  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $40,%eax                #   '('  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $68,%eax                #   'D'  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $67,%eax                #   'C'  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $71,%eax                #   'G'  --- char literal
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of gcd--- program
        ret                             # --- program
