package com.dhb.prototype.v2;



public class Test {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p2.age + " " + p2.score);
		System.out.println(p2.loc);

		System.out.println(p1.loc == p2.loc);
		p1.loc.street = "sh";
		System.out.println(p2.loc);
	}
}

class Person implements Cloneable {
	int age = 0;
	int score = 100;

	Location loc = new Location("bj",22);

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Person person = (Person) super.clone();
		person.loc = (Location) loc.clone();
		return person;
	}
}

class Location implements Cloneable{
	String street;
	int roomNo;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Location(String street, int roomNo) {
		this.street = street;
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return "Location{" +
				"street='" + street + '\'' +
				", roomNo=" + roomNo +
				'}';
	}
}