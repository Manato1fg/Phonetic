import java.io.*;
import java.util.HashMap;

public class Main{

	public HashMap<String, String> TABLE = new HashMap<String, String>();
	public static void main(String[] args){
		Main main = new Main();
		try{
			File file1 = new File("./table.txt");
			FileReader filereader1 = new FileReader(file1);
			BufferedReader br1 = new BufferedReader(filereader1);

			String resultStr1 = "";

			String str1 = br1.readLine();
			String[] re1;
			while(str1 != null){
				re1 = str1.split(" ");

				main.TABLE.put(re1[0], re1[1]);
				
				str1 = br1.readLine();
			}

			String v = "";
			for (String s : args) {
				s = s.replace("!", "").replace("?", "").replace(".", "").replace(",", "").toUpperCase();

				File file2 = new File("./words/"+String.valueOf(s.charAt(0))+"/word.txt");
				FileReader filereader2 = new FileReader(file2);
				BufferedReader br2 = new BufferedReader(filereader2);
				String str2 = br2.readLine();
				String[] re2;
				while (str2 != null) {
					re2 = str2.split("  ");
					if(re2[0].equals(s)){
						v = re2[1];
						break;
					}
					str2 = br2.readLine();
				}


				if(v != ""){
					String[] w = v.split(" ");
					String y = "";
					for (String x : w) {
						y += main.TABLE.get(x);
					}
					System.out.print(y+" ");
				}
				v = "";
			}
			System.out.println("");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}