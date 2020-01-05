package app;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.function.*;

public class QueryOLP {
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(new File("courses.csv"))));

		Function<String, Course> mapToCourse = (line) -> {
			String[] p = line.split(", ");
			return new Course(Integer.parseInt(p[0]), p[1], p[2], Integer.parseInt(p[3]), Float.parseFloat(p[4]), Float.parseFloat(p[5]), Integer.parseInt(p[6]));
		};
    
		List<Course> crs = br.lines().skip(1).map(mapToCourse).collect(Collectors.toList());

		/**
		 * Query 1: Count the numbers of subject individually 
		 * show name of subject and count
		 */
		System.out.println("Query 1:"); 
		Map<String, Long> countOfSubjects = crs.stream()
			.map(q -> q.subject)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	   
		countOfSubjects.forEach((name, count) -> {
			System.out.println(name + ":" + count);
		});
		System.out.println("--------"); 

		/**
		 * Query 2: Sorting according to Code, and
		 * discard maximum unit number
		 * show list according to trainees
		 */
		System.out.println("Query 2:"); 
		crs.stream()
			.filter(q -> crs.stream().filter(x -> x.units > q.units).count() > 1)
			.sorted(Comparator.comparing(Course::getCode))
			.map(q -> q.trainees)
			.forEach(System.out::println);
		System.out.println("--------");

		/**
		 * Query 3: Average price according to subject
		 */
		System.out.println("Query 3:"); 
		Map<String, Double> price = crs.stream().collect(Collectors
			.groupingBy(Course::getSubject, Collectors.averagingDouble(Course::getPrice)));

		price.forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
        System.out.println("--------"); 

		/**
		 * Query 4: Get longest duration among the set
		 */
		System.out.println("Query 4:"); 
		System.out.println(crs.stream().max(Comparator.comparing(Course::getDuration)).get().getDuration());
		System.out.println("--------");

		/**
		 * Query 5: Sorting according to instructor,code & units
		 * discarding according to trainees between 200 & 400
		 * displaying instructor
		 */
		System.out.println("Query 5:"); 
		crs.stream()
			.filter(q -> q.trainees > 200 && q.trainees < 400)
			.sorted(Comparator
				.comparing(Course::getInstructor)
				.thenComparing(Course::getCode)
				.thenComparing(Course::getUnits))
			.forEach(q -> System.out.println(q.instructor));
		System.out.println("--------"); 
	}
}
