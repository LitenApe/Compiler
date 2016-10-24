/* Et minimalt Pascal-program */
program Mini;
var res: integer;
const a = 0;

function test (m: integer): integer;
begin
   if a = 0 then
      res := test(1);
   else
      res := test(0);
end;

begin
  res := test(5);
  write('G', 'C', 'D', '(', v1, ',', v2, ')', '=', res, eol);
end.
