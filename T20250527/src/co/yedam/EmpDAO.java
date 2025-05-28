package co.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 등록,수정,삭제,목록 기능을 구현.
 * 저장은 storage에 반영하도록 함.
 */
public class EmpDAO {
	// 사원정보를 저장하는 컬렉션.
	List<Employee> storage = new ArrayList<Employee>();
	Scanner scn = new Scanner(System.in);
		
	public void add() { //추가
		System.out.print("사번입력>> ");
		String no = scn.nextLine();
		System.out.print("이름입력>> ");
		String name = scn.nextLine();
		System.out.print("전화번호입력>> ");
		String phone = scn.nextLine();
		System.out.print("입사일입력>> ");
		String date = scn.nextLine();
		System.out.print("급여입력>> ");
		int salary = Integer.parseInt(scn.nextLine());
		
		Employee employee = new Employee(no, name, phone, date, salary);
		
		storage.add(employee);		
	}//end of add.
	
	public void modify() { //수정
		System.out.print("사번 급여>> ");
		String inputno = scn.nextLine();
		String selno = inputno.substring(0,5);
		int selsal = Integer.parseInt(inputno.substring(6));
		
		
		for(int i = 0; i < storage.size(); i++) {
			if(selno.equals(storage.get(i).getNo())) {
				storage.get(i).setSalary(selsal);
				System.out.println("수정완료");
			}
		}
	}//end of modify.
	
	public void delete() { //삭제.
		System.out.print("사번 >>");	
		String inputno = scn.nextLine();
		for(int i = 0; i < storage.size(); i++) {
			if(inputno.equals(storage.get(i).getNo())){
				storage.remove(i);
				System.out.println("삭제완료");
			}
		}
		
	}//end of delete.
	
	
	public void list() { //목록.
		System.out.println(" 사번    이름     전화번호     급여");
		System.out.println("------------------------------");
		for(int i = 0; i < storage.size(); i++) {
				System.out.printf("%s  %s  %s    %d\n", storage.get(i).getNo(), storage.get(i).getName(), storage.get(i).getPhone(), storage.get(i).getSalary());				
		}
	} //end of list
	
	public void seleclist() { //조회(입사일).
		System.out.println("입사일 입력>>");
		String inputdate = scn.nextLine();
		
		System.out.println(" 사번     이름     전화번호 ");
		System.out.println("-------------------------");
		for(int i = 0; i < storage.size(); i++) {
			if(inputdate.equals(storage.get(i).getDate())) {
				System.out.printf("%s   %s   %s\n", storage.get(i).getNo(), storage.get(i).getName(), storage.get(i).getPhone());				
			}
		}
	} //end of seleclist

}
	
	

