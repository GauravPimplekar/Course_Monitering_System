package com.masai.mainApplication;
import com.masai.Execeptions.AdminException;
import com.masai.Execeptions.AuthenticationFailException;
import com.masai.Execeptions.CreateDetailsException;
import com.masai.Execeptions.UpdateDetailsException;
import com.masai.Execeptions.ViewDetailsException;
import com.masai.Execeptions.WrongInputException;

import java.util.*;
import com.masai.user.Administrator;
import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.user.FacultyLogin;


 
public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("----------------------------******************* [ WELCOME TO THE MINI MASAI SCHOOL ] *****************----------------------------------");
		
		
		System.out.println("Choose The Login Option");
		System.out.println("     1.As a Administrator");
		System.out.println("     2.As a Faculty");
		
		
		System.out.println("Enter your option : ");
		int num = sc.nextInt();
		
		
		
		
		switch(num) {
		
		case 1:
			
			System.out.println("          ----------------------------******************* [ ADMIN SECTION ] *****************----------------------------------");
			try {
				System.out.println("Enter Your UserName");
				String username = sc.next();
				System.out.println("Enter Your PassWord");
				String password = sc.next();
				
				
				Administrator admin = new Administrator(username, password);
				System.out.println();
				
				System.out.println("   Select the following option");
				
				System.out.println("     1) Course");
				System.out.println("     2) Batch");
				System.out.println("     3) Faculty");
				System.out.println("     4) CoursePlan");
				System.out.println("     5) Other");
				
				
				
				System.out.println("Enter your option : ");
				int step2 = sc.nextInt();
				
				switch(step2) {
				
				case 1: System.out.println("Select the following option");
						System.out.println("     1) Create Course");
						System.out.println("     2) Update Course");
						System.out.println("     3) View Course");
						
						
						System.out.println("Enter your option : ");
						int step3a = sc.nextInt();
						
						switch(step3a) {
						case 1: System.out.println("Enter course ID");
						 		int id = sc.nextInt();
						 		
						 		System.out.println("Enter course Name");
						 		String name = sc.next();
						 		
						 		System.out.println("Enter course fee");
						 		int fee = sc.nextInt();
						 		
						 		System.out.println("Enter course Description");
						 		String desc = sc.next();
						 		
						 		System.out.println();
						 		
						 		admin.createCourse(new Course(id,name,fee,desc));
						 		
						 		break;
						 		
						case 2: System.out.println("Enter course ID");
				 				int id2 = sc.nextInt();
				 		
				 				System.out.println("Enter course Name");
				 				String name2 = sc.next();
				 		
				 				System.out.println("Enter course fee");
				 				int fee2 = sc.nextInt();
				 		
				 				System.out.println("Enter course Description");
				 				String desc2 = sc.next();
				 				
				 				System.out.println();
				 		
							try {
								admin.updateCourse(new Course(id2,name2,fee2,desc2));
							} catch (UpdateDetailsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				 		
				 				break;
				 				
						case 3: System.out.println("Enter course Name");
						 		String name3 = sc.next();
						 		System.out.println();
						
							try {
								admin.viewCourse(name3);
							} catch (ViewDetailsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 		break;
						 		
						default: WrongInputException fe = new WrongInputException("Wrong Input");
		 	 			 		fe.printStackTrace();
		 	 			 		break;
						}
						
						
						break;
						
						
				
				case 2: System.out.println("     1) Create Batch");
				 	 	System.out.println("     2) Update Batch");
				 	 	System.out.println("     3) View Batch");
				 	 	
				 	 	System.out.println("Enter your option");
				 	 	int step3d = sc.nextInt();
				 	 	
				 	 	switch(step3d) {
				 	 	case 1: System.out.println("Enter batch ID");
				 	 	 		int id = sc.nextInt();
				 	 	 		
				 	 	 		System.out.println("Enter course ID");
				 	 	 		int id2  = sc.nextInt();
				 	 	 		
				 	 	 		System.out.println("Enter faculty ID");
				 	 	 		int id3 = sc.nextInt();
				 	 	 		
				 	 	 		System.out.println("Enter Number of Student");
				 	 	 		int nof = sc.nextInt();
				 	 	 		
				 	 	 		System.out.println("Enter batch start date in (yyyy-mm-dd) formate");
				 	 	 		String date = sc.next();
				 	 	 		sc.nextLine();
				 	 	 		
				 	 	 		System.out.println("Enter batch duration");
				 	 	 		String duration = sc.nextLine();
				 	 	 		
				 	 	 		admin.createBatch(new Batch(id,id2,id3,nof,date,duration));
				 	 	 		break;
				 	 	 		
				 	 	 		
				 	 	case 2: System.out.println("Enter batch ID");
		 	 	 				int id4 = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter course ID");
		 	 	 				int id5  = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter faculty ID");
		 	 	 				int id6 = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter Number of Student");
		 	 	 				int nof2 = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter batch start date in (yyyy-mm-dd) formate");
		 	 	 				String date2 = sc.next();
		 	 	 				sc.nextLine();
		 	 	 		
		 	 	 				System.out.println("Enter batch duration");
		 	 	 				String duration2 = sc.nextLine();
		 	 	 				
		 	 	 		
		 	 	 				admin.updateBatch(new Batch(id4,id5,id6,nof2,date2,duration2));
				 	 	 		
		 	 	 				break;
		 	 	 				
				 	 	case 3: System.out.println("Enter batch ID");
				 	 	 		int id7 = sc.nextInt();
				 	 	 		
				 	 	 		admin.viewBatch(id7);
				 	 	 		break;
				 	 	 		
				 	 	 		
				 	 	default: WrongInputException fe = new WrongInputException("Wrong Input");
		 	 			 		 fe.printStackTrace();
		 	 			 		 break;
				 	 	}
				 	 	
				 	 	
				 	 	break;
				 	 	
				 	 	
				
				case 3: System.out.println("     1) Create Faculty");
		 	 			System.out.println("     2) Update Faculty");
		 	 			System.out.println("     3) View Faculty");

		 	 			
		 	 			System.out.println("Enter Your option : ");
		 	 			int step3b = sc.nextInt();
		 	 			
		 	 			
		 	 			switch(step3b) {
		 	 			case 1: System.out.println("Enter Faculty ID");
		 	 			 		int id = sc.nextInt();
		 	 			 		sc.nextLine();
		 	 			 		
		 	 			 		System.out.println("Enter Faculty Name");
		 	 			 		String name = sc.nextLine();
		 	 			 		
		 	 			 		
		 	 			 		System.out.println("Enter Faculty address");
		 	 			 		String address = sc.next();
		 	 			 		
		 	 			 		System.out.println("Enter Faculty mobile");
		 	 			 		String mobile = sc.next();
		 	 			 		
		 	 			 		System.out.println("Enter Faculty email");
		 	 			 		String email = sc.next();
		 	 			 		
		 	 			 		System.out.println("Enter Faculty UserName");
		 	 			 		String user = sc.next();
		 	 			 		
		 	 			 		System.out.println("Enter Faculty PassWord");
		 	 			 		String pass = sc.next();
		 	 			 		
		 	 			 		admin.createFaculty(new Faculty(id,name,address,mobile,email,user,pass));
		 	 			 		break;
		 	 			 		
		 	 			 		
		 	 			case 2: System.out.println("Enter Faculty ID");
 	 			 				int id2 = sc.nextInt();
 	 			 				sc.nextLine();
 	 			 		
 	 			 				System.out.println("Enter Faculty Name");
 	 			 				String name2 = sc.nextLine();
 	 			 		
 	 			 				System.out.println("Enter Faculty address");
 	 			 				String address2 = sc.next();
 	 			 		
 	 			 				System.out.println("Enter Faculty mobile");
 	 			 				String mobile2 = sc.next();
 	 			 		
 	 			 				System.out.println("Enter Faculty email");
 	 			 				String email2 = sc.next();
 	 			 		
 	 			 				System.out.println("Enter Faculty UserName");
 	 			 				String user2 = sc.next();
 	 			 		
 	 			 				System.out.println("Enter Faculty PassWord");
 	 			 				String pass2 = sc.next();
 	 			 		
 	 			 				admin.updateFaculty(new Faculty(id2,name2,address2,mobile2,email2,user2,pass2));
 	 			 				break;
		 	 			
		 	 			case 3: System.out.println("Enter Faculty ID ");
		 	 					int id3 = sc.nextInt();
		 	 					
		 	 					admin.viewFaculty(id3);
		 	 					break;
		 	 					
		 	 			default: WrongInputException fe = new WrongInputException("Wrong Input");
		 	 			 		 fe.printStackTrace();
		 	 			 		 break;
		 	 			}
		 	 			
		 	 			
		 	 			break;
		 	 	
				case 4: System.out.println("     1) Create CoursePlan");
		 	 			System.out.println("     2) Update CoursePlan");
		 	 			System.out.println("     3) View CoursePlan");
		 	 			
		 	 			System.out.println("Enter your option");
		 	 			int step3c = sc.nextInt();
		 	 			
		 	 			switch(step3c) {
		 	 			case 1: System.out.println("Enter plan ID");
		 	 					int id = sc.nextInt();
		 	 					
		 	 					System.out.println("Enter batch id");
		 	 					int id2 = sc.nextInt();
		 	 					
		 	 					System.out.println("Enter Day Number");
		 	 					int id3 = sc.nextInt();
		 	 					sc.nextLine();
		 	 					
		 	 					System.out.println("Enter Topic");
		 	 					String topic = sc.nextLine();
		 	 					
		 	 					System.out.println("Enter Status");
		 	 					String status = sc.next();
		 	 					
		 	 					admin.createCoursePlan(new CoursePlan(id,id2,id3,topic,status));
		 	 					
		 	 					break;
		 	 					
		 	 			case 2:  System.out.println("Enter plan ID");
 	 							int id4 = sc.nextInt();
 	 					
 	 							System.out.println("Enter batch id");
 	 							int id5 = sc.nextInt();
 	 					
 	 							System.out.println("Enter Day Number");
 	 							int id6 = sc.nextInt();
 	 							sc.nextLine();
 	 						
 	 							System.out.println("Enter Topic");
 	 							String topic2 = sc.nextLine();
 	 							
 	 					
 	 							System.out.println("Enter Status");
 	 							String status2 = sc.next();
 	 					
 	 							admin.updateCoursePlan(new CoursePlan(id4,id5,id6,topic2,status2));
 	 					
 	 							break;
 	 							
		 	 			case 3: System.out.println("Enter CoursePlan ID");
		 	 			 		int id7 = sc.nextInt();
 	 					
		 	 			 		admin.viewCoursePlan(id7);
		 	 			 		break;
		 	 			 		
		 	 			default: WrongInputException fe = new WrongInputException("Wrong Input");
		 	 			 		 fe.printStackTrace();
		 	 			 		 break;
		 	 			}
		 	 			
		 	 			
		 	 			break;
		 	 	
				case 5: System.out.println("     1) Allocate faculty to a batch");
						System.out.println("     2) Generate Report for every batch");
						System.out.println("     3) View Day wise plan of every batch");
						
						System.out.println("Enter your option :");
						int step5 = sc.nextInt();
						
						switch(step5) {
						case 1: System.out.println("Enter batch ID");
		 	 	 				int id = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter course ID");
		 	 	 				int id2  = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter faculty ID");
		 	 	 				int id3 = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter Number of Student");
		 	 	 				int nof = sc.nextInt();
		 	 	 		
		 	 	 				System.out.println("Enter batch start date in (yyyy-mm-dd) formate");
		 	 	 				String date = sc.next();
		 	 	 		
		 	 	 				System.out.println("Enter batch duration");
		 	 	 				String duration = sc.nextLine();
		 	 	 		
		 	 	 				admin.createBatch(new Batch(id,id2,id3,nof,date,duration));
		 	 	 				break;
							
							
						case 2: System.out.println("Enter Bathc ID : ");
						 		int Id = sc.nextInt();
						 		
						 		admin.generateReport(Id);
						 		break;
						 		
						case 3: System.out.println("Enter Day Number : ");
						 		int day = sc.nextInt();
						 		
						 		admin.dayWiseUpdata(day);
						 		break;
						 		
						case 4: WrongInputException wr = new WrongInputException("Wrong Input");
								wr.printStackTrace();
								break;
						}
						
						break;
						
						
						
				default: WrongInputException fe = new WrongInputException("Wrong Input");
	 			         fe.printStackTrace();
				}
				
				
				
			} catch(AuthenticationFailException ae) {
				
				ae.printStackTrace();
			} catch (CreateDetailsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UpdateDetailsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ViewDetailsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AdminException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			break;
		
		case 2: try {
			System.out.println("          ----------------------------******************* [ FACULTY SECTION ] *****************----------------------------------");
				System.out.println("Enter Your UserName");
				String username = sc.next();
				System.out.println("Enter Your PassWord");
				String password = sc.next();
				
				
			
				FacultyLogin faculty = new FacultyLogin(username, password);
				
				System.out.println("Select the following option");
				
				System.out.println("   1) View the Course Plan");
				System.out.println("   2) Fill up the day wise planner");
				System.out.println("   3) Update password");
				System.out.println("   4) Update course status");
				
				System.out.println("Enter your option");
				int step2 = sc.nextInt();
				sc.nextLine();
				
				switch(step2) {
				case 1: System.out.println("Enter Faculty Name ");
				 		String name = sc.nextLine();
				 		
				 		faculty.viewCoursePlan(name);
				 		break;
				 		
				case 2: 
						System.out.println("Enter Day Number");
						int id3 = sc.nextInt();
						sc.nextLine();
					
						System.out.println("Enter Topic");
						String topic = sc.nextLine();
						
					
						System.out.println("Enter Status");
						String status = sc.next();
					
						faculty.fillCoursePlan(new CoursePlan(id3,topic,status));
						break;
						
				case 3: System.out.println("Enter username");
						String user = sc.next();
						
						System.out.println("Enter old password");
						String pass = sc.next();
						
						System.out.println("Enter New password");
						String npass = sc.next();
						
						faculty.updatePassword(user, pass, npass);
						break;
						
				case 4: System.out.println("Enter Day Number");
				 		int day = sc.nextInt();
				 		
				 		faculty.updateStatus(day);
						
				
	 			 		break;
	 			 		
				default: WrongInputException fe = new WrongInputException("Wrong Input");
		 				 fe.printStackTrace();
				}
			
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		
			break;
			
		default: WrongInputException e = new WrongInputException("Wrong Input");
				 e.printStackTrace();
				 break;
		}
		
	}

}
