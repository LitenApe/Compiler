        .globl  main                    # --- program
main:
                                        # --- program
        call    prog$gcd_1              # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
func$gcd_2:
                                        # --- func decl
        enter   $32,$2                  # --- func decl
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -32(%edx),%eax          # --- move variable into eax
        pushl   %eax                    # First on right of = 
        movl    $0,%eax                 #   '0' --- number literal
        popl    %ecx                    # Second part of = in to ecx
        cmpl    %eax,%ecx               # compare
        movl    $0,%eax                 # idk
        sete    %al                     # idk
        cmpl    $0,%eax                 # --- if statm
        je      .L0003                  # --- if statm
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -32(%edx),%eax          # --- move variable into eax
        movl    -8(%ebp),%edx           # ____________________________________gcd
        movl    %eax,-32(%edx)          # ________________________________________null
        je      .L0004                  # --- if statm
.L0003:
                                        # --- if statm stuff sdfbsldfhl
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -32(%edx),%eax          # --- move variable into eax
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -32(%edx),%eax          # --- move variable into eax
        pushl   %eax                    # Push next param. --- func call: gcd
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -32(%edx),%eax          # --- move variable into eax
        pushl   %eax                    # Push next param. --- func call: gcd
        call    func$gcd_2              # Call function --- func call: gcd
        addl    $8,%esp                 # Pop param. --- func call: gcd
        movl    -8(%ebp),%edx           # ____________________________________gcd
        movl    %eax,-32(%edx)          # ________________________________________null
.L0004:
                                        # --- if statm secoindsf stuff
        movl    -32(%ebp),%eax          # --- func decl
        leave                           # --- func decl
        ret                             # --- func decl
prog$gcd_1:
                                        # --- program
        enter   $36,$1                  # Start of gcd--- program
        movl    $462,%eax               #   '462' --- number literal
        pushl   %eax                    # Push next param. --- func call: gcd
        movl    $1071,%eax              #   '1071' --- number literal
        pushl   %eax                    # Push next param. --- func call: gcd
        call    func$gcd_2              # Call function --- func call: gcd
        addl    $8,%esp                 # Pop param. --- func call: gcd
        movl    -4(%ebp),%edx           # ____________________________________res
        movl    %eax,-36(%edx)          # ________________________________________null
        movl    $71,%eax                #   'G'  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $67,%eax                #   'C'  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $68,%eax                #   'D'  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $40,%eax                #   '('  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $1071,%eax              #   '1071' --- number literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_int               # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $44,%eax                #   ','  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $462,%eax               #   '462' --- number literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_int               # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $41,%eax                #   ')'  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $61,%eax                #   '='  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -36(%edx),%eax          # --- move variable into eax
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_int               # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    $10,%eax                #   '0' --- number literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        leave                           # End of gcd--- program
        ret                             # --- program