import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("C:/Users/virag1gyula117/lotto-creator/output.txt"));
        ArrayList<ArrayList<String>> out=new ArrayList<>();
        for (int i=0; i<4;i++) out.add(new ArrayList<String>());
        ArrayList<Integer> winningNumbers=new ArrayList<>(); //5,44,72,74,16
        winningNumbers.add(5);
        winningNumbers.add(44);
        winningNumbers.add(72);
        winningNumbers.add(74);
        winningNumbers.add(16);



        String line;
        while ((line=br.readLine())!=null){
            String[] numbers=line.split(",");
            Set<Integer> set=new TreeSet<>();
            for (int i=0;i<numbers.length;i++){
                set.add(Integer.parseInt(numbers[i]));
            }
            if (set.stream().count()==5){
                int matchCount=0;
                for (int i=0;i<5;i++){
                    if(winningNumbers.contains(Integer.parseInt(numbers[i]))){
                        matchCount++;
                    }
                }

                if (matchCount>=2) {
                    out.get(matchCount - 2).add(line);
                }
            }
        }

        FileWriter fw=new FileWriter("output.txt");
        for (int i=0;i<4;i++){
            fw.write("\n"+(i+2)+" találat:\n");
            //System.out.println("\n"+(i+2)+" találat:\n");
            for (int j=0;j<out.get(i).stream().count();j++){
                //System.out.println(out.get(i).get(j));
                fw.write(out.get(i).get(j)+"\n");
            }
        }
        fw.close();
    }
}