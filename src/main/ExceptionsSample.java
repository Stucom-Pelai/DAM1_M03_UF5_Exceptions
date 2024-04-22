package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsSample {
	public static void main(String[] args) {
		// they reflect some error inside the program logic 
		uncheckedExceptions();
		
		// they represent errors outside the control of the program
		checkedExceptions("test");		
	}

	/**
	 * to learn about unchecked exceptions
	 */
	public static void uncheckedExceptions() {
		ArrayList<Integer> numbers = new ArrayList<>();
	
		numbers.add(3);
		System.out.println("Give me position to read a number: ");
		Scanner sc = new Scanner(System.in);
		int position = -1;
		
		do {			
			try {
				position = sc.nextInt();
				System.out.println("position contains number: " + numbers.get(position));
				
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error, position does not exist: " + e);
				System.out.println("Type a new position again: ");
				sc = new Scanner(System.in);
			}catch (InputMismatchException e) {
				System.out.println("Error, format position must be a number: " + e);
				System.out.println("Type a new position again: ");
				sc = new Scanner(System.in);
			}finally {
				System.out.println("finally unchecked ... ");
			}			
		} while (position < 0 || position >= numbers.size());
	
	}

	/**
	 * to learn about checked exceptions
	 * 
	 * @param filePath path file to read
	 */
	public static boolean checkedExceptions(String filePath) {
		
		File f = new File(filePath);

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("First line read: " + br.readLine());
			fr.close();
			br.close();

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return false;
		}finally {
			System.out.println("finally checked ... ");
		}	
		return true;
	}
}
