package test240719.object2;

public class Company {
	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		
		employees[0] = new Secretary("Hilery",1,"secretary",800);
		employees[1] = new Sales("Clinten",2,"sales",1200);
		
		System.out.printf("%-8s %-13s %-8s\n","name","department","salary");
		System.out.println("------------------------------------------------");
		for(Employee e : employees) {
			System.out.printf("%-8s %-13s %-8s\n",e.getName(),e.getDepartment(),e.getSalary());
			((Bonus)e).incentive(100);
		}
		
		System.out.println("\n인센티브 100 지급");
		System.out.printf("%-8s %-13s %-8s %-8s\n","name","department","salary","tax");
		System.out.println("------------------------------------------------");
		for(Employee e : employees) {
			System.out.printf("%-8s %-13s %-8s %-8s\n",e.getName(),e.getDepartment(),e.getSalary(),e.tax());
		}
		
		
	}
}
