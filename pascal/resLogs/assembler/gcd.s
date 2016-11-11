        .globl  main                    # --- program
main:
                                        # --- program
        call    prog$gcd_1              # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
func$gcd_2:
                                        # --- func decl
        enter   $328,$2                 # --- func decl
        cmpl    $0,%eax                 # --- if statm
        je      .L0003                  # --- if statm
.L0003:
                                        # --- if statm
        jmp     .L0004                  # --- if statm
.L0004:
                                        # --- if statm
        call    func$gcd_2              # Call function --- func call
        pushl   %eax                    # Push next param. --- func call
        pushl   %eax                    # Push next param. --- func call
        addl    8,%esp                  # Pop param. --- func call
        movl    -32(%ebp),%eax          # --- func decl
        leave                           # --- func decl
        ret                             # --- func decl
prog$gcd_1:
                                        # --- program
        enter   $32,$1                  # Start of gcd--- program
        movl    $462,%eax               #   '462' --- number literal
        pushl   %eax                    # push param #2 --- const decl part
        movl    $1071,%eax              #   '1071' --- number literal
        pushl   %eax                    # push param #1 --- const decl part
        call    func$gcd_2              # Call function --- func call
        pushl   %eax                    # Push next param. --- func call
        pushl   %eax                    # Push next param. --- func call
        addl    8,%esp                  # Pop param. --- func call
        pushl   %eax                    # Push next param. --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        pushl   %eax                    # Push next param. --- proc call
        call    write_int               # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $61,%eax                #   '='  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $41,%eax                #   ')'  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        pushl   %eax                    # Push next param. --- proc call
        call    write_int               # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $44,%eax                #   ','  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        pushl   %eax                    # Push next param. --- proc call
        call    write_int               # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $40,%eax                #   '('  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $68,%eax                #   'D'  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $67,%eax                #   'C'  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        movl    $71,%eax                #   'G'  --- char literal
        pushl   %eax                    # Push next param. --- proc call
        call    write_char              # --- proc call
        addl    $4,%esp                 # Pop param. --- proc call
        leave                           # End of gcd--- program
        ret                             # --- program
