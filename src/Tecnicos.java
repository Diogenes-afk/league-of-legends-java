
public class Tecnicos extends Pessoa { //HERAN�A DA CLASSE 'PESSOA'

	public Tecnicos(String nome, String nick) {
		super(nome, nick);
	}
	
	public void getInfosPlus() {
		System.out.println("-------------------- ");
		this.getInfos();
		System.out.println("-------------------- ");
	}
	
}
