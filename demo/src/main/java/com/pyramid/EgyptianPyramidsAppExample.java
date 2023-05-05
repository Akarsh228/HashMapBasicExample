package com.pyramid;
import java.util.*;
public class EgyptianPyramidsAppExample {
  private static Map<String, List<String>> pyramids;
  private static Map<String, Integer> goldContributions;
  private static Set<String> requestedPyramids;
  private static Map<Integer, String> pharoahs = new HashMap<Integer, String>();
  private static Stack<String> stack1 = new Stack<String>();

  public static void main(String[] args) {
    pyramids = new HashMap<>();
    goldContributions = new HashMap<>();
    requestedPyramids = new HashSet<>();

    // pharoahs and their things
    pharoahs.put(1, "Steve");
    pharoahs.put(2, "Jeff");
    pharoahs.put(3, "Random DUDE");
    pharoahs.put(4, "Bob");
    pharoahs.put(5, "Karun");
    pharoahs.put(6, "Nathan");
    pharoahs.put(7, "Rama Tut");

  // add the pharaohs to each of the pyramids
    pyramids.put("Pyramid 1", Arrays.asList("Steve", "Jeff"));
    pyramids.put("Pyramid 2", Arrays.asList("Random DUDE", "bob"));
    pyramids.put("Pyramid 3", Arrays.asList("Steve", "RAMA TUT"));

    //put numbs for gold
    goldContributions.put("Pharaoh 1", 100);
    goldContributions.put("Pharaoh 2", 200);
    goldContributions.put("Pharaoh 3", 300);

    Scanner scanner = new Scanner(System.in);
    String command = "-";
    while (!command.equalsIgnoreCase("q")) {
      System.out.println("............Nassef's Egyptian Pyramid App................");
      System.out.println("Command       Description");
      System.out.println("..............");
      System.out.println("1             List all of the pharoas");
      System.out.println("2             enter Id to get pharoas");
      System.out.println("3             Display a list of all pyramids");
      System.out.println("4             Display information for a specific pyramid by id number");
      System.out.println("5             Report a list of requested pyramids without any duplicates");
      System.out.println("q             Quit the application");
      System.out.println("..........................................................");
      System.out.print("Enter a command: ");
      command  = scanner.nextLine();

      switch (command) {
        case "1":
          listpharaoh();
          break;
        case "2":
          int idToLook = scanner.nextInt();
          System.out.println("Name: " + pharoahs.get(idToLook));
          
         
          break;
        case "3":
          listPyramids();
          break;
        case "4":
          displayPyramidInfo(scanner);
          break;
        case "5":
          removeDuplicates(stack1);
          printStack(stack1);
          break;
        case "q":
          System.out.println("Quitting application...");
          System.exit(0);
        default:
          System.out.println("Invalid command. Please try again.");
          break;
      }
    }
  }

  private static void reportRequestedPyramidsWithoutDuplicates() {
  }

  private static void listPyramids() {
    System.out.println("List of all pyramids and contributors:");
    for (Map.Entry<String, List<String>> entry : pyramids.entrySet()) {
      String pyramid = entry.getKey();
      List<String> contributors = entry.getValue();
      System.out.println(pyramid + ": " + contributors);
    }
  }

  public static void printStack(Stack<String> stack) {
    Stack<String> temp = new Stack<String>();
    while (!stack.isEmpty()) {
        temp.push(stack.pop());
    }
    while (!temp.isEmpty()) {
        String element = temp.pop();
        System.out.println(element);
        stack.push(element);
    }
}


  private static void listpharaoh() {
    System.out.println("List of all pharoahs");
    for (Map.Entry<Integer, String> entry : pharoahs.entrySet()) {
      System.out.println("id: " + entry.getKey() + " Name: " + entry.getValue());
    }
  }

  public static void removeDuplicates(Stack<String> stack) {
    Set<String> set = new HashSet<String>();
    Stack<String> temp = new Stack<String>();
    while (!stack.isEmpty()) {
        String element = stack.pop();
        if (!set.contains(element)) {
            set.add(element);
            temp.push(element);
        }
    }
    while (!temp.isEmpty()) {
        stack.push(temp.pop());
    }
}

  private static void displayPyramidInfo(Scanner scanner) {
    System.out.print("Enter the name of the pyramid you want information on: ");
    String pyramid = scanner.nextLine();

    List<String> contributors = pyramids.get(pyramid);
    if (contributors == null) {
      System.out.println("Pyramid not found.");
      return;
    }

    stack1.add(pyramid);

    System.out.println("Information for " + pyramid + ":");
    int totalGold = 0;
    for (String contributor : contributors) {
      int gold = goldContributions.getOrDefault(contributor, 0);
      totalGold += gold;
      System.out.println(contributor + " contributed " + gold + " gold.");
    }
    System.out.println("Total gold contributed: " + totalGold);
    requestedPyramids.add(pyramid);
  }

}
