package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apple {
	public static void main(String[] args) {
		List<Student> arr = Arrays.asList(new Student(100, "red"), new Student(180, "blue"), new Student(150, "red"));
		ArrayList<Student> find = find(arr,new findGreen());
		find.forEach(val->{
			System.out.println(val);
		});
	}
	public interface fileter {
		Boolean fileters(Student stu);
	}

	public static class findGreen implements fileter {

		@Override
		public Boolean fileters(Student stu) {
			return stu.getWeight() > 100 && stu.getColor().equals("red");
		}

	}
	public static ArrayList<Student> find(List<Student> list,fileter file) {
		ArrayList<Student> arr = new ArrayList<Student>();
		list.forEach(val->{
			if(file.fileters(val)) {
				arr.add(val);
			}
		});
		return arr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
