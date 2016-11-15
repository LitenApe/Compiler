        .globl  main                    # --- program
main:
        call    prog$operatortest_1     # Start program --- program
        movl    $0,%eax                 # Set status 0 and --- program
        ret                             # terminate the program --- program
proc$testunaryboolean_2:
        enter   $32,$2                  
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    4,%esp                  #  Pop param.
        movl    $1,%eax                 #  numberliteral: 1
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    4,%esp                  #  Pop param.
        leave                           # --- proc call
        ret                             # --- proc call
proc$testbinaryboolean_3:
        enter   $32,$2                  
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $1,%eax                 #  numberliteral: 1
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $1,%eax                 #  numberliteral: 1
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $1,%eax                 #  numberliteral: 1
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $1,%eax                 #  numberliteral: 1
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        leave                           # --- proc call
        ret                             # --- proc call
proc$testunarynumeric_4:
        enter   $32,$2                  
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    4,%esp                  #  Pop param.
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    4,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    4,%esp                  #  Pop param.
        leave                           # --- proc call
        ret                             # --- proc call
proc$testbinarynumeric_5:
        enter   $32,$2                  
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $17,%eax                #  numberliteral: 17
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $11,%eax                #  numberliteral: 11
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        movl    $0,%eax                 #  numberliteral: 0
        pushl   %eax                    #  Proccall: Push next param.
        call    proc$_null              
        addl    8,%esp                  #  Pop param.
        leave                           # --- proc call
        ret                             # --- proc call
prog$operatortest_1:
        enter   $32,$1                  # Start of operatortest
        leave                           # End of operatortest--- program
        ret                             # --- program
