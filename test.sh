javac -encoding UTF-8 -d . *.java
totalRound=2

for ((i=1;i<=totalRound;i++))
do
    java BeeFarming totalRound=$totalRound outputFilename=output
done