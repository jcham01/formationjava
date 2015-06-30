package mylib;


// on herite de runtimeException pour eviter de forcer
// a gérer cette erreur
public class AgeException extends  RuntimeException
{

	private int age;
	public int getAge() {
		return age;
	}

	public AgeException(int age) {
		super("age invalide : " + age);
		this.age = age;
	}
	
}
