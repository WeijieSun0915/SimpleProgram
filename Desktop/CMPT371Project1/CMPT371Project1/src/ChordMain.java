import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChordMain {
    private int S, N, M, fingersize;
    private int[] ids, keys;
    private ChordNode[] chordNodes;
    public ChordMain() {
        System.out.println("Please input a file name:");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        loadData(filename);
    }

    // loading data
    private void loadData(String path) {
        File desfile=new File(path.replace(".in", ".out"));
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            S = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            chordNodes = new ChordNode[S + 1];
            for (int i = 0; i <= S; i++) {
                chordNodes[i] = null;
            }
            line = br.readLine();
            ids = new int[N];
            String[] buf = line.split(",");
            for (int i = 0; i < N; i++) {

                ids[i] = Integer.parseInt(buf[i]);
            }
            line = br.readLine();
            keys = new int[M];
            buf = line.split(",");
            for (int i = 0; i < M; i++) {
                keys[i] = Integer.parseInt(buf[i]);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fingersize = (int) (0.5 + Math.log10(S + 1) / Math.log10(2));

        // init
        for (int i = 0; i < N; i++) {
            chordNodes[ids[i]] = new ChordNode(ids[i], fingersize);

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < fingersize; j++) {
                for (int n = 0; n <= S; n++) {
                    if (chordNodes[(n
                            + chordNodes[ids[i]].fingertable[j][0])%(S+1)] != null)
                    {
                        chordNodes[ids[i]].fingertable[j][1] = (n
                                + chordNodes[ids[i]].fingertable[j][0])%(S+1);
                        break;
                    }
                }
            }
        }
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(desfile));
            for (int i = 0; i < M; i++) {
                for (int n = 0; n <= S; n++) {
                    if (chordNodes[(n + keys[i])%(S+1)] != null) {

                        bw.write(chordNodes[(n + keys[i])%(S+1)].printinfo());
                        break;
                    }
                }
                ;
            }
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

