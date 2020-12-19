package dhh_simulator;

public class Registers {
	
	// IF/ID Registers
	private int ifidRs;
	private int ifidRt;
	private int ifidRd;
	
	// ID/EX Registers
	private int idexRs;
	private int idexRt;
	private int idexRd;
	private int idexWr;
	private int idexRe;
	private int idexDst;
	
	// EX/MEM Registers
	private int exmemRd;
	private int exmemWr;
	
	// MEM/WB Registers
	private int memwbRd;
	private int memwbWr;
	
	//Forward
	private String forwardA;
	private String forwardB;
	
	//stall registers
	private int pcWrite;
	private int ifidWr;
	private int idexFl;
	
	
	/*initiate register values*/
	public Registers() {
		this.ifidRs = 0;
		this.ifidRt = 0;
		this.ifidRd = 0;
		
		this.idexRs = 0;
		this.idexRt = 0;
		this.idexRd = 0;
		this.idexWr = 0;
		this.idexRe = 0;
		this.idexDst = 0;
		
		this.exmemRd = 0;
		this.exmemWr = 0;
		
		this.memwbRd = 0;
		this.memwbWr = 0;
		
		this.forwardA = "00";
		this.forwardB = "00";
		
		this.pcWrite = 1;
		this.ifidWr = 1;
		this.idexFl = 0;
	}


	public int getIfidRs() {
		return ifidRs;
	}


	public void setIfidRs(int ifidRs) {
		this.ifidRs = ifidRs;
	}


	public int getIfidRt() {
		return ifidRt;
	}


	public void setIfidRt(int ifidRt) {
		this.ifidRt = ifidRt;
	}


	public int getIfidRd() {
		return ifidRd;
	}


	public void setIfidRd(int ifidRd) {
		this.ifidRd = ifidRd;
	}


	public int getIdexRs() {
		return idexRs;
	}


	public void setIdexRs(int idexRs) {
		this.idexRs = idexRs;
	}


	public int getIdexRt() {
		return idexRt;
	}


	public void setIdexRt(int idexRt) {
		this.idexRt = idexRt;
	}


	public int getIdexRd() {
		return idexRd;
	}


	public void setIdexRd(int idexRd) {
		this.idexRd = idexRd;
	}


	public int getIdexWr() {
		return idexWr;
	}


	public void setIdexWr(int idexWr) {
		this.idexWr = idexWr;
	}


	public int getIdexRe() {
		return idexRe;
	}


	public void setIdexRe(int idexRe) {
		this.idexRe = idexRe;
	}


	public int getIdexDst() {
		return idexDst;
	}


	public void setIdexDst(int idexDst) {
		this.idexDst = idexDst;
	}


	public int getExmemRd() {
		return exmemRd;
	}


	public void setExmemRd(int exmemRd) {
		this.exmemRd = exmemRd;
	}


	public int getExmemWr() {
		return exmemWr;
	}


	public void setExmemWr(int exmemWr) {
		this.exmemWr = exmemWr;
	}


	public int getMemwbRd() {
		return memwbRd;
	}


	public void setMemwbRd(int memwbRd) {
		this.memwbRd = memwbRd;
	}


	public int getMemwbWr() {
		return memwbWr;
	}


	public void setMemwbWr(int memwbWr) {
		this.memwbWr = memwbWr;
	}


	public String getForwardA() {
		return forwardA;
	}


	public void setForwardA(String forwardA) {
		this.forwardA = forwardA;
	}


	public String getForwardB() {
		return forwardB;
	}


	public void setForwardB(String forwardB) {
		this.forwardB = forwardB;
	}


	public int getPcWrite() {
		return pcWrite;
	}


	public void setPcWrite(int pcWrite) {
		this.pcWrite = pcWrite;
	}


	public int getIfidWr() {
		return ifidWr;
	}


	public void setIfidWr(int ifidWr) {
		this.ifidWr = ifidWr;
	}


	public int getIdexFl() {
		return idexFl;
	}


	public void setIdexFl(int idexFl) {
		this.idexFl = idexFl;
	}
	
	public void printAllRegisters() {

		System.out.println("IF/ID.registerRs: " + ifidRs);
		System.out.println("IF/ID.registerRt: " + ifidRt);
		System.out.println("IF/ID.registerRd: "+ ifidRd);
		System.out.println("ID/EX.registerRs: " + idexRs);
		System.out.println("ID/EX.registerRt:" + idexRt);
		System.out.println("ID/EX.registerRd: "+ idexRd);
		System.out.println("ID/EX.registerWrite: "+ idexWr);
		System.out.println("ID/EX.registerRead: "+ idexRe);
		System.out.println("ID/EX.registerDst: "+ idexDst);
		System.out.println("EX/MEM.registerRd: "+ exmemRd);
		System.out.println("EX/MEM.registerWrite: "+ exmemWr);
		System.out.println("MEM/WB.registerRd: "+ memwbRd);
		System.out.println("MEM/WB.registerWrite: "+ memwbWr);
		System.out.println("forwardA : "+ forwardA);
		System.out.println("forwardB : "+ forwardB);
		System.out.println("pcWrite: "+ pcWrite);
		System.out.println("IF/IDWrite: " + ifidWr);
		System.out.println("ID/EXFlush: "+ idexFl);
		System.out.println();
		
		
	}
	
	public void print1() {
		System.out.println("IF/ID.registerRs: " + ifidRs);
		System.out.println("IF/ID.registerRt: " + ifidRt);
		System.out.println("ID/EX.registerRs: " + idexRs);
		System.out.println("ID/EX.registerRt:" + idexRt);
		System.out.println("EX/MEM.registerRd: "+ exmemRd);
		System.out.println("EX/MEM.registerWrite: "+ exmemWr);
		System.out.println("MEM/WB.registerRd: "+ memwbRd);
		System.out.println("MEM/WB.registerWrite: "+ memwbWr);
		System.out.println("forwardA : "+ forwardA);
		System.out.println("forwardB : "+ forwardB);
		System.out.println();


		


	}
	
	
}
