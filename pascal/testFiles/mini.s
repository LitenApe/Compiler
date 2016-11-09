# Code file created by Pascal2016 compiler 2016-11-09 13:37:43
        .global main                    
main:
        call    prog$mini               # start program
        movl    $0, %eax                # set return value
        ret                             # quit program
prog$mini:
