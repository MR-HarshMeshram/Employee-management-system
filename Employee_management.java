import javax.sound.midi.Soundbank;
import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.Scanner;
class  Employee_s{ // employee class and create a employ obj with id
    int id_Employee;  // varibles
    String Employee_name;
    String Contact_no_Employee;
    String Discription_Employee;
    String Address_Employee;
    String Department_Employee;
    int year_experience_Employee;
    int Salary ;
    void  employee(int id_Employee ,String Employee_name ,String Contact_no_Employee ,String Discription_Employee , String Address_Employee ,String Department_Employee , int year_experience_Employee, int Salary ){
        this.id_Employee=id_Employee;
        this.Employee_name=Employee_name;
        this.Contact_no_Employee=Contact_no_Employee;
        this.Discription_Employee=Discription_Employee;
        this.Address_Employee=Address_Employee;
        this.Department_Employee=Department_Employee;
        this.year_experience_Employee=year_experience_Employee;
        this.Salary=Salary;
    }
    public String set_Address_Employee(String address){
        this.Address_Employee=address;
        return Address_Employee;
    }
    public String get_Address_Employee(){

        return Address_Employee;
    }
    public String set_Discription_Employee(String discription){
        this.Discription_Employee=discription;
        return Discription_Employee;
    }
    public String get_Discription_Employee(){
        return Discription_Employee;
    }
    public String set_Department_Employee(String department){
        this.Department_Employee=department;
        return Department_Employee;
    }
    public String get_Department_Employee(){
        return Department_Employee;
    }
}
class  Employee_management_system{
    ArrayList<Employee_s> employee_management_system=new ArrayList<>(); // create arraylist of employee
    Employee_management_system(){

    }
    public  void  Add_in_system(Employee_s object){
        employee_management_system.add(object);
        System.out.println("Employee Added ");
    }
    public void List_Employee(){
        for (Employee_s i:employee_management_system){

            System.out.println(i.id_Employee +" "+i.Employee_name);
        }
    }
    private static Scanner scanner = new Scanner(System.in); // Single instance of Scanner

    public void Up_Date_Data() {
        System.out.println(" What do you want to update ? (description, address, department)");
        String To_update=scanner.nextLine().toLowerCase();
        if(To_update.equals("description") || To_update.equals("address") || To_update.equals("department")){
            System.out.println("Enter the ID of the employee you want to update:");
            int employee_id= scanner.nextInt();
            scanner.nextLine();
            Employee_s This_employee=findEmployeeById(employee_id); // imp
            if(This_employee != null){// empty
                System.out.println(" enter a value "+To_update+" :");
                String new_value=scanner.nextLine();
                if(To_update.equals("description")){
                    This_employee.set_Discription_Employee(new_value);
                } else if (To_update.equals("address")) {
                    This_employee.set_Address_Employee(new_value);
                } else{
                    This_employee.set_Department_Employee(new_value);
                }
                System.out.println(" update successfully");
            }else {
                System.out.println(" its has empty value ");
            }
        }else System.out.println(" give proper input ");
    }
    private Employee_s findEmployeeById(int id) {
        for (Employee_s employee : employee_management_system) {
            if (employee.id_Employee == id) {
                return employee;
            }
        }
        return null;
    }
    public  void  Remove_Employee(){
        System.out.println(" enter employee id for remove ");
        int employee_id=scanner.nextInt();
        Employee_s remove_employee=findEmployeeById(employee_id);
        employee_management_system.remove(remove_employee);
        System.out.println(" removed ");
    }
    public void Search_Employee(){
        Scanner user=new Scanner(System.in);
        System.out.println(" enter  id which you want to Search");
        int Search_id=user.nextInt();
        for (Employee_s i:employee_management_system){
            if(i.id_Employee== Search_id ){
                System.out.println("------------------------------------------")
                System.out.println("ID :-"+i.id_Employee );
                System.out.println("Name :-"+i.Employee_name);
                System.out.println("Departement :-"+i.Department_Employee);
                System.out.println("Discription :-"+i.Discription_Employee);
                System.out.println("Salary :-"+i.Salary);
                System.out.println("Address :-"+i.Address_Employee);
                System.out.println("Experience of year :-"+i.year_experience_Employee);
                System.out.println("------------------------------------------")
            }
        }
    }
}
public class Employee_management {
    public static void main(String[] args){
        Employee_management_system EMS=new Employee_management_system();
        while (true){
            System.out.println(" -- Employee Management System --");
            System.out.println(" 1) Add Employee ");
            System.out.println(" 2) UpDate Employee ");
            System.out.println(" 3) Remove Employee ");
            System.out.println(" 4) List Employee ");
            System.out.println(" 5) Search Employee  ");
            System.out.println(" 6) EXIT ");
            Scanner User_response=new Scanner(System.in);
            int response=User_response.nextInt();
            switch (response){
                case  1:
                    Employee_s New_employee=new Employee_s();
                    System.out.println(" enter a ID of Employee ");
                    Scanner id=new Scanner(System.in);
                    int user_id=id.nextInt();

                    System.out.println(" enter a Name  ");
                    Scanner name=new Scanner(System.in);
                    String user_name=name.nextLine();

                    System.out.println(" enter a Contact ");
                    Scanner contact=new Scanner(System.in);
                    String user_contact=contact.nextLine();

                    System.out.println(" enter a Discription ");
                    Scanner discription=new Scanner(System.in);
                    String user_discription=discription.nextLine();

                    System.out.println(" enter a Address ");
                    Scanner address=new Scanner(System.in);
                    String user_address=address.nextLine();

                    System.out.println(" enter a Department");
                    Scanner department=new Scanner(System.in);
                    String user_department=department.nextLine();

                    System.out.println(" enter a Experience Year  ");
                    Scanner year_experience=new Scanner(System.in);
                    int user_year_experience=year_experience.nextInt();

                    System.out.println(" enter a  salary ");
                    Scanner salary=new Scanner(System.in);
                    int user_salary=salary.nextInt();

                    New_employee.employee(user_id,user_name,user_contact,user_discription,user_address,user_department,user_year_experience,user_salary);

                    EMS.Add_in_system(New_employee);
                    break;
                case 2:
                    EMS.Up_Date_Data();
                    break;
                case 3:
                    EMS.Remove_Employee();
                case 4:
                    EMS.List_Employee();
                    break;
                case 5:
                    EMS.Search_Employee();
                    break;
            }
        }
    }
}