#! /bin/bash

# solution 1
tail -n+10 file.txt|head -1

# solution 2
i=0
while ((i++ < 10))
do
  read line
done < file.txt
echo $line