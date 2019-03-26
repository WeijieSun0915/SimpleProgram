# SimpleProgram
This program can implement a basic Chord DHT. The input format is as follows :
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
Output each key with its associated node and the successor table (i.e., finger table).
For the input above, your output should be
 0
 0 1 1
 1 2 2
 2 4 6
 1
 0 2 2
 1 3 6
 2 5 

This is a P2P network algorithm, peer joining torrent: 
has no chunks, but will accumulate them over time
registers with tracker to get list of peers and connects to its subset. (“neighbors”)
while downloading,  peer uploads chunks to other peers. 
peers may come and go: churn
once peer has entire file, it may (selfishly) leave or (altruistically) remain

inherently P2P: pairs of users communicate.
proprietary application-layer protocol (inferred via reverse engineering) 
hierarchical overlay with SNs
Index maps usernames to IP addresses; distributed over SNs

For DHT:
Motivation:
Frustrated by popularity of all these “half-baked” P2P apps 
Guaranteed lookup success for files in system
Provable bounds on search time
Provable scalability to millions of node
Distributed Hash Table (DHT)
For each object, node(s) whose range(s) cover that object must be reachable via a “short” path
# neighbors for each node should scale well (e.g., should not be O(N))
Fully distributed (no centralized bottleneck/single point of failure)
DHT mechanism should gracefully handle nodes joining/leaving 
need to repartition the range space over existing nodes
need to reorganize neighbor set
need bootstrap mechanism to connect new nodes into the existing DHT infrastructure

For Chord:
 Associate to each node and file a unique id in an uni-dimensional space (a Ring)
E.g., pick from the range [0...2m-1]
the hash of the file or  IP address
Properties:
Routing table size is O(log N) , where N is the total number of nodes
Guarantees that a file is found in O(log N) hops

Chord routing: Upon receiving a query for file id, a node first calculates the key (Hash id)
Checks whether stores the key locally
If not, forwards the query to the largest node in its successor table that does not exceed the key
