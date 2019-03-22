# SimpleProgram
It can Implement a basic Chord DHT. The input format is as follows :
 S //Hash space [0…S] S=2^K-1 for some integer K (<10)
 N //Number of nodes
 M //Number of keys
 id1, id2, …, idN //Hashed node ids, joined in order
k1,k2,…,kM //Hashed keys, joined in order
-1,-1 //end
 For slides Application Layer 2: 51-55, the input will be
 7
 4
 2
 1,2,0,6
 7,1
 -1,-1
 For each key, output its associated node and the successor table (i.e., finger table).
For the input above, your output should be
 0
 0 1 1
 1 2 2
 2 4 6
 1
 0 2 2
 1 3 6
 2 5 
