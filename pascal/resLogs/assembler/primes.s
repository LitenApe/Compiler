        .globl  main                    # --- program
main:
        call    prog$primes_1           # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
proc$findprimes_2:
        enter   $3232,$2                
        movl    $2,%eax                 #  numberliteral: 2
        movl    0(%ebp),%edx            
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): i1 :=
.L0003:
                                        # Start while-statement
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i1
        cmpl    $0,%eax                 # --- while statm
        je      .L0004                  # --- while statm
        movl    $2,%eax                 #  numberliteral: 2
        pushl   %eax                    # idk in genCode Term
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i1
        movl    %eax,%ecx               
        popl    %eax                    
        imull   %ecx,%eax               #  In Term: *
        movl    0(%ebp),%edx            
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): i2 :=
.L0005:
                                        # Start while-statement
        movl    0(%ebp),%edx            
        movl    -40(%edx),%eax          #  In vardecl (also line above): i2
        cmpl    $0,%eax                 # --- while statm
        je      .L0006                  # --- while statm
        movl    $0,%eax                 #  numberliteral: 0
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): prime :=
        movl    0(%ebp),%edx            
        movl    -40(%edx),%eax          #  In vardecl (also line above): i2
        pushl   %eax                    # idk in genCode Term
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    0(%ebp),%edx            
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): i2 :=
        jmp     .L0005                  # --- while statm
.L0006:
                                        # End while-statement
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i1
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    0(%ebp),%edx            
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): i1 :=
        jmp     .L0003                  # --- while statm
.L0004:
                                        # End while-statement
        leave                           # --- proc call
        ret                             # --- proc call
proc$p4_7:
        enter   $324,$2                 
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            # paramdecl (also line above): x
        pushl   %eax                    #  in Expression
        movl    $1000,%eax              #  numberliteral: 1000
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        setl    %al                     #  in Expression: Test <
        cmpl    $0,%eax                 # --- if statm
        je      .L0008                  # --- if statm
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
.L0008:
                                        # ---skfjslkdfjlskdj lwhat hawtha wht h ---->_>_>_>_>_>_> Stronger - By Kanye West
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            # paramdecl (also line above): x
        pushl   %eax                    #  in Expression
        movl    $100,%eax               #  numberliteral: 100
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        setl    %al                     #  in Expression: Test <
        cmpl    $0,%eax                 # --- if statm
        je      .L0009                  # --- if statm
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
.L0009:
                                        # ---skfjslkdfjlskdj lwhat hawtha wht h ---->_>_>_>_>_>_> Stronger - By Kanye West
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            # paramdecl (also line above): x
        pushl   %eax                    #  in Expression
        movl    $10,%eax                #  numberliteral: 10
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        setl    %al                     #  in Expression: Test <
        cmpl    $0,%eax                 # --- if statm
        je      .L0010                  # --- if statm
        movl    $32,%eax                #  charliteral: 	' '
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
.L0010:
                                        # ---skfjslkdfjlskdj lwhat hawtha wht h ---->_>_>_>_>_>_> Stronger - By Kanye West
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            # paramdecl (also line above): x
        pushl   %eax                    #  Proccall: Push next param.
        call    write_int               
        addl    $4,%esp                 #  Pop param.
        leave                           # --- proc call
        ret                             # --- proc call
proc$printprimes_11:
        enter   $3232,$2                
        movl    $2,%eax                 #  numberliteral: 2
        movl    0(%ebp),%edx            
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): i :=
        movl    $0,%eax                 #  numberliteral: 0
        movl    0(%ebp),%edx            
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): nprinted :=
.L0012:
                                        # Start while-statement
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i
        cmpl    $0,%eax                 # --- while statm
        je      .L0013                  # --- while statm
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #  In vardecl (also line above): prime
        cmpl    $0,%eax                 # --- if statm
        je      .L0014                  # --- if statm
        movl    0(%ebp),%edx            
        movl    -40(%edx),%eax          #  In vardecl (also line above): nprinted
        pushl   %eax                    # idk in genCode Term
        movl    0(%ebp),%edx            
        movl    -40(%edx),%eax          #  In vardecl (also line above): nprinted
        pushl   %eax                    # idk in genCode Term
        movl    $10,%eax                #  numberliteral: 10
        movl    %eax,%ecx               
        popl    %eax                    
        cdq                             
        idivl   %ecx                    
        movl    %edx,%eax               #  mod
        pushl   %eax                    #  in Expression
        movl    $0,%eax                 #  numberliteral: 0
        popl    %ecx                    #  in Expression
        cmpl    %eax,%ecx               # in Expression
        movl    $0,%eax                 # idk
        sete    %al                     #  in Expression: Test =
        cmpl    $0,%eax                 # --- if statm
        je      .L0015                  # --- if statm
        movl    $10,%eax                #  numberliteral: 10
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
.L0015:
                                        # ---skfjslkdfjlskdj lwhat hawtha wht h ---->_>_>_>_>_>_> Stronger - By Kanye West
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i
        pushl   %eax                    #  Proccall: Push next param.
        addl    4,%esp                  #  Pop param.
        movl    0(%ebp),%edx            
        movl    -40(%edx),%eax          #  In vardecl (also line above): nprinted
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    0(%ebp),%edx            
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): nprinted :=
.L0014:
                                        # ---skfjslkdfjlskdj lwhat hawtha wht h ---->_>_>_>_>_>_> Stronger - By Kanye West
        movl    0(%ebp),%edx            
        movl    -36(%edx),%eax          #  In vardecl (also line above): i
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    0(%ebp),%edx            
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): i :=
        jmp     .L0012                  # --- while statm
.L0013:
                                        # End while-statement
        movl    $10,%eax                #  numberliteral: 10
        pushl   %eax                    #  Proccall: Push next param.
        call    write_char              
        addl    $4,%esp                 #  Pop param.
        leave                           # --- proc call
        ret                             # --- proc call
prog$primes_1:
        enter   $40,$1                  # Start of primes
        movl    $2,%eax                 #  numberliteral: 2
        movl    -4(%ebp),%edx           
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): i :=
.L0016:
                                        # Start while-statement
        movl    -4(%ebp),%edx           
        movl    -40(%edx),%eax          #  In vardecl (also line above): i
        cmpl    $0,%eax                 # --- while statm
        je      .L0017                  # --- while statm
        movl    $1,%eax                 #  numberliteral: 1
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          #  In assignstatm (also line above): prime :=
        movl    -4(%ebp),%edx           
        movl    -40(%edx),%eax          #  In vardecl (also line above): i
        pushl   %eax                    # idk in genCode Term
        movl    $1,%eax                 #  numberliteral: 1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               # In simpleexpr adding
        movl    -4(%ebp),%edx           
        movl    %eax,-40(%edx)          #  In assignstatm (also line above): i :=
        jmp     .L0016                  # --- while statm
.L0017:
                                        # End while-statement
        leave                           # End of primes--- program
        ret                             # --- program
