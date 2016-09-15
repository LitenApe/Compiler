# get current path
curPath=$(pwd)
# set path for directories
resPath="$curPath/resLogs/scannerLog/"
fasPath="$curPath/testFF/"

# retrieve log files
resultater=$(ls resLogs/scannerLog)
fasit=$(ls testFF)

# make it into an array
resultater=$resultater | cut -d ' ' -f 1,2,3,4,5,6
fasit=$fasit | cut -d ' ' -f 1,2,3,4,5,6

# iterate through the files
for fas in $fasit; do
  for res in $resultater; do
    if [[ $res == $fas ]]; then
      echo "Double checking:" $fas
      diff "$resPath$res" "$fasPath$fas"
    fi
  done
done
