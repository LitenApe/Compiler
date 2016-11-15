        .globl  main                    # --- program
main:
        call    prog$gcd_1              # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
func$gcd_2:
        enter   $32,$2                  #  start of gcd
        movl    -8(%ebp),%edx
        movl    12(%edx),%eax           # paramdecl (also line above): n
        pushl   %eax                    #  in Expression
        movl    $0,%eax                 #  numberliteral: 0
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        sete    %al                     #  in Expression: Test =
        cmpl    $0,%eax                 # --- if statm
        je      .L0003                  # --- if statm
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): m
        movl    -8(%ebp),%edx
        movl    %eax,-32(%edx)          #  In assignstatm (also line above): gcd :=
        jmp     .L0004                  # --- if statm
.L0003:
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): m
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    12(%edx),%eax           # paramdecl (also line above): n
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        pushl   %eax                    #  Funccall: Push param #2
        movl    -8(%ebp),%edx
        movl    12(%edx),%eax           # paramdecl (also line above): n
        pushl   %eax                    #  Funccall: Push param #1
        call    func$gcd_2
        addl    $8,%esp                 #  Pop parameters
        movl    -8(%ebp),%edx
        movl    %eax,-32(%edx)          #  In assignstatm (also line above): gcd :=
.L0004:
        movl    -32(%ebp),%eax          # --- func decl
        leave                           # --- func decl
        ret                             # --- func decl
prog$gcd_1:
        enter   $36,$1                  # Start of gcd
        movl    $462,%eax               #  numberliteral: 462
        pushl   %eax                    #  Funccall: Push param #2
        movl    $1071,%eax              #  numberliteral: 1071
        pushl   %eax                    #  Funccall: Push param #1
        call    func$gcd_2
        addl    $8,%esp                 #  Pop parameters
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): res :=
        movl    $71,%eax                #  charliteral: 	'G'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $67,%eax                #  charliteral: 	'C'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $68,%eax                #  charliteral: 	'D'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $40,%eax                #  charliteral: 	'('
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $1071,%eax              #  numberliteral: 1071
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $44,%eax                #  charliteral: 	','
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $462,%eax               #  numberliteral: 462
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $41,%eax                #  charliteral: 	')'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $61,%eax                #  charliteral: 	'='
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    -4(%ebp),%edx
        movl    -36(%edx),%eax          #  In vardecl (also line above): res
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $10,%eax                #  numberliteral: 10
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        leave                           # End of gcd--- program
        ret                             # --- program
