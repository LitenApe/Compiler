        .globl  main                    # --- program
main:
        call    prog$tenstars_1         # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
prog$tenstars_1:
        enter   $36,$1                  # Start of tenstars
        movl    $0,%eax                 #   '0' --- number literal
        movl    -4(%ebp),%edx           # ____________________________________i
        movl    %eax,-36(%edx)          # ________________________________________null
.L0002:
                                        # Start while-statement
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -36(%edx),%eax          # --- move variable into eax
        pushl   %eax                    # First on right of = 
        movl    $10,%eax                #   '10' --- number literal
        popl    %ecx                    # Second part of = in to ecx
        cmpl    %eax,%ecx               # compare
        movl    $0,%eax                 # idk
        setl    %al                     # idk
        cmpl    $0,%eax                 # --- while statm
        je      .L0003                  # --- while statm
        movl    $42,%eax                #   '*'  --- char literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        movl    -4(%ebp),%edx           # ----Getting variable in variable: 
        movl    -36(%edx),%eax          # --- move variable into eax
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #   '1' --- number literal
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -4(%ebp),%edx           # ____________________________________i
        movl    %eax,-36(%edx)          # ________________________________________null
        jmp     .L0002                  # --- while statm
.L0003:
                                        # End while-statement
        movl    $10,%eax                #   '0' --- number literal
        pushl   %eax                    # Push next param. --- proc call: write
        call    write_char              # --- proc call: write
        addl    $4,%esp                 # Pop param. --- proc call: write
        leave                           # End of tenstars--- program
        ret                             # --- program
