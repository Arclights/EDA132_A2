package tree;

public class TreeTest {

	public static void main(String[] args) {
		Tree frisatYes = new Tree(new GoalNode(true));
		Tree frisatNo = new Tree(new GoalNode(false));
		Tree frisat = new Tree(new AttributeNode("Fri/Sat?"));
		frisat.appendSubtree("Yes", frisatYes);
		frisat.appendSubtree("No", frisatNo);
		Tree type = new Tree(new AttributeNode("Type?"));
		Tree frenchYes = new Tree(new GoalNode(true));
		type.appendSubtree("French", frenchYes);
		Tree italianNo = new Tree(new GoalNode(false));
		type.appendSubtree("Italian", italianNo);
		type.appendSubtree("Thai", frisat);
		Tree burgerYes = new Tree(new GoalNode(true));
		type.appendSubtree("Burger", burgerYes);
		Tree hungry = new Tree(new AttributeNode("Hungry?"));
		Tree hungryNo = new Tree(new GoalNode(false));
		hungry.appendSubtree("No", hungryNo);
		hungry.appendSubtree("Yes", type);
		Tree patrons = new Tree(new AttributeNode("Patrons?"));
		Tree patronsNone = new Tree(new GoalNode(false));
		Tree patronsSome = new Tree(new GoalNode(true));
		patrons.appendSubtree("None", patronsNone);
		patrons.appendSubtree("Some", patronsSome);
		patrons.appendSubtree("Full", hungry);

		System.out.println(patrons);
	}

}
