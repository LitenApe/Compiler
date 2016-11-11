        .globl  main
main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$gcd_1:
        enter   $32,$1                  # Start of gcd
        movl    $462,%eax               #   '462'
        pushl   %eax                    # push param #11
        movl    $1071,%eax              #   '1071'
        pushl   %eax                    # push param #01
        pushl   %eax                    # Push next param.
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        movl    $41,%eax                #   ')'
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ','
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $40,%eax                #   '('
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        movl    $68,%eax                #   'D'
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        movl    $67,%eax                #   'C'
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        movl    $71,%eax                #   'G'
        pushl   %eax                    # Push next param.
        call    write_char
        addl    $4,%esp                 # Pop param.
        leave                           # End of gcd
        ret
