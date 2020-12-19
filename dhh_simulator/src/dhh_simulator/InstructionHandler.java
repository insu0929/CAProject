package dhh_simulator;

import java.util.ArrayList;
import java.util.HashMap;

public class InstructionHandler {

	
	//put instructions to stage
	static void stageInstructions(String command, String[] stages){
		
		int size = stages.length; //5
		
		String end = stages[size - 1]; //finised command
		
		for(int i = size - 1; i >= 1; i--) {
			stages[i] = stages[i - 1];
		}
		
		stages[0] = command;
	}
	
	//stall stages for LU Hazard
	static void stallInstructions(String command, String[] stages) {
		
		
	}
	
	static void printStageStatus(String[] stages) {
		
		System.out.println("IF: " + stages[0]);
		System.out.println("ID: " + stages[1]);
		System.out.println("EX: " + stages[2]);
		System.out.println("MEM: " + stages[3]);
		System.out.println("WB: " + stages[4]);
		System.out.println();
		
	}
	
	static int getInstType(String instruction) {
		
		String[] parsedInst = instruction.split(" ");
		
		String instrPrefix = parsedInst[0];
		
		
		if(instrPrefix.contentEquals("add") || instrPrefix.contentEquals("or")) { //r-format
			if(instrPrefix.contentEquals("add"))
				return 0;
			else //or
				return 1;
			
		}else if(instrPrefix.contentEquals("lw") || instrPrefix.contentEquals("sw") ||  instrPrefix.contentEquals("ori") || instrPrefix.contentEquals("addi")) { //i-format
			if(instrPrefix.contentEquals("lw"))
				return 2;
			else if(instrPrefix.contentEquals("sw"))
				return 3;
			else if(instrPrefix.contentEquals("ori"))
				return 4;
			else if(instrPrefix.contentEquals("addi"))
				return 5;
			
		}else { //exception in input
			return -1;
		}
		return -1;
	}
	
	static int getInstr(String in) {
		
		if(in.endsWith(",")) { //remove comma at the end
			in = in.substring(0, in.length() - 1);
		}
		
		if(in.startsWith("$")) { //registerType
			String res = in.substring(1,in.length());
			return Integer.parseInt(res);
		}else {
			if(in.endsWith(")")){ //0($3)
				String res = in.substring(0, in.length() - 1);
				StringBuilder sb = new StringBuilder();
				for(int i = in.length(); i >= 0; i--) {
					if(in.charAt(i) == '$')
						break;
					sb.append(in.charAt(i));
				}
				int result = Integer.parseInt(sb.toString());
				return result;
				
			}else {	
				int res = Integer.parseInt(in);
				return res;
			
			}
		}
	}
	
}
