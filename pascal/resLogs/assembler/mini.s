# Code file created by Pascal2016 compiler 2016-11-10 11:30:01
        .global main                    
main:
        call    prog$mini_1             # start program
        movl    $0, %eax                # set return value
        ret                             # quit program
prog$mini_1:
        enter   $32, $1                 
        movl    $120, %eax              # moving x to eax
        pushl   %eax                    # pushing value on stack
        leave                           # end of mini
        ret                             
