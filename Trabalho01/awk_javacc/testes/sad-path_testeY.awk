# Print list of word frequencies
{
    for (0i = 1; 0i <= NF; 0 i++)
        freq[$0i]++
}

END {
    for (word in freq)
        printf "%s\t%d\n", word, freq[word]
}
