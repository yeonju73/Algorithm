import java.io.*;

public class Main_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int studentNum = 30;
        int summitNum = 28;

        int[] array = new int[studentNum];

        for (int i = 0; i < summitNum; i++){
            int student = Integer.parseInt(bufferedReader.readLine());
            array[student-1]++;
        }
        for (int i = 0; i < studentNum; i++){
            if (array[i] == 0)
                bufferedWriter.write((i+1)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
