package test240718.object1;

public class PersonController {
	private Person[] p = new Person[20];
//	private Student[] s = new Student[3];
//	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] personNum = new int[2];
		int stdCnt = 0;
		int emplyCnt = 0;
		
		for(Person ps : p) {
			if(ps == null) break;
			
			if(ps instanceof Student) {
				stdCnt++;
			}
			else if(ps instanceof Employee) {
				emplyCnt++;
			}
		}
		personNum[0] = stdCnt;
		personNum[1] = emplyCnt;
		
		return personNum;
	}

	public void insertPerson(Person p) {
		for(int i=0; i< this.p.length; i++) {
			if(this.p[i] == null) {
				this.p[i] = p;
				return;
			}
		}
	}
	
	public Person[] printPerson() {
		return this.p;
	}
	

}
