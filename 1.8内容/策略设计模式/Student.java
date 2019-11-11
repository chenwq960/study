package java8;

public class Student {
	private int weight;
	private String color;
	@Override
	public String toString() {
		return "Student [weight=" + weight + ", color=" + color + "]";
	}
	public Student(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
}
