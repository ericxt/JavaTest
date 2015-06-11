package javaBasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerDog implements Serializable {
	private static final long serialVersionUID = -9066655574456326039L;

	private String name;
	private String color;
	// using transient, when serializing , the value not be saved.
	private transient int weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void introduce() {
		System.out.println("this is a " + color + name);
	}

}

public class SerializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerDog dog = new SerDog();
		dog.setName("Dog");
		dog.setColor("red");
		dog.setWeight(11);

		File dir = new File(".");

		try {
			FileOutputStream fos = new FileOutputStream(dir.getCanonicalPath()
					+ File.separator + "dog.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dog);

			oos.close();
			fos.close();
			System.out.println("Serialized dog is saved in dog.ser.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dog = null;
		
		try {
			FileInputStream fis = new FileInputStream("dog.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			dog = (SerDog)ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("deserialized dog...");
		System.out.println("name : " + dog.getName());
		System.out.println("color : " + dog.getColor());
		System.out.println("weight : " + dog.getWeight());

	}

}
