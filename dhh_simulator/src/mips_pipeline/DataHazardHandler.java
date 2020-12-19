package mips_pipeline;

public class DataHazardHandler {

	public static void handleEXHazard(Registers registers) {
		int ExMemRegWrite = registers.getExmemWr();
		int ExMemRegRead = registers.getExmemRd();
		int IdExRegRs = registers.getIdexRs();
		int IdExRegRt = registers.getIdexRt();
		
		if(ExMemRegWrite == 1 && ExMemRegRead != 0 && ExMemRegRead == IdExRegRs) {
			System.out.println("EX Hazard: Rs");
			registers.setForwardA("10");
		}
		
		if(ExMemRegWrite == 1 && ExMemRegRead != 0 && ExMemRegRead == IdExRegRt) {
			System.out.println("EX Hazard: Rt");
			registers.setForwardB("10");
		}
	}
	
	public static void handleMEMHazards(Registers registers) {
		int MemWbRegWrite = registers.getMemwbWr();
		int MemWbRegRead = registers.getMemwbRd();
		int IdExRegRs = registers.getIdexRs();
		
		int ExMemRegWrite = registers.getExmemWr();
		int ExMemRegRead = registers.getExmemRd();
		int IdExRegRt = registers.getIdexRt(); 
		
		if(MemWbRegWrite == 1 && MemWbRegRead != 0 && MemWbRegRead == IdExRegRs &&
				!(ExMemRegWrite == 1 && ExMemRegRead != 0 && ExMemRegRead == IdExRegRs)){
			
			System.out.println("MEM Hazard: Rs");
			registers.setForwardA("01");
		}
		
		if(MemWbRegWrite == 1 && MemWbRegRead != 0 && MemWbRegRead == IdExRegRt &&
				!(ExMemRegWrite == 1 && ExMemRegRead != 0 && ExMemRegRead == IdExRegRt)) {
			System.out.println("MEM Hazard: Rt");
			registers.setForwardB("01");
		}
		
		if(MemWbRegWrite == 1 && MemWbRegRead != 0 && MemWbRegRead == IdExRegRs &&
				(ExMemRegWrite == 1 && ExMemRegRead != 0 && ExMemRegRead == IdExRegRs)){
			
			System.out.println("Double Hazard: Rs");
			registers.setForwardA("10");
			registers.setForwardB("00");
		}
		
		if(MemWbRegWrite == 1 && MemWbRegRead != 0 && MemWbRegRead == IdExRegRt &&
				(ExMemRegWrite == 1 && ExMemRegRead != 0 && ExMemRegRead == IdExRegRt)){
			
			System.out.println("Double Hazard: Rt");
			registers.setForwardA("00");
			registers.setForwardB("10");
		}	
	}
	
	public static void handleLUHazards(Registers registers) {
		
		int IdExMemRead = registers.getIdexRe();
		int IdExRegRt = registers.getIdexRt();
		int IfIdRegRs = registers.getIfidRs();
		int IfIdRegRt = registers.getIfidRt();
		
		if(IdExMemRead == 1 && (IdExRegRt == IfIdRegRs || IdExRegRt == IfIdRegRt)) {

			System.out.println("Pipeline stall detected!");
			
			//memread = 0
			//memwrite = 0
			//regwrite = 0
			
			registers.setPcWrite(0);
			registers.setIfidWr(0);
			registers.setIdexFl(1);
			
			
		}
		
		
	}
	
	public static boolean isStall(Registers registers) {
		if(registers.getPcWrite() == 0 && registers.getIfidWr() == 0 && registers.getIdexFl() == 1)
			return true;
		else 
			return false;
		
	}
	
	
	
}
