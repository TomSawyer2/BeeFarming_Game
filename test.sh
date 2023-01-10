#javac -encoding UTF-8 -d . *.java
#totalRound=2
#
#for ((i=1;i<=totalRound;i++))
#do
#    echo "$i"/4 >> ./Result/roundinfo
#    java BeeFarming totalRound=$totalRound outputFilename=output currentRound="$i"
#done
echo $1