        .globl  main                    # --- program
main:
        call    prog$tenstars_1         # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
prog$tenstars_1:
        enter   $36,$1                  # Start of tenstars
        movl    $0,%eax                 #  numberliteral: 0
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): i :=
.L0002:
                                        # Start while-statement
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #  In vardecl (also line above): i
        pushl   %eax                    #  in Expression
        movl    $10,%eax                #  numberliteral: 10
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        setl    %al                     #  in Expression: Test <
        cmpl    $0,%eax                 # --- while statm
        je      .L0003                  # --- while statm
        movl    $42,%eax                #  charliteral: 	'*'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #  In vardecl (also line above): i
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): i :=
        jmp     .L0002                  # --- while statm
.L0003:
                                        # End while-statement
        movl    $10,%eax                #  numberliteral: 10
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
        leave                           # End of tenstars--- program
        ret                             # --- program
