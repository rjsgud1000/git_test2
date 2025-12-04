package git_test2;

import java.util.List;
import java.util.Random;

public class Hello {
	
	// ANSI Color Codes for awesome terminal output
	private static final String RESET = "\u001B[0m";
	private static final String CYAN = "\u001B[36m";
	private static final String YELLOW = "\u001B[33m";
	private static final String GREEN = "\u001B[32m";
	private static final String MAGENTA = "\u001B[35m";
	private static final String BOLD = "\u001B[1m";
	private static final String RAINBOW = "\u001B[38;5;";
	private static final String RAINBOW_RESET = "\u001B[0m";
	private static final String UNDERLINE = "\u001B[4m";

	
	private final List<Greeting> greetings = List.of(
		new Greeting("안녕하세요", "Korean", "🇰🇷"),
		new Greeting("Hello", "English", "🇬🇧"),
		new Greeting("Bonjour", "French", "🇫🇷"),
		new Greeting("こんにちは", "Japanese", "🇯🇵"),
		new Greeting("Hola", "Spanish", "🇪🇸"),
		new Greeting("Ciao", "Italian", "🇮🇹"),
		new Greeting("Привет", "Russian", "🇷🇺"),
		new Greeting("你好", "Chinese", "🇨🇳")
	);
	
	public void say() {
		printAwesomeBanner();
		printAllGreetings();
		printRandomGreeting();
	}
	
	private void printAwesomeBanner() {
		String banner = """
			╔═══════════════════════════════════════════════════╗
			║                                                   ║
			║    ✨  AWESOME MULTILINGUAL GREETER 2025  ✨    ║
			║                                                   ║
			╚═══════════════════════════════════════════════════╝
			""";
		System.out.println(CYAN + BOLD + banner + RESET);
	}
	
	private void printAllGreetings() {
		System.out.println(YELLOW + "🌍 Greetings from around the world:" + RESET);
		System.out.println();
		
		greetings.forEach(greeting -> {
			System.out.printf("%s %s%-12s%s - %s%-10s%s - %s%s%s%n",
				greeting.emoji(),
				GREEN, greeting.message(), RESET,
				MAGENTA, greeting.language(), RESET,
				CYAN, "(" + greeting.message().length() + " chars)", RESET
			);
		});
		System.out.println();
	}
	
	private void printRandomGreeting() {
		Greeting random = greetings.get(new Random().nextInt(greetings.size()));
		String sparkles = "✨ ⭐ 🌟 ✨";
		
		System.out.println(YELLOW + sparkles + RESET);
		System.out.printf(BOLD + "%sRandom greeting of the day:%s %s %s%s%s%n",
			GREEN, RESET, random.emoji(), CYAN, random.message(), RESET);
		System.out.println(YELLOW + sparkles + RESET);
	}
	
	// Modern Java Record for clean data modeling
	public record Greeting(String message, String language, String emoji) {
		public Greeting {
			// Compact constructor with validation
			if (message == null || message.isBlank()) {
				throw new IllegalArgumentException("Message cannot be empty!");
			}
		}
	}
}
