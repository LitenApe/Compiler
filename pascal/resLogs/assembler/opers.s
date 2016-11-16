        .globl  main                    
main:
        call    prog$operatortest_1     # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
proc$testunaryboolean_2:
        enter   $32,$2                  # Start of testunaryboolean
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    4,%esp                  # Pop params.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    4,%esp                  # Pop params.
        leave                           # End of testunaryboolean
        ret                             
proc$testbinaryboolean_3:
        enter   $32,$2                  # Start of testbinaryboolean
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $1,%eax                 #   1
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        leave                           # End of testbinaryboolean
        ret                             
proc$testunarynumeric_4:
        enter   $32,$2                  # Start of testunarynumeric
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    4,%esp                  # Pop params.
        movl    $11,%eax                #   11
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    4,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    4,%esp                  # Pop params.
        leave                           # End of testunarynumeric
        ret                             
proc$testbinarynumeric_5:
        enter   $32,$2                  # Start of testbinarynumeric
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $11,%eax                #   11
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $11,%eax                #   11
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $11,%eax                #   11
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $11,%eax                #   11
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $17,%eax                #   17
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $11,%eax                #   11
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #1
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        movl    $0,%eax                 #   0
        pushl   %eax                    # Push param #2
        call    proc$_null              
        addl    8,%esp                  # Pop params.
        leave                           # End of testbinarynumeric
        ret                             
prog$operatortest_1:
        enter   $32,$1                  # Start of operatortest
        leave                           # End of operatortest
        ret                             
