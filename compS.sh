# get current path
curPath=$(pwd)
# set path for directories
resPath="$curPath/pascal/resLogs/scannerLog/"
fasPath="$curPath/pascal/testFF/scanner/"

# scanner
# retrieve log files
resultater=$(ls $resPath)
fasit=$(ls $fasPath)

# make it into an array
resultater=$resultater | cut -d ' ' -f 1,2,3,4,5,6
fasit=$fasit | cut -d ' ' -f 1,2,3,4,5,6

# iterate through the files
echo ""
echo "TESTING SCANNER LOGS"
for fas in $fasit; do
  for res in $resultater; do
    if [[ $res == $fas ]]; then
      tester="$(diff -b "$resPath$res" "$fasPath$fas")"
      if [[ ${#tester} -eq 0 ]]; then
        echo "Passed:" $fas
      else
        echo "Failed:" $fas
      fi
    fi
  done
done

resPath="$curPath/pascal/resLogs/parserLog/"
fasPath="$curPath/pascal/testFF/parser/"

# parser
# retrieve log files
resultater=$(ls $resPath)
fasit=$(ls $fasPath)

# make it into an array
resultater=$resultater | cut -d ' ' -f 1,2,3,4,5,6
fasit=$fasit | cut -d ' ' -f 1,2,3,4,5,6

echo ""
echo "TESTING PARSER LOGS"
for fas in $fasit; do
  for res in $resultater; do
    if [[ $res == $fas ]]; then
      tester="$(diff -b "$resPath$res" "$fasPath$fas")"
      if [[ ${#tester} -eq 0 ]]; then
        echo "Passed:" $fas
      else
        echo "Failed:" $fas
      fi
    fi
  done
done

resPath="$curPath/pascal/resLogs/checkerLog/"
fasPath="$curPath/pascal/testFF/checker/"

# checker
# retrieve log files
resultater=$(ls $resPath)
fasit=$(ls $fasPath)

# make it into an array
resultater=$resultater | cut -d ' ' -f 1,2,3,4,5,6
fasit=$fasit | cut -d ' ' -f 1,2,3,4,5,6

echo ""
echo "TESTING CHECKER LOGS"
for fas in $fasit; do
  for res in $resultater; do
    if [[ $res == $fas ]]; then
      tester="$(diff -b "$resPath$res" "$fasPath$fas")"
      if [[ ${#tester} -eq 0 ]]; then
        echo "Passed:" $fas
      else
        echo "Failed:" $fas
      fi
    fi
  done
done
