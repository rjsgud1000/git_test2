package git_test2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	private static final String BLUE = "\u001B[34m";
	private static final String GREEN = "\u001B[32m";
	private static final String RESET = "\u001B[0m";
	private static final String BOLD = "\u001B[1m";
	
	public static void main(String[] args) {
		printWelcome();
		
		// Measure execution time like a pro
		long startTime = System.nanoTime();
		
		Hello h = new Hello();
		h.say();
		
		long endTime = System.nanoTime();
		double executionTimeMs = (endTime - startTime) / 1_000_000.0;
		
		printStats(executionTimeMs);
		printGoodbye();
	}
	
	private static void printWelcome() {
		String timestamp = LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		System.out.println(BLUE + BOLD + "┌─────────────────────────────────────────┐" + RESET);
		System.out.printf(BLUE + BOLD + "│  🚀 Program Started: %-18s │%n" + RESET, timestamp);
		System.out.println(BLUE + BOLD + "└─────────────────────────────────────────┘" + RESET);
		System.out.println();
	}
	
	private static void printStats(double executionTimeMs) {
		System.out.println();
		System.out.println(GREEN + "📊 Performance Statistics:" + RESET);
		System.out.printf("   ⏱️  Execution time: %.3f ms%n", executionTimeMs);
		System.out.printf("   💾 Memory used: %.2f MB%n", 
			(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024.0 / 1024.0);
		System.out.printf("   ⚡ Status: %sAWESOME!%s%n", BOLD + GREEN, RESET);
	}
	
	private static void printGoodbye() {
		System.out.println();
		System.out.println(BLUE + "👋 Thank you for using Awesome Java! 🎉" + RESET);
	}
}

