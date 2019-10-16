package ch.maxant.rules;


import java.util.Arrays;
import java.util.List;


public class DriverClass {
	
	public static void main(String[] args) {
		Rule rule= new Rule("1", "input.age > 30 && (input.sex =='F'  )" , "veryOld", 1, "ch.maxant.produkte");
		Rule rule1= new Rule("2", "input.age < 30 && input.sex =='F' " , "Young", 2, "ch.maxant.produkte");
		Rule rule2= new Rule("3", "input.age >= 30 && (input.sex =='F' && input.name=='jane')" , "Oldyyyy", 3, "ch.maxant.produkte");

		List<Rule> rules = Arrays.asList(rule,rule1,rule2);
		try {
			Engine e = new Engine(rules, true);
			Person p1 = new Person("jane");
			p1.setAge(35);
			p1.setSex("F");
			System.out.println(e.getBestOutcome(p1));
			System.out.println(e.getMatchingRules(p1).size());
			//p1.setAge(33);
			//System.out.println(e.getMatchingRules(p1));

		} 
		catch (NoMatchingRuleFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (DuplicateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
