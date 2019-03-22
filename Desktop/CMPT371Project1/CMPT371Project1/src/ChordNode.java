import java.util.Map;

public class ChordNode {
    public int nodeId,ChordKey,successor,predecessor,M,size;

    public int[][] fingertable;
    public ChordNode(int id,int fingersize)
    {
        nodeId=id;
        M=fingersize;
        size=1<<M;
        fingertable=new int[fingersize][2];

        for(int i=0;i<M;i++)
        {
            fingertable[i][0]=(nodeId+(1<<i))%size;

        }
    }
    public String printinfo()
    {
        String info=nodeId+"\n";
        for(int i=0;i<M;i++)
        {
            info=info+i+" "+fingertable[i][0]+" " +fingertable[i][1]+"\n";
        }
        System.out.println(info);
        return info;
    }

}
