        .globl  main                    # --- program
main:
        call    prog$easter_1           # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
proc$easter_2:
        enter   $324,$2
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): y
        pushl   %eax                    # idk in genCode Term
        movl    $19,%eax                #  numberliteral: 19
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        movl    -8(%ebp),%edx
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): a :=
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): y
        pushl   %eax                    # idk in genCode Term
        movl    $100,%eax               #  numberliteral: 100
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): b :=
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): y
        pushl   %eax                    # idk in genCode Term
        movl    $100,%eax               #  numberliteral: 100
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        movl    -8(%ebp),%edx
        movl    %eax,-44(%edx)          #  In assignstatm (also line above): c :=
        movl    -8(%ebp),%edx
        movl    -40(%edx),%eax          #  In vardecl (also line above): b
        pushl   %eax                    # idk in genCode Term
        movl    $4,%eax                 #  numberliteral: 4
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-48(%edx)          #  In assignstatm (also line above): d :=
        movl    -8(%ebp),%edx
        movl    -40(%edx),%eax          #  In vardecl (also line above): b
        pushl   %eax                    # idk in genCode Term
        movl    $4,%eax                 #  numberliteral: 4
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        movl    -8(%ebp),%edx
        movl    %eax,-52(%edx)          #  In assignstatm (also line above): e :=
        movl    -8(%ebp),%edx
        movl    -40(%edx),%eax          #  In vardecl (also line above): b
        pushl   %eax                    # idk in genCode Term
        movl    $8,%eax                 #  numberliteral: 8
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        pushl   %eax                    # idk in genCode Term
        movl    $25,%eax                #  numberliteral: 25
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-56(%edx)          #  In assignstatm (also line above): f :=
        movl    -8(%ebp),%edx
        movl    -40(%edx),%eax          #  In vardecl (also line above): b
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -56(%edx),%eax          #  In vardecl (also line above): f
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        subl    %ecx,%eax               # In simpleexpr subtracting
        movl    $1,%eax                 #  numberliteral: 1
        pushl   %eax                    # idk in genCode Term
        movl    $3,%eax                 #  numberliteral: 3
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-60(%edx)          #  In assignstatm (also line above): g :=
        movl    $19,%eax                #  numberliteral: 19
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -36(%edx),%eax          #  In vardecl (also line above): a
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -40(%edx),%eax          #  In vardecl (also line above): b
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -8(%ebp),%edx
        movl    -48(%edx),%eax          #  In vardecl (also line above): d
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -60(%edx),%eax          #  In vardecl (also line above): g
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        subl    %ecx,%eax               # In simpleexpr subtracting
        movl    $15,%eax                #  numberliteral: 15
        pushl   %eax                    # idk in genCode Term
        movl    $30,%eax                #  numberliteral: 30
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        movl    -8(%ebp),%edx
        movl    %eax,-64(%edx)          #  In assignstatm (also line above): h :=
        movl    -8(%ebp),%edx
        movl    -44(%edx),%eax          #  In vardecl (also line above): c
        pushl   %eax                    # idk in genCode Term
        movl    $4,%eax                 #  numberliteral: 4
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-68(%edx)          #  In assignstatm (also line above): i :=
        movl    -8(%ebp),%edx
        movl    -44(%edx),%eax          #  In vardecl (also line above): c
        pushl   %eax                    # idk in genCode Term
        movl    $4,%eax                 #  numberliteral: 4
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        movl    -8(%ebp),%edx
        movl    %eax,-72(%edx)          #  In assignstatm (also line above): k :=
        movl    $32,%eax                #  numberliteral: 32
        pushl   %eax                    # idk in genCode Term
        movl    $2,%eax                 #  numberliteral: 2
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -52(%edx),%eax          #  In vardecl (also line above): e
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    $2,%eax                 #  numberliteral: 2
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -68(%edx),%eax          #  In vardecl (also line above): i
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -64(%edx),%eax          #  In vardecl (also line above): h
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -8(%ebp),%edx
        movl    -72(%edx),%eax          #  In vardecl (also line above): k
        pushl   %eax                    # idk in genCode Term
        movl    $7,%eax                 #  numberliteral: 7
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        movl    -8(%ebp),%edx
        movl    %eax,-76(%edx)          #  In assignstatm (also line above): l :=
        movl    -8(%ebp),%edx
        movl    -36(%edx),%eax          #  In vardecl (also line above): a
        pushl   %eax                    # idk in genCode Term
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -64(%edx),%eax          #  In vardecl (also line above): h
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    $22,%eax                #  numberliteral: 22
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -76(%edx),%eax          #  In vardecl (also line above): l
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    $451,%eax               #  numberliteral: 451
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-80(%edx)          #  In assignstatm (also line above): m :=
        movl    -8(%ebp),%edx
        movl    -64(%edx),%eax          #  In vardecl (also line above): h
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -76(%edx),%eax          #  In vardecl (also line above): l
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    $7,%eax                 #  numberliteral: 7
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -80(%edx),%eax          #  In vardecl (also line above): m
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    $114,%eax               #  numberliteral: 114
        movl    %eax,%ecx
        popl    %eax
        subl    %ecx,%eax               # In simpleexpr subtracting
        pushl   %eax                    # idk in genCode Term
        movl    $31,%eax                #  numberliteral: 31
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    -8(%ebp),%edx
        movl    %eax,-84(%edx)          #  In assignstatm (also line above): month :=
        movl    -8(%ebp),%edx
        movl    -64(%edx),%eax          #  In vardecl (also line above): h
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -76(%edx),%eax          #  In vardecl (also line above): l
        pushl   %eax                    # idk in genCode Term
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    $7,%eax                 #  numberliteral: 7
        pushl   %eax                    # idk in genCode Term
        movl    -8(%ebp),%edx
        movl    -80(%edx),%eax          #  In vardecl (also line above): m
        movl    %eax,%ecx
        popl    %eax
        imull   %ecx,%eax               #  In Term: *
        pushl   %eax                    # idk in genCode Term
        movl    $114,%eax               #  numberliteral: 114
        movl    %eax,%ecx
        popl    %eax
        subl    %ecx,%eax               # In simpleexpr subtracting
        pushl   %eax                    # idk in genCode Term
        movl    $31,%eax                #  numberliteral: 31
        movl    %eax,%ecx
        popl    %eax
        cdq
        idivl   %ecx
        movl    %edx,%eax               #  mod
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -8(%ebp),%edx
        movl    %eax,-88(%edx)          #  In assignstatm (also line above): day :=
        movl    -8(%ebp),%edx
        movl    -84(%edx),%eax          #  In vardecl (also line above): month
        pushl   %eax                    #  in Expression
        movl    $3,%eax                 #  numberliteral: 3
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        sete    %al                     #  in Expression: Test =
        cmpl    $0,%eax                 # --- if statm
        je      .L0003                  # --- if statm
        movl    -8(%ebp),%edx
        movl    -88(%edx),%eax          #  In vardecl (also line above): day
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $77,%eax                #  charliteral: 	'M'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $97,%eax                #  charliteral: 	'a'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $114,%eax               #  charliteral: 	'r'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $99,%eax                #  charliteral: 	'c'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $104,%eax               #  charliteral: 	'h'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): y
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $10,%eax                #  numberliteral: 10
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        jmp     .L0004                  # --- if statm
.L0003:
        movl    -8(%ebp),%edx
        movl    -88(%edx),%eax          #  In vardecl (also line above): day
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $65,%eax                #  charliteral: 	'A'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $112,%eax               #  charliteral: 	'p'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $114,%eax               #  charliteral: 	'r'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $105,%eax               #  charliteral: 	'i'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $108,%eax               #  charliteral: 	'l'
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
        movl    -8(%ebp),%edx
        movl    8(%edx),%eax            # paramdecl (also line above): y
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int
        addl    $4,%esp                 #  Pop param.
        movl    $10,%eax                #  numberliteral: 10
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char
        addl    $4,%esp                 #  Pop param.
.L0004:
        leave                           # --- proc call
        ret                             # --- proc call
prog$easter_1:
        enter   $36,$1                  # Start of easter
        movl    $2010,%eax              #  numberliteral: 2010
        movl    -4(%ebp),%edx
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): y :=
.L0005:
                                        # Start while-statement
        movl    -4(%ebp),%edx
        movl    -36(%edx),%eax          #  In vardecl (also line above): y
        cmpl    $0,%eax                 # --- while statm
        je      .L0006                  # --- while statm
        movl    -4(%ebp),%edx
        movl    -36(%edx),%eax          #  In vardecl (also line above): y
        pushl   %eax                    #  Proccall: Push next param.
        addl    4,%esp                  #  Pop param.
        movl    -4(%ebp),%edx
        movl    -36(%edx),%eax          #  In vardecl (also line above): y
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx
        popl    %eax
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -4(%ebp),%edx
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): y :=
        jmp     .L0005                  # --- while statm
.L0006:
                                        # End while-statement
        leave                           # End of easter--- program
        ret                             # --- program
