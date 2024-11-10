package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramCandidato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votos = new LinkedHashMap<>();
		
		System.out.println("Enter file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int cont = Integer.parseInt(fields[1]);
			
				if(votos.containsKey(name)) {
					int votosAteAgora = votos.get(name);
					votos.put(name, cont + votosAteAgora);
				}
				else {
					votos.put(name, cont);
				}
				
				line = br.readLine();
			}
			
			for(String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
			
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
