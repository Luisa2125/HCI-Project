import javax.swing.JOptionPane;




public class Usuario {
	String email;
	String user;
	String name;
	int age;
	String pasword;
	boolean karatec;
	boolean danza;
	boolean completo=false;
	
	boolean verde = false;
	
	public void setEmail(String emailU){
		this.email = emailU;
	}
	public void setUser(String userU){
		this.user =userU;
	}
	public void setName(String nameU){
		this.name = nameU;
	}
	public void setAge(int ageU){
		this.age = ageU;
	}
	public void setPasword(String paswordU,String pasword2){
		if(paswordU.equals(pasword2)){
			this.pasword=paswordU;
			verde = true;
		}
		else{
			verde = false;
			JOptionPane.showMessageDialog(null, "Contraseña}n Incorrecta", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void setKarate(boolean karateU){
		this.karatec = karateU;
	}
	public void setDanza(boolean danzaU){
		this.danza = danzaU;
		
	}

	public String getEmail() {
		return email;
	}
	public String getUser() {
		return user;
	}
	public String getPasword() {
		return pasword;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public boolean isKarate() {
		return karatec;
	}
	public boolean isDanza() {
		return danza;
	}
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", user=" + user + ", name=" + name
				+ ", age=" + age + ", pasword=" + pasword + ", karate="
				+ karatec + ", danza=" + danza + "]";
	}
	
	
}
