import java.io.IOException;
import java.io.InputStream;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.readInt();
        StringBuilder output = new StringBuilder();
        for (int t=0; t<T; t++) {
            int N = reader.readInt();
            String s = reader.readString(N);
            long[] C = reader.readLongArray(N);
            long[][] dp = new long[N+1][15];
            for (int n=1; n<=N; n++) {
                char c = s.charAt(n-1);
                long cost = C[n-1];
                // 0: R
                // 5: GR
                // 6: BR
                // 11: GBR
                // 12: BGR
                if (c == 'R') {
                    dp[n][0] = dp[n-1][0];
                    dp[n][5] = Math.min(dp[n-1][1],dp[n-1][5]);
                    dp[n][6] = Math.min(dp[n-1][2],dp[n-1][6]);
                    dp[n][11] = Math.min(dp[n-1][11],Math.min(dp[n-1][8],dp[n-1][1]));
                    dp[n][12] = Math.min(dp[n-1][12],Math.min(dp[n-1][4],dp[n-1][2]));
                } else {
                    dp[n][0] = dp[n-1][0]+cost;
                    dp[n][5] = Math.min(dp[n-1][1],dp[n-1][5])+cost;
                    dp[n][6] = Math.min(dp[n-1][2],dp[n-1][6])+cost;
                    dp[n][11] = Math.min(dp[n-1][11],Math.min(dp[n-1][8],dp[n-1][1]))+cost;
                    dp[n][12] = Math.min(dp[n-1][12],Math.min(dp[n-1][4],dp[n-1][2]))+cost;
                }
                // 1: G
                // 3: RG
                // 4: BG
                // 13: RBG
                // 14: BRG
                if (c == 'G') {
                    dp[n][1] = dp[n-1][1];
                    dp[n][3] = Math.min(dp[n-1][0],dp[n-1][3]);
                    dp[n][4] = Math.min(dp[n-1][2],dp[n-1][4]);
                    dp[n][13] = Math.min(dp[n-1][13],Math.min(dp[n-1][7],dp[n-1][0]));
                    dp[n][14] = Math.min(dp[n-1][14],Math.min(dp[n-1][6],dp[n-1][2]));
                } else {
                    dp[n][1] = dp[n-1][1]+cost;
                    dp[n][3] = Math.min(dp[n-1][0],dp[n-1][3])+cost;
                    dp[n][4] = Math.min(dp[n-1][2],dp[n-1][4])+cost;
                    dp[n][13] = Math.min(dp[n-1][13],Math.min(dp[n-1][7],dp[n-1][0]))+cost;
                    dp[n][14] = Math.min(dp[n-1][14],Math.min(dp[n-1][6],dp[n-1][2]))+cost;
                }
                // 2: B
                // 7: RB
                // 8: GB
                // 9: RGB
                // 10: GRB
                if (c == 'B') {
                    dp[n][2] = dp[n-1][2];
                    dp[n][7] = Math.min(dp[n-1][0],dp[n-1][7]);
                    dp[n][8] = Math.min(dp[n-1][1],dp[n-1][8]);
                    dp[n][9] = Math.min(dp[n-1][9],Math.min(dp[n-1][3],dp[n-1][0]));
                    dp[n][10] = Math.min(dp[n-1][10],Math.min(dp[n-1][5],dp[n-1][1]));
                } else {
                    dp[n][2] = dp[n-1][2]+cost;
                    dp[n][7] = Math.min(dp[n-1][0],dp[n-1][7])+cost;
                    dp[n][8] = Math.min(dp[n-1][1],dp[n-1][8])+cost;
                    dp[n][9] = Math.min(dp[n-1][9],Math.min(dp[n-1][3],dp[n-1][0]))+cost;
                    dp[n][10] = Math.min(dp[n-1][10],Math.min(dp[n-1][5],dp[n-1][1]))+cost;
                }
            }
            long min = Long.MAX_VALUE;
            for (long value : dp[N]) {
                min = Math.min(min, value);
            }
            output.append(min).append('\n');
        }
        System.out.print(output);
    }
 
    static final class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public final int readInt() throws IOException {
            return (int)readLong();
        }
 
        public final long readLong() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new IOException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }
 
        public final String readString(int length) throws IOException {
            char[] A = new char[length];
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new IOException();
            }
            A[0] = (char)c;
            for (int n=1; n<length; n++) {
                A[n] = (char)read();
            }
            return new String(A);
        }
 
        public final int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i=0; i<size; i++) {
                array[i] = readInt();
            }
            return array;
        }
 
        public final long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i=0; i<size; i++) {
                array[i] = readLong();
            }
            return array;
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
 
}
